package com.example.ReceptionistMicroservice.controller;




import com.example.ReceptionistMicroservice.entity.User; 
import com.example.ReceptionistMicroservice.payload.request.LoginRequest;
import com.example.ReceptionistMicroservice.payload.request.SignupRequest;
import com.example.ReceptionistMicroservice.payload.response.JwtResponse;
import com.example.ReceptionistMicroservice.payload.response.MessageResponse;
import com.example.ReceptionistMicroservice.repository.UserRepository;
import com.example.ReceptionistMicroservice.security.jwt.JwtUtils;
import com.example.ReceptionistMicroservice.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/Receptionist/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(
			@Validated @RequestBody LoginRequest loginRequest) {
		
		//here i am authenticate username and password by using  authenticationManager
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		//  I am generating jwtToken to the authentication by using jwtutils
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		//here iam creating new jwt responses
		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail() 
												 ));
	}
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
		//here I am checking  username is present in Data Base if it is present it will give message
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Receptionist is already taken!"));
		}
		//here I am checking  email is present in Data Base if it is present it will give message
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		// Create new Receptionist's account
		User user = new User(signUpRequest.getUsername(),
							 signUpRequest.getEmail(),
							 //encoder is used to encode the password
							 encoder.encode(signUpRequest.getPassword()));
		//saving  new user in database
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("Receptionist added successfully!"));
	}

}