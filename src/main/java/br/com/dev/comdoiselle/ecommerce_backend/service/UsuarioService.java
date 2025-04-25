package br.com.dev.comdoiselle.ecommerce_backend.service;


import br.com.dev.comdoiselle.ecommerce_backend.dto.UsuarioDTO;

public class UsuarioService {
    public void salvar(UsuarioDTO dto){
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuarioRepository.save(usuario);
    }
}
