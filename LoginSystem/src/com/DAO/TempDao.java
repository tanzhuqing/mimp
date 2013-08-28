package com.DAO;

import com.ORM.Temp;
import java.sql.Timestamp;
import java.util.List;

public interface TempDao {

	public void save(Temp t);
	
	public List<String> search(Timestamp tt); 
}
