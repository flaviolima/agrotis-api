package com.agrotis.agrotisapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrotis.agrotisapi.repository.LaboratoryRepository;
import com.agrotis.agrotisapi.repository.PropertyRepository;
import com.agrotis.agrotisapi.repository.UserRepository;
import com.agrotis.agrotisapi.entity.Laboratory;
import com.agrotis.agrotisapi.entity.Property;
import com.agrotis.agrotisapi.entity.User;
import com.agrotis.agrotisapi.exceptions.ResourceNotFound;
import com.agrotis.agrotisapi.requests.UserRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PropertyRepository propertyRepository;

	@Autowired
	private LaboratoryRepository laboratoryRepository;

	@Override
	public User create(UserRequest userRequest) throws ResourceNotFound {

		Property property = getPropertyById(userRequest.getProperty().getId());
		Laboratory laboratory = getLaboratoryById(userRequest.getLaboratory().getId());

		User user = new User();
		user.setName(userRequest.getName());
		user.setStartAt(userRequest.getStartAt());
		user.setFinishAt(userRequest.getFinishAt());
		user.setLaboratory(laboratory);
		user.setProperty(property);
		user.setNotes(userRequest.getNotes());

		return userRepository.save(user);

	}
	
	@Override
	public User update(Long id, UserRequest userRequest) throws ResourceNotFound {
		
		Property property = getPropertyById(userRequest.getProperty().getId());
		Laboratory laboratory = getLaboratoryById(userRequest.getLaboratory().getId());
		
		User user = getUserById(id);
		user.setName(userRequest.getName());
		user.setNotes(userRequest.getNotes());
		user.setFinishAt(userRequest.getFinishAt());
		user.setStartAt(userRequest.getStartAt());
		user.setLaboratory(laboratory);
		user.setProperty(property);
		
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(Long id) throws ResourceNotFound {
		Optional<User> userOptional = userRepository.findById(id);
		userOptional.orElseThrow(() -> new ResourceNotFound("Usuário não encontrado"));
		userRepository.deleteById(userOptional.get().getId());
	}
	
	@Override
	public User findById(Long id) throws ResourceNotFound {
		return getUserById(id);
	}

	private User getUserById(Long userId) throws ResourceNotFound {
		Optional<User> userOptional = userRepository.findById(userId);
		userOptional.orElseThrow(() -> new ResourceNotFound("Usuário não encontrado"));
		return userOptional.get();
	}

	private Property getPropertyById(Long propertyId) throws ResourceNotFound {
		Optional<Property> proptOptional = propertyRepository.findById(propertyId);
		proptOptional.orElseThrow(() -> new ResourceNotFound("Propriedade não encontrada"));
		return proptOptional.get();
	}

	private Laboratory getLaboratoryById(Long laboratoryId) throws ResourceNotFound {
		Optional<Laboratory> labOptional = laboratoryRepository.findById(laboratoryId);
		labOptional.orElseThrow(() -> new ResourceNotFound("Laboratório não encontrado"));
		return labOptional.get();
	}

}
