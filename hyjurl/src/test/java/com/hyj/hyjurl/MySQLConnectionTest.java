package com.hyj.hyjurl;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
public class MySQLConnectionTest {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
 
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://127.0.0.1:3306/eunbitlove?useSSL=false&serverTimezone=UTC";
    static final String USERNAME = "root";
    static final String PASSWORD = "eunbitlove";
 
    @Test
    public void getMySQLConnectionTest() {
        
        Connection conn = null;
        Statement stmt = null;
        
        try {
            
        	 logger.info("==================== MySQL Connection START ====================");
            
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
 
            String sql = "SELECT * FROM urllist";
 
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                
                String no = rs.getString("no");
                String s_url = rs.getString("s_url");
                String f_url = rs.getString("f_url");
 
                logger.info("nonononono : {}", no);
                logger.info("s_urls_urls_url: {}", s_url);
                logger.info("f_urlf_urlf_url: {}", f_url);
                logger.info("========================================");
            }
 
            rs.close();
            stmt.close();
            conn.close();
 
        } catch (SQLException se1) {
            se1.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        
        logger.info("==================== MySQL Connection END ====================");
    }
}