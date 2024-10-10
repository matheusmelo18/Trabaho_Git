public class Usuario {
    private int id;
    private String nome;
    private TipoUsuario tipo;

    public Usuario(int id, String nome, TipoUsuario tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Tipo: " + tipo;
    }

    enum TipoUsuario {
        ADMINISTRADOR, FUNCIONARIO
    }
}
