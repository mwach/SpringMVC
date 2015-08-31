package mawa.com.pl.springmvc.dao;

import mawa.com.pl.springmvc.bean.Team;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamRepo extends CrudRepository<Team, Integer>{
}
