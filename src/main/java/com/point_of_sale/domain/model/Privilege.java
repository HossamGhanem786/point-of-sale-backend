package com.point_of_sale.domain.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.point_of_sale.domain.audit.BasicUpdatableAudit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="PRIVILEGE")
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NamedQuery(name="Privilege.findAll", query="SELECT p FROM Privilege p")
public class Privilege extends BasicUpdatableAudit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false, updatable=false)
	private Long id;
	
	@Column(name="NAME", nullable=false, updatable=false)
	private String name;
	

}
