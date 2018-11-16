package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistance.domain.Classroom;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	public String getAllClass() {
		TypedQuery<Classroom> query = manager.createQuery("SELECT a FROM Account a", Classroom.class);
        return util.getJSONForObject(query.getResultList());
	}
	
	@Transactional(REQUIRED)
	public String createClass(String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		manager.persist(aClassroom);
		return "{\"message\": \"account has been added\"}";
	}

	@Transactional(REQUIRED)
	public String updateClass(Long id, String updateToClassroom) {
		Classroom updatedClassroom = util.getObjectForJSON(updateToClassroom, Classroom.class);
		Classroom classFromDB = findClass(id);
		if(updateToClassroom != null) {
			classFromDB = updatedClassroom;
			manager.merge(classFromDB);
		}
		return "{\"message\": \"class updated\"}";
	}

	public String deleteClass(Long id) {
		Classroom accountInDB = findClass(id);
		if(accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"account deleted\"}";
	}
	
	private Classroom findClass(Long id) {
		return manager.find(Classroom.class, id);
	}
	
	private void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	

}
