package br.edu.pucgoias.pessoas.controller;

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

import br.edu.pucgoias.pessoas.service.PessoaService;
import br.edu.pucgoias.pessoas.model.Pessoa;


@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public List<Pessoa> getAllPessoas() {
        return pessoaService.getAllPessoas();
    }

    @PostMapping("/")
    public Pessoa insertPessoa(@RequestBody Pessoa pessoa) {
        
        return pessoaService.insertPessoa(pessoa);
    }
    
    @PutMapping("/")
    public Pessoa updatePessoa(@RequestBody Pessoa pessoa) {

        return pessoaService.updatePessoa(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletePessoa(@PathVariable Long id) {
        pessoaService.deletePessoa(id);
    }

}
