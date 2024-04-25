package com.example.demo.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BookServ.EndUserServImpl;
import com.example.demo.model.EndUser;
import com.example.demo.repo.EndUserRepo;
import com.example.demo.request.JwtToken;
import com.example.demo.request.LoginRequest;
import com.example.demo.security.JwtUtil;

@RestController
@RequestMapping("/login")
public class EndUserController {
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private EndUserServImpl endServ;
	@Autowired
	private EndUserRepo endRepo;
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/save")
	public ResponseEntity<String> saveAll(@RequestBody EndUser user) {
		  
		  EndUser status=endServ.saveAllUsers(user);
		   return new ResponseEntity<>("Successfully saved", HttpStatus.OK);

		  
	  }
 @PostMapping("/token")
	public ResponseEntity<JwtToken> loginvalidation(@RequestBody LoginRequest request){
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			}
			catch(Exception e) {
				return new ResponseEntity<> (new JwtToken("Invalid email/password","failed"),HttpStatus.OK);
			}
			UserDetails l=endServ.loadUserByUsername(request.getEmail());
			EndUser user=endServ.findByEmail(request.getEmail());
			
			final String jwt=jwtUtil.generateToken(l);
			user.setToken(jwt);
			endRepo.save(user);
			
			return new ResponseEntity<>(new JwtToken(jwt,(user.getFirstName()+" "+user.getLastName())),HttpStatus.OK);
 }
 
}

