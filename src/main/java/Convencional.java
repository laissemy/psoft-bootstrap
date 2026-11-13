public class Convencional implements Entrega {
    private double tarifaFixa;
    private double valorKm;
    private String nome = "Convencional";

    public Convencional(double tarifaFixa, double valorKm) {
        this.tarifaFixa = tarifaFixa;
        this.valorKm = valorKm;
    }

    @Override
    public double calcularCusto(double distancia) {
        return tarifaFixa + valorKm * distancia;
    }

    @Override
    public int calcularPrazo(double distancia) {
        return (int) Math.ceil(distancia / 200) + 3;
    }

    @Override
    public String getNome() { return nome; }
}