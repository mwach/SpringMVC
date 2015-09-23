package mawa.com.pl.springmvc.service;

import mawa.com.pl.springmvc.bean.Contact;
import mawa.com.pl.springmvc.dao.TransactionalRepo;
import mawa.com.pl.springmvc.service.exception.MyDaoException;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalService {

	@Autowired
	TransactionalRepo repo;

	@Autowired
	Validator validator;

	@Transactional(readOnly = false)
	public void storeItem(Contact contact) {
		Contact c1 = new Contact();
		c1.setName("asds");
		c1.setSurname("dsgfdsfd");
		repo.storeItem(c1);

		if (validator.validate(contact).size() > 0) {
			// throw new MyDaoException("dsd");
		}
		try {
			repo.storeItem(contact);
		} catch (Exception exc) {
			throw new MyDaoException("validation failed");
		}
	}
}
