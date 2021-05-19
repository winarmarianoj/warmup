package com.marianowinar.warmup.util;

import com.marianowinar.warmup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserConnectedService {

	@Autowired
	UserService userService;

	public String userConected() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String name = loggedInUser.getName(); 
		return name;
	}

}
