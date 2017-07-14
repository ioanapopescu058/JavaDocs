package ro.teamnet.zth.appl.domain.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Ioana.Popescu on 7/14/2017.
 */
public class DepartmentDao {

    EntityManager em = new EntityManagerImpl();

    public <Department> Department findById(Class<Department> entityClass, Long id) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return em.findById(entityClass, id);
    }

    public <Department> Object insert(Department entity) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return em.insert(entity);
    }

    public <Department> List<Department> findAll(Class<Department> entityClass) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return em.findAll(entityClass);
    }

    public <Department> Department update(Department entity) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return em.update(entity);
    }

    public <Department> List<Department> findByParams(Class<Department> entityClass, Map<String, Object> params) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return em.findByParams(entityClass, params);
    }
}
