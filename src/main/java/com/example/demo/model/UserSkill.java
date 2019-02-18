package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class UserSkill {
	
	@Id
	@SequenceGenerator(name="swq",allocationSize=23,initialValue=3213,sequenceName="skill_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="swq")
	private int sid;
	private String name;
	private String branch; 
	
	private String skills;
	
}
