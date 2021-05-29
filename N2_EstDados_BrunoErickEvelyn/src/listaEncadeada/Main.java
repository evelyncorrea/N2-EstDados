package listaEncadeada;

public class Main {
	static int tamArray = 10;
	
	static Loja[] lojas = new Loja[tamArray];

	public static void main(String[] args) {
		
		String[] newProds = new String[] {"Prod1", "Prod2"};
		
		insereNoInicio("Loja1", 21219090, "RJ", newProds);
		insereNoFim("Loja2", 22009090, "SP", newProds);
		apresentaDoFim();
		apresentaDoInicio();
		removePrimeiroNo();
		removeUltimoNo();
		insereNoInicio("Loja1", 21219090, "RJ", newProds);
		insereNoFim("Loja2", 22009090, "SP", newProds);
		consultaPorLocalizacao("RJ");
	}
	
	public static void insereNoInicio(String nome, int tel, String loc, String[] produtos) {
		
		if(lojas[0] == null) {
			lojas[0] = new Loja(nome, tel, loc, produtos);
		} else {
			for(int i = tamArray - 1; i > 0; i--) {
				lojas[i] = new Loja(
							lojas[i - 1].nomeDaLoja, 
							lojas[i - 1].telefone, 
							lojas[i - 1].localizacao, 
							lojas[i - 1].produtos
						);
			}
			
			lojas[0] = new Loja(nome, tel, loc, produtos);
		}
		
		System.out.println("Insere no inicio: " + lojas[0].toString());
	}
	
	public static void insereNoFim(String nome, int tel, String loc, String[] produtos) {
		if(lojas[tamArray - 1] == null) {
			lojas[tamArray - 1] = new Loja(nome, tel, loc, produtos);
		} else {
			System.out.println("Lista cheia!");
		}
		
		System.out.println("Insere no fim: " + lojas[tamArray - 1].toString());
	}
	
	public static void apresentaDoFim() {
		System.out.println("Apresenta lista do fim: ");
		
		int i = tamArray - 1;
		while (i >= 0) {
			if(lojas[i] != null) {
				System.out.println(lojas[i].toString());
			}
			i--;
		}
	}
	
	public static void apresentaDoInicio() {
		System.out.println("Apresenta lista do início: ");
		
		int i = 0;
		while(i < tamArray) {
			if(lojas[i] != null) {
				System.out.println(lojas[i].toString());
			}
			i++;
		}
	}
	
	public static void removePrimeiroNo() {
		if(lojas[0] != null) {
			lojas[0] = null;
			System.out.println("Primeiro nó removido!");
		} else {
			System.out.println("Primeiro nó já está vazio!");
		}
	}
	
	public static void removeUltimoNo() {
		if(lojas[tamArray - 1] != null) {
			lojas[tamArray - 1] = null;
			System.out.println("Último nó removido!");
		} else {
			System.out.println("Último nó já está vazio!");
		}
	}
	
	public static void consultaPorLocalizacao(String loc) {
		for (int i = 0; i < tamArray; i++) {
			if(lojas[i] != null) {
				if(lojas[i].localizacao == loc) {
					System.out.println(lojas[i].toString());
					break;
				} else if(i == tamArray - 1) {
					System.out.println("Nenhuma loja encontrada!");
				}				
			}
		}
	}

}
