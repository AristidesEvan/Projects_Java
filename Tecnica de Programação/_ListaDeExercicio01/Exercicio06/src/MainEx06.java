public class MainEx06 {
    public static void main(String[] args) throws Exception {
        
        Carro carro = new Carro();
        
        carro.liga();
        System.out.println("Ligado: "+carro.isLigado());
        System.out.println(carro.getQuilometragem()+" Km");
        System.out.println(carro.getVelocidade()+"\n");

        carro.setQuilometragem(123);
        System.out.println("Ligado: "+carro.isLigado());
        System.out.println(carro.getQuilometragem()+" Km");
        System.out.println(carro.getVelocidade()+"\n");

        carro.setVelocidade(50);;
        System.out.println("Ligado: "+carro.isLigado());
        System.out.println(carro.getQuilometragem()+" Km");
        System.out.println(carro.getVelocidade()+" Km/h\n");

        carro.desliga();
        System.out.println("Ligado: "+carro.isLigado());
        System.out.println(carro.getQuilometragem()+" Km");
        System.out.println(carro.getVelocidade()+" Km/h\n");

    }
}
