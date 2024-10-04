import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Item> itens;

    public Estoque() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        System.out.println("Item adicionado ao estoque: " + item.getNome());
    }

    public void removerItem(Item item) {
        if (itens.remove(item)) {
            System.out.println("Item removido do estoque: " + item.getNome());
        } else {
            System.out.println("Erro: Item não encontrado no estoque.");
        }
    }

    public void listarEstoque() {
        System.out.println("Itens no estoque:");
        for (Item item : itens) {
            System.out.println(item);
        }
    }
}
