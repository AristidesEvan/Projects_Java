public class MainEx02 {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(Pessoa.leInt("Digite a matrícula da pessoa 1: "),
                Pessoa.leString("Digite o nome da pessoa 1: "),
                Pessoa.leString("Digite o CPF da pessoa 1: "),
                Pessoa.leDouble("Digite o salário da pessoa 1: "));

        Pessoa p2 = new Pessoa(Pessoa.leInt("Digite a matrícula da pessoa 2: "),
                Pessoa.leString("Digite o nome da pessoa 2: "),
                Pessoa.leString("Digite o CPF da pessoa 2: "),
                Pessoa.leDouble("Digite o salário da pessoa 2: "));

        Pessoa p3 = new Pessoa(Pessoa.leInt("Digite a matrícula da pessoa 3: "),
                Pessoa.leString("Digite o nome da pessoa 3: "),
                Pessoa.leString("Digite o CPF da pessoa 3: "),
                Pessoa.leDouble("Digite o salário da pessoa 3: "));

        p1.imprimeDados();
        p2.imprimeDados();
        p3.imprimeDados();
    }
}