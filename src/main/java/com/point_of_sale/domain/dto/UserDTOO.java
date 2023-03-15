package com.point_of_sale.domain.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString()
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDTOO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonFormat(shape = JsonFormat.Shape.NATURAL)
	private long id;

	@JsonFormat(shape = JsonFormat.Shape.NATURAL)
	private String firstName;

	@JsonFormat(shape = JsonFormat.Shape.NATURAL)
	private String lastName;

	@JsonFormat(shape = JsonFormat.Shape.NATURAL)
	private String username;

	@JsonFormat(shape = JsonFormat.Shape.NATURAL)
	private String password;

	@JsonFormat(shape = JsonFormat.Shape.NATURAL)
	private String email;

	@JsonFormat(shape = JsonFormat.Shape.NATURAL)
	private String phoneNumber;

}
