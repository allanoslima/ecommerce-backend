package br.com.dev.comdoiselle.ecommerce_backend.controller;

import br.com.dev.comdoiselle.ecommerce_backend.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor

public class ProdutoController {
    private final ProdutoRepository produtoRepository;

    @GetMapping
    public ReponseEntity<List<Produto>>listarTodos(){
        return ResponseEntity.ok(produtoRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }
}
