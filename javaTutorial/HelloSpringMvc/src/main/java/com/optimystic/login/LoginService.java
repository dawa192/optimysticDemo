package com.optimystic.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public Boolean loginValidation(String username, String password ){
		return username.equals("dawa") && password.equals("lama");
	}

}
