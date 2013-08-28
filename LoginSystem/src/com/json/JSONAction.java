package com.json;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class JSONAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private static final long serialVersionUID = -989477296829078690L;

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String format;
	
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
	    this.response = response;	
	}

	public void json() {
				JSONArray jsonArray = new JSONArray();
				
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", 1);
				jsonObject.put("title", "哈利波特");
				jsonObject.put("timelength", 89);
				
				JSONObject jsonObject1 = new JSONObject();
				jsonObject1.put("id", 2);
				jsonObject1.put("title", "速度与激情");
				jsonObject1.put("timelength", 120);
				
				JSONObject jsonObject2 = new JSONObject();
				jsonObject2.put("id", 3);
				jsonObject2.put("title", "变形金刚3");
				jsonObject2.put("timelength", 100);
			
				jsonArray.add(0, jsonObject);
				jsonArray.add(1, jsonObject1);
				jsonArray.add(2, jsonObject2);
				
				try {
					this.response.setCharacterEncoding("UTF-8");
					this.response.getWriter().write(jsonArray.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
}
