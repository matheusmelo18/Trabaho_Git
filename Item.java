public class Item{
	private String nome;
	private double preco;
	private int qtd;
	private int id;
	private String carne;

	public Item(String nome, int qtd, int id, double preco, String carne) {
		this.nome = nome;
		this.id = id;
		this.qtd = qtd;
		this.preco = preco;
		this.carne = carne;
	}

	public Item(String carne, int qtd) {
	}

	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public int getQtd() {
		return qtd;
	}

	public double getPreco() {
		return preco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "##Item "+id+"##\n"+"Nome: "+nome+"\nQuantidade: "+qtd+"\nPreço: "+preco;
	}
}
