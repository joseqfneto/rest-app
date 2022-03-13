package com.joseqfneto.restapp.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {
    @NotBlank
    private String nome;

    @NotNull
    private int quantidade;

    @NotNull
    private BigDecimal preco;
}
