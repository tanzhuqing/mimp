package com.DAO;

import java.sql.Timestamp;
import java.util.Iterator; 
import java.util.List; 
import org.hibernate.Query; 
import org.hibernate.Session; 
import org.hibernate.Transaction; 
import com.ORM.Temp;
import com.hibernate.HibernateUtil; 

public class TempDaoImpl implements TempDao {

	HibernateUtil util = new HibernateUtil(); 
	public void save(Temp t)
	{
		Session session = util.getSession(); 
        Transaction ts = null; 
        try{ 
            ts = session.beginTransaction(); 
            session.save(t); 
            ts.commit(); 
        }catch(Exception e){ 
            System.out.println("TempDaoImpl.add()方法发生异常:"); 
            e.printStackTrace(); 
        }finally{ 
            util.closeSession(session); 
        } 
		
	}
	
	public List<String> search(Timestamp tt)
	{
		 String s="";
		 List<String> datalist = null;
		Session session = util.getSession(); 
		 try{ 
			   String time = tt.toString();
	            Query query = session.createQuery("from temp t where t.tTime = ?"); 
	            query.setString(0,time); 
	            List<Temp> list = query.list(); 
	            Iterator it = list.iterator(); 
	            //Temp temp = (Temp)it.next(); 
	           
	            while(it.hasNext())
	            {
	            	Temp temp=(Temp)it.next();
	            	datalist.add(temp.getText());
	            }
	            return datalist;
	        }catch(Exception e){ 
	            System.out.println("TempDaoImpl.Search()方法发生异常:"); 
	            e.printStackTrace(); 
	            return datalist;    //异常时返回0 
	        }finally{ 
	            util.closeSession(session); 
	        } 
	    
	}
}
