package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ioana.Popescu on 7/13/2017.
 */
public class EntityManagerImplTest {

    @Test
    public void testfindByIdMethod() throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        EntityManagerImpl em = new EntityManagerImpl();
        Department instance = em.findById(Department.class, new Long(10));
        assertEquals("", "");
    }

    @Test
    public void testGetNextIdVal() throws SQLException{
        EntityManagerImpl em = new EntityManagerImpl();
        Long value = em.getNextIdVal("Departments", "department_id");
        assertEquals(new Long(271), value);
    }

    @Test
    public void testInsert() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        EntityManagerImpl em = new EntityManagerImpl();
        Department dept = new Department();
        Object value = em.insert(Department.class);
        assertEquals("", "");
    }

    @Test
    public void testFindAllMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        EntityManagerImpl em = new EntityManagerImpl();
        List<Department> list = em.findAll(Department.class);
        assertEquals(list.get(0).getDepartmentName(), "Administration");
    }
}
