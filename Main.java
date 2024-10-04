import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crie uma lista de itens
        List<Item> ingredientes = new ArrayList<>();
        ingredientes.add(new Item("Frango", 10));
        ingredientes.add(new Item("Carne", 15));

        // Crie um estoque e adicione os itens à lista
        Estoque estoque = new Estoque(ingredientes);
        estoque.imprimirEstoque();

        // Remova um item do estoque por nome
        estoque.removerPorNome("Carne");
        estoque.imprimirEstoque();
    }

}