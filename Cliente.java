import java.util.List;

public class Cliente  extends  Pessoa{
    private List<Pedido> pedidos; // Adicionado lista para os pedidos dos clientes, ainda não implementado

    public Cliente(String nome, int idade, int cpf){
        super(nome,idade,cpf);
    }

    public void adicionarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

}
