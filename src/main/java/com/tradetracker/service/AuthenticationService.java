package com.tradetracker.service;

import com.tradetracker.model.AuthenticationResponse;
import com.tradetracker.model.Hospital;
import com.tradetracker.model.Menu;
import com.tradetracker.model.Token;
import com.tradetracker.model.User;
import com.tradetracker.repository.TokenRepository;
import com.tradetracker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

	@Autowired
	private MenuService menuService;

	@Autowired
	private HospitalService hospitalService;

	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	private final TokenRepository tokenRepository;

	private final AuthenticationManager authenticationManager;

	public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService,
			TokenRepository tokenRepository, AuthenticationManager authenticationManager) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.tokenRepository = tokenRepository;
		this.authenticationManager = authenticationManager;
	}

	public AuthenticationResponse register(User request) {

		// check if user already exist. if exist than authenticate the user
		if (repository.findByUsername(request.getUsername()).isPresent()) {
			return new AuthenticationResponse(null, "User already exist", null, null,null);
		}

		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));

		user.setRole(request.getRole());

		user = repository.save(user);

		String jwt = jwtService.generateToken(user);

		saveUserToken(jwt, user);

		return new AuthenticationResponse(jwt, "User registration was successful", null, null, null);

	}

	public AuthenticationResponse authenticate(User request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		User user = repository.findByUsername(request.getUsername()).orElseThrow();
		String jwt = jwtService.generateToken(user);

		List<Menu> menus = menuService.getMenusForUser(user.getId());
		List<Hospital> hospitals = hospitalService.getVendorHospitals(user.getVendorId(), user.getServiceId());

//        revokeAllTokenByUser(user);
//        saveUserToken(jwt, user);

		return new AuthenticationResponse(jwt, "User login was successful", user, menus, hospitals);

	}

	private void revokeAllTokenByUser(User user) {
		List<Token> validTokens = tokenRepository.findAllTokensByUser(user.getId());
		if (validTokens.isEmpty()) {
			return;
		}

		validTokens.forEach(t -> {
			t.setLoggedOut(true);
		});

		tokenRepository.saveAll(validTokens);
	}

	private void saveUserToken(String jwt, User user) {
		Token token = new Token();
		token.setToken(jwt);
		token.setLoggedOut(false);
		token.setUser(user);
		tokenRepository.save(token);
	}
}