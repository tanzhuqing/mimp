package com.action; 
 
import java.util.Map; 
 
import com.opensymphony.xwork2.ActionContext; 
import com.opensymphony.xwork2.ActionSupport; 
import com.DAO.UserDao; 
import com.DAO.UserDaoImpl; 
import com.ORM.User; 
 
public class RegisterAction extends ActionSupport { 
 
    private UserDao userDao = new UserDaoImpl(); 
 
    private User user;    //注册提交的用户对象 
     
    private String repwd;    //重复密码 
     
    private String inputCertCode;    //验证码 

	private String SUCCESS;
 
    public User getUser() { 
        return user; 
    } 
 
    public void setUser(User user) { 
        this.user = user; 
    } 
 
    public String getRepwd() { 
        return repwd; 
    } 
 
    public void setRepwd(String repwd) { 
        this.repwd = repwd; 
    } 
    public String getInputCertCode() { 
   
        return inputCertCode; 
    } 
     public void setInputCertCode(String inputCertCode) { 
        this.inputCertCode = inputCertCode; 
    } 
    @Override 
     public String execute() throws Exception { 
       // User user = new User(); 
        userDao.add(user);        //保存注册的user 对象 
        return SUCCESS; 
    } 
  //  @Override 
  /**   public void validate() { 
        //验证码验证 
         if(null == inputCertCode || "".equals(inputCertCode)){ 
            this.addFieldError("inputCertCode", "验证码不能为空!"); 
         }else{ 
            Map session = ActionContext.getContext().getSession(); 
            String certCode = session.get("certCode").toString(); 
             if( ! certCode.equals(this.inputCertCode)){ 
                this.addFieldError("inputCertCode", "验证码不正确!"); 
            } 
        } 
         
    }
    **/
}
         
   
    
    