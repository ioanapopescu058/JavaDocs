package ro.teamnet.zth.api.em;

import com.sun.org.apache.xpath.internal.SourceTree;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static ro.teamnet.zth.api.em.EntityUtils.castFromSqlType;

/**
 * Created by Ioana.Popescu on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager{

    @Override
    public <T> T findById(Class<T> entityClass, Long id) throws SQLException, InstantiationException, IllegalAccessException,
    NoSuchFieldException {

        Connection conn = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entityClass);

        List<ColumnInfo> columns = new ArrayList<>();
        columns.addAll(EntityUtils.getColumns(entityClass));

        Condition cond = new Condition();
        cond.setValue(id);
        for (ColumnInfo col : columns) {
            if (col.isId())
                cond.setColumnName(col.getDbColumnName());
        }


        QueryBuilder qb = new QueryBuilder();
        qb.setQueryType(QueryType.SELECT);
        qb.addQueryColumns(columns);
        qb.setTableName(tableName);
        qb.addCondition(cond);

        try (Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(qb.createQuery());
            while (rs.next()) {
                T instance = entityClass.newInstance();
                for (ColumnInfo col : columns) {
                        Field f = instance.getClass().getDeclaredField(col.getColumnName());
                        f.setAccessible(true);
                        f.set(instance, castFromSqlType(rs.getObject(col.getDbColumnName()), f.getType()));
                }
                System.out.println(instance);
                return instance;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long getNextIdVal(String tableName, String columnIdName) throws SQLException{

        Connection conn = DBManager.getConnection();

        String SQL = "select max(" + columnIdName + ") from " + tableName;

        try (Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Long result = rs.getLong(1);
                result++;
                return result;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> Object insert(T entity) throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException {

        Connection conn = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entity.getClass());

        List<ColumnInfo> columns = new ArrayList<>();
        columns.addAll(EntityUtils.getColumns(entity.getClass()));

        for (ColumnInfo col : columns) {
            if (col.isId())
                col.setValue(getNextIdVal(tableName, col.getDbColumnName()));
            else {
                Field f = entity.getClass().getDeclaredField(col.getColumnName());
                f.setAccessible(true);
                col.setValue(f.get(entity));
            }
        }
        QueryBuilder qb = new QueryBuilder();
        qb.setQueryType(QueryType.INSERT);
        qb.setTableName(tableName);
        qb.addQueryColumns(columns);

        try (Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(qb.createQuery());
            return findById(entity.getClass(), 271l);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Connection conn = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entityClass);

        List<ColumnInfo> columns = new ArrayList<>();
        columns.addAll(EntityUtils.getColumns(entityClass));

        QueryBuilder qb = new QueryBuilder();
        qb.setQueryType(QueryType.SELECT);
        qb.addQueryColumns(columns);
        qb.setTableName(tableName);

        try (Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(qb.createQuery());
            ArrayList<T> list = new ArrayList<>();
            while(rs.next()) {
                T instance = entityClass.newInstance();
                for (ColumnInfo col : columns) {
                    Field f = instance.getClass().getDeclaredField(col.getColumnName());
                    f.setAccessible(true);
                    f.set(instance, castFromSqlType(rs.getObject(col.getDbColumnName()), f.getType()));
                    list.add(instance);
                }
            }
            return list;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T update(T entity) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException{

        Connection conn = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entity.getClass());

        List<ColumnInfo> columns = new ArrayList<>();
        columns.addAll(EntityUtils.getColumns(entity.getClass()));

        Condition cond = new Condition();
        Long id = null;

        for (ColumnInfo col : columns) {
            if (col.isId()) {

                Field f = entity.getClass().getDeclaredField(col.getColumnName());
                f.setAccessible(true);
                col.setValue(f.get(entity));

                cond.setColumnName(col.getDbColumnName());
                cond.setValue(col.getValue());
                id = (Long)col.getValue();
            }

            Field f = entity.getClass().getDeclaredField(col.getColumnName());
            f.setAccessible(true);
            col.setValue(f.get(entity));
        }

        QueryBuilder qb = new QueryBuilder();
        qb.setQueryType(QueryType.UPDATE);
        qb.addQueryColumns(columns);
        qb.setTableName(tableName);
        qb.addCondition(cond);

        System.out.println(qb.createQuery());

        try (Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(qb.createQuery());
            return (T)findById(entity.getClass(), id);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Object entity) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Connection conn = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entity.getClass());

        List<ColumnInfo> columns = new ArrayList<>();
        columns.addAll(EntityUtils.getColumns(entity.getClass()));

        Condition cond = new Condition();

        for (ColumnInfo col : columns) {
            if (col.isId()) {

                Field f = entity.getClass().getDeclaredField(col.getColumnName());
                f.setAccessible(true);
                col.setValue(f.get(entity));

                cond.setColumnName(col.getDbColumnName());
                cond.setValue(col.getValue());

                System.out.println(col.getValue());
            }
            Field f = entity.getClass().getDeclaredField(col.getColumnName());
            f.setAccessible(true);
            col.setValue(f.get(entity));
        }


        QueryBuilder qb = new QueryBuilder();
        qb.setQueryType(QueryType.DELETE);
        qb.addQueryColumns(columns);
        qb.setTableName(tableName);
        qb.addCondition(cond);

        try (Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(qb.createQuery());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException{

        Connection conn = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entityClass);

        List<ColumnInfo> columns = new ArrayList<>();
        columns.addAll(EntityUtils.getColumns(entityClass));

        List<T> retList = new ArrayList<T>();

        for (ColumnInfo col : columns) {
            Field f = entityClass.getDeclaredField(col.getColumnName());
            f.setAccessible(true);
            col.setValue(f.getName());
        }

        Condition[] cond = new Condition[10];
        for (int i = 0; i < 10; i++) {
            cond[i] = new Condition();
        }

        int i = 0;
        Set<Map.Entry<String, Object>> entries = params.entrySet();
        for (Map.Entry entry : entries) {
            cond[i].setColumnName((String)entry.getKey());
            cond[i].setValue(entry.getValue());
            i++;
        }

        QueryBuilder qb = new QueryBuilder();
        qb.setQueryType(QueryType.SELECT);
        qb.addQueryColumns(columns);
        qb.setTableName(tableName);
        qb.addCondition(cond[0]);
        qb.addCondition(cond[1]);
        System.out.println(qb.createQuery());

        try (Statement stmt = conn.createStatement()){
            ResultSet rset = stmt.executeQuery(qb.createQuery());
            while (rset.next()) {
                T inst = entityClass.newInstance();
                for (ColumnInfo c : columns) {
                    Field f = inst.getClass().getDeclaredField(c.getColumnName());
                    f.setAccessible(true);
                    f.set(inst, castFromSqlType(rset.getObject(c.getDbColumnName()), f.getType()));
                    retList.add(inst);
                }
            }
            return retList;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return retList;
    }

    @Override
    public List<Employee> searchEmployees(Class<Employee> entityEmpl, Class<Department> entityDept, String dep) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {

        Connection conn = DBManager.getConnection();

        String tableName1 = EntityUtils.getTableName(entityEmpl);
        String tableName2 = EntityUtils.getTableName(entityDept);

        List<ColumnInfo> columns1 = new ArrayList<>();
        columns1.addAll(EntityUtils.getColumns(entityEmpl));

        List<ColumnInfo> columns2 = new ArrayList<>();
        columns2.addAll(EntityUtils.getColumns(entityDept));

        List employees = new ArrayList<>();

        for (ColumnInfo col1 : columns1) {
            Field f = entityEmpl.getDeclaredField(col1.getColumnName());
            f.setAccessible(true);
            col1.setValue(f.getName());
        }

        for (ColumnInfo col2 : columns2) {
            Field f = entityDept.getDeclaredField(col2.getColumnName());
            f.setAccessible(true);
            col2.setValue(f.getName());
        }

        String sql = "select * from " + tableName1 + " join " + tableName2 + " on " +
                tableName1 + ".department_id = " + tableName2 + ".department_id where " +
                tableName2 + ".department_name like '%" + dep + "%'";

        try (Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employee inst = entityEmpl.newInstance();
                inst.setId(rs.getLong(1));
                inst.setFirstName(rs.getString(2));
                inst.setLastName(rs.getString(3));
                employees.add(inst);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
