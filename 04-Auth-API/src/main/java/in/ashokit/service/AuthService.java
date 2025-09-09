package in.ashokit.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Customer;
import in.ashokit.repository.CustomerRepository;

@Service
public class AuthService {
	@Autowired
	private PasswordEncoder pwdEncoder;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	public String saveCustomer(Customer customer) {
		customer.setPwd(pwdEncoder.encode(customer.getPwd()));
		custRepo.save(customer);
		return "Registration Successfull !!";
	}
	
	public String getToken(String username) {
		String jwtToken = jwtService.generateToken(username);
		return jwtToken;
	}
	
	public boolean validateCustomer(Customer customer) {
		boolean result = false;
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(customer.getEmail(), customer.getPwd(), Collections.emptyList());
		Authentication authenticate = authManager.authenticate(authToken);
		
		if(authenticate.isAuthenticated()) {
			result = true;
		}
		return result;
	}
}
