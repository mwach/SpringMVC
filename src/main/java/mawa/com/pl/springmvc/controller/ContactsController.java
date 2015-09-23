package mawa.com.pl.springmvc.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import mawa.com.pl.springmvc.bean.Contact;
import mawa.com.pl.springmvc.bean.ExclusiveContact;
import mawa.com.pl.springmvc.bean.Order;
import mawa.com.pl.springmvc.bean.Player;
import mawa.com.pl.springmvc.bean.Team;
import mawa.com.pl.springmvc.dao.ContactRepo;
import mawa.com.pl.springmvc.dao.TeamRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactsController {

	@Autowired
	ContactRepo repository;

	@Autowired
	TeamRepo teamRepository;

	@Autowired
	Validator validator;

	@RequestMapping("/uuid")
	@ResponseBody
	public Contact getUUID(HttpServletResponse response) throws IOException {
		Contact cnt = new Contact();
		cnt.setName(UUID.randomUUID().toString());
			Set<ConstraintViolation<Contact>> exc = validator.validate(cnt);
			if(!exc.isEmpty()){
				response.sendError(HttpStatus.BAD_REQUEST.value(), exc.toString());
			}else{
				repository.save(cnt);
			}
		return cnt;
	}

	/**
	 * One-To-Many with JOIN table
	 */
	@RequestMapping("/uuid2")
	@ResponseBody
	public ExclusiveContact getUUID2() {
		ExclusiveContact cnt = new ExclusiveContact();
		cnt.setName(UUID.randomUUID().toString());
		cnt.setGoldenCardNo(UUID.randomUUID().toString());
		Order order = new Order();
		order.setOrderUUID(UUID.randomUUID().toString());
		cnt.addOrder(order);
		repository.save(cnt);
		return cnt;
	}

	/**
	 * One-To-Many without JOIN table
	 */
	@RequestMapping("/uuid3")
	@ResponseBody
	public void getUUID3() {

		Team team = new Team();
		Player p1 = new Player();
		Player p2 = new Player();

		teamRepository.save(team);
		team.setPlayers(Arrays.asList(new Player[]{p2}));

		team.setName("t1");
		p1.setNickName("p1");
		p1.setTeam(team);
		p2.setNickName("p2");
		p2.setTeam(team);
		teamRepository.save(team);
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