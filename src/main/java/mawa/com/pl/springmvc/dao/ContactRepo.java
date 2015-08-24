package mawa.com.pl.springmvc.dao;

import java.util.List;

import mawa.com.pl.springmvc.bean.Contact;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends CrudRepository<Contact, Integer>{

	public List<Contact> findByName(String name);
}
