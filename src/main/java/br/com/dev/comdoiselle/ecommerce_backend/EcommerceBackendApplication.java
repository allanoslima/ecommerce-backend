package br.com.dev.comdoiselle.ecommerce_backend;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class EcommerceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceBackendApplication.class, args);
	}

	public class Usuario {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String nome;

		@Column(unique = true)
		private String email;
		private String senha;

		private String endereco;

		private boolean ativo = false;
		private String tokenConfirmacao;
		private String tokenSenhaConfirmacao;
		private LocalDateTime expiracaoTokenRecuperacao;

	}

	public class Produto {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String nome;
		private String descricao;
		private BigDecimal preco;

		@ManyToOne
		@JoinColumn(name="categoria_id")
		private String categoria;

		private String caminhoImagem;
	}

	public class Categoria {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String nome;
	}

	@ControllerAdvice
	public class GlobalExceptionHandler {
		@ExceptionHandler(EmailExistenteException.class)
		public ResponseEntity<String> handleEmailExistente(EmailExistenteException ex){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}