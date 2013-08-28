package com.DAO;
import java.util.Iterator; 
import java.util.List; 
import org.hibernate.Query; 
import org.hibernate.Session; 
import org.hibernate.Transaction; 
import com.ORM.User; 
import com.hibernate.HibernateUtil; 
public class UserDaoImpl implements UserDao { 
	 
    HibernateUtil util = new HibernateUtil(); 
     
    /** 
     * �����û� 
     * @param user Ҫ���ӵ��û� 
     */ 
    public void add(User user){ 
        Session session = util.getSession(); 
        Transaction ts = null; 
        try{ 
            ts = session.beginTransaction(); 
            session.save(user); 
            ts.commit(); 
        }catch(Exception e){ 
            System.out.println("UserDaoImpl.add()���������쳣:"); 
            e.printStackTrace(); 
        }finally{ 
            util.closeSession(session); 
        } 
    } 
     
    /** 
     * ��¼��֤ 
     * @param name 
     *      * @param password 
     * @return -1:�������û��� ; -2:���벻��ȷ ; >0:��¼�ɹ�(�����ظü�¼ID) 
     */ 
    public int isExist(String name,String password){ 
        //int state = 0 ;        //��ʼ��״̬���� 
        Session session = util.getSession(); 
        try{ 
            Query query = session.createQuery("from User u where u.name = ?"); 
            query.setString(0, name); 
            List list = query.list(); 
            if(null == list || 0 == list.size()){ 
                return -1 ;     //�û��������� 
            } 
            Query query2 = session.createQuery("from User u where u.name = ? and u.pwd = ?");
            query2.setString(0, name); 
            query2.setString(1, password); 
            List list2 = query.list(); 
            if(null == list2){ 
                return -2 ;        //���벻��ȷ 
            } 
            Iterator it = list.iterator(); 
            User user = (User)it.next(); 
            return user.getId();    //��֤�ɹ�,ȡ IDֵ 
        }catch(Exception e){ 
            System.out.println("UserDaoImpl.isExist()���������쳣:"); 
            e.printStackTrace(); 
            return 0;    //�쳣ʱ����0 
        }finally{ 
            util.closeSession(session); 
        } 
    } 
} 
  
