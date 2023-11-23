package br.edu.pucgoias.estoque.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.pucgoias.estoque.model.Categoria;

public interface CategoriaDao extends CrudRepository<Categoria,Long> {
    
    List<Categoria> findAllByCategoria(String categoria);

    List<Categoria> findAllById(Long id);

}
