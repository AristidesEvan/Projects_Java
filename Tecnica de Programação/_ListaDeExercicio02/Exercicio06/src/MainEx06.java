import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainEx06 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        String linhaDados = "10423547000003587253007202202082022";

        String banco = linhaDados.substring(0, 3);
        String codigoMoeda = linhaDados.substring(3, 4);
        String agencia = linhaDados.substring(4, 9);
        String valorBoleto = linhaDados.substring(9, 19);
        String dataVencimentoStr = linhaDados.substring(19, 27);
        String dataPagamentoStr = linhaDados.substring(27, 35);

        DecimalFormat df = new DecimalFormat("#,##0.00");
        DateFormat dtfEntrada = new SimpleDateFormat("ddMMyyyy");
        DateFormat dtfSaida = new SimpleDateFormat("dd/MM/yyyy");

        double valorBoletoDouble = Double.parseDouble(valorBoleto) / 100;
        String valorBoletoStr = df.format(valorBoletoDouble);

        Date dataVencimento = dtfEntrada.parse(dataVencimentoStr);
        String dataVencimentoFormatada = dtfSaida.format(dataVencimento);

        Date dataPagamento = dtfEntrada.parse(dataPagamentoStr);
        String dataPagamentoFormatada = dtfSaida.format(dataPagamento);

        String moeda = "";
        switch (codigoMoeda) {
            case "1":
                moeda = "real";
                break;
            case "2":
                moeda = "dólar";
                break;
            case "3":
                moeda = "euro";
                break;
            case "4":
                moeda = "peso";
                break;
            case "5":
                moeda = "libra";
                break;
            default:
                moeda = "desconhecida";
        }

        System.out.println("Banco: " + banco);
        System.out.println("Moeda: " + moeda);
        System.out.println("Agência Bancária: " + agencia);
        System.out.println("Valor do Boleto: " + valorBoletoStr);
        System.out.println("Data de Vencimento: " + dataVencimentoFormatada);
        System.out.println("Data de Pagamento: " + dataPagamentoFormatada);

        sc.close();
    }
}