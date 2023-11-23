package br.edu.pucgoias.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.pucgoias.estoque.service.CategoriaService;
import br.edu.pucgoias.estoque.model.Categoria;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/getByName/{categoria}")
    public List<Categoria> getCategoriaByName(@PathVariable String categoria) {
        return categoriaService.getAllByCategoria(categoria);
    }

    @GetMapping("/getById/{id}")
    public List<Categoria> getCategoriaById(@PathVariable Long id) {
        return categoriaService.getAllById(id);
    }

    @GetMapping("/")
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @PostMapping("/")
    public Categoria insertCategoria(@RequestBody Categoria categoria) {
        
        return categoriaService.insertCategoria(categoria);
    }
    
    @PutMapping("/")
    public Categoria updateCategoria(@RequestBody Categoria categoria) {

        return categoriaService.updateCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }

}