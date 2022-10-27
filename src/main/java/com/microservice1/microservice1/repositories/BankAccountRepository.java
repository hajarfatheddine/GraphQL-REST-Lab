package com.microservice1.microservice1.repositories;

import com.microservice1.microservice1.entities.BankAccount;
import com.microservice1.microservice1.enums.BankAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

}

