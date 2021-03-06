package com.ashish.cactus.school.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.cactus.school.admin.db.model.User;
import com.ashish.cactus.school.admin.services.AdminApplicationUserService;

@RestController
@RequestMapping("/admin")
public class AdminTestController {
	
	@Autowired()
	@Qualifier("AdminApplicationUserService")
	private AdminApplicationUserService appUserService;
	

	@RequestMapping(value="/admin/{username}", method=RequestMethod.GET)
//	@PreAuthorize("hasAuthority('ROLE_ADMIN_CREATE')")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN_CREATE','ROLE_ADMIN_READ')")
	public String getMessage(@PathVariable("username") String username) {
		return appUserService.findByUsername(username).getPassword();
	}
	
	@RequestMapping(value="/parent/{username}", method=RequestMethod.GET)
//	@PreAuthorize("hasAuthority('ROLE_ADMIN_CREATE')")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN_CREATE','ROLE_ADMIN_READ','ROLE_PARENT_READ')")
	public String getParentMessage(@PathVariable("username") String username) {
		return username;
	}

}