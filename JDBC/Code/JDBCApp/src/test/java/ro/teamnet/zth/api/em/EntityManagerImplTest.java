package ro.teamnet.zth.api.em;

import com.sun.deploy.resources.Deployment_pt_BR;
import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ioana.Popescu on 7/13/2017.
 */
public class EntityManagerImplTest {

    @Test
    public void testfindByIdMethod() throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        EntityManagerImpl em = new EntityManagerImpl();
        Department instance = em.findById(Department.class, 10L);
        assertEquals("", "");
    }

    @Test
    public void testGetNextIdVal() throws SQLException{
        EntityManagerImpl em = new EntityManagerImpl();
        Long value = em.getNextIdVal("Departments", "department_id");
        assertEquals(new Long(295), value);
    }

    @Test
    public void testInsertMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        EntityManagerImpl em = new EntityManagerImpl();
        Department dept = new Department();
        dept.setDepartmentName("FR");
        dept.setLocation(1700l);
        Department value = (Department) em.insert(dept);
        assertEquals(dept.getDepartmentName(), "FR");
    }

    @Test
    public void testFindAllMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        EntityManagerImpl em = new EntityManagerImpl();
        List<Department> list = em.findAll(Department.class);
        assertEquals(list.get(0).getDepartmentName(), "Administration");
    }

    @Test
    public void testUpdateMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        EntityManagerImpl em = new EntityManagerImpl();
        Department dept = new Department();
        dept.setDepartmentName("Piroman");
        dept.setLocation(1700l);
        dept.setId(272l);
        Department value = (Department) em.update(dept);
        assertEquals(value.getDepartmentName(), "Piroman");
    }

    @Test
    public void testDeleteMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        EntityManagerImpl em = new EntityManagerImpl();
        Department dept = new Department();
        dept.setId(294L);
        em.delete(dept);
        Department newDep = em.findById(Department.class, dept.getId());
        assertEquals(null, newDep);
    }

    @Test
    public void testFindByParamsMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        EntityManagerImpl em = new EntityManagerImpl();
        Map<String, Object> params = new HashMap<>();
        params.put("department_name", "FR");
        params.put("location_id", 1700l);
        List<Department> list = em.findByParams(Department.class, params);
        for (Department dep : list) {
            System.out.println("Id: " + dep.getId() + " Name: " + dep.getDepartmentName() + " Location: " + dep.getLocation());
        }
        assertEquals(66, list.size());
    }

    @Test
    public void testSearchEmployeesMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        EntityManagerImpl em = new EntityManagerImpl();
        List<Employee> employees = em.searchEmployees(Employee.class, Department.class, "str");
        for (Employee e : employees)
            System.out.println("Id: " + e.getId() + " First Name: " + e.getFirstName() + " Last Name: " + e.getLastName());
        assertEquals("", "");
    }
}
