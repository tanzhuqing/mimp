package com.ORM;

public class User { 
	   
	  private int id;        //主键ID 
	  private String name;    //用户名 
	  private String pwd;        //密码 
	    /* 
	    * Getter 方法与Setter 方法 
	    */  
	  public User(){}
	  
	    public String getName() { 
	       return name; 
	   } 
	    public void setName(String name) { 
	       this.name = name; 
	   } 
	    public String getPwd() { 
	       return pwd; 
	   } 
	    public User(String name, String pwd) {
			this.name = name;
			this.pwd = pwd;
		}
		public void setPwd(String pwd) { 
	       this.pwd = pwd; 
	   } 
	    public void setId(int id) { 
	        this.id = id; 
	     
	          } 
	    public int getId()
	    {
	    	return this.id;
	    	
	    }
	     
	    
}