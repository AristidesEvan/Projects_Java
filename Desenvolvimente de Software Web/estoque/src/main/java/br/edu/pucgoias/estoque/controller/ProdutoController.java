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

import br.edu.pucgoias.estoque.service.ProdutoService;
import br.edu.pucgoias.estoque.model.Produto;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/getByName/{descricao}")
    public List<Produto> getProdutoByName(@PathVariable String descricao) {
        return produtoService.getAllByDescricao(descricao);
    }

    @GetMapping("/getById/{id}")
    public List<Produto> getProdutoById(@PathVariable Long id) {
        return produtoService.getAllById(id);
    }

    @GetMapping("/")
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @PostMapping("/")
    public Produto insertProduto(@RequestBody Produto produto) {
        
        return produtoService.insertProduto(produto);
    }
    
    @PutMapping("/")
    public Produto updateCategoria(@RequestBody Produto produto) {

        return produtoService.updateProduto(produto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
    }

}