import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Item> ingredientes;

    public Estoque() {
        this.ingredientes = new ArrayList<>();
    }

    // Construtor para inicializar a lista de ingredientes
    public Estoque(List<Item> ingredientes) {
        this.ingredientes = ingredientes;
    }

    // Adicionar um item ao estoque
    public void adicionar(Item item) {
        if (item != null) {
            ingredientes.add(item);
            System.out.println("Item adicionado com sucesso: " + item.getNome());
        } else {
            System.out.println("Erro: Item é nulo.");
        }
    }

    // Remover um item do estoque
    public void remover(Item item) {
        if (item != null && ingredientes.remove(item)) {
            System.out.println("Item removido com sucesso: " + item.getNome());
        } else if (!ingredientes.contains(item)) {
            System.out.println("Erro: Item não encontrado no estoque.");
        } else {
            System.out.println("Erro: Item é nulo ou não existe na lista.");
        }
    }

    // Remover um item do estoque por nome
    public void removerPorNome(String nome) {
        for (Item item : ingredientes) {
            if (item.getNome().equals(nome)) {
                remover(item);
                return;
            }
        }
        System.out.println("Erro: Item com esse nome não encontrado no estoque.");
    }

    // Imprimir os itens do estoque
    public void imprimirEstoque() {
        System.out.println("\nItens do Estoque:");
        for (Item item : ingredientes) {
            System.out.println(item);
        }
    }

    // Getter e Setter para acessar a lista de ingredientes
    public List<Item> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Item> ingredientes) {
        this.ingredientes = ingredientes;
    }

}