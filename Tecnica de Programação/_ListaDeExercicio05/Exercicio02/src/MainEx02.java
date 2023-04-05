
public class MainEx02 {
    public static void main(String[] args) throws Exception {

        Funcionario funcionario = new Funcionario("aristides", 1591591591, 159159195, 10000.10);
        funcionario.aumento();
        funcionario.exibDados();

        Administrativo administrativo = new Administrativo("joão", 123546789, 132456456, 10000.0, 1321654, "noturno");
        administrativo.aumento();
        administrativo.exibDados();

        Assistente assistente = new Assistente("pedro", 123564987, 321321321, 10000.0, 321654);
        assistente.aumento();
        assistente.exibDados();

        Gerente gerente = new Gerente("jorge", 132654897, 321654654, 10000.0, "alto");
        gerente.aumento();
        gerente.exibDados();

        Tecnico tecnico = new Tecnico("maria", 123546987, 213546879, 10000.0, 213213);
        tecnico.aumento();
        tecnico.exibDados();
        


    
    }
}
