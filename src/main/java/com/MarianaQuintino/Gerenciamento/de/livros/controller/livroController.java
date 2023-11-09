package com.MarianaQuintino.Gerenciamento.de.livros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MarianaQuintino.Gerenciamento.de.livros.services.livroService;
import com.MarianaQuintino.Gerenciamento.de.livros.entities.*;

@RestController
@RequestMapping("/livros")
public class livroController {
	
	private final livroService livroService;
	
	@Autowired
	public livroController (livroService livroService) {
		this.livroService = livroService;
	}
	
	@PostMapping
	public livro createlivro(@RequestBody livro livro) {
		return livroService.savelivro(livro);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<livro> getlivro(@PathVariable Long id){
		livro livro = livroService.getlivroById(id);
		if (livro != null) {
			return ResponseEntity.ok(livro);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/home")
	public String paginaInicial () {
		return "index"; //Nome do seu arquivo HTML (sem a extensão)
	}
	
	@DeleteMapping("/{id}")
	public void deletelivro(@PathVariable Long id) {
		livroService.deletelivro(id);
	}

	//Utilizando o ResponseEntity e RequestEntity
		@GetMapping
		public ResponseEntity<List<livro>> getAlllivro(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<livro> livro = livroService.getAlllivros();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(livro);
		}
		
		@PutMapping("/{id}")
		public livro updatelivro(@PathVariable Long id, @RequestBody livro livro) {
		    return livroService.updatelivro(id, livro);
		}	
	
	
}