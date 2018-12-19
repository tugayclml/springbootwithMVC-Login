package com.springbootmvc.serviceTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springbootmvc.login.model.User;
import com.springbootmvc.repository.RoleRepository;
import com.springbootmvc.repository.UserRepository;
import com.springbootmvc.service.UserService;

public class UserServiceTest {
	
	@Mock
	private UserRepository mockUserRepository;
	
	@Mock
	private RoleRepository mockRoleRepository;
	
	@Mock
	private BCryptPasswordEncoder mockBCryptPasswordEncoder;
	
	private UserService userServiceUnderTest;
	private User user;

	@Before
	public void setUp() {
		initMocks(this);
		
		userServiceUnderTest = new UserService(mockUserRepository,mockRoleRepository,mockBCryptPasswordEncoder);
		
		user = User.builder()
                .id(1)
                .name("Gustavo")
                .lastName("Ponce")
                .email("test@test.com")
                .build();
		
		Mockito.when(mockUserRepository.save(any())).thenReturn(user);
		
		Mockito.when(mockUserRepository.findByEmail(anyString())).thenReturn(user);
	}
	
	@Test
	public void testFindUserByEmail() {
		final String email = "deneme@hotmail.com";
		
		final User result = userServiceUnderTest.findUserByEmail(email);
		
		assertEquals(email, result);
	}
	
	@Test
	public void testAddUser() {
		final String email = "deneme@hotmail.com";
		
		User result = userServiceUnderTest.addUser(User.builder().build());
		
		assertEquals(email,result.getEmail());
	}
}

