public class Lista {
    private int ultimo;
    private int maxTam;
    private Contato[] lista;

    public boolean setMaxTam(int aux) {
        if (aux <= 2) {
            return false;
        }
        maxTam = aux;
        lista = new Contato[maxTam];
        return true;
    }

    public int getMaxTam() {
        return maxTam;
    }

    public Lista() {
        this.maxTam = 2;
        this.ultimo = 0;
        this.lista = null;
    }

    public boolean listaVazia() {
        return (ultimo == 0);
    }

    public boolean listaCheia() {
        return (ultimo == maxTam);
    }

    public boolean insereFinal(Contato cli) {
        if (listaCheia()) {
            return false;
        }

        lista[ultimo] = cli;
        ultimo++;
        return true;
    }

    public Contato retira(String procurarPor) {
        if (listaVazia()){return null;}

        String texto = "";
        int index = 0;

        for (int i = 0; i < lista.length; i++) {
            texto = lista[i].getContato();

            if (texto.toLowerCase().contains(procurarPor.toLowerCase())) {
                index = i;
                break;
            }
        }

        // Realocar de forma diferente
            
        ultimo--;
        Contato aux = lista[index];
        lista[index] = null;

        for (int i = index; i < lista.length; i++) {
            if(ultimo == i) {
                lista[i] = null;
                break;
            }
            
            lista[i] = lista[i+1];
        }

        return aux;
    }

    public Contato pesquisa(String procurarPor) {

        String texto = "";
        Contato aux = null;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                texto = lista[i].getContato();
            }
            
            if (texto.toLowerCase().contains(procurarPor.toLowerCase())) {
                aux = lista[i];
                break;
            }
        }

        return aux;
        
    }

    public String getLista() {
        String aux = "";

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                aux += lista[i].getContato();
            }
        }
        return aux;
    }



}