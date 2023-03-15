package com.point_of_sale.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.point_of_sale.domain.dto.ResponseDTO;
import com.point_of_sale.domain.dto.RoleDTO;
import com.point_of_sale.domain.dto.UserDTO;
import com.point_of_sale.domain.dto.UserDTOO;
import com.point_of_sale.domain.model.User;
import com.point_of_sale.repository.UserRepository;
import com.point_of_sale.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseAbstractService<User> implements UserService {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private RoleServiceImpl roleServiceImpl;

	@Autowired
	private UserRepository userRepository;
	
	
	public UserServiceImpl(JpaRepository<User, Long> jpaRepository) {
		super(jpaRepository);
	}

	public RoleDTO saveRole(RoleDTO roleDTO) throws Exception {

		return roleServiceImpl.saveRole(roleDTO);
	}

	public List<RoleDTO> viewRoles() throws Exception {
		return roleServiceImpl.viewRoles();
	}

	public  ResponseEntity<String> saveUser(UserDTO userDTO) throws Exception {
		User user = null;
		if (checkUserExists(userDTO.getUsername(),userDTO.getEmail(),userDTO.getPhoneNumber())) {
			return ResponseEntity.badRequest().body("UserExists");
		}
        	if(checkEmailExists(userDTO.getEmail())) {
        		return ResponseEntity.badRequest().body("EmailExists");
        		
        	}
        	
        	if(checkUsernameExists(userDTO.getUsername())) {
        		return ResponseEntity.badRequest().body("UsernameExists");
        	}
        	
        	if(checkPhoneNumberExists(userDTO.getPhoneNumber())) {
        		return ResponseEntity.badRequest().body("PhoneNumberExists");
        	}
		try {
			String password = userDTO.getPassword();
			String encodedPass = encoder.encode(password);

			userDTO.setPassword(encodedPass);
			userDTO.setActivated(true);
			
			user = this.save(modelMapper.map(userDTO, User.class));
		} catch (Exception e) {
			throw new Exception(e);
		}
		 return new  ResponseEntity<String>("Sign Up Succesfully!",HttpStatus.OK);
	}
	
	public @ResponseBody ResponseDTO saveUserChanges(UserDTO userDTO) throws Exception {
		
		String password = userDTO.getConfirmPassword();
		String encodedPass = encoder.encode(password);
		userDTO.setPassword(encodedPass);
		save(modelMapper.map(userDTO, User.class));
	ResponseDTO responseDTO = new ResponseDTO();
	responseDTO.setBody("User change Settings Sucessfully!");
	responseDTO.setStatus("Success");
	return responseDTO;
}

	public UserDTOO updateUser(UserDTO userDTO) throws Exception {
		User user = null;
		try {
			user = this.save(modelMapper.map(userDTO, User.class));
		} catch (Exception e) {
			throw new Exception(e);
		}
		return modelMapper.map(user, UserDTOO.class);
	}

	public UserDTO deactivateUser(Long id, Boolean status) throws Exception {
		User user = this.findById(id);
		user.setActivated(status);
		this.save(user);
		return modelMapper.map(user, UserDTO.class);
	}

	public List<UserDTO> findAllUsers() throws Exception {
		return this.findAll().stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}
	
	public RoleDTO viewRole(Long roleId) throws Exception {
		return modelMapper.map(roleServiceImpl.findById(roleId), RoleDTO.class);
	}
	
	public UserDTO findByUsername(String username) {
		System.out.println("Username Already Exist 667777   "+ username);
		User user=  userRepository.findByUsername(username);
		
		if (user==null) {
			System.out.println("Username Not Exist!");
			return null;
		}
		System.out.println("findByUsername [[[[>>>>   "+ user);
		return modelMapper.map(user, UserDTO.class);
		}
	

	public UserDTOO findByUsernameO(String username) {
		User user=  userRepository.findByUsername(username);
		
		if (user==null) {
			System.out.println("Username Not  Exist!");
			return null;
		}
		System.out.println("findByUsername [[[[>>>>   "+ user);
		return modelMapper.map(user, UserDTOO.class);
		}
	
	public UserDTO findByEmail(String email) {
		User user=  userRepository.findByUsername(email);
		if (user!=null) {
			
			System.out.println("Email Already Exist!");
		}
		return modelMapper.map(user, UserDTO.class);
	}
	
	public UserDTO findByPhoneNumber(String phoneNumber) {
		return modelMapper.map(userRepository.findByPhoneNumber(phoneNumber), UserDTO.class);
	}
	
	 
	public boolean checkUserExists(String username, String email, String phoneNumber ) {
		
		if(checkUsernameExists(username) && checkEmailExists(email) && checkPhoneNumberExists( phoneNumber) ) {
			return true;
		}
		return false;
	}
	
	
	public boolean checkUsernameExists(String username) {
		User user =userRepository.findByUsername(username);
		return user == null?false:true;
	}

	
	public boolean checkEmailExists(String email) {
		User user =userRepository.findByEmail(email);
		return user == null?false:true;
	}
	
	
	
	public boolean checkPhoneNumberExists(String phoneNumber) {
		User user =userRepository.findByPhoneNumber(phoneNumber);
		
		return user != null?true:false;
	}
	
	
	public ResponseEntity<String> activatedUser(String username) throws Exception {
		
		User user =userRepository.findByUsername(username);
		if(user!= null) {
			user.setActivated(true);
			this.save(user);
			 return new  ResponseEntity<String>("User activated Succesfully!",HttpStatus.OK);
		}else {
			System.out.println("User Not Found!!");
			return new  ResponseEntity<String>("Failed to activated user!",HttpStatus.BAD_REQUEST);
		}
		
	}
public ResponseEntity<String> deActivatedUser(String username) throws Exception {
		
		User user =userRepository.findByUsername(username);
		if(user!= null) {
			user.setActivated(false);
			this.save(user);
			 return new  ResponseEntity<String>("User Deactivated Succesfully!",HttpStatus.OK);
		}else {
			System.out.println("User Not Found!!");
			return new  ResponseEntity<String>("Failed to Deactivated user!",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
	
	
	
	

}
