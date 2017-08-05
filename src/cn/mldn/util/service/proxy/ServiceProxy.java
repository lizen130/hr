package cn.mldn.util.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.mldn.util.DatabaseConnection.DatabaseConnection;



public class ServiceProxy implements InvocationHandler {
private  Object target;

public  Object bind(Object target){
	try{
		this.target=target;
		return  Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);}
	catch(Exception e){
		e.printStackTrace();
	}
	return null;
	
}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
		Object ret=null;
		try {
		
				
				if(method.getName().startsWith("add")||method.getName().startsWith("update")||
						method.getName().startsWith("delete")){
					DatabaseConnection.get().setAutoCommit(false);
					try{
						ret=method.invoke(target, args);
						DatabaseConnection.get().commit();
					}catch(Exception e){
						DatabaseConnection.get().rollback();
						throw e;
					}
				}else{
					ret=method.invoke(target, args);}
			 
			
		}catch(Exception e){
			throw e;
		}finally{
	   DatabaseConnection.close();
	   }
		return ret;
}
}

