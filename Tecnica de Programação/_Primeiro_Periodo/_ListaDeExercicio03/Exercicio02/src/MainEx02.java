public class MainEx02 {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.setMatricula("Digite a matrícula da pessoa 1: ");
        p1.setNome("Digite o nome da pessoa 1: ");
        p1.setCpf("Digite o CPF da pessoa 1: ");
        p1.setSalario("Digite o salário da pessoa 1: ");

        Pessoa p2 = new Pessoa();
        p2.setMatricula("Digite a matrícula da pessoa 2: ");
        p2.setNome("Digite o nome da pessoa 2: ");
        p2.setCpf("Digite o CPF da pessoa 2: ");
        p2.setSalario("Digite o salário da pessoa 2: ");

        Pessoa p3 = new Pessoa();
        p3.setMatricula("Digite a matrícula da pessoa 3: ");
        p3.setNome("Digite o nome da pessoa 3: ");
        p3.setCpf("Digite o CPF da pessoa 3: ");
        p3.setSalario("Digite o salário da pessoa 3: ");

        p1.imprimeDados();
        p2.imprimeDados();
        p3.imprimeDados();
    }
}