public class EquipamentoSonoro extends Equipamento{
    int volume;
    boolean stereo;

    public EquipamentoSonoro() {
        super();
    }

    public int getVolume() {return volume;}
    public void setVolume(int volume) {this.volume = volume;}
    public boolean isStereo() {return stereo;}
    public void setStereo(boolean stereo) {this.stereo = stereo;}

    public void liga(){
        setLigado(true);
        volume = 5;
    } 
    public void desliga(){
        setLigado(false);
        volume = 0;
    } 
    public void somMono() {
        stereo = false;
    }
    public void somStereo() {
        stereo = true;
    }
}
