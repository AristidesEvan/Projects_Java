public class Pessoa {

    private String grauInstrucao, codeSexo;
    private int idade;

    public Pessoa() {}

    public Pessoa(String grauInstrucao, String codeSexo, int idade) {
        this.grauInstrucao = grauInstrucao;
        this.codeSexo = codeSexo;
        this.idade = idade;
    }
    public String getPessoa() {
        String aux;
        aux = "| "+this.grauInstrucao+" - "+this.codeSexo+" - "+this.idade+" |\n";
        return aux;
    }

    public String getGrauInstrucao() {return grauInstrucao;}
    public void setGrauInstrucao(String grauInstrucao) {this.grauInstrucao = grauInstrucao;}
    public String getCodeSexo() {return codeSexo;}
    public void setCodeSexo(String codeSexo) {this.codeSexo = codeSexo;}
    public int getIdade() {return idade;}
    public void setIdade(int idade) {this.idade = idade;}

}
