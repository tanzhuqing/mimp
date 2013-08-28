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
     * 增加用户 
     * @param user 要增加的用户 
     */ 
    public void add(User user){ 
        Session session = util.getSession(); 
        Transaction ts = null; 
        try{ 
            ts = session.beginTransaction(); 
            session.save(user); 
            ts.commit(); 
        }catch(Exception e){ 
            System.out.println("UserDaoImpl.add()方法发生异常:"); 
            e.printStackTrace(); 
        }finally{ 
            util.closeSession(session); 
        } 
    } 
     
    /** 
     * 登录验证 
     * @param name 
     *      * @param password 
     * @return -1:不存在用户名 ; -2:密码不正确 ; >0:登录成功(即返回该记录ID) 
     */ 
    public int isExist(String name,String password){ 
        //int state = 0 ;        //初始化状态变量 
        Session session = util.getSession(); 
        try{ 
            Query query = session.createQuery("from User u where u.name = ?"); 
            query.setString(0, name); 
            List list = query.list(); 
            if(null == list || 0 == list.size()){ 
                return -1 ;     //用户名不存在 
            } 
            Query query2 = session.createQuery("from User u where u.name = ? and u.pwd = ?");
            query2.setString(0, name); 
            query2.setString(1, password); 
            List list2 = query.list(); 
            if(null == list2){ 
                return -2 ;        //密码不正确 
            } 
            Iterator it = list.iterator(); 
            User user = (User)it.next(); 
            return user.getId();    //验证成功,取 ID值 
        }catch(Exception e){ 
            System.out.println("UserDaoImpl.isExist()方法发生异常:"); 
            e.printStackTrace(); 
            return 0;    //异常时返回0 
        }finally{ 
            util.closeSession(session); 
        } 
    } 
} 
  
