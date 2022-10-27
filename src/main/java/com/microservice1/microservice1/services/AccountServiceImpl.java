package com.microservice1.microservice1.services;

import com.microservice1.microservice1.dto.BankAccountRequestDTO;
import com.microservice1.microservice1.dto.BankAccountResponseDTO;
import com.microservice1.microservice1.entities.BankAccount;
import com.microservice1.microservice1.mappers.AccountMapper;
import com.microservice1.microservice1.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    public AccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @Autowired
    private AccountMapper accountMapper;
    private BankAccountRepository bankAccountRepository;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .createdAt(new Date())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount= bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO= accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }
}
