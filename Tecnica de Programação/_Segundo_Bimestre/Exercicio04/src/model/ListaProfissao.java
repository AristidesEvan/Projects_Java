package model;

public class ListaProfissao {
    private int pk_id_profissao1;
    private int pk_id_profissao2;
    private int pk_id_profissao3;

    public ListaProfissao() {}
    public ListaProfissao(int pk_id_profissao1, int pk_id_profissao2, int pk_id_profissao3) {
        this.pk_id_profissao1 = pk_id_profissao1;
        this.pk_id_profissao2 = pk_id_profissao2;
        this.pk_id_profissao3 = pk_id_profissao3;
    }

    public int getPk_id_profissao1() {
        return pk_id_profissao1;
    }
    public void setPk_id_profissao1(int pk_id_profissao1) {
        this.pk_id_profissao1 = pk_id_profissao1;
    }
    public int getPk_id_profissao2() {
        return pk_id_profissao2;
    }
    public void setPk_id_profissao2(int pk_id_profissao2) {
        this.pk_id_profissao2 = pk_id_profissao2;
    }
    public int getPk_id_profissao3() {
        return pk_id_profissao3;
    }
    public void setPk_id_profissao3(int pk_id_profissao3) {
        this.pk_id_profissao3 = pk_id_profissao3;
    }

}
