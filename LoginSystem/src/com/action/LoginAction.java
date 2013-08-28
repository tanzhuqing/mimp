package com.action; 
 
import java.util.Map; 
import com.opensymphony.xwork2.ActionContext; 
import com.opensymphony.xwork2.ActionSupport; 
import com.DAO.UserDao; 
import com.DAO.UserDaoImpl; 
 
public class LoginAction extends ActionSupport { 
     
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserDao userDao = new UserDaoImpl();//操纵数据库 DAO 类(Hibernate 实现),过Struts.xml 注入值 
     
    private int id; 
    private String name;    //用户名(值由 struts注入) 
    private String pwd;        //密码(值由 struts 注入) 
     
    private String inputCertCode;    //验证码 
 
    public int getId() { 
        return id; 
    } 
    public void setId(int id) { 
        this.id = id; 
    } 
    public String getName() { 
        return name; 
    } 
    public void setName(String name) { 
        this.name = name; 
    } 
    public String getPwd() { 
        return pwd; 
    } 
    public void setPwd(String pwd) { 
        this.pwd = pwd; 
    } 
 
    public String getInputCertCode() { 
        return inputCertCode; 
    } 
    public void setInputCertCode(String inputCertCode) { 
        this.inputCertCode = inputCertCode; 
    } 
    @Override 
    public String execute() throws Exception { 
        int state = userDao.isExist(name,pwd); 
        System.out.println("state="+state); 
        if(state == -1){ 
            this.addFieldError("name", "用户名不正确,请先注册!"); 
            return INPUT; 
        }else if(state == -2){ 
            this.addFieldError("pwd", "密码不正确,请重新输入密码!"); 
            return INPUT; 
        }else if(state > 0){ 
            System.out.println("[测试]登录成功!用户 ID="+state); 
            this.setId(state); 
            return SUCCESS; 
        }else{ 
            this.addFieldError("name", "登录失败,请与管理员联系!"); 
            return INPUT; 
        } 
    } 
 /**    
    public void validate() { 
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
     **/
    
 }
  

    