package br.com.dev.comdoiselle.ecommerce_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ProdutoDTO {
    private String nome;
    private BigDecimal preco;
    private Long categoriaId;
}
