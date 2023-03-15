package com.point_of_sale.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import com.point_of_sale.domain.dto.ResponseDTO;
import com.point_of_sale.domain.dto.RoleDTO;
import com.point_of_sale.domain.dto.UserDTO;
import com.point_of_sale.domain.dto.UserDTOO;

public interface UserService {
	
	RoleDTO saveRole(RoleDTO roleDTO) throws Exception;
	List<RoleDTO> viewRoles() throws Exception;
	ResponseEntity<String> saveUser(UserDTO userDTO) throws Exception;
	@ResponseBody ResponseDTO saveUserChanges(UserDTO userDTO) throws Exception;
	UserDTOO updateUser(UserDTO userDTO) throws Exception;
	UserDTO deactivateUser(Long id, Boolean status) throws Exception;
	List<UserDTO> findAllUsers() throws Exception;
	RoleDTO viewRole(Long roleId) throws Exception;
	 UserDTO findByUsername(String username);
	 UserDTO findByEmail(String email);
	 UserDTO findByPhoneNumber(String phoneNumber);
	 boolean checkUserExists(String username, String email, String phoneNumber );
	 boolean checkUsernameExists(String username);
	 boolean checkEmailExists(String email);
	 boolean checkPhoneNumberExists(String phoneNumber);
	 ResponseEntity<String> activatedUser(String username) throws Exception;
	 ResponseEntity<String> deActivatedUser(String username) throws Exception;
}
