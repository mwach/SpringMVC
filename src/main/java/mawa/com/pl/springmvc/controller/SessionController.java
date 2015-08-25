package mawa.com.pl.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionController {

	@Autowired
	SessionClass sessionClass;

	@Autowired 
	HttpSession httpSession;

	@RequestMapping("/session")
	@ResponseBody
	public int getUUID() {
		if(sessionClass.isValid()){
			sessionClass.setCnt(sessionClass.getCnt() + 1);
			sessionClass.touch();
		}else{
			sessionClass.reset();
		}
		return sessionClass.getCnt();
		
	}
}