package ro.teamnet.zth.api.appl;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;
import ro.teamnet.zth.appl.domain.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.dao.LocationDao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ioana.Popescu on 7/14/2017.
 */
public class LocationDaoTest {

    @Test
    public void testfindByIdMethod() throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        LocationDao ld = new LocationDao();
        Location instance = ld.findById(Location.class, 1000L);
        assertEquals(instance.getCity(), "Roma");
    }

    @Test
    public void testInsertMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        LocationDao ld = new LocationDao();
        Location loc = new Location();
        loc.setCity("Iasi");
        loc.setPostalCode("123456");
        loc.setStateProvince("Romania");
        loc.setStreetAddress("address");
        Location value = (Location) ld.insert(loc);
        assertEquals(value.getCity(), "Iasi");
    }

    @Test
    public void testFindAllMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        LocationDao ld = new LocationDao();
        List<Location> list = ld.findAll(Location.class);
        assertEquals(list.get(0).getCity(), "Roma");
    }

    @Test
    public void testUpdateMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        LocationDao ld = new LocationDao();
        Location loc = new Location();
        loc.setCity("Iasi");
        loc.setPostalCode("123456");
        loc.setStateProvince("Romania");
        loc.setStreetAddress("address");
        loc.setId(1100L);
        Location value = ld.update(loc);
        assertEquals(value.getCity(), "Iasi");
    }

    @Test
    public void testFindByParamsMethod() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        LocationDao ld = new LocationDao();
        Map<String, Object> params = new HashMap<>();
        params.put("city", "Iasi");
        params.put("state_province", "Romania");
        List<Location> list = ld.findByParams(Location.class, params);
        for (Location loc : list) {
            System.out.println("Location_id: " + loc.getId() + " City: " + loc.getCity() + " State_Province: " + loc.getStateProvince());
        }
    }
}
