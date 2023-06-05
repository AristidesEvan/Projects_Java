package model;

public class ListaTelefone {
    private String telefone1;
    private String telefone2;
    private String telefone3;

    public ListaTelefone() {}
    public ListaTelefone(String telefone1, String telefone2, String telefone3) {
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
    }

    public String getTelefone1() {
        return telefone1;
    }
    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }
    public String getTelefone2() {
        return telefone2;
    }
    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }
    public String getTelefone3() {
        return telefone3;
    }
    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }
    
}
