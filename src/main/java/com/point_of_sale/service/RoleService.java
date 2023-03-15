package com.point_of_sale.service;

import java.util.List;

import com.point_of_sale.domain.dto.RoleDTO;

public interface RoleService {
	RoleDTO saveRole(RoleDTO roleDTO) throws Exception;
	List<RoleDTO> viewRoles() throws Exception ;
}
