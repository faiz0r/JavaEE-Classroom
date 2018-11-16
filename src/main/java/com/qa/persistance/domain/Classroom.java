package com.qa.persistance.domain;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.mapping.List;

@Entity
public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classroomid;
	@Column(length = 100)
	private String trainer;
	@Column(length = 100)
	private String trainees;
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trainees")
//	private List<trainees> trainee = new ArrayList<>();
//
//	@Entity
//	public class trainees {
//	    @ManyToOne(fetch = FetchType.LAZY)
//	    @JoinColumn(name = "classroomid")
//	    private Classroom classroom;
//	}
	
	
	public Classroom() {
		
	}
	
	public Classroom(Long classroomid, String trainer, String trainees) {
		this.classroomid = classroomid;
		this.trainer = trainer;
		this.trainees = trainees;
		
	}

	public Long getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(Long classroomid) {
		this.classroomid = classroomid;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getTrainees() {
		return trainees;
	}

	public void setTrainees(String trainees) {
		this.trainees = trainees;
	}
	
}
