package com.microservice1.microservice1.services;

import com.microservice1.microservice1.dto.BankAccountRequestDTO;
import com.microservice1.microservice1.dto.BankAccountResponseDTO;
import com.microservice1.microservice1.entities.BankAccount;
import com.microservice1.microservice1.enums.BankAccountType;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
