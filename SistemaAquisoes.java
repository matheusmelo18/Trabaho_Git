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
}
