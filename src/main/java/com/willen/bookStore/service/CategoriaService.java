package com.willen.bookStore.service;

import com.willen.bookStore.domain.Categoria;
import com.willen.bookStore.dtos.CategoriaDTO;
import com.willen.bookStore.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(null);
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null); // derruba id enviado pelo cliente. Quem define o id é o banco
        return  repository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDTO) {
        Categoria obj = findById(id);
        obj.setNome(objDTO.getNome());
        obj.setDescricao(objDTO.getDescricao());

        return repository.save(obj);
    }

    public void delete(Integer id) {
        Categoria obj = findById(id);
        repository.deleteById(id);
    }
}
