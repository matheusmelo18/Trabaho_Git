import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private List<Item> pedidos;

    public Cliente(String nome, int idade) {
        super(nome, idade);
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Item item) {
        pedidos.add(item);
        System.out.println("Item " + item.getNome() + " adicionado ao pedido.");
    }

    public void listarPedidos() {
        System.out.println("Pedidos do cliente " + nome + ":");
        for (Item item : pedidos) {
            System.out.println(item);
        }
    }
}
