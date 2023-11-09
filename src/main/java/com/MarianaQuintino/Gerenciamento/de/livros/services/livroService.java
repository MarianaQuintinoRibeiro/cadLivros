package com.MarianaQuintino.Gerenciamento.de.livros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MarianaQuintino.Gerenciamento.de.livros.entities.*;
import com.MarianaQuintino.Gerenciamento.de.livros.repository.*;

@Service
public class livroService {
	private final livroRepository livroRepository;
	
	@Autowired
	public livroService (livroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	public livro getlivroById(Long id) {
		return livroRepository.findById(id).orElse (null);
	}
	
	public List<livro> getAlllivros () {
		return livroRepository.findAll ();
	}
	
	public livro savelivro (livro livro) {
		return livroRepository.save(livro);
	}
	
	public void deletelivro (Long id) {
		livroRepository.deleteById(id);
	}
	
	public livro updatelivro(Long id, livro novolivro) {
        Optional<livro> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
        	livro livroExistente = livroOptional.get();
           	livroExistente.setDescricao(novolivro.getDescricao());
        	livroExistente.setIsbn(novolivro.getIsbn());          
            return livroRepository.save(livroExistente); 
        } else {
            return null; 
        }
    }
	

}
