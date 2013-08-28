package com.servlet;
import java.io.*;
import java.net.URLDecoder;
import java.sql.Timestamp;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;

import net.sf.json.JSONObject;

import org.hibernate.Transaction;

import com.dao.MonitorDAO;
import com.orm.Monitor;

import java.util.Iterator;
import java.util.List;
public class DownloadServlet extends HttpServlet {
  
	public void service(ServletRequest req, ServletResponse res)throws IOException,ServletException{
		StringBuffer buffer = new StringBuffer();
		 try{
			 BufferedReader reader = req.getReader();
			 String line = null;
			 while((line = reader.readLine())!= null){
				 buffer.append(line);
			 }
		 }catch(Exception e){};
		 
		 res.setContentType("text/html");
		 PrintWriter out = res.getWriter();
		 JSONObject jsonObject;
		 if(buffer.toString().equals(""))
		 {
			 jsonObject = new JSONObject();
			 jsonObject.put("head", "default");
			 jsonObject.put("frame", "-1");
			 jsonObject.put("length", "0");
			 jsonObject.put("element", "[0,0,0,0]");
			 jsonObject.put("time", "0000-00-00 00:00:00");
			out.println(jsonObject.toString()); 
		 }
		 else{
			 int frame = 0;
			 try{
				 jsonObject = JSONObject.fromObject(buffer.toString());
				 frame=jsonObject.getInt("frame");
			 }catch(Exception e){out.println(e);}
			 Monitor t = findByFrame(frame);
			 if(t != null)
			 {
				 jsonObject=new JSONObject();
				 jsonObject.put("head", "aa55");  //aa55?
				 jsonObject.put("frame", t.getFrame());
				 jsonObject.put("length", t.getLength());
				 jsonObject.put("element", t.getContent());
				 jsonObject.put("time", t.getTime().toString());
				out.println(jsonObject.toString()); 
			 }
			 else{
				 out.println(buffer.toString());
			 }
			 
		 }
	}
	
	public Monitor findByFrame(int frame){
		Monitor t = null;
		MonitorDAO adao = new MonitorDAO();
		Transaction ts = adao.getSession().beginTransaction();
		List list = adao.findByFrame(frame);
		
		for(Iterator i = list.iterator();i.hasNext();)
		{
			t = (Monitor)i.next();
		}
		ts.commit();
		return t;
		
	}
}
