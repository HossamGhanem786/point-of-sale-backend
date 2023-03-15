package com.point_of_sale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.point_of_sale.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.username = :username OR u.email = :username")
	User findByEmailOrUsername(@Param("username")String username);	
	
	User findByUsernameAndActivated(String username,boolean activated);

	User findByUsername(String username);
	User findByEmail(String username);
	User findByPhoneNumber(String phoneNumber);


}
