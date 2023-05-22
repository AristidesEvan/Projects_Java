
public class App {
    public static void main(String[] args) throws Exception {

        Usuario usuario = new Usuario();

        usuario.setSaldo(1200.0);
        usuario.addSaldo(1200.0);

        System.out.println(usuario.getSaldo());

    }
}
