package com.exemplo.exercicio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.model.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> lista = new ArrayList<>();

    @GetMapping("/")
    public String olaMundo() {
        return "Olá, mundo!";
    }

    @GetMapping("/usuario")
    public Usuario usuario() {
        Usuario u = new Usuario();
        u.setId(2);
        u.setNome("joão");
        u.setSenha("senha");
        u.setUsuario("joãoU");

        return u;
    }

    @PostMapping("/")
    public Usuario retornaUsuario(@RequestBody Usuario usuario) {
        lista.add(usuario);
        return usuario;
    }

    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios() {
        return lista;
    }

    @GetMapping("/{id}")
    public Usuario pesquisaIdUsuario (@PathVariable("id") Integer id) { 

        Usuario usuario = null; 

        for(int i=0; i<lista.size(); i++) {

            Integer idx = lista.get(i).getId();

            if (idx==id) {

                usuario = lista.get(i); 
                break;

            }
        }
        return usuario;
    }

    @GetMapping("/{id}/{nome}")
    public Usuario pesquisaIdNomeUsuario (@PathVariable("id") Integer id, @PathVariable("nome") String nome) { 

        Usuario usuario = null; 

        for(int i=0; i<lista.size(); i++) {

            Integer idx = lista.get(i).getId();
            String nomex = lista.get(i).getNome();

            if (idx==id && nomex.equals(nome)) {

                usuario = lista.get(i); 
                break;

            }
        }
        return usuario;
    }

}
