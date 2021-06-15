package fila;

import java.util.Arrays;

public class Main {
	
	static int tamArray = 5;
	
	static Loja[] lojas = new Loja[tamArray];

	public static void main(String[] args) {
		String[] newProds = new String[] {"Prod1", "Prod2"};
		
		enfileirar("Loja1", 21219090, "RJ", newProds);
		enfileirar("Loja2", 21218080, "SP", newProds);
		enfileirar("Loja3", 21217070, "MG", newProds);
		enfileirar("Loja4", 21216060, "ES", newProds);
		enfileirar("Loja5", 21215050, "BA", newProds);
		
		exibirElementos();
		
		desenfileirar();
		desenfileirar();
		desenfileirar();
		
		exibirElementos();
	}
	
	static public void enfileirar(String nome, int tel, String loc, String[] produtos) {
		Loja newLoja = new Loja(nome, tel, loc, produtos);
		if(lojas[tamArray - 1] != null) {
			System.out.println("Fila cheia!");
		} else {
			int i = 0;
			while(i < tamArray) {
				if(lojas[i] == null) {
					lojas[i] = newLoja;
					System.out.println("Loja " + lojas[i].nomeDaLoja + " adicionada na posição " + i);
					break;
				}
				i++;
			}
		}
	}
	
	static public void desenfileirar() {
		if(lojas[0] != null) {
			System.out.println("Desenfileirando loja " + lojas[0].nomeDaLoja);
			for(int i = 0; i < tamArray; i++) {
				if(i == tamArray - 1) {
					lojas[i] = null;
				} else {					
					lojas[i] = lojas[i + 1];
				}
			}
		} else {
			System.out.println("Fila vazia!");
		}
		
	}
	
	static public void exibirElementos() {
		if(lojas[0] != null) {
			String fila = Arrays.toString(lojas);
			System.out.println(fila);
		} else {
			System.out.println("A fila está vazia!");
		}
	}

}
