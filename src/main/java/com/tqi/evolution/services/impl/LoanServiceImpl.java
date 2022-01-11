package com.tqi.evolution.services.impl;

import com.tqi.evolution.dtos.LoanDTO;
import com.tqi.evolution.dtos.LoanDetailDTO;
import com.tqi.evolution.entities.Loan;
import com.tqi.evolution.exceptions.BusinessException;
import com.tqi.evolution.exceptions.EntityNotFoundException;
import com.tqi.evolution.repositories.LoanRepository;
import com.tqi.evolution.services.ClientService;
import com.tqi.evolution.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepository repository;

    @Autowired
    private ClientService clientService;

    public LoanDetailDTO findDetailedLoan(Long id) {
        Loan loan = findById(id);
        return LoanDetailDTO.of(loan, loan.getClient());
    }

    private Loan findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Loan not found."));
    }

    public List<LoanDTO> findByClientId(Long clientId) {
        return repository.findByClientId(clientId).stream().map(LoanDTO::of).collect(Collectors.toList());
    }

    public Loan save(Loan loan, HttpServletRequest request) {
        checkLoanEnablement(loan);
        loan.setClient(clientService.findByRequestAuthorizationHeader(request));
        return repository.save(loan);
    }

    private void checkLoanEnablement(Loan loan) {
        if (loan.getInstallmentAmount() < 1 || loan.getInstallmentAmount() > 60) {
            throw new BusinessException("The installment amount must be between 1 and 60.");
        } else if (loan.getFirstInstallmentDate().atStartOfDay().isAfter(LocalDateTime.now().plusMonths(3))) {
            throw new BusinessException("The first installment date must be less than or equal to 3 months.");
        }
    }

}
