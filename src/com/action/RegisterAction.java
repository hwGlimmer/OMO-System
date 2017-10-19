package com.action;

import org.springframework.stereotype.Controller;
/**
 * 功能:帮助拦截器进行页面跳转，没有其他参与业务逻辑
 * @author 胡伟
 * 时间：2017/8/26
 *
 */
@Controller
public class RegisterAction{
	public String execute(){
		return "success";
	}
}
