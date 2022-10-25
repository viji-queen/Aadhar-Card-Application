package com.aadhar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aadhar.DTO.UserDTO;
import com.aadhar.entity.User;
import com.aadhar.exception.AadharCardException;
import com.aadhar.repository.UserRepository;

@Service(value="useService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserDTO> getAllUsers() throws AadharCardException{
		Iterable<User> users = userRepository.findAll();
		List<UserDTO> userDTO = new ArrayList<>();
		users.forEach(user -> {
			UserDTO userdto = new UserDTO();
			userdto.setAadharNumber(user.getAadharNumber());
			userdto.setName(user.getName());
			userdto.setGender(user.getGender());
			userdto.setPhoneNo(user.getPhoneNo());
			userdto.setCity(user.getCity());
			
			userDTO.add(userdto);
		});
		if(userDTO.isEmpty())
			throw new AadharCardException("UserService.USERS_NOT_FOUND");
		
		return userDTO;
		
		
	}
	
	@Override
	public Long registerUser(UserDTO userDTO) throws AadharCardException{
		User user =new User();
		user.setAadharNumber(user.getAadharNumber());
		user.setName(user.getName());
		user.setGender(user.getGender());
		user.setPhoneNo(user.getPhoneNo());
		user.setCity(user.getCity());
		
		User user2  = userRepository.save(user);
		
		return user2.getAadharNumber();
		
	}


	@Override
	public UserDTO getUser(Long aadharNumber) throws AadharCardException {
		// TODO Auto-generated method stub
		Optional<User> optional = userRepository.findById(aadharNumber);
		User user = optional.orElseThrow(()-> new AadharCardException("UserService.USERS_NOT-FOUND"));
		UserDTO userDTO = new UserDTO();
		userDTO.setAadharNumber(user.getAadharNumber());
		userDTO.setName(user.getName());
		userDTO.setGender(user.getGender());
		userDTO.setPhoneNo(user.getPhoneNo());
		userDTO.setCity(user.getCity());
		
		
		
		return userDTO;
	}


	@Override
	public void updateUser(Long adharNumber, Long phoneNo) throws AadharCardException {
		// TODO Auto-generated method stub
		Optional<User> optional = userRepository.findById(adharNumber);
		User u= optional.orElseThrow(()-> new AadharCardException("UserService.USERS_NOT_FOUND"));
		u.setPhoneNo(phoneNo);
	}

	@Override
	public void deleteUser(Long aadharNumber) throws AadharCardException {
		// TODO Auto-generated method stub
		Optional<User> optional = userRepository.findById(aadharNumber);
		optional.orElseThrow(()-> new AadharCardException("UserService.USERS_NOT_FOUND"));
		userRepository.deleteById(aadharNumber);
		
	}
}
