package br.edu.pucgoias.estoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.pucgoias.estoque.dao.CategoriaDao;
import br.edu.pucgoias.estoque.model.Categoria;

@Component
public class CategoriaService {
    
    @Autowired
    private CategoriaDao categoriaDao;

    public List<Categoria> getAllCategorias() {
        return (List<Categoria>) categoriaDao.findAll();
    }

    public Categoria insertCategoria(Categoria categoria) {
        return categoriaDao.save(categoria);
    }

    public Categoria updateCategoria(Categoria categoria) {
        return categoriaDao.save(categoria);
    }

    public void deleteCategoria(Long id) {
        categoriaDao.deleteById(id);
    }

    public List<Categoria> getAllByCategoria(String categoria) {
        return categoriaDao.findAllByCategoria(categoria);
    }

    public List<Categoria> getAllById(Long id) {
        return categoriaDao.findAllById(id);
    }
    
}