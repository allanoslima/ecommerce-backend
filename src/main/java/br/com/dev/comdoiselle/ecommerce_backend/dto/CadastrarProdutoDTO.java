package br.com.dev.comdoiselle.ecommerce_backend.dto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CadastrarProdutoDTO {
    @PostMapping("/admin-cadastrar-produto")
    public ResponseEntity<String> cadastrarProduto(@RequestBody @Valid cadastrarProdutoDTO dto){
        CadastroProdutoService cadastroProdutoService = null;
        CadastroProdutoService.salvar(dto);
        return ResponseEntity.ok("Produto cadastrado com sucesso!");
    }
}
