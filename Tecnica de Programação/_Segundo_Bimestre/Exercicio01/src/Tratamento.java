import java.text.DecimalFormat;
import java.util.ArrayList;

public class Tratamento {
    private String valor;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>(); // lista de funcionarios (para cada funcionario também tem seus descendentes);
    private ArrayList<String[]> valores = new ArrayList<>(); //4, 7, 10 | lista de lista de valores (valores que se referem ao funcionario junto aos seus descendentes);
    
    // Construtor que guarda o texto na classe tratamento;
    public Tratamento() {}
    public Tratamento(String valor) {
        this.valor = valor;
    }

    // Função principal que transforma o texto em valores e posteriormente em funcionarios e descendentes;
    public void tratar() {
        String valor = this.valor; // Recebe o texto a ser tratado;
        String[] linhas = valor.split("\\r?\\n"); // Separa o texto em linhas através dos espaços do texto;

        // Separa as linhas em valores através dos ífens;
        for (int i = 0; i < linhas.length; i++) {
            String[] valores = linhas[i].split("-");
            this.valores.add(valores);
        }

        // Aloca os valores em funcionários e descendentes;
        for (int i = 0; i < this.valores.size(); i++) {
            String[] aux = this.valores.get(i); // Pega a linha (String[] valores.get(i)) referente ao "i" do "for" para trabalha-la;

            if (aux.length > 3) { // Verifica se existe mais de 3 valores dentro do vetor aux = (existe um funcionário);

                Funcionario funcionario = criarFuncionario(i, aux); // Cria um Funcionario;

                if (aux.length > 6) { // Verifica se existe mais de 6 valores dentro do vetor aux = (existe um descendente);
                    funcionario.setDescendente(criarDescendente1(aux)); // Cria e adiciona um Descendente ao Funcionário;
                }
                if (aux.length > 9) { // Verifica se existe mais de 9 valores dentro do vetor aux = (existe mais um descendente);
                    funcionario.setDescendente(criarDescendente2(aux)); // Cria e adiciona mais um Descendente ao Funcionário;
                }

                this.funcionarios.add(funcionario); // Guarda o funcionario criado no ArrayList funcionário;

            }

        }

    }

    // Retorna a String que mostra a informação de todos os funcionarios;
    public String getFuncionarioFormatados() {
        ArrayList<Funcionario> listaDeFuncionarios = this.funcionarios; // Pega a lista de funcionarios;
        String retorno = "Lista de funcionários\n=====================================\n";
        String aux = "";

        // Cria um loop para trabalhar todos os funcionários;
        for (int i = 0; i < listaDeFuncionarios.size(); i++) { 
            aux += criarFuncionarioDescendente(listaDeFuncionarios.get(i));
        }

        retorno += aux;
        return retorno;        
    }

    // Pega os valores de cada funcionario e decendente, e retorna uma string do formato exigido;
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

    // Pega os valore dos Descendentes e retorna a string do formato exigido;
    public String descendenteString(Descendente descendente) {
        String aux = "";

        aux += "      "+descendente.getNome();
        aux += " - "+descendente.getNascimento()+" - ";
        aux += descendente.getSexo()+"\n";

        return aux;
    }

    // Pega um valor double formata para ter duas casas depois do ponto e retorna como String;
    public String doubleToString(Double valor) {
        DecimalFormat formato = new DecimalFormat("0.00");
        String aux = "";
        aux = formato.format(valor);
        // .replaceAll(".", ",")
        return aux;
    }

    // Cria um funcionário;
    public Funcionario criarFuncionario(int i, String[] aux) {
        int matricula = Integer.parseInt(aux[0]);
        Double salario = Double.parseDouble(aux[2]);
        Double gratificacao = Double.parseDouble(aux[3]);
                    
        Funcionario funcionario = new Funcionario(normalizarCodigo(i), matricula, capitalizandoNome(aux[1]), doubleToString(divididoPorCem(salario)), doubleToString(divididoPorCem(gratificacao)));
        return funcionario;
    }

    // Faz com que o código sempre tenha 3 casas inteiras;
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

    // Auxilia a criar o primeiro descendente;
    public Descendente criarDescendente1(String[] aux) {
                    
        Descendente descendente = new Descendente(capitalizandoNome(aux[4]), stringToDate(aux[5]), charToString(aux[6]));
        return descendente;
        
    }

    // Auxilia a criar o segundo descendente;
    public Descendente criarDescendente2(String[] aux) {
                    
        Descendente descendente = new Descendente(capitalizandoNome(aux[7]), stringToDate(aux[8]), charToString(aux[9]));
        return descendente;
        
    }

    // Divide números por cem para colocar duas casas após o ponto;
    public Double divididoPorCem(Double valor) {
        Double valorTratado = valor / 100;
        return valorTratado;
    }

    // Capitaliza Strings
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

    // Formata a data para o formato exigido;
    public String stringToDate (String nascimento) {
        String dia = nascimento.substring(0, 2);
        String mes = nascimento.substring(2, 4);
        String ano = nascimento.substring(4, 8);

        String nascimentoFormatado = dia +"/"+ mes +"/"+ ano;

        return nascimentoFormatado;
    }

    // Transforma os valores "M" e "F" em "Masculino" e "Feminino" respectivamente;
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
