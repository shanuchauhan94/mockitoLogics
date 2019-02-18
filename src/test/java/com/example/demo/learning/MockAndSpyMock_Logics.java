package com.example.demo.learning;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.service.MailService;
import com.example.demo.service.RequestService;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("unchecked")
public class MockAndSpyMock_Logics {

	@Test
	public void spyLogicTest() {
		// make a dummy fake object
		ArrayList<String> mockArray = mock(ArrayList.class);
		assertEquals(0, mockArray.size());
		mockArray.add("Hello");
		assertEquals(0, mockArray.size());

		// in case of spy - --- > ArrayList as real one(Partial Mock) like James Bond
		ArrayList<String> spyArray = spy(ArrayList.class);
		assertEquals(0, spyArray.size());
		spyArray.add("Hello2");
		assertEquals(1, spyArray.size());

		verify(spyArray).add(Mockito.anyString());
		verify(spyArray, never()).clear(); // never call clear() method
	}

	// power mock to mock static and final methods

	@SuppressWarnings("static-access")
	@Test
	public void staticMethodTest() {
		MailService mailServiceSpy = spy(MailService.class);
		String staicOutput = mailServiceSpy.sendEmail(44);
		RequestService RequestServiceMock = spy(RequestService.class);
		String excepted = RequestServiceMock.getAllUser(33);
		assertEquals(staicOutput,excepted);

		//verify(mailServiceSpy).sendEmail(55); 
	}

}
