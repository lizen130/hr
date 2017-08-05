package cn.mldn.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.AbstractDAO;
import cn.mldn.dao.IDeptDAO;
import cn.mldn.vo.Dept;

public class DeptDAOImpl extends AbstractDAO implements IDeptDAO {
	private PreparedStatement pstmt;

	@Override
	public List<Dept> findAll() throws SQLException {
		List<Dept> all = new ArrayList<Dept>();
		String sql = "  select d.deptno,d.dname,d.loc,temp.count,temp.avg,temp.avgyear,temp.max,temp.min  "
				+ "  from dept d,(select deptno dno,count(*)  count,avg(sal+nvl(comm,0))  avg, trunc(avg(months_between(sysdate,hiredate)/12))  avgyear,  "
				+ "  max(sal+nvl(comm,0))  max,min(sal+nvl(comm,0))  min   "
				+ "  from emp group by deptno) temp  " 
				+ "  where d.deptno=temp.dno(+)  ";

		this.pstmt = super.conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Dept vo = new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
			vo.getMso().put("count", rs.getInt(4));
			vo.getMso().put("avg", rs.getInt(5));
			vo.getMso().put("avgyear", rs.getInt(6));
			vo.getMso().put("max", rs.getInt(7));
			vo.getMso().put("min", rs.getInt(8));
			all.add(vo);
		}
		return all;
	}

	@Override
	public Dept finfByid(Integer id) throws SQLException {
		Dept vo=null;
		String sql=" select deptno,dname,loc from dept where deptno=? ";
		pstmt=super.conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			vo=new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
		}		
		return vo;
	}

	@Override
	public boolean doCreate(Dept vo) throws SQLException {
		String sql=" insert into dept (deptno,dname,loc) values (?,?,?) ";
		pstmt=super.conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getDeptno());
		pstmt.setString(2, vo.getDname());
		pstmt.setString(3, vo.getLoc());
		return pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(Dept vo) throws SQLException {
		String sql=" Update dept set dname=?,loc=? where deptno=?  ";
		pstmt=super.conn.prepareStatement(sql);
		pstmt.setString(1,vo.getDname());
		pstmt.setString(2, vo.getLoc());
		pstmt.setInt(3, vo.getDeptno());
		return pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemove(Set<Integer> ids) throws SQLException {
		StringBuffer sb=new StringBuffer();
		sb.append(" delete from dept where deptno in ( ");
		Iterator<Integer> iter=ids.iterator();
		while(iter.hasNext()) {
			sb.append(iter.next()).append(",");
		}
		sb.delete(sb.length()-1, sb.length()).append(")");
		pstmt=super.conn.prepareStatement(sb.toString());
		return pstmt.executeUpdate()==ids.size();
	}
}
