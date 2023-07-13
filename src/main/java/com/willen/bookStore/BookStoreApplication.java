package com.willen.bookStore;

import com.willen.bookStore.domain.Categoria;
import com.willen.bookStore.domain.Livro;
import com.willen.bookStore.repositories.CategoriaRepository;
import com.willen.bookStore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informática", "Livos de TI");
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);

		cat1.getLivros().addAll(Arrays.asList(l1));

		// persistência de dados
		this.categoriaRepository.saveAll(List.of(cat1));
		this.livroRepository.saveAll(List.of(l1));
	}
}
