package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.Department;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Ioana.Popescu on 7/12/2017.
 */
public class EntityUtilsTest {

    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testgetColumnsMethod() {
        ArrayList<ColumnInfo> fields = EntityUtils.getColumns(Department.class);
        assertEquals("Table name should be departments!", "", fields);
    }

}
