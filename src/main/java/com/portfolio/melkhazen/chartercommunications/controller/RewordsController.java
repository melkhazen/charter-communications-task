package com.portfolio.melkhazen.chartercommunications.controller;

import com.google.gson.Gson;
import com.portfolio.melkhazen.chartercommunications.entity.Customer;
import com.portfolio.melkhazen.chartercommunications.repo.CustomerRepo;
import com.portfolio.melkhazen.chartercommunications.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class RewordsController {

    @Autowired
    RewardsService rewardsService;
    @Autowired
    CustomerRepo customerRepo;
    Gson gson = new Gson();

    @PostMapping(value = "/newTransaction")
    public ResponseEntity saveNewTransaction(@RequestBody String newTransaction){
        Customer customer = gson.fromJson(newTransaction, Customer.class);
        rewardsService.saveNewCustomer(customer);
        return new ResponseEntity<>("customer transaction is saved with the ID: " + customer.getCustomerId() +
                " use the ID to get the rewards points", HttpStatus.OK);
    }
    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getRewardsByCustomerId(@PathVariable("customerId") Long customerId){
        Customer customer = customerRepo.findByCustomerId(customerId);
        if (customer == null){
//            throw new RuntimeException("Invalid / Missing customer Id ");
            return new ResponseEntity<>("Customer Not Found", HttpStatus.NOT_FOUND);
        }
        String customerRewards = rewardsService.getRewardsByCustomerId(customerId);
        return new ResponseEntity<>("this customer has this many points: "+customerRewards, HttpStatus.OK);
    }
}
