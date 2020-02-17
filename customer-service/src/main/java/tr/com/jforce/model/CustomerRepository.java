package tr.com.jforce.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByExternalId(String externalId);
    List findByAccountsId(Long id);
}