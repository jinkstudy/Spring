package exercise.order.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import exercise.order.domain.Customer;

public interface CustomerRepository {
	

	void save(Customer customer);
	void delete(long id);
}
