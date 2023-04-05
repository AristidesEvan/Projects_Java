public class MainEx05 {
    public static void main(String[] args) throws Exception {
        
        Double A = 90000.0, B = 200000.0;
        int qntAno = 0;

        do {

            A += A * 0.03;
            B += B * 0.015;

            qntAno++;
            
        } while (A < B);

        System.out.println("Em "+ qntAno +" anos a cidade A ultrapasará ou se igualará a quantidade de abitantes da cidade B.");

    }
}
