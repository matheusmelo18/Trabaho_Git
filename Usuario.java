public class Usuario {
    private int id;
    private String nome;
    private String tipo; // "funcionario" ou "administrador"
    private String cargo;
    private String iniciais;
    private Departamento departamento;

    public Usuario(int id, String nome, String tipo, String cargo, String iniciais, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.cargo = cargo;
        this.iniciais = iniciais;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCargo() {
        return cargo;
    }

    public String getIniciais() {
        return iniciais;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public boolean isAdministrador() {
        return "administrador".equalsIgnoreCase(tipo);
    }
}
