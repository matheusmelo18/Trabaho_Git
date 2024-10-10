import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nome;
    private int id;
    private boolean permissao;

    public Departamento(String nome, int id, boolean permissao) {
        this.nome = nome;
        this.id = id;
        this.permissao = permissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean verificaPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }
}
