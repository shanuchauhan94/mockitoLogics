package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RequestModel;
import com.example.demo.service.RequestService;

@RestController
@RequestMapping("/webapp")
public class RequestController {

	@Autowired
	private RequestService requestService;
	
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveData(@RequestBody RequestModel requestModel) {
		RequestModel user = new RequestModel();
		if(requestModel != null)
          user = requestService.saveUser(requestModel);
		if(user != null)
		    return new ResponseEntity<>("Save data Successfully. "+user,HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Operation Failed.... "+user,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/data")
	public ResponseEntity<Object> findAllData() {
		 return new ResponseEntity<Object>(requestService.findAllRecords(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/skills/{id}")
	public ResponseEntity<Object> findUserSkills(@PathVariable("id") Integer sid) {
		 return new ResponseEntity<Object>(requestService.findAllSkills(sid),HttpStatus.ACCEPTED);
	}
	
	
}
