package in.ashokit.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Customer;
import in.ashokit.repository.CustomerRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
	@Autowired
	private CustomerRepository custRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer = custRepo.findByEmail(email);
		return new User(customer.getEmail(), customer.getPwd(), Collections.emptyList());
	}
}
