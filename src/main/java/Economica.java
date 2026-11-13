public class Economica implements Entrega {
    private static final double VALOR_KM = 0.8;
    private String nome = "Economica";

    public Economica() {}

    @Override
    public double calcularCusto(double distancia) {
        return VALOR_KM * distancia;
    }

    @Override
    public int calcularPrazo(double distancia) {
        return (int) Math.ceil(distancia / 100) + 7;
    }

    @Override
    public String getNome() { return nome; }
}
