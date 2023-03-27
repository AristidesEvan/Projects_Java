import java.util.Scanner;

public class MainEx02 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        Aluno[] aluno;
        String nome;
        int idade;
        int matricula;

        int tamanhoDaLista;
        
        System.out.print("Escreva o número de alunos que deseja cadastrar: ");
        tamanhoDaLista = sc.nextInt();
        aluno = new Aluno[tamanhoDaLista];

        for (int i = 0; i < aluno.length; i++) {
            nome = gerarNome();
            idade = gerarIdade();
            matricula = 1000 + i;

            if(matricula > 9999) {
                break;
            }

            aluno[i] = new Aluno (nome, idade, matricula);

        }

        System.out.println("| Matricula - Nome - Idade - Turma |");
        for (int i = 0; i < aluno.length; i++) {
            System.out.print("| " + aluno[i].getMatricula());
            System.out.print(" - " + aluno[i].getNome());
            System.out.print(" - " + aluno[i].getIdade());
            System.out.print(" - " + aluno[i].getTurma() + " |\n");
        }

        sc.close();
    }

    public static String gerarNome() {
        String nome = ""; // 65 - 90
        String aux = "";

        for (int i = 0; i < 15; i++) {
            Double random = Math.random()*25 + 65;
            int num = random.intValue();
    
            aux += (char)num;
            nome = aux;       
        }
        return nome;
    }
    
    public static int gerarIdade() {
        int idade = 0;

        for (int i = 0; i < 15; i++) {
            Double random = Math.random()*28 + 7;
            idade = random.intValue();       
        }
        return idade;
    }
} 
