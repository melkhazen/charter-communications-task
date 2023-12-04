package com.portfolio.melkhazen.chartercommunications.repo;

import com.portfolio.melkhazen.chartercommunications.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    public Customer findByCustomerId(Long customerId);
}
