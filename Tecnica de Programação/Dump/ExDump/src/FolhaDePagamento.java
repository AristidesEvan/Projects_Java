import javax.swing.JOptionPane;

abstract class Funcionario {

    protected String nome;

    protected int horasTrabalhadas;

    public Funcionario(String nome, int horasTrabalhadas) {

        this.nome = nome;

        this.horasTrabalhadas = horasTrabalhadas;
    }

    public abstract double calcularSalario();
}

class FuncionarioAdministrativo extends Funcionario {

    public FuncionarioAdministrativo(String nome,int horasTrabalhadas) {
        super(nome, horasTrabalhadas);
    }

    public double calcularSalario() {
        return 1300.0;
    }
}

class FuncionarioProfessor extends Funcionario {

    public FuncionarioProfessor(String nome, int horasTrabalhadas) {
        super(nome, horasTrabalhadas);
    }

    public double calcularSalario() {

        double salarioMinimo = 1300.0;

        double valorHoraAula = 25.0;

        double salarioFixo = salarioMinimo + (horasTrabalhadas * valorHoraAula);

        return salarioFixo;
    }
}

class FuncionarioMedico extends Funcionario {

    public FuncionarioMedico(String nome, int horasTrabalhadas) {
        super(nome, horasTrabalhadas);
    }

    public double calcularSalario() {

        double salarioMinimo = 1300.0;

        double salarioBase = salarioMinimo * 2.5;

        double valorHora = 55.0;

        double salarioExtra = horasTrabalhadas * valorHora;

        return salarioBase + salarioExtra;
    }
}

public class FolhaDePagamento {

    public static void main(String[] args) {

        String opcao = JOptionPane.showInputDialog( null, "Digite a categoria do funcionário (A - Administrativo, P - Professor, M - Médico):");

        String nome = JOptionPane.showInputDialog( null, "Digite o nome do funcionário:");

        int horasTrabalhadas = Integer.parseInt(JOptionPane.showInputDialog( null, "Digite a quantidade de horas trabalhadas:"));

        Funcionario funcionario;

        switch (opcao) {

            case "A":
                funcionario = new

                FuncionarioAdministrativo(nome, horasTrabalhadas);

                break;

            case "P":
                funcionario = new

                FuncionarioProfessor(nome, horasTrabalhadas);

                break;

            case "M":
                funcionario = new

                FuncionarioMedico(nome, horasTrabalhadas);

                break;

            default:
                JOptionPane.showMessageDialog( null, "Opção inválida");

                return;
        }

        double salario = funcionario.calcularSalario();
        JOptionPane.showMessageDialog( null, "Nome: " + nome + "\nCategoria: " + opcao + "\nSalário: R$" + salario);
    }
}