package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.model.RequestModel;
import com.example.demo.model.UserSkill;
import com.example.demo.repository.RequestRepository;
import com.example.demo.repository.SkillRepository;

@SuppressWarnings("unchecked")
@RunWith(MockitoJUnitRunner.class)
public class RequestServiceTest {

	@Mock
	private RequestRepository requestRepository;
	@Mock
	private SkillRepository skillRepository;

	@InjectMocks
	private RequestService requestService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		requestService = new RequestService(requestRepository, skillRepository);
	}

	@Test
	public void testFindAllRecords() {
		// List<RequestModel> list = new ArrayList<>();
		ArrayList<RequestModel> list = Mockito.mock(ArrayList.class);

		when(requestRepository.findAll()).thenReturn(list);
		List<RequestModel> actual = requestService.findAllRecords();
		assertEquals(list, actual);
		verify(requestRepository).findAll();
	}

	@Test
	public void findAllSkillsTest() {
		Optional<UserSkill> testskills = Optional.of(new UserSkill());
		when(skillRepository.findById(Mockito.anyInt())).thenReturn(testskills);

		Optional<UserSkill> skills = requestService.findAllSkills(44);
		assertEquals(testskills, skills);
		verify(skillRepository).findById(Mockito.anyInt());
	}

	@Test
	public void saveUserTest() {
		RequestModel requestModel = new RequestModel();
		when(requestRepository.saveAndFlush(Mockito.any())).thenReturn(new RequestModel());

		RequestModel dummyReturn = requestService.saveUser(requestModel);
		assertEquals(requestModel, dummyReturn);
		verify(requestRepository).saveAndFlush(requestModel);
	}

	@Test
	public void saveNullUserTest() {
		RequestModel requestModel = new RequestModel();
		when(requestRepository.saveAndFlush(Mockito.any())).thenReturn(null);
		RequestModel dummyReturn = requestService.saveUser(requestModel);
		assertEquals(null, dummyReturn);
		verify(requestRepository).saveAndFlush(Mockito.any());
	}
}
