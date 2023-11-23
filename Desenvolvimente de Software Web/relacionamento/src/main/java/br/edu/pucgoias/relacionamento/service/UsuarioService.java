package br.edu.pucgoias.relacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.pucgoias.relacionamento.dao.UsuarioDao;
import br.edu.pucgoias.relacionamento.model.Usuario;

@Component
public class UsuarioService {
    
    @Autowired
    private UsuarioDao usuarioDao;

    public List<Usuario> getAllUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    public Usuario insertUsuario(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    // public void deleteUsuario(Long id) {
    //     usuarioDao.deleteById(id);
    // }

    public void deleteUsuario(Long idUsuario) {
        Usuario usuario = usuarioDao.findById(idUsuario).orElseThrow();

        // Remova as relações de seguimento
        for (Usuario seguindo : usuario.getSeguindo()) {
            seguindo.getSeguidores().remove(usuario);
        }

        // Remova as relações de seguidores
        for (Usuario seguidor : usuario.getSeguidores()) {
            seguidor.getSeguindo().remove(usuario);
        }

        // Exclua o usuário
        usuarioDao.delete(usuario);
    }

    public String seguirUsuario(Long idSeguidor, Long idSeguindo) {
        Usuario seguidor = usuarioDao.findById(idSeguidor).orElseThrow();
        Usuario seguindo = usuarioDao.findById(idSeguindo).orElseThrow();

        if (!seguidor.getSeguindo().contains(seguindo)) {
            
            seguidor.getSeguindo().add(seguindo);
            seguindo.getSeguidores().add(seguidor);
    
            usuarioDao.save(seguidor);
            usuarioDao.save(seguindo);

            return "Usuario seguiu com sucesso!";

        }

        return "Usuario ja esta seguindo este usuario!";

    }

    public String deixarDeSeguirUsuario(Long idSeguidor, Long idSeguindo) {
        Usuario seguidor = usuarioDao.findById(idSeguidor).orElseThrow();
        Usuario seguindo = usuarioDao.findById(idSeguindo).orElseThrow();

        if (seguidor.getSeguindo().contains(seguindo)) {

            seguidor.getSeguindo().remove(seguindo);
            seguindo.getSeguidores().remove(seguidor);
    
            usuarioDao.save(seguidor);
            usuarioDao.save(seguindo);

            return "Usuario deixou de seguir com sucesso!";

        }

        return "Usuario ja nao segue este usuario!";

    }

}
