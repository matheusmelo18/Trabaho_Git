import java.util.ArrayList;
import java.util.Scanner;
public class Estoque {
	
//Lista de itens/igredientes junto com a quantidade de pratos, copos e talheres no estoque
//char nos talheres para representar a "quantidade" de talheres assim como o tipo baseado na 1 letra do nome 'g'-garfo, 'f'-faca, 'c'-colher, etc.
	private ArrayList<Item> itens;
	private int pratos;
	private int copos;
	private char[] talheres;

	public Estoque(ArrayList<Item> itens, int pratos, int copos, int qntTalheres){
	this.itens = itens;
	this.pratos = pratos;
	this.copos = copos;
	this.talheres = new char[qntTalheres];
	}

	public int getPratos(){return pratos;}
	public int getCopos(){return copos;}
	public String getItens(){return itens.toString();}
	public char[] getTalheres(){return talheres;}

	public void setPratos(int pratos){this.pratos = pratos;}
	public void setCopos(int copos){this.copos = copos;}
	public void setItens(ArrayList<Item> itens){this.itens = itens;}
	public void setTalher(char[] talheres){this.talheres = talheres;}

	public void adicionaTalheres(int qtdTiposTalher){
	String talher = "0"; 
	int qtdTalher = 0; 
	Scanner in = new Scanner(System.in);
	for(int i = 0; i<qtdTiposTalher; i++) 	{
	System.out.println("Qual talher deseja nomear ?");
	talher = in.nextLine();
	System.out.println("Quantas unidades deste talher existe ?");
	qtdTalher = in.nextInt();
	in.nextLine();
		for(int j = 0; j<=qtdTalher; j++){
			int cont = 0;
			getTalheres()[cont] = talher.charAt(0);
			cont++;
	}
						}
	in.close();
	}

	public int contaTalher(char tipo){
		int cont = 0;
		for(int i = 0; i<getTalheres().length; i++){
			if(tipo==getTalheres()[i]) cont++;
		}
		return cont;
	}

	@Override
	public String toString(){return "##ESTOQUE##\n Itens: "+ itens +"\n Qtd de Pratos: "+pratos+"\n Qtd de Copos: "+copos+"\n Qtd de Garfos: "+ contaTalher('g')+"\n Qtd de Facas: "+ contaTalher('f');}
}
