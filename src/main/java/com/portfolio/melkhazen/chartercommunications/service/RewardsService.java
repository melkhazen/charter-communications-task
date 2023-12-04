package com.portfolio.melkhazen.chartercommunications.service;

import com.portfolio.melkhazen.chartercommunications.entity.Customer;
import com.portfolio.melkhazen.chartercommunications.model.Constants;
import com.portfolio.melkhazen.chartercommunications.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RewardsService{

    public final CustomerRepo customerRepo;
    LocalDate currentDate = LocalDate.now();
    double rewardsPoints = 0;

    private Customer newCustomer = new Customer();
    @Autowired
    public RewardsService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public void saveNewCustomer(Customer customer){

        System.out.println(String.valueOf(currentDate) + " logging");
        newCustomer.setCustomerName(customer.getCustomerName());
        newCustomer.setTransactionDate(String.valueOf(currentDate));
        newCustomer.setTransactionAmount(customer.getTransactionAmount());
        customerRepo.save(customer);
    }

    public String getRewardsByCustomerId(Long customerId){

        Customer customer = customerRepo.findByCustomerId(customerId);

        if (customer.getTransactionAmount() < Constants.SECOND_REWARD && customer.getTransactionAmount() < 0){
            rewardsPoints = customer.getTransactionAmount() - Constants.FIRST_REWARD;
        } else if (customer.getTransactionAmount() > Constants.SECOND_REWARD) {
            rewardsPoints = ((customer.getTransactionAmount() - Constants.SECOND_REWARD) * 2) + Constants.FIRST_REWARD;
        }
        return String.valueOf(rewardsPoints);
    }
}
