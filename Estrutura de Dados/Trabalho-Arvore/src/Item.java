public class Item{
    private String nome, fone; 
    public Item(String pNome, String pFone) { 
        nome = pNome; 
        fone = pFone; 
    } 
    
    public String getNome() {return nome;}
    public String getFone() {return fone;} 
    
    @Override
    public String toString() { 
        return (nome+ "\n"+ fone+ "\n"); 
    }

}
 
