import java.util.Random;

import javax.swing.JOptionPane;

public class MainEx02 {

	Random r = new Random();

	public static void main(String[] args) {
		MainEx04 pri = new MainEx04();

		int conta=0;
		while (conta==0)
		{
			String s=JOptionPane.showInputDialog(null,"digite a quantidade de nomes","Entrada",0);
			try{
				conta=Integer.parseInt(s);
				if (conta<5 || conta>30)
				{
					JOptionPane.showMessageDialog(null,"valor n�o deve ser menor que 5 e nem maior que 30","Erro",1);
					conta=0;
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Valor informado � inv�lido","Erro",1);
				conta=0;

			}
		}
		Pessoa[] vetor = new Pessoa[conta];
		for(int i=0;i<conta;i++){
			Pessoa p= new Pessoa();
			p.setNome(pri.geraString(10));
			p.setSobreNome(pri.geraString(15));
			vetor[i]=p;
		}

		String resultado="SEQ     NOME        SOBRENOME\n";
		int seq=1;
		for(int i=0; i<conta; i++){
			if (seq<10)
				resultado=resultado+"00"+seq+"  ";
			else
				resultado=resultado+"0"+seq+"  ";
			resultado=resultado+vetor[i].getNome()+"   ";
			resultado=resultado+vetor[i].getSobreNome()+"\n";
			seq++;
		}
        JOptionPane.showMessageDialog(null,resultado,"final",3);

	}

	public String geraString(int quant){
		String s="";
		for(int i=0; i<quant; i++){
			int x= r.nextInt(26)+65;
			char c= (char)x;
			s=s+s.valueOf(c);
		}
		return s;
	}

}
