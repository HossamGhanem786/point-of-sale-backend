package com.point_of_sale.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.point_of_sale.domain.dto.ResponseDTO;
import com.point_of_sale.domain.dto.UserDTO;
import com.point_of_sale.domain.dto.UserDTOO;
import com.point_of_sale.service.UserService;


import io.swagger.annotations.Api;

@RestController
@RequestMapping("api/user")
@Api(value = "UserManagementController", produces = "application/json")
public class UserManagementController {
	@Autowired
	private UserService userService;
	

	

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> saveUser(@RequestBody(required = true) UserDTO userDTO) throws Exception {
		System.out.println("User DTO ==>"+userDTO);
			return userService.saveUser(userDTO);
	}
	
	@RequestMapping(value = "/saveuserChanges", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseDTO saveUserChanges(@RequestBody(required = true) UserDTO userDTO) throws Exception {
		System.out.println("User DTO ==>"+userDTO);
			return userService.saveUserChanges(userDTO);
	}
	
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody UserDTOO updateUser(@RequestBody(required = true) UserDTO userDTOO) throws Exception {
		return userService.updateUser(userDTOO);

	}

	
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody UserDTO viewUser() throws Exception {
		
		String username= SecurityContextHolder.getContext().getAuthentication().getName();
		
		UserDTO userDTO = userService.findByUsername(username);
		return userDTO;
	}
	
	
}
