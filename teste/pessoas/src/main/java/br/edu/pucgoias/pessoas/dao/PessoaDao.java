package br.edu.pucgoias.pessoas.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.pucgoias.pessoas.model.Pessoa;

public interface PessoaDao extends CrudRepository<Pessoa,Long> {
    
    List<Pessoa> findAllByNome(String nome);

}
