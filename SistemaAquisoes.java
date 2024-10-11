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
}
