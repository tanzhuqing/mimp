package com.hibernate;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration; 
 
public class HibernateUtil { 
     
    //声明 Hibernate配置文件所在的路径 
    private static String configFile = "/hibernate.cfg.xml"; 
    //建 Configuration对象 
    private static Configuration configuration = new Configuration(); 
    //建 Session工厂对象 
    private static SessionFactory sessionFactory = null; 
    /** 
     * 单例模式,只初始化一 ,只产生一 SessionFactory对象(线程安全) 
     */ 
    static { 
        try{ 
            //通过hibernate.cfg.xml 配置数据库连接 
       
            configuration.configure(configFile); 
            //建立一 Session工厂 
           
            sessionFactory = configuration.buildSessionFactory(); 
            System.out.println("[标记]初始化SessionFactory"); 
        }catch(Exception e){ 
            System.out.println("[异常]创建SessionFactory时发生异常,异常原因如下:"); 
            e.printStackTrace(); 
        } 
    } 
     
    /** 
    /** 
     * getSession()方法 
     * @return Session对象 
     * @throws HibernateException 
     */ 
     public Session getSession(){ 
        Session session = null; 
         try{ 
            session = sessionFactory.openSession(); 
         }catch(Exception e){ 
            System.out.println("[异常]开 Session时发生异常,异常原因如下:"); 
            e.printStackTrace(); 
         } 
         return session; 
     } 
      
     /** 
      * closeSession()方法 
      * @param session 要关闭的Session对象 
      */ 
     public void closeSession(Session session){ 
         try{ 
             if(null != session) 
                 session.close(); 
         }catch(Exception e){ 
             System.out.println("[异常]关闭Session时发生异常,异常原因如下:"); 
             e.printStackTrace(); 
         } 
     } 
      
      
      
 } 
   