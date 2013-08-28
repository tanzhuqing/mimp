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

	private UserDao userDao = new UserDaoImpl();//�������ݿ� DAO ��(Hibernate ʵ��),��Struts.xml ע��ֵ 
     
    private int id; 
    private String name;    //�û���(ֵ�� strutsע��) 
    private String pwd;        //����(ֵ�� struts ע��) 
     
    private String inputCertCode;    //��֤�� 
 
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
            this.addFieldError("name", "�û�������ȷ,����ע��!"); 
            return INPUT; 
        }else if(state == -2){ 
            this.addFieldError("pwd", "���벻��ȷ,��������������!"); 
            return INPUT; 
        }else if(state > 0){ 
            System.out.println("[����]��¼�ɹ�!�û� ID="+state); 
            this.setId(state); 
            return SUCCESS; 
        }else{ 
            this.addFieldError("name", "��¼ʧ��,�������Ա��ϵ!"); 
            return INPUT; 
        } 
    } 
 /**    
    public void validate() { 
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
     **/
    
 }
  

    