public class Fila {
    private int maxTam;
    private int fim;
    private Cliente[] lista;

    public Fila() {
        this.maxTam = 2;
        this.fim = 0;
        this.lista = null;
    }

    public boolean enfileirar(Cliente cli) {
        if (filaCheia()) {
            return false;
        }

        lista[fim] = cli;
        fim++;
        return true;
    }

    public Cliente desenfileirar() {
        if (filaVazia()){return null;}
            
        fim--;
        Cliente aux = lista[0];
        lista[0] = null;

        for (int i = 0; i < lista.length; i++) {
            if(fim == i) {
                lista[i] = null;
                break;
            }
            
            lista[i] = lista[i+1];
        }

        return aux;
    }

    public boolean filaVazia() {
        return (fim == 0);
    }

    public boolean filaCheia() {
        return (fim == maxTam);
    }

    public boolean setMaxTam(int aux) {
        if (aux <= 2) {
            return false;
        }
        maxTam = aux;
        lista = new Cliente[maxTam];
        return true;
    }

    public int getMaxTam() {
        return maxTam;
    }

}
