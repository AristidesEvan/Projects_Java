import java.text.DecimalFormat;
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

    public String getFuncionarioFormatados() {
        ArrayList<Funcionario> listaDeFuncionarios = this.funcionarios;
        String retorno = "Lista de funcionários\n=====================================\n";
        String aux = "";

        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
            aux += criarFuncionarioDescendente(listaDeFuncionarios.get(i));
        }

        retorno += aux;
        return retorno;        
    }

    public String criarFuncionarioDescendente(Funcionario funcionario) {
        String aux = "";

        aux = funcionario.getCodigo()+" ";
        aux += funcionario.getNome()+" ";
        aux += "- R$"+funcionario.getSalario()+" ";
        aux += "- R$"+funcionario.getGratificacao()+"\n";

        if (funcionario.getDescendente().size() >= 1) {
            aux += descendenteString(funcionario.getDescendente().get(0));
            if(funcionario.getDescendente().size() == 2) {
                aux += descendenteString(funcionario.getDescendente().get(1));
            }
        } else {
            aux += "      <Sem filhos>\n";
        }

        return aux;
    }

    public String descendenteString(Descendente descendente) {
        String aux = "";

        aux += "      "+descendente.getNome();
        aux += " - "+descendente.getNascimento()+" - ";
        aux += descendente.getSexo()+"\n";

        return aux;
    }

    public String doubleToString(Double valor) {
        DecimalFormat formato = new DecimalFormat("0.00");
        String aux = "";
        aux = formato.format(valor);
        // .replaceAll(".", ",")
        return aux;
    }

    public Funcionario criarFuncionario(int i, String[] aux) {
        int matricula = Integer.parseInt(aux[0]);
        Double salario = Double.parseDouble(aux[2]);
        Double gratificacao = Double.parseDouble(aux[3]);
                    
        Funcionario funcionario = new Funcionario(normalizarCodigo(i), matricula, capitalizandoNome(aux[1]), doubleToString(divididoPorCem(salario)), doubleToString(divididoPorCem(gratificacao)));
        return funcionario;
    }

    public String normalizarCodigo(int codigo) {
        codigo++;
        if(codigo < 10) {
            return "00" + Integer.toString(codigo);
        } else if (codigo < 100) {
            return "0" + Integer.toString(codigo);
        } else if (codigo > 999) {
            return "Máximo funcionarios permitido 999";
        } else {
            return "Número não esperado";
        }
    }

    public Descendente criarDescendente1(String[] aux) {
                    
        Descendente descendente = new Descendente(capitalizandoNome(aux[4]), stringToDate(aux[5]), charToString(aux[6]));
        return descendente;
        
    }

    public Descendente criarDescendente2(String[] aux) {
                    
        Descendente descendente = new Descendente(capitalizandoNome(aux[7]), stringToDate(aux[8]), charToString(aux[9]));
        return descendente;
        
    }

    public Double divididoPorCem(Double valor) {
        Double valorTratado = valor / 100;
        return valorTratado;
    }

    public String capitalizandoNome(String nome) {
        String[] nomes = nome.split(" ");
        String aux = "";

        for (int i = 0; i < nomes.length; i++) {
            nomes[i] = nomes[i].substring(0, 1).toUpperCase() + nomes[i].substring(1).toLowerCase();
            aux = aux + " " + nomes[i];  
        }

        nome = aux.trim();

        return nome;
    }

    public String stringToDate (String nascimento) {
        String dia = nascimento.substring(0, 2);
        String mes = nascimento.substring(2, 4);
        String ano = nascimento.substring(4, 8);

        String nascimentoFormatado = dia +"/"+ mes +"/"+ ano;

        return nascimentoFormatado;
    }

    public String charToString(String sexo) {
        if (sexo.equals("M")) {
            return "Masculino";
        } else if (sexo.equals("F")) {
            return "Feminino";
        } else {
            return "";
        }
    }

}
