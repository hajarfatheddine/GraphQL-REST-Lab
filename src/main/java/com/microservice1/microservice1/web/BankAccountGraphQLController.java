package com.microservice1.microservice1.web;

import com.microservice1.microservice1.dto.BankAccountRequestDTO;
import com.microservice1.microservice1.dto.BankAccountResponseDTO;
import com.microservice1.microservice1.entities.BankAccount;
import com.microservice1.microservice1.entities.Customer;
import com.microservice1.microservice1.repositories.BankAccountRepository;
import com.microservice1.microservice1.repositories.CustomerRepository;
import com.microservice1.microservice1.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGraphQLController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<BankAccount> accountList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("account not found"));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id, bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id) {
        bankAccountRepository.deleteById(id);
        return true;
    }

    @QueryMapping
    public List<Customer> cutomers(){
        return customerRepository.findAll();
    }
}
//un record c'est un objet immutable où on spécifie les paramètres / les arguments dont on a besoin
// les records n'existaient pas dans les versions precedentes de JAVA (java 8)
//on peut utiliser record ou bien créer une classe BankAccountDTO avec les contructeurs, les getters et les setters
/*record BankAccountDTO(Double balance, String type, String currency){

}
 */