public class Vip extends Ingresso{
    private Double valorAdicional;

    public Vip(Double valor, Double valorAdicional) {
        super(valor);
        this.valorAdicional = valorAdicional;
    }

    public void imprimeIngressoVip() {
        System.out.println(getValor()+" "+this.valorAdicional);
    }

}
