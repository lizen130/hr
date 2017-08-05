package cn.mldn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.mldn.util.DatabaseConnection.DatabaseConnection;

public abstract class AbstractDAO {
  protected Connection conn;
  private PreparedStatement pstmt;
  public  AbstractDAO() {
	  this.conn=DatabaseConnection.get();
}
}
