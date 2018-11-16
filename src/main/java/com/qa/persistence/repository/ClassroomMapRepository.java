package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistance.domain.Classroom;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class ClassroomMapRepository implements ClassroomRepository{
	
	private final Long INITIAL_COUNT = 1L;
	private Map<Long, Classroom> classMap;
	private Long ID;
	
	@Inject
	private JSONUtil util;
	
	public ClassroomMapRepository() {
		this.classMap = new HashMap<Long, Classroom>();
		ID = INITIAL_COUNT;
		initAccountMap();
	}

	public String getAllClass() {
		return util.getJSONForObject(classMap.values());
	}

	public String createClass(String classroom) {
		ID++;
		Classroom newClassroom = util.getObjectForJSON(classroom, Classroom.class);
		classMap.put(ID, newClassroom);
		return classroom;
	}

	public String updateClass(Long id, String updateClassroom) {
		Classroom newClassroom = util.getObjectForJSON(updateClassroom, Classroom.class);
		classMap.put(id, newClassroom);
		return updateClassroom;
	}

	public String deleteClass(Long id) {
		classMap.remove(id);
		return "{\"message\": \"class removed\"}";
	}
	
	private void initAccountMap() {
		Classroom classroom = new Classroom(ID, "Joe", "Bloggs");
		classMap.put(1L, classroom);
	}

}
