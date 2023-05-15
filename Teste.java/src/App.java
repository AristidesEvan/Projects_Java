import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int x, y ,r = 0;
        Scanner input = new Scanner(System.in);

        x = input.nextInt();
        y = input.nextInt();

        for (int i = 1; i < x; i++) {
            if(x % i == 0 && y % i == 0) {
                r = i;
            }
        }
        System.out.println(r);
    }
}
