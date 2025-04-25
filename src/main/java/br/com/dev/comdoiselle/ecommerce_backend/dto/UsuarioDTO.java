package br.com.dev.comdoiselle.ecommerce_backend.dto;

import br.com.dev.comdoiselle.ecommerce_backend.service.UsuarioService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@Setter
public class UsuarioDTO {
    private String nome;
    private String senha;
    private String email;
    private String endereco;
}

