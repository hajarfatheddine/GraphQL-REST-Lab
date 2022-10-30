package com.microservice1.microservice1;

import com.microservice1.microservice1.entities.BankAccount;
import com.microservice1.microservice1.entities.Customer;
import com.microservice1.microservice1.enums.BankAccountType;
import com.microservice1.microservice1.repositories.BankAccountRepository;
import com.microservice1.microservice1.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class Microservice1Application {

    public static void main(String[] args) {
        SpringApplication.run(Microservice1Application.class, args);
    }

   @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
    return args -> {
        Stream.of("Yassine","Oussama","Yasmine","Salma").forEach(c->{
            Customer customer=Customer.builder()
                    .name(c)
                    .build();
            customerRepository.save(customer);
        });
        customerRepository.findAll().forEach(customer -> {
            for (int i=1; i<10;i++){
                BankAccount bankAccount=BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5?BankAccountType.CURRENT:BankAccountType.SAVING)
                        .balance(10000+Math.random()*90000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .customer(customer)
                        .build();
                bankAccountRepository.save(bankAccount);
            }
        });

    };
    }

}
