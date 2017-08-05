package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.vo.Dept;

public interface IDeptDAO {
     public List<Dept> findAll() throws SQLException;
     public Dept finfByid(Integer id) throws SQLException;
     public boolean doCreate(Dept vo)throws SQLException;
     public boolean doUpdate(Dept vo)throws SQLException;
     public boolean doRemove(Set<Integer> ids) throws SQLException;
}
