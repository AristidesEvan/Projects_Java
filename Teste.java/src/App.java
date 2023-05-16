
public class App {
    public static void main(String[] args) throws Exception {
        String[] nomes = nome.split(" ");
        String aux = "";
        System.out.println(nomes);
        for (int i = 0; i < nomes.length; i++) {
            nomes[i] = nomes[i].substring(0, 1).toUpperCase() + nomes[i].substring(1).toLowerCase();
            aux = aux + " " + nomes[i];  
        }
        nome = aux.trim();
        System.out.println(nome);


    }
}
