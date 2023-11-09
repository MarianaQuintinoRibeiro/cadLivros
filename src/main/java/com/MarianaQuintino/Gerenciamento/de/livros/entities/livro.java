package com.MarianaQuintino.Gerenciamento.de.livros.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tb_livro")
public class livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String descricao;
	
	@NotNull
	@NotBlank
	@Size (min = 8,message= "Mínimo de 8 caracteres")
	private String isbn; 
	
	public livro() {
		
	}
	
	public livro(Long id, String descricao, String isbn) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.descricao = isbn;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setName(String descricao) {
		this.descricao = descricao;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setDescricao(String descricao) {
		// TODO Auto-generated method stub
		
	}
}