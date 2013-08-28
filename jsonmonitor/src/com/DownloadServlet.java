package com;

import java.io.*;
import java.net.URLDecoder;
import java.sql.Timestamp;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;

import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;


import net.sf.json.*;

import dao.*;
public class DownloadServlet extends HttpServlet {
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException{
		
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
			Monitor t = findByFrame(0);
		//	out.print( .getContent() );	
			obj  = new JSONObject();
			obj.put("head", "aa55");
			obj.put("frame", t.getFrame());
			obj.put("length", t.getLength());
			obj.put("element", t.getContent());
			obj.put("time", t.getTime().toString());
			
			out.print(obj.toString());
		}
		else{
			//out.println(bf.toString());
			int frame = 0;
			try{
				obj = JSONObject.fromObject(bf.toString());
				frame = obj.getInt("frame");
			}catch(Exception e){out.println(e);}
			
			Monitor t = findByFrame(frame);
			if(t!=null)
			{
				obj  = new JSONObject();
				obj.put("head", "aa55");
				obj.put("frame", t.getFrame());
				obj.put("length", t.getLength());
				//obj.put("element","'"+t.getContent() +"'");
				obj.put("element",t.getContent());
				obj.put("time", t.getTime().toString());
				
				out.print(obj.toString());
			}else{
				out.println(bf.toString());
			}
		}
	}
	
	
	/*
	 * 查询数据
	 * */
	
	public Monitor findByFrame(int frame){
		Monitor t = null;
		MonitorDAO adao = new MonitorDAO();
		Transaction tx = adao.getSession().beginTransaction();		
		
		List pl = adao.findByFrame(frame);
		
		// 遍历结果
		for(Iterator pit = pl.iterator();pit.hasNext();){
			t = (Monitor)pit.next(); 
		}			
		tx.commit();	
		return t;	
	}
	
}
