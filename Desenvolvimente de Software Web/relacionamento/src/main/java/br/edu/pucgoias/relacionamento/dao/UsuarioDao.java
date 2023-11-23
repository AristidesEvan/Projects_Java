package br.edu.pucgoias.relacionamento.dao;

import org.springframework.data.repository.CrudRepository;

import br.edu.pucgoias.relacionamento.model.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {
    
}
