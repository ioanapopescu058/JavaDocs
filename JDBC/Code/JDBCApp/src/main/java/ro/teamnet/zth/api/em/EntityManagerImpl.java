package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ro.teamnet.zth.api.em.EntityUtils.castFromSqlType;

/**
 * Created by Ioana.Popescu on 7/13/2017.
 */
public class EntityManagerImpl {

    <T> T findById(Class<T> entityClass, Long id) throws SQLException, InstantiationException, IllegalAccessException,
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

    Long getNextIdVal(String tableName, String columnIdName) throws SQLException{

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

    <T> Object insert(T entity) throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException {

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

    <T> List<T> findAll(Class<T> entityClass) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {

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

}
