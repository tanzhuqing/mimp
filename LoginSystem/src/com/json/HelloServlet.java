package com.json;

import java.io.*;
import java.sql.Timestamp;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

import org.hibernate.Transaction;

import com.DAO.TempDaoImpl;
import com.DAO.UserDao;
import com.DAO.UserDaoImpl;
import com.ORM.Temp;
import com.ORM.User;

import net.sf.json.*;


public class HelloServlet extends HttpServlet {
	private String SUCCESS;
	 private UserDao userDao = new UserDaoImpl(); 
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException{
		//String name = req.getParameter("name");
		
		StringBuffer bf = new StringBuffer();
		try{
			BufferedReader reader = req.getReader();
			String line = null;
			while((line = reader.readLine()) != null ){
				bf.append(line);
			}
		}catch(Exception e){};
	//	TestSave(bf.toString());
		
		//String json = "{x:'1',y:'2',userId:'112',element:[{id:'123',name:'haha'},{id:'456',name:'hehe'}]}";
		  
		//JSONObject obj = JSONObject.fromObject(json);	
	
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		JSONObject obj;
		if(bf.toString().equals(""))
		{ 
			String json = "{x:'1',y:'2',userId:'112',element:[{id:'123',name:'haha'},{id:'456',name:'hehe'}]}";
			obj = JSONObject.fromObject(json);
			out.print(obj.toString());	
		}
		else{
			//out.println(bf.toString());
			try{
				obj = JSONObject.fromObject(bf.toString());
				JSONArray jsonarr =obj.getJSONArray("element");
				for(int i=0;i<3;i++){
					out.println(jsonarr.getString(i));
				}
				Timestamp time = Timestamp.valueOf(obj.getString("time"));
				String s = obj.getString("element");
				insert(time,s);
			}catch(Exception e){out.println(e);}
		}
		
		//out.print(json);

	}
	
	public void insert(Timestamp time, String s){
		Temp t = new Temp(time,s);
		TempDaoImpl tdi = new TempDaoImpl();
		//Transaction tx = adao.getSession().beginTransaction();		
		tdi.save(t);		
		//tx.commit();		
	   //User user=new User("qqqq","qqqq"); 
		//  userDao.add(user);        //保存注册的user 对象 
	       
	}

	
}
