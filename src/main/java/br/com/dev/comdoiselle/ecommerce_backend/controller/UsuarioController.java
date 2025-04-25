package br.com.dev.comdoiselle.ecommerce_backend.controller;

import br.com.dev.comdoiselle.ecommerce_backend.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@Service

public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid @UsuarioDTO usuarioDTO){
        if(usuarioRepository.existsByEmail(usuarioDTO.getEmail())) {
            throw new EmailExistenteException("E-mail já cadastrado. Tente outro");
        }
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        usuario.setTokenConfirmacao(UUID.randomUUID().toString();
        usuarioRepository.save(usuario);
        emailService.enviarEmailConfirmacao(usuario.getEmail(), usuario.getTokenConfirmacao());
        return ResponseEntity.ok("Cadastro realizado com sucesso. Confirme seu e-mail.");
    }
}
