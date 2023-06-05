package model;

public class Pessoa {
    private String nome_pessoa;
    private int id_lista_de_profissao_fk;
    private int id_lista_de_telefones_fk;

    public Pessoa() {}
    public Pessoa(String nome_pessoa, int id_lista_de_profissao_fk, int id_lista_de_telefones_fk) {
        this.nome_pessoa = nome_pessoa;
        this.id_lista_de_profissao_fk = id_lista_de_profissao_fk;
        this.id_lista_de_telefones_fk = id_lista_de_telefones_fk;
    }
    
    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public int getId_lista_de_profissao_fk() {
        return id_lista_de_profissao_fk;
    }

    public void setId_lista_de_profissao_fk(int id_lista_de_profissao_fk) {
        this.id_lista_de_profissao_fk = id_lista_de_profissao_fk;
    }

    public int getId_lista_de_telefones_fk() {
        return id_lista_de_telefones_fk;
    }

    public void setId_lista_de_telefones_fk(int id_lista_de_telefones_fk) {
        this.id_lista_de_telefones_fk = id_lista_de_telefones_fk;
    }
    

    
}
