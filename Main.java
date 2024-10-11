import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Teste de criação de usuários
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1, "João", Usuario.TipoUsuario.ADMINISTRADOR));
        usuarios.add(new Usuario(2, "Maria", Usuario.TipoUsuario.FUNCIONARIO));

        Estoque estoque = new Estoque();
        Funcionario funcionario = new Funcionario("João", 30, "Garçom"); // Criação do funcionário
        Fornecedor fornecedor = new Fornecedor("Fornecedor XYZ", "12.345.678/0001-90");

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
                    System.out
                            .println("Funcionário " + funcionario.getNome() + " está adicionando um item ao estoque.");
                    fornecedor.fornecerItem(estoque, new Item("Pizza", 40.0));
                    break;
                case 2:
                    System.out.println("Funcionário " + funcionario.getNome() + " está removendo um item do estoque.");
                    estoque.removerItem(new Item("Pizza", 40.0));
                    break;
                case 3:
                    estoque.listarEstoque();
                    break;
                case 4:
                    opcao = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao);

        scanner.close();
    }
}
