package action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import domain.User;



public class RegisterAction  extends DispatchAction{
  private RegisterAction registeraction;

public RegisterAction getRegisteraction() {
	return registeraction;
}

public void setRegisteraction(RegisterAction registeraction) {
	this.registeraction = registeraction;
}
 
public ActionForward newUser(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
	String username = (String) dyForm.get("username");// 取得用户名
	String password = (String) dyForm.get("password");// 取得密码

	User user = new User();
	user.setUsername(username);
	user.setPassword(password);

	//BookType bt = new BookType();
	//bt.setId(type);s
	//book.setBooktypeT(bt);
	//book.setInTime(new Date());
	//Operator o = new Operator();
	//o.setId(operator);
	//book.setOperatorT(o);
	//book.setPrice(price);
	//book.setPublisher(publisher);
	//bookInfoFacade.newBook(book, num);// 调用BookTypeFacade类中newBook()方法

	ActionForward actForward = mapping.findForward("showALLBookInfo");
	String path = actForward.getPath();
	path += "?method=findAllBook";// 需要传递的参数
	return new ActionForward(actForward.getName(), path, true);// 防止刷新提交

}

}
