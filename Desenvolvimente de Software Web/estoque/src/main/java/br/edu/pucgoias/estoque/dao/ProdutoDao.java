package br.edu.pucgoias.estoque.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.pucgoias.estoque.model.Produto;

public interface ProdutoDao extends CrudRepository<Produto,Long> {
    
    List<Produto> findAllByDescricao(String descricao);

    List<Produto> findAllById(Long id);

}