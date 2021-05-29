package listaEncadeada;

import java.util.Arrays;

public class Loja {
	public String nomeDaLoja;
	public int telefone;
	public String localizacao;
	public String[] produtos;
	
	public Loja () {
		super();
	}
	
	public Loja (String nome, int tel, String loc, String[] produtos) {
		this.nomeDaLoja = nome;
		this.telefone = tel;
		this.localizacao = loc;
		this.produtos = produtos;
	}
	
	@Override
	public String toString() {
		return this.nomeDaLoja + " " 
				+ this.telefone + " " 
				+ this.localizacao + " " 
				+ Arrays.toString(this.produtos);
	}
}
