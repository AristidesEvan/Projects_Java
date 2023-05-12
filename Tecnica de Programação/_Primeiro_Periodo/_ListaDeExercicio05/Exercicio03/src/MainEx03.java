public class MainEx03 {
    public static void main(String[] args) throws Exception {
        
        Vip vip = new Vip(100.0, 50.0);
        vip.imprimeValor(); // função da classe ingresso
        vip.imprimeIngressoVip(); // função da classe vip

        Normal normal = new Normal(80.0);
        normal.imprimeValor(); // função da classe ingresso
        normal.imprimeIngressoNormal(); // função da classe normal
        
    }
}
