public class MainEx03 {
    public static void main(String[] args) throws Exception {

        Pessoa[] pessoa;

        String listaDeNomes = "";

        String input = "";
        int numeroPessoas = 0;
        String code = "";
        int erro = 1;

        while (erro == 1) {

            try {

                input = JOptionpaneUtil.pgtQtName();
                numeroPessoas = Integer.parseInt(input);
                
                if (numeroPessoas > 4 && numeroPessoas < 31) {

                    pessoa = new Pessoa[numeroPessoas];
                    
                    for (int i = 0; i < pessoa.length; i++) {

                        if (i < 10) {
                            code = "00" + Integer.toString(i) + " ";
                        } else if (i >= 10) {
                            code = "0" + Integer.toString(i) + " ";
                        } else if (i >= 100) {
                            code = Integer.toString(i) + " ";
                        }

                        pessoa[i] = new Pessoa(Generator.generateName(10), Generator.generateName(15));

                        listaDeNomes += code + pessoa[i].getNomeCompleto();

                    }

                    JOptionpaneUtil.showList(listaDeNomes);

                    erro = 0;

                } else {
                    
                    JOptionpaneUtil.qtdWrong();
                    erro = 1;

                }

            } catch (Exception e) {
                JOptionpaneUtil.error();
                erro = 0;
            }

        }

    }
    
}
