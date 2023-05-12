public class Funcionario {
    
    private String nome;
    private long cpf, rg;
    private Double salario;

    public Funcionario(String nome, long cpf, long rg, Double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.salario = salario;
    }

    public void exibDados() {
        System.out.println("| nome - cpf - rg - salario |");
        System.out.print("| " + this.nome + " - ");
        System.out.print(this.cpf + " - ");
        System.out.print(this.rg + " - ");
        System.out.print(this.salario+" |\n\n");
    }

    public void aumento() {
        this.salario += this.salario * 0.10; 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    
}
