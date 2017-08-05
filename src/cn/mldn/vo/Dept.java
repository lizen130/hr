package cn.mldn.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Dept implements Serializable {
   private Integer deptno;
   private String dname;
   private String loc;
   /**保存所有相关的统计数据，键=值规定如下<br>
    * key=count,value=所有员工的数量
    * key=avg,value=员工的平均工资
    * key=avgyear,value=员工平均工龄
    * key=max,value=员工最高工资
    * key=min,value=员工最低工资
    */
   private Map<String,Object> mso=new HashMap<String,Object>(); 
public Integer getDeptno() {
	return deptno;
}
public void setDeptno(Integer deptno) {
	this.deptno = deptno;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public String getLoc() {
	return loc;
}
public void setLoc(String loc) {
	this.loc = loc;
}
public Map<String, Object> getMso() {
	return mso;
}
@Override
public String toString() {
	return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", mso=" + mso + "]";
}


   
}
