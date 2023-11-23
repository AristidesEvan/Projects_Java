package br.edu.pucgoias.sistemaestoque.modelo;

public class Estoque {
	
	private int id;
	private String descricao;
	private double quantidade;
	private double precounit;
	
	private String mensagem;
	private int controle;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public double getPrecounit() {
		return precounit;
	}
	public void setPrecounit(double precounit) {
		this.precounit = precounit;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public int getControle() {
		return controle;
	}
	public void setControle(int controle) {
		this.controle = controle;
	}
	@Override
	public String toString() {
		return "Estoque [id=" + id + ", descricao=" + descricao + ", quantidade=" + quantidade + ", precounit="
				+ precounit + ", mensagem=" + mensagem + ", controle=" + controle + "]";
	}
	
}

