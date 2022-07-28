package com.agrotis.agrotisapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.agrotis.agrotisapi.entity.Laboratory;
import com.agrotis.agrotisapi.entity.Property;
import com.agrotis.agrotisapi.entity.User;
import com.agrotis.agrotisapi.exceptions.ResourceNotFound;
import com.agrotis.agrotisapi.repository.LaboratoryRepository;
import com.agrotis.agrotisapi.repository.PropertyRepository;
import com.agrotis.agrotisapi.repository.UserRepository;
import com.agrotis.agrotisapi.requests.LaboratoryRequest;
import com.agrotis.agrotisapi.requests.PropertyRequest;
import com.agrotis.agrotisapi.requests.UserRequest;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	private static final LocalDate NOW = LocalDate.now();

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	@Mock
	private PropertyRepository propertyRepository;

	@Mock
	private LaboratoryRepository laboratoryRepository;

	
	@Test // create method
	public void shouldReturnUserWithSuccess() throws ResourceNotFound {
		User userMock = new User();
		userMock.setId(89l);
		userMock.setName("Flavio Lima");
		userMock.setFinishAt(NOW);
		userMock.setStartAt(NOW);
		
		Property propMock = new Property();
		propMock.setId(1L);
		propMock.setName("Agrotis Prop");
		propMock.setDocument(1234567891234L);

		Laboratory labMock = new Laboratory();
		labMock.setId(1L);
		labMock.setName("Agrotis Lab");
		
		PropertyRequest propRequest = new PropertyRequest();
		propRequest.setId(1L);
		propRequest.setName("Agrotis Prop");
		propRequest.setDocument(1234567891234L);
		
		LaboratoryRequest labRequest = new LaboratoryRequest();
		labRequest.setId(1L);
		labRequest.setName("Agrotis Lab");
		
		UserRequest userRequest = new UserRequest();
		userRequest.setName("Flavio Lima");
		userRequest.setProperty(propRequest);
		userRequest.setLaboratory(labRequest);
		userRequest.setFinishAt(NOW);
		userRequest.setStartAt(NOW);

		when(propertyRepository.findById(anyLong())).thenReturn(Optional.of(propMock));
		when(laboratoryRepository.findById(anyLong())).thenReturn(Optional.of(labMock));

		when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(userMock);
		userService.create(userRequest);

		assertThat(userMock.getName()).isSameAs(userRequest.getName());
		assertThat(userMock.getNotes()).isSameAs(userRequest.getNotes());
		assertThat(userMock.getStartAt()).isSameAs(userRequest.getStartAt());
		assertThat(userMock.getFinishAt()).isSameAs(userRequest.getFinishAt());
		
		verify(propertyRepository).findById(anyLong());
		verify(laboratoryRepository).findById(anyLong());
		verify(userRepository).save(ArgumentMatchers.any(User.class));
	}
	
	
	@Test // update method
	public void shouldUpdateUserIfFound() throws ResourceNotFound {
		User user = new User();
		user.setId(89l);
		user.setName("Flavio Lima");
		user.setNotes("notes test");
		user.setFinishAt(NOW);
		user.setStartAt(NOW);

		PropertyRequest propRequest = new PropertyRequest();
		propRequest.setId(1L);
		propRequest.setName("Agrotis Prop");
		propRequest.setDocument(1234567891234L);
		
		Property propMock = new Property();
		propMock.setId(1L);
		propMock.setName("Agrotis Prop");
		propMock.setDocument(1234567891234L);

		Laboratory labMock = new Laboratory();
		labMock.setId(1L);
		labMock.setName("Agrotis Lab");
		
		LaboratoryRequest labRequest = new LaboratoryRequest();
		labRequest.setId(1L);
		labRequest.setName("Agrotis Lab");
		
		UserRequest newUser = new UserRequest();
		newUser.setName("Flavio Oliveira"); 
		newUser.setNotes("updated test notes");
		newUser.setStartAt(NOW);
		newUser.setFinishAt(NOW);
		newUser.setProperty(propRequest);
		newUser.setLaboratory(labRequest);
		
		when(propertyRepository.findById(anyLong())).thenReturn(Optional.of(propMock));
		when(laboratoryRepository.findById(anyLong())).thenReturn(Optional.of(labMock));
		
		when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
		userService.update(user.getId(), newUser);

		verify(propertyRepository).findById(anyLong());
		verify(laboratoryRepository).findById(anyLong());
		verify(userRepository).save(user);
		verify(userRepository).findById(user.getId());
	}
	
	@Test(expected = ResourceNotFound.class) // create method
	public void shouldThrowExceptionWhenPropertyNotFound() throws ResourceNotFound {
		
		PropertyRequest propRequest = new PropertyRequest();
		propRequest.setId(1L);
		propRequest.setName("Agrotis Prop");
		propRequest.setDocument(1234567891234L);
		
		LaboratoryRequest labRequest = new LaboratoryRequest();
		labRequest.setId(1L);
		labRequest.setName("Agrotis Lab");
		
		UserRequest userRequest = new UserRequest();
		userRequest.setName("Flavio Lima");
		userRequest.setProperty(propRequest);
		userRequest.setLaboratory(labRequest);
		userRequest.setFinishAt(NOW);
		userRequest.setStartAt(NOW);

		when(propertyRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

		userService.create(userRequest);
	}
	
	@Test(expected = ResourceNotFound.class) // create method
	public void shouldThrowExceptionWhenLaboratoryNotFound() throws ResourceNotFound {
		User user = new User();
		user.setId(89l);
		user.setName("Flavio Lima");
		user.setNotes("notes test");
		user.setFinishAt(NOW);
		user.setStartAt(NOW);

		PropertyRequest propRequest = new PropertyRequest();
		propRequest.setId(1L);
		propRequest.setName("Agrotis Prop");
		propRequest.setDocument(1234567891234L);
		
		Property propMock = new Property();
		propMock.setId(1L);
		propMock.setName("Agrotis Prop");
		propMock.setDocument(1234567891234L);

		Laboratory labMock = new Laboratory();
		labMock.setId(1L);
		labMock.setName("Agrotis Lab");
		
		LaboratoryRequest labRequest = new LaboratoryRequest();
		labRequest.setId(1L);
		labRequest.setName("Agrotis Lab");
		
		UserRequest newUser = new UserRequest();
		newUser.setName("Flavio Oliveira"); 
		newUser.setNotes("updated test notes");
		newUser.setStartAt(NOW);
		newUser.setFinishAt(NOW);
		newUser.setProperty(propRequest);
		newUser.setLaboratory(labRequest);
		
		when(propertyRepository.findById(anyLong())).thenReturn(Optional.of(propMock));
		when(laboratoryRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
		
		userService.update(user.getId(), newUser);;
	}
	
	@Test(expected = ResourceNotFound.class) // update method
	public void shouldThrowExceptionWhenUserDoesntExist() throws ResourceNotFound {
		User user = new User();
		user.setId(89l);
		user.setName("Flavio Lima");
		user.setNotes("notes test");
		user.setFinishAt(NOW);
		user.setStartAt(NOW);

		PropertyRequest propRequest = new PropertyRequest();
		propRequest.setId(1L);
		propRequest.setName("Agrotis Prop");
		propRequest.setDocument(1234567891234L);
		
		Property propMock = new Property();
		propMock.setId(1L);
		propMock.setName("Agrotis Prop");
		propMock.setDocument(1234567891234L);

		Laboratory labMock = new Laboratory();
		labMock.setId(1L);
		labMock.setName("Agrotis Lab");
		
		LaboratoryRequest labRequest = new LaboratoryRequest();
		labRequest.setId(1L);
		labRequest.setName("Agrotis Lab");
		
		UserRequest newUser = new UserRequest();
		newUser.setName("Flavio Oliveira"); 
		newUser.setNotes("updated test notes");
		newUser.setStartAt(NOW);
		newUser.setFinishAt(NOW);
		newUser.setProperty(propRequest);
		newUser.setLaboratory(labRequest);
		
		when(propertyRepository.findById(anyLong())).thenReturn(Optional.of(propMock));
		when(laboratoryRepository.findById(anyLong())).thenReturn(Optional.of(labMock));
		
		when(userRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
		userService.update(user.getId(), newUser);
	}

	
	@Test // delete method
	public void shouldDeleteUserIfFound() throws ResourceNotFound {
		User user = new User();
		user.setName("Flavio Lima");
		user.setId(1L);

		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		userService.delete(user.getId());

		verify(userRepository).deleteById(user.getId());
	}

	@Test(expected = ResourceNotFound.class) // delete method
	public void shouldThrowExceptionWhenUserDoenstExistAndTryDelete() throws ResourceNotFound {
		User user = new User();
		user.setName("Test Name");
		user.setId(1111L);

		when(userRepository.findById(user.getId())).thenReturn(Optional.ofNullable(null));
		userService.delete(user.getId());
	}

	
	@Test // list all method
	public void shouldReturnAllUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User());

		when(userRepository.findAll()).thenReturn(users);
		List<User> expected = userService.findAll();
		
		assertEquals(expected, users);
		verify(userRepository).findAll();
	}

	
	@Test // list by id method
	public void shouldListUserIfFound() throws ResourceNotFound {
		User user = new User();
		user.setId(89L);

		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		User expected = userService.findById(user.getId());

		assertThat(expected).isSameAs(user);
		verify(userRepository).findById(user.getId());
	}

	@Test(expected = ResourceNotFound.class) // list by id method
	public void shouldThrowExceptionWhenUserDoesntExistAndTryListById() throws ResourceNotFound {
		User user = new User();
		user.setId(89L);
		user.setName("Test Name");

		when(userRepository.findById(user.getId())).thenReturn(Optional.ofNullable(null));
		userService.findById(user.getId());
	}

}
