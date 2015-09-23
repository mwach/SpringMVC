package mawa.com.pl.springmvc.service;

import mawa.com.pl.springmvc.bean.Contact;
import mawa.com.pl.springmvc.dao.TransactionalRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionalService {

	@Autowired
	TransactionalRepo repo;

	@Transactional(readOnly = false, noRollbackFor=Throwable.class)
	public void storeItem(Contact contact) {
			Contact c1 = new Contact();
			c1.setName("asds");
			c1.setSurname("dsgfdsfd");
			repo.storeItem(c1);

			repo.storeItem(contact);
	}
}
