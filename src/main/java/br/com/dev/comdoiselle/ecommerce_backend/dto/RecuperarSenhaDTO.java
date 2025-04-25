package br.com.dev.comdoiselle.ecommerce_backend.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class RecuperarSenhaDTO {
    @PostMapping("/recuperar-senha")
    public ResponseEntity<String> solicitarRecuperacao(@RequestParam String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(()-> new UsuarioNaoEncontradoException("E-mail não cadastrado"));
        usuario.setTokenRecuperacaoSenha(UUID.randomUUID().toString());
        usuario.setExpiracaoTokenRecuperacao(LocalDateTime.now().plusHours(1));
        usuarioRepository.save(usuario);
        emailService.enviarEmailRecuperacao(email, usuario.getTokenRecuperacaoSenha());
            return ResponseEntity.ok(   "E-mail de recuperação enviado. Cheque seu e-mail.");
    }
}
