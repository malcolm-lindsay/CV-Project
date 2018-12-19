package com.qa.cv_manager.usercreationapi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.cv_manager.usercreationapi.rest.UserRest;
import com.qa.cv_manager.usercreationapi.service.UserServiceImpl;
import com.qa.cv_manager.usercreationapi.util.constants.Constants;

@RunWith(MockitoJUnitRunner.class)
public class EndpointTests {
	
	@InjectMocks
	private UserRest rest;
	
	@Mock
	private UserServiceImpl service;

	@Test
	public void getAllUsersTest() {
		Mockito.when(service.getAllUsers()).thenReturn(Constants.MOCK_LIST);
		assertEquals(Constants.MOCK_LIST, rest.getAllUsers());
		Mockito.verify(service).getAllUsers();
	}
	
	@Test
	public void addUserTest() {
		Mockito.when(service.addUser(Constants.TEST_USER_POJO)).thenReturn(Constants.RESPONSE_OK);
		assertEquals(Constants.RESPONSE_OK, rest.addUser(Constants.TEST_USER_POJO));
		Mockito.verify(service).addUser(Constants.TEST_USER_POJO);
	}
	
	@Test
	public void updatePasswordTest() {
		Mockito.when(service.updatePassword(Constants.TEST_USER_POJO, Constants.MOCK_USERNAME)).thenReturn(Constants.RESPONSE_OK);
		assertEquals(Constants.RESPONSE_OK, rest.updatePassword(Constants.TEST_USER_POJO, Constants.MOCK_USERNAME));
		Mockito.verify(service).updatePassword(Constants.TEST_USER_POJO, Constants.MOCK_USERNAME);
	}
	
	@Test
	public void deleteUserTest() {
		Mockito.when(service.deleteUser(Constants.MOCK_USERNAME)).thenReturn(Constants.RESPONSE_OK);
		assertEquals(Constants.RESPONSE_OK, rest.deleteUser(Constants.MOCK_USERNAME));
		Mockito.verify(service).deleteUser(Constants.MOCK_USERNAME);
	}
	
	@Test
	public void enableAccountTest() {
		Mockito.when(service.enableAccount(Constants.MOCK_USERNAME)).thenReturn(Constants.RESPONSE_OK);
		assertEquals(Constants.RESPONSE_OK, rest.enableAccount(Constants.MOCK_USERNAME));
		Mockito.verify(service).enableAccount(Constants.MOCK_USERNAME);
	}
	
	@Test
	public void disableAccountTest() {
		Mockito.when(service.disableAccount(Constants.MOCK_USERNAME)).thenReturn(Constants.RESPONSE_OK);
		assertEquals(Constants.RESPONSE_OK, rest.disableAccount(Constants.MOCK_USERNAME));
		Mockito.verify(service).disableAccount(Constants.MOCK_USERNAME);
	}
}