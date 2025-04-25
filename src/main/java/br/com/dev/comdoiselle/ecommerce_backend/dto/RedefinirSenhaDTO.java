package br.com.dev.comdoiselle.ecommerce_backend.dto;

import org.springframework.web.bind.annotation.PostMapping;

public class RedefinirSenhaDTO {
    @PostMapping("/redefinir-senha")
    public ResponseEntity<String> redefinirSenha(
            @RequestParam String token,
            @RequestParam String novaSenha
    ) {
        Usuario usuario = usuarioRepository.findByTokenRecuperacaoSenha(token)
                .orElseThrow(() -> new TokenInvalidoException("Token inválido"));

        if (LocalDateTime.now().isAfter(usuario.getExpiracaoTokenRecuperacao())) {
            throw new TokenExpiradoException("Token expirado");
        }

        usuario.setSenha(passwordEncoder.encode(novaSenha));
        usuario.setTokenRecuperacaoSenha(null);
        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Senha redefinida com sucesso");
    }
}
