package com.qa.business;

public interface ClassService {
	
	String getAllClass();
	
	String createClass(String classroom);
	
	String updateClass(Long id, String classroom);

	String deleteClass(Long id);
	
}
