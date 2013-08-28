package com.DAO;

import com.ORM.User; 
public interface UserDao { 
    
    /** 
     * 增加用户 
     * @param user 要增加的用户 
     */ 
    public void add(User user); 
     
    /** 
     * 登录验证 
     * @param name 
     * @param password 
     * @return -1:不存在用户名 ; -2:密码不正确 ; >0:登录成功(即返回该记录ID) 
     */ 
    public int isExist(String name,String password);     
}  