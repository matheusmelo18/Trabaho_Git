import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaAquisoes sistema = new SistemaAquisoes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            exibirUsuarioAtual(sistema);
            System.out.println("1. Mostrar Usuários");
            System.out.println("2. Escolher Usuário");
            System.out.println("3. Registrar pedido");
            System.out.println("4. Avaliar Pedido");
            System.out.println("5. Lista de pedidos Aprovados e Reprovados");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    mostrarUsuarios(sistema);
                    break;
                case 2:
                    mostrarUsuarios(sistema);
                    System.out.print("Digite o ID do usuário: ");
                    int id = scanner.nextInt();
                    sistema.escolherUsuario(id);
                    exibirUsuarioAtual(sistema);
                    break;
                case 3:
                    System.out.print("Digite a descrição do item: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite o valor unitário: ");
                    double valorUnitario = scanner.nextDouble();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    List<Item> itens = new ArrayList<>();
                    itens.add(new Item(descricao, valorUnitario, quantidade));
                    sistema.registrarPedido(itens);
                    break;
                case 4:
                    List<Pedido> pedidosAbertos = sistema.listarPedidosAbertos();
                    if (pedidosAbertos.isEmpty()) {
                        System.out.println("Não há pedidos abertos.");
                    } else {
                        System.out.println("Pedidos Abertos:");
                        for (int i = 0; i < pedidosAbertos.size(); i++) {
                            System.out.println(i + 1 + ": " + pedidosAbertos.get(i).detalhesPedido());
                        }
                        System.out.print("Escolha o número do pedido para avaliar: ");
                        int index = scanner.nextInt() - 1;
                        if (index >= 0 && index < pedidosAbertos.size()) {
                            System.out.print("Digite 'aprovar' ou 'reprovar': ");
                            String resultado = scanner.next();
                            sistema.avaliarPedido(pedidosAbertos.get(index), resultado);
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    break;
                case 5:
                    sistema.listarPedidosAprovadosEReprovados();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void mostrarUsuarios(SistemaAquisoes sistema) {
        System.out.println("Lista de Usuários:");
        for (Usuario usuario : sistema.usuarios) {
            System.out.println("ID: " + usuario.getId() +
                    ", Nome: " + usuario.getNome() +
                    ", Tipo: " + usuario.getTipo() +
                    ", Cargo: " + usuario.getCargo() +
                    ", Iniciais: " + usuario.getIniciais() +
                    ", Departamento: " + usuario.getDepartamento().getNome());
        }
    }

    private static void exibirUsuarioAtual(SistemaAquisoes sistema) {
        if (sistema.usuarioAtual != null) {
            System.out.println("Usuário Atual: " + sistema.usuarioAtual.getNome() +
                    " (ID: " + sistema.usuarioAtual.getId() +
                    ", Tipo: " + sistema.usuarioAtual.getTipo() +
                    ", Cargo: " + sistema.usuarioAtual.getCargo() +
                    ", Iniciais: " + sistema.usuarioAtual.getIniciais() +
                    ", Departamento: " + sistema.usuarioAtual.getDepartamento().getNome() + ")");
        } else {
            System.out.println("Nenhum usuário selecionado.");
        }
    }
}
