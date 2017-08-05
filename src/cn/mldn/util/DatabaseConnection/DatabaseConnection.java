package cn.mldn.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DBDRIVER="oracle.jdbc.driver.OracleDriver";
    private static final String DBURL="jdbc:oracle:thin:@localhost:1521:lz";
    private static final String DBUSER="scott";
    private static final String PASSWORD="tiger";
    private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
  
    private static Connection rebuildConnection() {
        try {
    			Class.forName(DBDRIVER);
    			return DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
               return null;
		
    }
    public static Connection get(){
    	Connection conn=tl.get();
    	if(conn==null){
			conn=rebuildConnection();
			tl.set(conn);
    	}
    	return conn;
    }
    
    
    public static void close() {
    	Connection conn=tl.get();
    	if(conn!=null){
    		try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	tl.remove();
    }
}

