package com.qa.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistance.domain.Classroom;
import com.qa.persistence.repository.ClassroomRepository;

public class ClassServiceImpl implements ClassService {
	
	private static final Logger LOGGER = Logger.getLogger(Classroom.class);
	
	@Inject
	private ClassroomRepository repo;


	public String getAllClass() {
		LOGGER.info("In ClassServiceImpl getAllClass ");
		return repo.getAllClass();
	}

	public String createClass(String createClassroom) {
		return repo.createClass(createClassroom);
	}

	public String updateClass(Long id, String classroom) {
		return repo.updateClass(id, classroom);
	}

	public String deleteClass(Long id) {
		return repo.deleteClass(id);
	}

}
