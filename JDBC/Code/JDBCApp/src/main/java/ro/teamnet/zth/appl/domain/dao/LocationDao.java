package ro.teamnet.zth.appl.domain.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Ioana.Popescu on 7/14/2017.
 */
public class LocationDao {

    public EntityManager em = new EntityManagerImpl();

        public <Location> Location findById(Class<Location> entityClass, Long id) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
            return em.findById(entityClass, id);
        }

        public <Location> Object insert(Location entity) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
            return em.insert(entity);
        }

        public <Location> List<Location> findAll(Class<Location> entityClass) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
            return em.findAll(entityClass);
        }

        public <Location> Location update(Location entity) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
            return em.update(entity);
        }

        public <Location> List<Location> findByParams(Class<Location> entityClass, Map<String, Object> params) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
            return em.findByParams(entityClass, params);
        }
}
