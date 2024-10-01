import java.util.List;

public class Cliente  extends  Pessoa{
    private List<Pedido> pedidos;


    public Cliente(String nome, int idade, int cpf){
        super(nome,idade,cpf);

    }

    public void adicionarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

}
