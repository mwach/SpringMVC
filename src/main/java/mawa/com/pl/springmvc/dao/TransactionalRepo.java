package mawa.com.pl.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import mawa.com.pl.springmvc.bean.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionalRepo {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@PersistenceContext
	private EntityManager entityManager;

	public void storeItem(Contact contact) {

			entityManager.persist(contact);
			entityManager.flush();
	}
}
