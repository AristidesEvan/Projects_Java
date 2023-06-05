package model;

public class Profissao {
    private int id_profissao = 0;
    private String nomeProfissao;
    private String descricaoProfissao;
    
    // Constructors, get's e set's. -----------------------------------
    public Profissao() {}
    public Profissao(String nomeProfissao, String descricaoProfissao) {
        this.nomeProfissao = nomeProfissao;
        this.descricaoProfissao = descricaoProfissao;
    }
    public String getNomeProfissao() {
        return nomeProfissao;
    }
    public void setNomeProfissao(String nomeProfissao) {
        this.nomeProfissao = nomeProfissao;
    }
    public String getDescricaoProfissao() {
        return descricaoProfissao;
    }
    public void setDescricaoProfissao(String descricaoProfissao) {
        this.descricaoProfissao = descricaoProfissao;
    }
    public int getId_profissao() {
        return id_profissao;
    }
    public void setId_profissao(int id_profissao) {
        this.id_profissao = id_profissao;
    }
    // Constructors, get's e set's. -----------------------------------
    
}
