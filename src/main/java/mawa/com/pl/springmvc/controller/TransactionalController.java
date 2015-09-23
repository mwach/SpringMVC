package mawa.com.pl.springmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import mawa.com.pl.springmvc.bean.Contact;
import mawa.com.pl.springmvc.service.TransactionalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TransactionalController {

	@Autowired
	TransactionalService transactionalService;

	@RequestMapping("/store")
	@ResponseBody
	public void storeItem(){
		Contact contact = new Contact();
		transactionalService.storeItem(contact);
	}

	@RequestMapping("/store2")
	@ResponseBody
	public void storeItem2(@Valid Contact contact, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			throw new RuntimeException("blah");
		}
		transactionalService.storeItem(contact);
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public void handleNotFoundException(RuntimeException exc, WebRequest request, HttpServletResponse response) throws IOException {
	    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Sorry dude, my server broke");

	}

}
