package com.willen.bookStore.service;

import com.willen.bookStore.domain.Livro;
import com.willen.bookStore.repositories.LivroRepository;
import com.willen.bookStore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired // Instância gerenciada pelo spring - cria, gerencia, destroi
    LivroRepository repository;

    public Livro findById(Integer id) {
        Optional<Livro> obj = repository.findById(id);

        return obj.orElseThrow( () -> new ObjectNotFoundException("Livro não encontrado, id: " + id));
    }
}
