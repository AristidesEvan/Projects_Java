package com.jasper.jasper.data;

import org.springframework.data.repository.CrudRepository;

import com.jasper.jasper.model.Usuario;

public interface UsuarioData extends CrudRepository<Usuario, Long> {
    
}
