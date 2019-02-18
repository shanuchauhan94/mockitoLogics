package com.example.demo.learning;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.example.demo.service.MailService;
import com.example.demo.service.RequestService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.example.demo.*")
public class PowerMockLogics {
 
	@InjectMocks
	private RequestService requestService;
	private static final String MESSAGE = "Email Send Successfully.";
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(MailService.class);
	}

	@Test
	public void testStaticSendMailMethod() {
		
		PowerMockito.mockStatic(MailService.class);
		when(MailService.sendEmail(23)).thenReturn(MESSAGE);
		String expected = RequestService.getAllUser(88);
		String actual = MailService.sendEmail(43);
		assertEquals(expected, actual);
		 
	}

}
