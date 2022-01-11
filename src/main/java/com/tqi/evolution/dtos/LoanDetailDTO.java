package com.tqi.evolution.dtos;

import com.tqi.evolution.entities.Client;
import com.tqi.evolution.entities.Loan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanDetailDTO {
    private Long loanId;
    private Double loanValue;
    private Integer loanInstallmentAmount;
    private LocalDate loanFirstInstallmentDate;
    private String clientEmail;
    private Double clientIncome;

    public static LoanDetailDTO of(Loan loan, Client client) {
        return LoanDetailDTO.builder()
                .loanId(loan.getId())
                .loanValue(loan.getValue())
                .loanInstallmentAmount(loan.getInstallmentAmount())
                .loanFirstInstallmentDate(loan.getFirstInstallmentDate())
                .clientEmail(client.getEmail())
                .clientIncome(client.getIncome())
                .build();
    }

    public static LoanDetailDTO of(Loan loan) {
        Client client = loan.getClient();
        return LoanDetailDTO.builder()
                .loanId(loan.getId())
                .loanValue(loan.getValue())
                .loanInstallmentAmount(loan.getInstallmentAmount())
                .loanFirstInstallmentDate(loan.getFirstInstallmentDate())
                .clientEmail(client.getEmail())
                .clientIncome(client.getIncome())
                .build();
    }
}
