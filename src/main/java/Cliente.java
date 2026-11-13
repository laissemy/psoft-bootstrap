public class Cliente {
    private String nome;
    private String cpf;
    private String numeroTelefone;

    public Cliente(String nome, String cpf, String numeroTelefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.numeroTelefone = numeroTelefone;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNumeroTelefone() {
        return this.numeroTelefone;
    }

    public void setNumeroTelefone(String novoNumero) {
        this.numeroTelefone = novoNumero;
    }

    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ", Tel: " + numeroTelefone + ")";
    }
}