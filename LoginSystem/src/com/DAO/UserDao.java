package com.DAO;

import com.ORM.User; 
public interface UserDao { 
    
    /** 
     * �����û� 
     * @param user Ҫ���ӵ��û� 
     */ 
    public void add(User user); 
     
    /** 
     * ��¼��֤ 
     * @param name 
     * @param password 
     * @return -1:�������û��� ; -2:���벻��ȷ ; >0:��¼�ɹ�(�����ظü�¼ID) 
     */ 
    public int isExist(String name,String password);     
}  