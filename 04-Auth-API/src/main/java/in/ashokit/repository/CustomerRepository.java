package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findByEmail(String email);
}
