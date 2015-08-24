package mawa.com.pl.springmvc.controller;

import java.util.UUID;

import mawa.com.pl.springmvc.bean.Contact;
import mawa.com.pl.springmvc.dao.ContactRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactsController {

	@Autowired
	ContactRepo repository;

	@RequestMapping("/uuid")
	@ResponseBody
	public String getUUID() {
		Contact cnt = new Contact();
		cnt.setName(UUID.randomUUID().toString());
		repository.save(cnt);
		return Integer.toString(cnt.getId());
		
	}

	@RequestMapping("/uuidname")
	@ResponseBody
	public String getUUIDWithName(
			@RequestParam(name = "name", defaultValue = "") String name) {
		return name + UUID.randomUUID().toString();
	}

	@RequestMapping("/uuid/{id}")
	@ResponseBody
	public String getUUIDWithId(@PathVariable("id") String id) {
		return id + UUID.randomUUID().toString();
	}

}