package br.com.dev.comdoiselle.ecommerce_backend.dto;

import br.com.dev.comdoiselle.ecommerce_backend.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class CadastrarDTO {

    public ResponseEntity<String> cadastrar(@RequestBody @Valid UsuarioDTO dto){
        UsuarioService usuarioService = null;
        usuarioService.salvar(dto);
        return ResponseEntity.ok("Usuario cadastrado com sucesso!");
    }
}
