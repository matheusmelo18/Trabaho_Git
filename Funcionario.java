
public class Funcionario extends Pessoa{
    private double salario;
    private String cargo;
    private Boolean trabalhando;
    
    // Funcionário implementa o construtor de Pessoa + salario e cargo (atributos exclusivos de Funcionario)  
    public Funcionario(String nome, int idade, int cpf, double salario, String cargo){
        super(nome,idade,cpf);
        this.salario = salario;
        this.cargo = cargo;
        this.trabalhando = false;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void exibirDados(){
        super.exibirDados();
        System.out.println("Salario: " + this.salario);
        System.out.println("Cargo: " + this.cargo);
    }

    public void alterarSalario(double novoSalario){
        this.salario = novoSalario;
    }

    public void alterarCargo(String novoCargo){
        this.cargo = novoCargo;
    }

    //Implementado métodos para trabalho, caso não tenha ninguem trabalhando o pedido é ignorado? (ainda pensando)
    public void iniciarTrabalho(){
        this.trabalhando = true;
        System.out.println("O funcionário " + this.getNome() + " está trabalhando");
    }

    public void finalizarTrabalho(){
        this.trabalhando = false;
        System.out.println("O funcionário " + this.getNome() + " está descansando");
    }

    public void status(){
        if (this.trabalhando) {
            System.out.println("O funcionário " + this.getNome() + " está trabalhando");
        }
        else {
            System.out.println("O funcionário " + this.getNome() + " está descansando");
        }
    }

}
