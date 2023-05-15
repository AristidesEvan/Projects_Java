public class MainEx05 {
    public static void main(String[] args) throws Exception {
        
        Equipamento equipamento = new Equipamento();
        EquipamentoSonoro equipamentoSonoro = new EquipamentoSonoro();

        equipamento.liga();
        System.out.println("Equipamento ligado? : "+equipamento.isLigado());
        equipamento.desliga();
        System.out.println("Equipamento ligado? : "+equipamento.isLigado()+"\n");

        equipamentoSonoro.liga();
        equipamentoSonoro.somMono();
        System.out.println("Equipamento ligado? : "+equipamentoSonoro.isLigado());
        System.out.println("Volume: "+equipamentoSonoro.getVolume());
        System.out.println("É stereo: "+equipamentoSonoro.isStereo());
        equipamentoSonoro.somStereo();
        System.out.println("Equipamento ligado? : "+equipamentoSonoro.isLigado());
        System.out.println("Volume: "+equipamentoSonoro.getVolume());
        System.out.println("É stereo: "+equipamentoSonoro.isStereo());
        equipamentoSonoro.desliga();
        System.out.println("Equipamento ligado? : "+equipamentoSonoro.isLigado());
        System.out.println("Volume: "+equipamentoSonoro.getVolume());
        System.out.println("É stereo: "+equipamentoSonoro.isStereo());


    }
}
