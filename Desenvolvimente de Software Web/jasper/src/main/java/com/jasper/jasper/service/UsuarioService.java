package com.jasper.jasper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jasper.jasper.data.UsuarioData;
import com.jasper.jasper.model.Usuario;

@Component
public class UsuarioService {
    
    @Autowired
    private UsuarioData usuarioData;

    public List<Usuario> getAllUsuarios() {
        return (List<Usuario>) usuarioData.findAll();
    }

    public Usuario insertUsuario(Usuario usuario) {
        return usuarioData.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioData.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioData.deleteById(id);
    }

}
