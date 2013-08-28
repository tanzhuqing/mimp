package com.action; 
 
import java.util.Map; 
 
import com.opensymphony.xwork2.ActionContext; 
import com.opensymphony.xwork2.ActionSupport; 
import com.DAO.UserDao; 
import com.DAO.UserDaoImpl; 
import com.ORM.User; 
 
public class RegisterAction extends ActionSupport { 
 
    private UserDao userDao = new UserDaoImpl(); 
 
    private User user;    //ע���ύ���û����� 
     
    private String repwd;    //�ظ����� 
     
    private String inputCertCode;    //��֤�� 

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
        userDao.add(user);        //����ע���user ���� 
        return SUCCESS; 
    } 
  //  @Override 
  /**   public void validate() { 
        //��֤����֤ 
         if(null == inputCertCode || "".equals(inputCertCode)){ 
            this.addFieldError("inputCertCode", "��֤�벻��Ϊ��!"); 
         }else{ 
            Map session = ActionContext.getContext().getSession(); 
            String certCode = session.get("certCode").toString(); 
             if( ! certCode.equals(this.inputCertCode)){ 
                this.addFieldError("inputCertCode", "��֤�벻��ȷ!"); 
            } 
        } 
         
    }
    **/
}
         
   
    
    