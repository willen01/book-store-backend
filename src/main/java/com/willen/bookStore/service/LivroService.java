package com.willen.bookStore.service;

import com.willen.bookStore.domain.Livro;
import com.willen.bookStore.repositories.LivroRepository;
import com.willen.bookStore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired // Instância gerenciada pelo spring - cria, gerencia, destroi
    LivroRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> obj = repository.findById(id);

        return obj.orElseThrow( () -> new ObjectNotFoundException("Livro não encontrado, id: " + id));
    }

    public List<Livro> findAll(Integer idCat) {
         categoriaService.findById(idCat); // busca categoria, lança excessão

        return repository.findAllByCategoria(idCat);
    }

    public Livro update(Integer id, Livro obj) {
        Livro newobj = findById(id);
        updateObj(newobj, obj);

        return repository.save(newobj);
    }

    private void updateObj(Livro newobj, Livro obj) {
        newobj.setTitulo(obj.getTitulo());
        newobj.setNome_autor(obj.getNome_autor());
        newobj.setTexto(obj.getTexto());
    }
}
