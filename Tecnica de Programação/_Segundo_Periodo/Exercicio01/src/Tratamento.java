import java.util.ArrayList;

public class Tratamento {
    private String valor;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<String[]> valores = new ArrayList<>(); //4, 7, 10
    

    public Tratamento() {}
    public Tratamento(String valor) {
        this.valor = valor;
    }

    public void tratar() {
        String valor = this.valor;
        String[] linhas = valor.split("\\r?\\n");

        for (int i = 0; i < linhas.length; i++) {
            String[] valores = linhas[i].split("-");
            this.valores.add(valores);
        }

        for (int i = 0; i < this.valores.size(); i++) {
            String[] aux = this.valores.get(i);

            if (aux.length > 3) {

                Funcionario funcionario = criarFuncionario(i, aux);

                if (aux.length > 6) {
                    funcionario.setDescendente(criarDescendente1(aux));
                }
                if (aux.length > 9) {
                    funcionario.setDescendente(criarDescendente2(aux));
                }

                this.funcionarios.add(funcionario);

            }

        }
    }

    public Funcionario criarFuncionario(int i, String[] aux) {
        int matricula = Integer.parseInt(aux[0]);
        Double salario = Double.parseDouble(aux[2]);
        Double gratificacao = Double.parseDouble(aux[3]);
                    
        Funcionario funcionario = new Funcionario(i, matricula, aux[1], salario, gratificacao);
        return funcionario;
    }

    public Descendente criarDescendente1(String[] aux) {
                    
        Descendente descendente = new Descendente(aux[4], aux[5], aux[6]);
        return descendente;
        
    }

    public Descendente criarDescendente2(String[] aux) {
                    
        Descendente descendente = new Descendente(aux[7], aux[8], aux[9]);
        return descendente;
        
    }


    
}
