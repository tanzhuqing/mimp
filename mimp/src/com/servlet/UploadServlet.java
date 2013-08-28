package com.servlet;

import java.io.*;
import java.net.URLDecoder;
import java.sql.Timestamp;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Transaction;

import com.orm.Monitor;
import com.dao.MonitorDAO;

import net.sf.json.*;
public class UploadServlet extends HttpServlet  {
    
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException{
		
		
		HttpSession session = ((HttpServletRequest)req).getSession();  //获取当前session
		
	  
		//从手机端读取数据流，存在buffer中。
	
		 StringBuffer buffer = new StringBuffer();
		 try{
			 BufferedReader reader = req.getReader();
			 String line =null;
			 while((line = reader.readLine()) != null){
				 buffer.append(line);
			 }
		 }catch(Exception e){};
		 
		 res.setContentType("text/html");
		 PrintWriter out = res.getWriter();
		 JSONObject jsonObjects;  //json数据集
		
		 if(buffer.toString().equals(""))
		 {
			 String jsonData = "{head:'default',frame:'-1',length:'-1',time:'0000-00-00 00:00:00',element:[\"0\",\"0\",\"0\",\"0\"]}";;
			 jsonObjects = JSONObject.fromObject(jsonData);
			 out.print(jsonObjects.toString());
		 }
		 else{
			 try{
				 //解析数据流[number:1~3,entity1:[json],entity2:[json],entity3:[json]]
				 
				 jsonObjects = JSONObject.fromObject(buffer.toString());
				 int num = jsonObjects.getInt("number");				
				switch(num){
				case 3:
				     out.println(decodeData(3,jsonObjects)); //返回确认。
				case 2:
			         out.println(decodeData(2,jsonObjects));
				case 1:
					 out.println(decodeData(1,jsonObjects));
				}
			 }catch(Exception e){out.println(e);}
		 }
	}	
	public String decodeData(int num,JSONObject jsons)
	{
		String res="[number:"+num+",";
		int i;
		 for(i=0;i<num;i++)
		 {
			 JSONObject json;
			 json = jsons.getJSONObject("entity"+(i+1));
			 Timestamp time = Timestamp.valueOf(json.getString("time"));
			 String element = json.getString("element");
			 int length = json.getInt("length");
			 int frame = json.getInt("frame");
			
			 //存入数据库
			 insert(time,element,length,frame);
			 
			 res += json;
		 }
		 
		return res+"]";
	}
	
	public void insert(Timestamp time,String element,int length,int frame){
		Monitor t = new Monitor(time,element,length,frame);
		MonitorDAO adao = new MonitorDAO();
		Transaction tx = adao.getSession().beginTransaction();		
		adao.save(t);		
		tx.commit();
	}
}
