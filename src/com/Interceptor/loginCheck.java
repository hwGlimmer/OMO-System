package com.Interceptor;

import java.util.Map;

import com.entity.Users;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * ¹¦ÄÜ£ºµÇÂ½À¹½ØÆ÷
 * @author ºúÎ°
 * Ê±¼ä£º2017/8/25
 *
 */
public class loginCheck implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		ActionContext ctx = arg0.getInvocationContext();
		
		Map<String,Object> session = ctx.getSession();
		Users user = (Users) session.get("user");
		if(user==null){
			return "unlogin";
		}
		return arg0.invoke();
	}

}
