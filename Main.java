import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Cliente cliente = new Cliente("Matheus", 25);
        Funcionario funcionario = new Funcionario("João", 30, "Garçom");
        Fornecedor fornecedor = new Fornecedor("Fornecedor XYZ", "12.345.678/0001-90");

        // Simulação de interações
        Scanner scanner = new Scanner(System.in);
        boolean opcao = false;

        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Adicionar item ao estoque");
            System.out.println("2. Remover item do estoque");
            System.out.println("3. Listar estoque");
            System.out.println("4. Fazer pedido do cliente");
            System.out.println("5. Listar pedidos do cliente");
            System.out.println("6. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    fornecedor.fornecerItem(estoque, new Item("Pizza", 40.0));
                    break;
                case 2:
                    estoque.removerItem(new Item("Pizza", 40.0));  // Remover com base no item
                    break;
                case 3:
                    estoque.listarEstoque();
                    break;
                case 4:
                    cliente.adicionarPedido(new Item("Refrigerante", 5.0));
                    break;
                case 5:
                    cliente.listarPedidos();
                    break;
                case 6:
                    opcao = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao);

        scanner.close();
    }
}
