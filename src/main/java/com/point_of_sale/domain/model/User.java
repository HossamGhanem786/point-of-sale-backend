package com.point_of_sale.domain.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.point_of_sale.domain.audit.BasicUpdatableAudit;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "USERS")
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString(exclude= {"recipientList","appointmentList"})
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User extends BasicUpdatableAudit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, updatable = false)
	private Long id;

	@Column(name = "USERNAME", unique = true, length = 200, nullable = false)
	private String username;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "PASSWORD", length = 300, nullable = false)
	private String password;
	
	@Column(name = "CONFIRM_PASSWORD", length = 300, nullable = false)
	private String confirmPassword;

	@Column(name = "EMAIL", unique = true)
	private String email;

	@Column(name = "PHONE_NUMBER", unique = true)
	private String phoneNumber;

	@Column(name = "MOBILE_NUMBER", unique = true)
	private String mobileNumber;

	@ManyToMany
	@JoinTable( name = "users_roles", joinColumns = @JoinColumn( name = "user_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")) 
	private Collection<Role> roles;

	
	@CreationTimestamp
	@Column(name = "REGISTRATION_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date registrationDate;

	@Column(name = "LASET_LOGIN_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date lastLoginDate;

	@Column(name = "ACTIVATED")
	private Boolean activated;
	
}
