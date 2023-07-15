package com.willen.bookStore.dtos;

import com.willen.bookStore.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "Campo NOME é obrigatório")
    @Length(min = 3, max = 50, message = "O campo NOME deve ter entre 3 e 50 caracteres")
    private String nome;


    @NotEmpty(message = "Campo DESCRICAO é obrigatório")
    @Length(min = 10, max = 200, message = "O campo DESCRICAO deve ter entre 10 e 200 caracteres")
    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
