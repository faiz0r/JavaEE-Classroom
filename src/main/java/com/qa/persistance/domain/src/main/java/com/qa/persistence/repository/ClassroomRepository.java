package com.qa.persistence.repository;

public interface ClassroomRepository {
	
	String getAllClass();
	
	String createClass(String createClassroom);
	
	String updateClass(Long id, String updateClassroom);
	
	String deleteClass(Long id);

}
