import java.util.ArrayList;
import java.util.Scanner;

public class MainEx01 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        int flag = 1;
        

        while (flag != 0) {
            String grauInstrucao = "Digite o grau de instrução da pessoa: ";
            String codeSexo = "Digite o código do sexo da pessoa: ";
            String idade = "Digite a idade da pessoa: ";
            Pessoa aux = new Pessoa(lerString(grauInstrucao), lerString(codeSexo), lerInt(idade));
            if(aux.getIdade() == 0) {
                flag = 0;
                break;
            }
            pessoas.add(aux);
            System.out.println(mostrarLista(pessoas));
            int[] qtd = qtd(pessoas);
            System.out.println("A quantidade de pessoas do sexo masculino com grau médio é: "+qtd[0]+".\nA quantidade de mulheres com grau Fundamental é: "+qtd[1]);
            System.out.println("A média  das idades das pessoas com grau pós é: "+mediaIdade(pessoas));
            System.out.println("A porcentagem de pessoas femininas com grau superior é: "+porCemFem(pessoas));



            System.out.print("0 para encerrar: ");
            flag = input.nextInt();
        }



    }
    public static int[] qtd(ArrayList<Pessoa> lista) {
        int[] qnt = {0,0}; 
        for (Pessoa pessoa : lista) {
            if(pessoa.getGrauInstrucao().equals("medio") && pessoa.getCodeSexo().equals("masc")) {
                qnt[0]++; 
            }
        }
        for (Pessoa pessoa : lista) {
            if(pessoa.getGrauInstrucao().equals("fundamental") && pessoa.getCodeSexo().equals("fem")) {
                qnt[1]++; 
            }
        }
        return qnt;
    } 

    public static double mediaIdade(ArrayList<Pessoa> lista) {
        int idade = 0, total = 0;
        double media = 0.0;
        for (Pessoa pessoa : lista) {
            if(pessoa.getGrauInstrucao().equals("pos")) {
                idade += pessoa.getIdade();
                total++;
            }
        }
        if(total == 0){return media;};
        media = idade / total;
        return media;
    }

    public static double porCemFem(ArrayList<Pessoa> lista) {
        int qnt = 0, total = 0;
        double porCem = 0.0;
        for (Pessoa pessoa : lista) {
            if(pessoa.getGrauInstrucao().equals("superior") && pessoa.getCodeSexo().equals("fem")) {
                qnt++;
            }
            total++;
        }
        porCem = qnt / total;
        return porCem;
    }

    public static String mostrarLista(ArrayList<Pessoa> lista){
        String aux = "";

        for (Pessoa pessoa : lista) {
            aux += pessoa.getPessoa();
        }
        return aux;
    }

    public static String lerString(String print) {  
        System.out.print(print);
        String aux = input.nextLine();
        if(aux.equals("")) {
            aux = input.nextLine();
        }
        return aux;
    }

    public static int lerInt(String print) {
        System.out.print(print);
        int aux = input.nextInt();
        while (aux < 0) {
            System.out.print("Erro: A idade não pode ser menor que 0, digite outra idade: ");
            aux = input.nextInt();
        }
        return aux;
    }

}
