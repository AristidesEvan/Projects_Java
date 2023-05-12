public class UsaPessoa {
    public static void main(String[] args) throws Exception {
        
        Pessoa pessoa1 = new Pessoa("Mario","Lopes");
        Funcionario pessoa2 = new Funcionario("Lucas", "Mendes", 10, 2000.0);
        Professor pessoa3 = new Professor("Rafael", "Lira", 20, 5000.0);


        System.out.println(pessoa1.getNomeCompleto());
        System.out.println(pessoa2.getNomeCompleto());
        System.out.println(pessoa3.getNomeCompleto());

        System.out.println(pessoa2.getSalarioPrimeiraParcela());
        System.out.println(pessoa2.getSalarioSegundaParcela());
        System.out.println(pessoa3.getSalarioPrimeiraParcela());
        System.out.println(pessoa3.getSalarioSegundaParcela());

    }
}
