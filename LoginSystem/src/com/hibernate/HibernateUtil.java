package com.hibernate;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration; 
 
public class HibernateUtil { 
     
    //���� Hibernate�����ļ����ڵ�·�� 
    private static String configFile = "/hibernate.cfg.xml"; 
    //�� Configuration���� 
    private static Configuration configuration = new Configuration(); 
    //�� Session�������� 
    private static SessionFactory sessionFactory = null; 
    /** 
     * ����ģʽ,ֻ��ʼ��һ ,ֻ����һ SessionFactory����(�̰߳�ȫ) 
     */ 
    static { 
        try{ 
            //ͨ��hibernate.cfg.xml �������ݿ����� 
       
            configuration.configure(configFile); 
            //����һ Session���� 
           
            sessionFactory = configuration.buildSessionFactory(); 
            System.out.println("[���]��ʼ��SessionFactory"); 
        }catch(Exception e){ 
            System.out.println("[�쳣]����SessionFactoryʱ�����쳣,�쳣ԭ������:"); 
            e.printStackTrace(); 
        } 
    } 
     
    /** 
    /** 
     * getSession()���� 
     * @return Session���� 
     * @throws HibernateException 
     */ 
     public Session getSession(){ 
        Session session = null; 
         try{ 
            session = sessionFactory.openSession(); 
         }catch(Exception e){ 
            System.out.println("[�쳣]�� Sessionʱ�����쳣,�쳣ԭ������:"); 
            e.printStackTrace(); 
         } 
         return session; 
     } 
      
     /** 
      * closeSession()���� 
      * @param session Ҫ�رյ�Session���� 
      */ 
     public void closeSession(Session session){ 
         try{ 
             if(null != session) 
                 session.close(); 
         }catch(Exception e){ 
             System.out.println("[�쳣]�ر�Sessionʱ�����쳣,�쳣ԭ������:"); 
             e.printStackTrace(); 
         } 
     } 
      
      
      
 } 
   