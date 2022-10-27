package com.microservice1.microservice1.dto;

import com.microservice1.microservice1.enums.BankAccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountRequestDTO {
    private  Double balance;
    private String currency;
    private BankAccountType type;
}
