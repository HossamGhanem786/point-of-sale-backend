package com.point_of_sale.domain.dto;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author manar.anan
 *
 */
@Data
@ToString()
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RoleDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonFormat(shape = JsonFormat.Shape.NATURAL)
	private long id;

	@JsonFormat(shape = JsonFormat.Shape.NATURAL)
	private String name;

	@JsonFormat(shape = JsonFormat.Shape.NATURAL)
	private Collection<PrivilegeDTO> privileges;
}
