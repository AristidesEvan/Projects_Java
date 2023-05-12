import java.util.Scanner;

public class MainEx01 {
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

            System.out.print("Escreva o nome do(a) aluno(a) "+ i +": ");
            nome = sc.next();

            System.out.print("Escreva a idade do(a) aluno(a) "+ i +": ");
            idade = sc.nextInt();

            System.out.print("Escreva o matricula do(a) aluno(a) "+ i +": ");
            matricula = sc.nextInt();

            aluno[i] = new Aluno (nome, idade, matricula);

        }

        for (int i = 0; i < aluno.length; i++) {
            System.out.println("| Matricula - Nome - Idade - Turma |");
            System.out.print("| " + aluno[i].getMatricula());
            System.out.print(" - " + aluno[i].getNome());
            System.out.print(" - " + aluno[i].getIdade());
            System.out.print(" - " + aluno[i].getTurma() + " |\n");
        }

        sc.close();
    }
} 
