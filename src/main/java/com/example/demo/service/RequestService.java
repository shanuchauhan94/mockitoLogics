package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.RequestModel;
import com.example.demo.model.UserSkill;
import com.example.demo.repository.RequestRepository;
import com.example.demo.repository.SkillRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository requestRepository;
	@Autowired
	private SkillRepository skillRepository;

	public RequestService() {
	}

	public RequestService(RequestRepository requestRepository, SkillRepository skillRepository) {
		this.requestRepository = requestRepository;
		this.skillRepository = skillRepository;
	}

	public RequestModel saveUser(RequestModel requestModel) {
		if (requestModel != null)
			return requestRepository.saveAndFlush(requestModel);
		else
			return null;
	}

	public List<RequestModel> findAllRecords() {
		return requestRepository.findAll();
	}

	public Optional<UserSkill> findAllSkills(int sid) {
		if (sid != 0)
			return skillRepository.findById(sid);
		else
			return null;
	}
	 
	public static String getAllUser(int id) {
		if (id != 0) {
			return MailService.sendEmail(id);
		}
		else
			return MailService.sendEmail(id);

	}

}
