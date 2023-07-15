package com.willen.bookStore.resources;

import com.willen.bookStore.domain.Livro;
import com.willen.bookStore.dtos.LivroDTO;
import com.willen.bookStore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    LivroService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro livro = service.findById(id);
        return ResponseEntity.ok().body(livro);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll (@RequestParam(value = "categoria") Integer id_cat){

        List<Livro> list = service.findAll(id_cat);
        List<LivroDTO> livroDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(livroDTO);
        // 8080/livros?categoria=1
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro obj) {
        Livro newobj = service.update(id, obj);
        return ResponseEntity.ok().body(newobj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> updatePath(@PathVariable Integer id, @RequestBody Livro obj) {
        Livro newobj = service.update(id, obj);
        return ResponseEntity.ok().body(newobj);
    }

    @PostMapping
    public ResponseEntity<Livro> create (
            @RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
            @RequestBody Livro obj) {
        Livro newObj = service.create(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
