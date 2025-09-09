package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Customer;
import in.ashokit.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthRestController {
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
		String msg = authService.saveCustomer(customer);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> generateToken(@RequestBody Customer customer) {
		ResponseEntity<String> response = new ResponseEntity<>("Invalid Credentials !!", HttpStatus.BAD_REQUEST);
		
		try {
			if(authService.validateCustomer(customer)) {
				String token = authService.getToken(customer.getEmail());
				response = new ResponseEntity<>(token, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
}
