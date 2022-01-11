package com.tqi.evolution.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientAuthDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
