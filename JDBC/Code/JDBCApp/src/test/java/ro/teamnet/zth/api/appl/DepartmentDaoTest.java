package ro.teamnet.zth.api.appl;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.dao.DepartmentDao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ioana.Popescu on 7/14/2017.
 */
public class DepartmentDaoTest {

    @Test
    public void testfindByIdMethod() throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        DepartmentDao dd = new DepartmentDao();
        Department instance = dd.findById(Department.class, 10L);
        assertEquals(instance.getDepartmentName(), "Administration");
    }

    @Test
    public void testInsertMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        DepartmentDao dd = new DepartmentDao();
        Department dept = new Department();
        dept.setDepartmentName("FR");
        dept.setLocation(1700l);
        Department value = (Department) dd.insert(dept);
        assertEquals(dept.getDepartmentName(), "FR");
    }

    @Test
    public void testFindAllMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        DepartmentDao dd = new DepartmentDao();
        List<Department> list = dd.findAll(Department.class);
        assertEquals(list.get(0).getDepartmentName(), "Administration");
    }

    @Test
    public void testUpdateMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        DepartmentDao dd = new DepartmentDao();
        Department dept = new Department();
        dept.setDepartmentName("Piroman");
        dept.setLocation(1700l);
        dept.setId(272l);
        Department value = dd.update(dept);
        assertEquals(value.getDepartmentName(), "Piroman");
    }

    @Test
    public void testFindByParamsMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        DepartmentDao dd = new DepartmentDao();
        Map<String, Object> params = new HashMap<>();
        params.put("department_name", "FR");
        params.put("location_id", 1700l);
        List<Department> list = dd.findByParams(Department.class, params);
        for (Department dep : list) {
            System.out.println("Id: " + dep.getId() + " Name: " + dep.getDepartmentName() + " Location: " + dep.getLocation());
        }
        //assertEquals(66, list.size());
    }
}
