public class Fornecedor {
	private String nome;
	private String cnpj;

	public Fornecedor(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void fornecerItem(Estoque estoque, Item item) {
		estoque.adicionarItem(item);
		System.out.println("Fornecedor " + nome + " forneceu o item: " + item.getNome());
	}
}
