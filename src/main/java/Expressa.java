public class Expressa implements Entrega {
    private static final double VALOR_KM = 1.5; 
    private double adicional;
    private String nome = "Expressa";

    public Expressa(double adicional) {
        this.adicional = adicional;
    }

    @Override
    public double calcularCusto(double distancia) {
        return adicional + VALOR_KM * distancia;
    }

    @Override
    public int calcularPrazo(double distancia) {
        return (int) Math.ceil(distancia / 500) + 1;
    }

    @Override
    public String getNome() { return nome; }
}