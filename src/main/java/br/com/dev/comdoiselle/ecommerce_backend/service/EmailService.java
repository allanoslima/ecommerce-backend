package br.com.dev.comdoiselle.ecommerce_backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    public void enviarEmailConfirmacao(String emailDestino, String token) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(emailDestino);
        email.setSubject("Confirme seu cadastro");
        email.setText("Click no link para confirmar seu cadastro: http://localhost:3030/confirmar?token=" + token);
        mailSender.send(email);
    }
}
