package pilha;

import listaEncadeada.Loja;

public class Main {
	
	static int tamArray = 5;
	
	static Loja[] lojas = new Loja[tamArray];

	public static void main(String[] args) {
		String[] newProds = new String[] {"Prod1", "Prod2"};
		
		consultaTopo();
		
		empilhar("Loja1", 21219090, "RJ", newProds);
		empilhar("Loja2", 21218080, "SP", newProds);
		empilhar("Loja3", 21217070, "MG", newProds);
		empilhar("Loja4", 21216060, "ES", newProds);
		empilhar("Loja5", 21215050, "BA", newProds);
		
		consultaTopo();
		
		desempilhar();
		desempilhar();
		desempilhar();
		
		consultaTopo();
	}
	
	public static void empilhar(String nome, int tel, String loc, String[] produtos) {
		if(lojas[0] == null) {
			lojas[0] = new Loja(nome, tel, loc, produtos);
		} else {
			for(int i = tamArray - 1; i > 0; i--) {
				
				int numToCheck;
				if(i - 1 == -1) {
					numToCheck = 0;
				} else {
					numToCheck = i - 1;
				}
				
				if(lojas[numToCheck] != null) {
					lojas[i] = new Loja(
								lojas[numToCheck].nomeDaLoja, 
								lojas[numToCheck].telefone, 
								lojas[numToCheck].localizacao, 
								lojas[numToCheck].produtos
							);
				}
			}
			
			lojas[0] = new Loja(nome, tel, loc, produtos);
		}
		System.out.println("Item empilhado: " + lojas[0]);
	}
	
	public static void desempilhar() {
		if(lojas[0] == null) {
			System.out.println("Pilha vazia!");
		} else {
			for(int i = 0; i < tamArray - 1; i++) {
				if(lojas[tamArray - 1] != null || lojas[i + 1] != null) {
					lojas[i] = new Loja(
								lojas[i + 1].nomeDaLoja, 
								lojas[i + 1].telefone, 
								lojas[i + 1].localizacao, 
								lojas[i + 1].produtos
							);
				}
			}
			System.out.println("Topo da pilha removido! Novo item no topo: " + lojas[0]);
		}
		
	}
	
	public static void consultaTopo() {
		if(lojas[0] == null) {
			System.out.println("A pilha está vazia!");
		} else {
			System.out.println("Valor no topo da pilha: " + lojas[0]);
		}
	}

}
