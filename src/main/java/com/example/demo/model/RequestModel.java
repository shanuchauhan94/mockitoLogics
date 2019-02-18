package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class RequestModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String marks;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="sid",referencedColumnName="id")
	private List<UserSkill> userSkill = new ArrayList<>();
	
}
