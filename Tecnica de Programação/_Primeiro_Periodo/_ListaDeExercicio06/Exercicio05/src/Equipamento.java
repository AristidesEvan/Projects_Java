public class Equipamento {
    boolean ligado;

    public Equipamento() {

    }
   
    public boolean isLigado() {return ligado;}
    public void setLigado(boolean lig) {this.ligado = lig;}
    
    public void liga(){
        ligado = true;
    }
    public void desliga(){
        ligado = false;
    }

}
