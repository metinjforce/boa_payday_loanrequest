package tr.com.jforce.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface IncomeRepository extends CrudRepository<Income, Long> {
    Income findByExternalId(String externalId);
}