import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Usuario funcionario;
    private Departamento departamento;
    private Date dataPedido;
    private Date dataConclusao;
    private String status;
    private List<Item> itens;

    public Pedido(Usuario funcionario, Departamento departamento, List<Item> itens) {
        this.funcionario = funcionario;
        this.departamento = departamento;
        this.itens = itens;
        this.dataPedido = new Date();
        this.status = "aberto";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String detalhesPedido() {
        StringBuilder detalhes = new StringBuilder();
        detalhes.append("Funcionário: ").append(funcionario.getNome())
                .append(" (ID: ").append(funcionario.getId())
                .append(", Cargo: ").append(funcionario.getCargo())
                .append(", Iniciais: ").append(funcionario.getIniciais()).append(")\n")
                .append("Departamento: ").append(funcionario.getDepartamento().getNome()).append("\n")
                .append("Data do Pedido: ").append(dataPedido).append("\n")
                .append("Status: ").append(status).append("\n")
                .append("Itens:\n");

        for (Item item : itens) {
            detalhes.append("- ").append(item.getDescricao())
                    .append(", Valor Unitário: ").append(item.getValorUnitario())
                    .append(", Quantidade: ").append(item.getQuantidade())
                    .append(", Total: ").append(item.getValorTotal()).append("\n");
        }

        return detalhes.toString();
    }
}
