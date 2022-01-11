package com.tqi.evolution.controllers;

import com.tqi.evolution.dtos.LoanDTO;
import com.tqi.evolution.dtos.LoanDetailDTO;
import com.tqi.evolution.entities.Loan;
import com.tqi.evolution.services.LoanService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @ApiOperation("Salva um novo emprestimo no sistema, o campo de cliente é preenchido automaticamente apartir do token de autenticação.")
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan, HttpServletRequest request) {
        return new ResponseEntity<>(loanService.save(loan, request), HttpStatus.CREATED);
    }

    @ApiOperation("Resgata um emprestimo detalhado pelo id.")
    @GetMapping("/detail/{id}")
    public ResponseEntity<LoanDetailDTO> findDetailedLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.findDetailedLoan(id));
    }

    @ApiOperation("Resgata todos os emprestimos de um cliente.")
    @GetMapping("/byClient/{clientId}")
    public ResponseEntity<List<LoanDTO>> findByClientId(@PathVariable Long clientId) {
        return ResponseEntity.ok(loanService.findByClientId(clientId));
    }
}
