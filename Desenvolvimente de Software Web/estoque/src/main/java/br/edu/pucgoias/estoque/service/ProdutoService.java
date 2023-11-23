package br.edu.pucgoias.estoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.pucgoias.estoque.dao.ProdutoDao;
import br.edu.pucgoias.estoque.model.Produto;

@Component
public class ProdutoService {
    
    @Autowired
    private ProdutoDao produtoDao;

    public List<Produto> getAllProdutos() {
        return (List<Produto>) produtoDao.findAll();
    }

    public Produto insertProduto(Produto produto) {
        return produtoDao.save(produto);
    }

    public Produto updateProduto(Produto produto) {
        return produtoDao.save(produto);
    }

    public void deleteProduto(Long id) {
        produtoDao.deleteById(id);
    }

    public List<Produto> getAllByDescricao(String descricao) {
        return produtoDao.findAllByDescricao(descricao);
    }

    public List<Produto> getAllById(Long id) {
        return produtoDao.findAllById(id);
    }
    
}
