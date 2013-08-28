package com.action;

import java.sql.Timestamp;
import java.util.Iterator;

import com.DAO.TempDao;
import com.DAO.TempDaoImpl;
import com.opensymphony.xwork2.ActionContext; 
import com.opensymphony.xwork2.ActionSupport; 
public class DataUploadAction extends ActionSupport {

	private TempDao tempdao = new TempDaoImpl();
	private Integer id;
	private Timestamp time;
	private String text;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	 public String execute(Timestamp tt) throws Exception { 
	   String data="";
	   Iterator it=tempdao.search(tt).iterator();
	   while(it.hasNext())
	   {
		   data += (String)it.next();
		   
	   }
		 return data;
	 }
	
}
