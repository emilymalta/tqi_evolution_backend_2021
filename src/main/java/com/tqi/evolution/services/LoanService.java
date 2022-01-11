package com.tqi.evolution.services;

import com.tqi.evolution.dtos.LoanDTO;
import com.tqi.evolution.dtos.LoanDetailDTO;
import com.tqi.evolution.entities.Loan;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LoanService {
    LoanDetailDTO findDetailedLoan(Long id);

    List<LoanDTO> findByClientId(Long clientId);

    Loan save(Loan loan, HttpServletRequest request);
}
