package mawa.com.pl.springmvc.dao;

import java.util.List;

import mawa.com.pl.springmvc.bean.Contact;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel="contact", path="contact")
@Repository
public interface ContactRepo extends CrudRepository<Contact, Integer>{

	public List<Contact> findByName(@Param("name") String name);
}
