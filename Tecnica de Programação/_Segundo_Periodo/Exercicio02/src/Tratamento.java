// import java.text.DecimalFormat;
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

        //54 e 34

        for (int i = 0; i < linhas.length; i++) {
            String[] valores = partindoLinha(linhas[i]);
            this.valores.add(valores);
        }

        for (int i = 0; i < this.valores.size(); i++) {
            String[] aux = this.valores.get(i);

            if (aux.length > 3) {

                Funcionario funcionario = criarFuncionario(aux);
                Descendente[] descendentes = criarDescendente(aux);

                for (int j = 0; j < descendentes.length; j++) {
                    funcionario.setDescendente(descendentes[j]);
                }

                this.funcionarios.add(funcionario);

            }

        }

    }

    public String[] partindoLinha(String linha) {
        int aux = (linha.length() - 53) / 34;
        String[] linhas = new String[aux + 1];

        linhas[0] = linha.substring(0, 53);

        for (int i = 0; i < aux; i++) {
            int position = 53 + (34 * i);
            linhas[i+1] = linha.substring(position, position + 34);
        }

        String[] valores = new String[4 + (3 * aux)];

        valores[0] = linhas[0].substring(0, 4);
        valores[1] = linhas[0].substring(4, 34);
        valores[2] = linhas[0].substring(34, 42);
        valores[3] = linhas[0].substring(42, 53);

        for (int i = 0; i < aux; i++) {
            valores[4 + (3 * i)] = linhas[1 + i].substring(0, 25);
            valores[5 + (3 * i)] = linhas[1 + i].substring(25, 26);
            valores[6 + (3 * i)] = linhas[1 + i].substring(26, 34);
        }

        return valores;
    }

    public Funcionario criarFuncionario(String[] aux) {
        Funcionario funcionario = new Funcionario(aux[0], capitalizandoNome(aux[1]), stringToDate(aux[2]), normalizandoCpf(aux[3]));
        return funcionario;
    }
    
    public Descendente[] criarDescendente(String[] valores) {
        int qnt = (valores.length - 4) / 3;
        Descendente[] descendentes = new Descendente[qnt];

        for (int i = 0; i < qnt; i++) {
            int aux = 4 + (3 * i);
            Descendente descendente = new Descendente(capitalizandoNome(valores[aux]), codigoDependente(valores[aux + 1]), stringToDate(valores[aux + 2]));
            descendentes[i] = descendente;
        }

        return descendentes;
    }

    public String stringToDate (String nascimento) {
        String ano = nascimento.substring(0, 4);
        String mes = nascimento.substring(4, 6);
        String dia = nascimento.substring(6, 8);

        String nascimentoFormatado = dia +"/"+ mes +"/"+ ano;

        return nascimentoFormatado;
    }

    public String capitalizandoNome(String nome) {
        String[] nomes = nome.split(" ");
        String aux = "";

        for (int i = 0; i < nomes.length; i++) {
            nomes[i] = nomes[i].substring(0, 1).toUpperCase() + nomes[i].substring(1).toLowerCase();
            aux = aux + nomes[i] + " ";  
            aux.trim();
        }

        while (aux.length() < 33) {
            aux += " ";
        }

        nome = aux;

        return nome;
    }

    public String normalizandoCpf(String cpf) {
        String primeiraParte = cpf.substring(0, 3);
        String segundaParte = cpf.substring(3, 6);
        String terceiraParte = cpf.substring(6, 9);
        String quartaParte = cpf.substring(9, 11);

        String cpfNormalizado = primeiraParte +"."+ segundaParte +"."+ terceiraParte +"-"+ quartaParte;

        return cpfNormalizado;
    }

    public String codigoDependente(String codigo) {
        if(codigo.equals("1")) {
            return "pai       ";
        } else if (codigo.equals("2")) {
            return "mãe       ";
        } else if (codigo.equals("3")) {
            return "cônjuge   ";
        } else if (codigo.equals("4")) {
            return "filho     ";
        } else if (codigo.equals("5")) {
            return "outros    ";
        } else {
            return "Código inválido";
        }
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }



























    

    public String getFuncionariosFormatados() {
        ArrayList<Funcionario> listaDeFuncionarios = this.funcionarios;
        String retorno = "";
        String titulo = "";
        titulo += "\nRELAÇÃO DE FUNCIONÁRIOS E SEUS DEPENDENTES\n";
        titulo += "\nSeq.  Nome do Funcionário                          Data Nasc.    Cpf\n";
        titulo += "\n====================================================================================================\n";
        String aux = "";

        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
            if (i == 0 || i % 15 == 0) {
                aux += titulo;
            }
            aux += criarFuncionarioDescendente(listaDeFuncionarios.get(i));
        }

        retorno += aux;
        return retorno;        
    }

    public String criarFuncionarioDescendente(Funcionario funcionario) {
        String aux = "";

        aux = "\n" + funcionario.getMatricula()+" ";
        aux += funcionario.getNome()+" ";
        aux += funcionario.getNascimento()+" ";
        aux += funcionario.getCpf()+"\n";



        if (funcionario.getDescendente().size() > 0) {
            aux += "\n     Dependentes: Nome                             Tipo      Data Nasc.\n";
            for (int i = 0; i < funcionario.getDescendente().size(); i++) {
                aux += descendenteString(funcionario.getDescendente().get(i));
            }
        } else {
            aux += "\n     Dependentes: (NÃO POSSUI)\n";
        }
        aux += "\n....................................................................................................\n";

        return aux;
    }

    public String descendenteString(Descendente descendente) {
        String aux = "";

        aux += "\n                  "+descendente.getNome();
        aux += descendente.getTipo();
        aux += descendente.getNascimento()+"\n";

        return aux;
    }

}
