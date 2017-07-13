package ro.teamnet.zth.api.database;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ioana.Popescu on 7/13/2017.
 */
public class DBManagerTest {

    @Test
    public void testGetConnectionMethod() throws SQLException{
        Connection conn = DBManager.getConnection();
        assertEquals("", "");
    }

    @Test
    public void testCheckConnectionMethod() throws SQLException{
        DBManager.checkConnection(DBManager.getConnection());
        assertEquals("", "");
    }

}
