package com.example.demo.BookServ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.demo.model.EndUser;
import com.example.demo.repo.EndUserRepo;
import com.example.demo.request.Login;
@Service
public class EndUserServImpl implements EndUserInterface,UserDetailsService {
	
	@Autowired
	private EndUserRepo endRepo;

	public UserDetails loadUserByUsername(String username) 
	{
		
		EndUser user=endRepo.findByEmail(username);
		Login login=new Login();
		login.setUsername(username);
		System.out.println(user);
		login.setPassword(user.getPassword());
		return login;
	}
	@Override
	public EndUser saveAllUsers(EndUser user) {
	
		return endRepo.save(user);
	}

	public EndUser findByEmail(String email) {
	
		return endRepo.findByEmail(email);
	}

}
