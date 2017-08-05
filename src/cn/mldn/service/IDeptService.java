package cn.mldn.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.vo.Dept;

public interface IDeptService {
     public List<Dept> list() throws SQLException;
     public boolean add(Dept vo)throws SQLException;
     public boolean update(Dept vo)throws SQLException;
     public Dept find(Integer id)throws SQLException;
     public boolean delete(Set<Integer> ids)throws SQLException;
}
