public class Pilha {
    private int maxTam, topo;
    private Contato[] vetor;

    public int getMaxTam() {
        return maxTam;
    }

    public boolean setMaxTam(int aux) {
        if (aux <= 2)
            return false;
        topo = 0;
        maxTam = aux;
        vetor = new Contato[maxTam];
        return true;
    }

    public boolean pilhaCheia() {
        return (topo == maxTam);
    }

    public boolean pilhaVazia() {
        return (topo == 0);
    }

    public Pilha() {
        topo = 0;
        maxTam = 2;
        vetor = null;
    }

    public boolean push(Contato aux) {
        if (pilhaCheia())
            return false;
        vetor[topo] = aux;
        topo++;
        return true;
    }

    public Contato pop() {
        if (pilhaVazia())
            return null;
        topo--;
        Contato aux = vetor[topo];
        vetor[topo] = null;
        return aux;
    }
}