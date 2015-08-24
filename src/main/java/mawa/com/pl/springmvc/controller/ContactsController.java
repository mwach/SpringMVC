package mawa.com.pl.springmvc.controller;

import java.util.List;
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
	public Contact getUUID() {
		Contact cnt = new Contact();
		cnt.setName(UUID.randomUUID().toString());
		repository.save(cnt);
		return cnt;
		
	}

	@RequestMapping("/uuidname")
	@ResponseBody
	public Contact getUUIDWithName(
			@RequestParam(name = "name", defaultValue = "") String name) {
		List<Contact> cts = repository.findByName(name);
		return cts.isEmpty() ? null : cts.get(0);
	}

	@RequestMapping("/uuid/{id}")
	@ResponseBody
	public String getUUIDWithId(@PathVariable("id") String id) {
		return id + UUID.randomUUID().toString();
	}

}