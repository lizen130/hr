package cn.mldn.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IDeptDAO;
import cn.mldn.dao.impl.DeptDAOImpl;
import cn.mldn.service.IDeptService;
import cn.mldn.util.factory.DAOFactory;
import cn.mldn.vo.Dept;

public class DeptServiceImpl implements IDeptService {

	@Override
	public List<Dept> list() throws SQLException {
		IDeptDAO idd=DAOFactory.getInstance(DeptDAOImpl.class);
		return idd.findAll();
	}

	@Override
	public boolean add(Dept vo) throws SQLException {
		IDeptDAO idd=DAOFactory.getInstance(DeptDAOImpl.class);
		if(idd.finfByid(vo.getDeptno())==null) {
			return idd.doCreate(vo);
		}
		return false;
	}

	@Override
	public boolean update(Dept vo) throws SQLException {
		IDeptDAO idd=DAOFactory.getInstance(DeptDAOImpl.class);
		return idd.doUpdate(vo);
	}

	@Override
	public Dept find(Integer id) throws SQLException {
		IDeptDAO idd=DAOFactory.getInstance(DeptDAOImpl.class);
		return idd.finfByid(id);
	}

	@Override
	public boolean delete(Set<Integer> ids) throws SQLException {
		IDeptDAO idd=DAOFactory.getInstance(DeptDAOImpl.class);
		return idd.doRemove(ids);

}
}