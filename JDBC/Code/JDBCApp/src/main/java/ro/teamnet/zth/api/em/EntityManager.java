package ro.teamnet.zth.api.em;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Ioana.Popescu on 7/13/2017.
 */
public interface EntityManager {

    <T> T findById(Class<T> entityClass, Long id) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;
    Long getNextIdVal(String tableName, String columnIdName) throws SQLException;
    <T> Object insert(T entity) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;
    <T> List<T> findAll(Class<T> entityClass) throws SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException;
    <T> T update(T entity) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException;
	void delete(Object entity) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;
	<T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) throws SQLException, InstantiationException, IllegalAccessException,
            NoSuchFieldException;


}
