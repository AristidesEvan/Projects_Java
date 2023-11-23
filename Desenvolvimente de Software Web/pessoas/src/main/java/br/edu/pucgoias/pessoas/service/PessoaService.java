package br.edu.pucgoias.pessoas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.pucgoias.pessoas.dao.PessoaDao;
import br.edu.pucgoias.pessoas.model.Pessoa;

@Component
public class PessoaService {
    
    @Autowired
    private PessoaDao pessoaDao;

    public List<Pessoa> getAllPessoas() {
        return (List<Pessoa>) pessoaDao.findAll();
    }

    public Pessoa insertPessoa(Pessoa pessoa) {
        return pessoaDao.save(pessoa);
    }

    public Pessoa updatePessoa(Pessoa pessoa) {
        return pessoaDao.save(pessoa);
    }

    public void deletePessoa(Long id) {
        pessoaDao.deleteById(id);
    }

    public List<Pessoa> getAllByNome(String nome) {
        return pessoaDao.findAllByNome(nome);
    }

}
