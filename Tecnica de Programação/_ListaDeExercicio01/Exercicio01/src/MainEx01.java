import java.util.Scanner;

public class MainEx01 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        
        Animal[] animal;
        int QtdAnimais;

        System.out.print("Digite quantos animais deseja cadastrar: ");
        QtdAnimais = scanner.nextInt();
        animal = new Animal[QtdAnimais];

        for (int i = 0; i < animal.length; i++) {
            
            String nome, cor, ambiente, caracteristicas;
            Double comprimento;
            int patas;

            System.out.print("Nome do animal: ");
            nome = scanner.next();
            System.out.print("Cor do animal: ");
            cor = scanner.next();
            System.out.print("Ambiente do animal: ");
            ambiente = scanner.next();
            System.out.print("Caracteristica do animal: ");
            caracteristicas = scanner.next();
            System.out.print("Comprimento do animal: ");
            comprimento = scanner.nextDouble();
            System.out.print("patas do animal: ");
            patas = scanner.nextInt();

            animal[i] = new Animal(nome, cor, ambiente, caracteristicas, comprimento, patas);
            
        }

        for (int i = 0; i < animal.length; i++) {
            System.out.println("| Animal "+i+" |");
            System.out.println(" - nome: " + animal[i].getNome());
            System.out.println(" - cor: " + animal[i].getCor());
            System.out.println(" - ambiente: " + animal[i].getAmbiente());
            System.out.println(" - caracteristicas: " + animal[i].getCaracteristicas());
            System.out.println(" - comprimento: " + animal[i].getComprimento());
            System.out.println(" - patas: " + animal[i].getPatas() + "\n");
        }


        scanner.close();
    }
}
