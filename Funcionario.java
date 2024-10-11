public class Funcionario {
    private String id;
    private String nome;
    private Departamento departamento;
    private Usuario usuario; // Adiciona referência ao usuário

    public Funcionario(String id, String nome, Departamento departamento, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.usuario = usuario; // Atribui o usuário
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Usuario getUsuario() {
        return usuario; // Método para obter o usuário associado
    }
}
