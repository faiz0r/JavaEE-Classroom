package com.qa.business;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.qa.persistance.domain.Classroom;

import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class Service {
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public Classroom findUser(Long id) {
		return em.find(Classroom.class, id);
	}

	@Transactional(REQUIRED)
	public Classroom createClass(Classroom classroom) {
		em.persist(classroom);
		return classroom;
	}

	@Transactional(REQUIRED)
	public Classroom deleteClass(Classroom classroom) {
		em.remove(classroom);
		return classroom;
	}

	@Transactional(REQUIRED)
	public Classroom updateClass(Classroom classroom) {
		em.merge(classroom);
		return classroom;
	}
	  
}