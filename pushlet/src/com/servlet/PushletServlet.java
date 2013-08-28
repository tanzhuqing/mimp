package com.servlet;


import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventPullSource; 
import java.io.Serializable; 
	      
	     /** 
	     *Created by IntelliJ IDEA. 
	     * User:liuzhy 
	     * Date: 2011-1-18
	     * Time:10:54:35 
	     */
public class PushletServlet  implements Serializable{ 
	        static public class HwPlushlet extends EventPullSource { 
	     
	            @Override 
	            protected long getSleepTime() { 
	                return 1000;   
	            } 
	     
	            @Override 
	           protected Event pullEvent() { 
	               Event event =Event.createDataEvent("/zhaoyang/hi"); 
	                event.setField("hw","hello,world"); 
	                return event;  
	           } 
	        } 
}
