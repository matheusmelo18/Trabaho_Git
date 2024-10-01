public class Fornecedor {

	private String nome;
	private int id;
	private Item item; 
	

	public Fornecedor(String nome, int id, Item elem){ 
	this.nome = nome;
	this.id = id;
	this.item = elem;
	}

	public String getNome(){return nome;}
	public int getId(){return id;}
	public Item getItem(){return item;}

	public void setNome(String nome){this.nome = nome;
}	public void setId(int id){this.id = id;}
	public void setItem(Item elem){this.item = elem;}

	@Override
	public String toString(){return "##Fornecedor "+id+"##\n"+"Nome: "+nome+"\nNome do item: "+item.getNome()+"\nPreço do item: "+item.getPreco();}
}
