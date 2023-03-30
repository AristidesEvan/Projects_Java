public class Ingresso {
    private Double valor;

    public Ingresso(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return this.valor;
    }

    public void imprimeValor() {
        System.out.println(valor);
    }
}
