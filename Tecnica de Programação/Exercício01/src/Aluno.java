
public class Aluno {

    private String nome;
    private int idade;
    private int matricula;
    private String turma;

    public Aluno(String nome, int idade, int matricula) throws Exception {

        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;

        if (idade <= 11 && idade > 0) {
            this.turma = "Infância";
        } else if (idade >= 12 && idade <= 20) {
            this.turma = "Adolecência";
        } else if (idade >= 21) {
            this.turma = "Adulto";
        }
        
    }

    public String getNome () {
        return this.nome;
    }
    public int getIdade () {
        return this.idade;
    }
    public int getMatricula () {
        return this.matricula;
    }
    public String getTurma () {
        return this.turma;
    }
} 
