import java.util.List;

public class Cliente  extends  Pessoa{
    private List<Item> itens;


    public Cliente(String nome, int idade, int cpf){
        super(nome,idade,cpf);
    }

    public void adicionarPedido(Item item){
        this.itens.add(item);
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getPrecoTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public void exibirPedido(){
        for (Item item : itens) {
            System.out.println(item);
        }
    }

    public void procurarItem(String nome){
        for (Item item : itens) {
            if (item.getNome().equals(nome)) {
                System.out.println(item);
            }
        }
    }

    public void removerItem(String nome){
        for (Item item : itens) {
            if (item.getNome().equals(nome)) {
                itens.remove(item);
            }
        }
    }

    public void alterarQntd(String nome, int qtd){
        for (Item item : itens) {
            if (item.getNome().equals(nome)) {
                item.setQtd(qtd);
            }
        }
    }

    public void aplicarDesconto(double desconto){
        double percentual = desconto / 100;
        for (Item item : itens) {
            item.setPreco(item.getPreco() - (item.getPreco() * percentual));
        }
    }
}
