package com.tqi.evolution.dtos;

import com.tqi.evolution.entities.Loan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {
    private Long id;
    private Double value;
    private Integer installmentAmount;

    public static LoanDTO of(Loan loan) {
        return LoanDTO.builder()
                .id(loan.getId())
                .value(loan.getValue())
                .installmentAmount(loan.getInstallmentAmount())
                .build();
    }
}
