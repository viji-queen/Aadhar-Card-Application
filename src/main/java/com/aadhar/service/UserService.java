package com.aadhar.service;

import java.util.List;

import com.aadhar.DTO.UserDTO;
import com.aadhar.exception.AadharCardException;

public interface UserService {
	public UserDTO getUser(Long aadharNumber) throws AadharCardException;
	public List<UserDTO> getAllUsers() throws AadharCardException;
	public Long registerUser (UserDTO userDTO) throws  AadharCardException;
	public void  updateUser(Long adharNumber, Long phoneNo) throws AadharCardException;
	public void deleteUser(Long aadharNumber) throws AadharCardException;

}
