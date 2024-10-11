import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaAquisoes {
    public List<Usuario> usuarios;
    public List<Pedido> pedidos;
    public Usuario usuarioAtual;

    public SistemaAquisoes() {
        this.usuarios = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        inicializarDados();
    }

    private void inicializarDados() {
        Departamento financeiro = new Departamento("Financeiro", 1000);
        Departamento rh = new Departamento("RH", 500);
        Departamento admin = new Departamento("Administracao", 2000);
        Departamento cozinha = new Departamento("Cozinha", 1500);
        Departamento atendimento = new Departamento("Atendimento", 800);

        usuarios.add(new Usuario(1, "Amanda Cardoso", "funcionario", "Analista", "AC", financeiro));
        usuarios.add(new Usuario(2, "Bruno Oliveira", "administrador", "Gerente", "BO", rh));
        usuarios.add(new Usuario(3, "Carlos Almeida", "funcionario", "Dono", "CA", admin));
        usuarios.add(new Usuario(4, "Diana Souza", "administrador", "Chefe principal", "DS", cozinha));
        usuarios.add(new Usuario(5, "Eduardo Marques", "funcionario", "Garçom", "EM", atendimento));
        usuarios.add(new Usuario(6, "Fernando Marques", "funcionario", "Garçom", "FM", atendimento));
        usuarios.add(new Usuario(7, "Diego Gomes", "funcionario", "Chapeiro", "DG", cozinha));
        usuarios.add(new Usuario(8, "Arthur Almeida", "funcionario", "Contador", "AA", financeiro));
        usuarios.add(new Usuario(9, "Leonardo Lima", "administrador", "Dono", "LL", admin));
        usuarios.add(new Usuario(10, "João Gomes", "funcionario", "Garçom", "JG", atendimento));
        usuarios.add(new Usuario(11, "Carolina Gomes", "funcionario", "Atendente de caixa", "CG", atendimento));
        usuarios.add(new Usuario(12, "Josiane Amaral", "administrador", "Gerente de caixa", "JA", atendimento));
        usuarios.add(new Usuario(13, "Rafael Machado", "funcionario", "Chapeiro", "RM", cozinha));
        usuarios.add(new Usuario(14, "Fernando Neves", "funcionario", "RH", "FN", rh));
        usuarios.add(new Usuario(15, "Danilo Pereira", "administrador", "Garçom", "DP", atendimento));

    }

    public void escolherUsuario(int id) {
        usuarioAtual = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuarioAtual = usuario;
                break;
            }
        }
    }

    public void registrarPedido(List<Item> itens) {
        if (usuarioAtual == null) {
            System.out.println("Nenhum usuário selecionado.");
            return;
        }

        double totalPedido = itens.stream().mapToDouble(Item::getValorTotal).sum();
        if (totalPedido > usuarioAtual.getDepartamento().getLimite()) {
            System.out.println("O valor total do pedido excede o limite do departamento.");
            return;
        }

        Pedido pedido = new Pedido(usuarioAtual, usuarioAtual.getDepartamento(), itens);
        pedidos.add(pedido);
        System.out.println("Pedido registrado com sucesso.");
    }

    public List<Pedido> listarPedidosAbertos() {
        List<Pedido> pedidosAbertos = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if ("aberto".equalsIgnoreCase(pedido.getStatus())) {
                pedidosAbertos.add(pedido);
            }
        }
        return pedidosAbertos;
    }

    public void avaliarPedido(Pedido pedido, String resultado) {
        if (!usuarioAtual.isAdministrador()) {
            System.out.println("Apenas administradores podem avaliar pedidos.");
            return;
        }

        if ("aprovar".equalsIgnoreCase(resultado)) {
            pedido.setStatus("aprovado");
        } else if ("reprovar".equalsIgnoreCase(resultado)) {
            pedido.setStatus("reprovado");
        } else {
            System.out.println("Resultado inválido.");
            return;
        }

        System.out.println("Pedido avaliado com sucesso: " + resultado);
    }

    public void listarPedidosAprovadosEReprovados() {
        System.out.println("Pedidos Aprovados:");
        for (Pedido pedido : pedidos) {
            if ("aprovado".equalsIgnoreCase(pedido.getStatus())) {
                System.out.println(pedido.detalhesPedido());
            }
        }
        System.out.println("Pedidos Reprovados:");
        for (Pedido pedido : pedidos) {
            if ("reprovado".equalsIgnoreCase(pedido.getStatus())) {
                System.out.println(pedido.detalhesPedido());
            }
        }
    }
}
