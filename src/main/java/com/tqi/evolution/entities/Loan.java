package com.tqi.evolution.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Client client;
    @NotBlank
    private Double value;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotBlank
    private LocalDate firstInstallmentDate;
    @NotBlank
    private Integer installmentAmount;
}
