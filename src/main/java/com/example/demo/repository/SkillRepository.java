package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserSkill;

@Repository
public interface SkillRepository extends JpaRepository<UserSkill, Integer> {

}
