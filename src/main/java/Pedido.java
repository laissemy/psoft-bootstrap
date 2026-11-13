public class Pedido {
    private int cod;
    private Cliente cliente;
    private String origem;
    private String destino;
    private double distancia;
    private double peso;
    private Entrega entrega;

    public Pedido(int cod, Cliente cliente, String origem, String destino,
                  double peso, double distancia, Entrega entrega) {
        this.cod = cod;
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.distancia = distancia;
        this.entrega = entrega;
    }

    public int getCod() {
        return this.cod;
    }

    public String getOrigem() {
        return this.origem;
    }

    public String getDestino() {
        return this.destino;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public double getPeso() {
        return this.peso;
    }

    public Entrega getEntrega() {
        return this.entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public int getPrazo() {
        return this.entrega.calcularPrazo(this.distancia);
    }

    public double getValor() {
        return this.entrega.calcularCusto(this.distancia);
    }

    @Override
    public String toString() {
        return "Pedido #" + cod + " | " + cliente + " | " + origem + " -> " + destino
             + " | " + entrega.getNome()
             + " | R$ " + String.format("%.2f", getValor())
             + " | " + getPrazo() + " dias";
    }
}