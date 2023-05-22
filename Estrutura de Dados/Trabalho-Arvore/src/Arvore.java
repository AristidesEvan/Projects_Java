public class Arvore { 
    
    private class No { 
        private Item dados;
        private No fd, fe, pai;
        
        public No (Item aux) { 
            dados = aux;
            fd = fe = pai = null; 
        } 
    } 
    
    private No raiz;
    private int tamanho;

    public Arvore () { 
        raiz = null;
        tamanho = 0; 
    } 

    public int getTamanho() { 
        return tamanho; 
    } 

    public boolean vazia() { 
        return(raiz == null); 
    } 

    private No consultar(Item obj) {
        No aux = raiz;

        while( aux != null ){ 
            if(obj.getNome().compareTo(aux.dados.getNome()) < 0) {
                aux = aux.fe;
            } else if (obj.getNome().compareTo(aux.dados.getNome()) > 0) {
                aux = aux.fd;
            } else {return aux;} // Sucesso
        }

        return null; // Insucesso
    } 

    public Item pesquisar(Item obj) {
        No aux = consultar(obj);

        if( aux == null){ return null; } // Insucesso

        return(new Item(aux.dados.getNome(), aux.dados.getFone())); // Sucesso
    }

    public boolean inserir(Item obj) {
        No aux = new No(obj); // Cria-se um nó
        if(vazia()) { raiz = aux; return true; } // Verifica-se o estado da arvore
        No ptr = raiz; No ant = raiz; // Caso vazia, torna o nó criado na raiz
        
        while( ptr != null){
            if(obj.getNome().compareTo(ptr.dados.getNome()) < 0) { 
                ant = ptr; ptr = ptr.fe; 
            } else if (obj.getNome().compareTo(ptr.dados.getNome()) > 0) { 
                ant = ptr; ptr = ptr.fd; 
            } else {return false;} // Insucesso
        }

        aux.pai = ant;
        
        // Define se o nó é a direita ou a esquerda
        if(obj.getNome().compareTo(ant.dados.getNome()) < 0) { 
            ant.fe = aux; 
        } else { ant.fd = aux; } 

        return true; // Sucesso
    }

    private No maximo(No obj) {
        if(obj == null) return null;
        
        No atual = obj;
        
        // Verifica-se o maximo
        while(atual.fd != null) { 
            atual = atual.fd;
        } 

        return atual;// Maior valor
    }

    private No minimo(No obj) {
        if(obj == null) return null;
        
        No atual = obj;
        
        // Verifica-se o minimo
        while(atual.fe != null) { 
            atual = atual.fe; 
        }

        return atual; // Menor valor
    }

    private No antecessor(No obj) {
        if(obj == null) {return null;}
        if(obj.fe != null) {return (maximo(obj.fe));} 

        No atual = obj.pai;
        No ant = obj; 
        
        while(atual != null && ant == atual.fe) { 
            ant = atual;
            atual = atual.pai;
        }

        return atual;
    }

    private No sucessor(No obj) {
        if(obj == null) {return null;}
        if(obj.fd != null) {return(minimo(obj.fd));}

        No atual = obj.pai; 
        No ant = obj; 

        while(atual != null && ant == atual.fd){ 
            ant = atual; 
            atual = atual.pai; 
        }
        
        return atual;
    }

    public Item retirar(Item obj) {
        Item aux = null;
        No z = consultar(obj); 

        if(z != null) { 
            aux = z.dados; 

            No y = null;
            No x = null;

            if(z.fd == null || z.fe == null) { 
                y = z;
            } else {
                y = sucessor(z);
            } if (y.fe != null) {
                x = y.fe;
            } else {
                x = y.fd;
            } 
            
            if(x != null) { x.pai = y.pai; }
            if(y.pai == null) {
                raiz = x; 
                if(x != null) {x.pai = null;} 
            } else {
                if(y == y.pai.fe) {
                    y.pai.fe = x;
                } else {
                    y.pai.fd = x;
                } 
            }
            if(y != z) {z.dados = y.dados;}

            tamanho--; 
        } 
        return aux;
    }
    
    // public void visitaEmOrdem(StringBuffer aux) { // chamar método recursivo
    // } 
    // public void visitaEmPreOrdem(StringBuffer aux) { // chamar método recursivo 
    // } 
    // public void visitaEmPosOrdem(StringBuffer aux) { // chamar método recursivo 
    // } 
    // public void testaIntegridade(StringBuffer aux) { // chamar método recursivo 
    // } 
}