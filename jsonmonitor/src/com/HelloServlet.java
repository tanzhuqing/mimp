package com;

import java.io.*;
import java.net.URLDecoder;
import java.sql.Timestamp;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

import org.hibernate.Transaction;

import net.sf.json.*;

import dao.*;
public class HelloServlet extends HttpServlet {
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
				/*JSONArray jsonarr =obj.getJSONArray("element");
				for(int i=0;i<3;i++){
					out.println(jsonarr.getString(i));
				}*/
				Timestamp time = Timestamp.valueOf(obj.getString("time"));
				String s = obj.getString("element");
				int length  = obj.getInt("length");
				int frame   = obj.getInt("frame");
				insert(time,s,length,frame);
				//out.print(obj.toString());
			}catch(Exception e){out.println(e);}
		}
	}
	
	public void insert(Timestamp time, String s,int length,int frame){
		Monitor t = new Monitor(time,s,length,frame);
		MonitorDAO adao = new MonitorDAO();
		Transaction tx = adao.getSession().beginTransaction();		
		adao.save(t);		
		tx.commit();		
	}
}
