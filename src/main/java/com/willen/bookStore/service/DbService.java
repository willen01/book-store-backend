package com.willen.bookStore.service;

import com.willen.bookStore.domain.Categoria;
import com.willen.bookStore.domain.Livro;
import com.willen.bookStore.repositories.CategoriaRepository;
import com.willen.bookStore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {
        Categoria cat1 = new Categoria(null, "informática", "Livos de TI");
        Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
        Categoria cat3 = new Categoria(null, "Biografias", "Livos de biografias");

        Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
        Livro l2 = new Livro(null, "Engenharia de software", "Louis V. Gerstner", "Lorem ipsum", cat1);
        Livro l3 = new Livro(null, "The Time Machine", "H. G. Wells", "Lorem ipsum", cat2);
        Livro l4 = new Livro(null, "The War of the Worlds", "H. G. Wells", "Lorem ipsum", cat2);
        Livro l5 = new Livro(null, "I Robot", "Isaac Asimov", "Lorem ipsum", cat2);

        cat1.getLivros().addAll(Arrays.asList(l1, l2, l3, l4, l5));

        // persistência de dados
        this.categoriaRepository.saveAll(List.of(cat1, cat2, cat3));
        this.livroRepository.saveAll(List.of(l1, l2, l3, l4, l5));
    }
} // Instancia base de dados
