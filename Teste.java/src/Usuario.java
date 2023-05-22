public class Usuario {
    private Double saldo = 450.0;

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void addSaldo(Double add) {
        this.saldo += add;
    }

    public Double getSaldo() {
        return this.saldo;
    }
}
