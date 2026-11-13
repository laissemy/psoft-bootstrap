import java.util.ArrayList;

public class LogCentral {
    private static LogCentral instancia;
    private ArrayList<Pedido> pedidosAtivos = new ArrayList<>();
    private ArrayList<Pedido> pedidosRealizados = new ArrayList<>();
    private ArrayList<Entrega> entregasTipos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private int proximoCod = 1;

    private LogCentral() {}

    public static LogCentral getInstancia() {
        if (instancia == null) {
            instancia = new LogCentral();
        }
        return instancia;
    }

    public void criarCliente(String nome, String cpf, String numero) {
        if (achar​Cliente(cpf) != null) {
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }
        clientes.add(new Cliente(nome, cpf, numero));
    }

    public void adicionarEntrega(Entrega entrega) {
        entregasTipos.add(entrega);
    }

    public void criarPedido(String cpf, String origem, String destino,
                            double peso, double distancia, String nomeEntrega) {
        Cliente cliente = acharCliente(cpf);
        if (cliente == null) throw new IllegalArgumentException("Cliente não encontrado.");
        Entrega entrega = acharEntrega(nomeEntrega);
        pedidosAtivos.add(new Pedido(proximoCod++, cliente, origem, destino, peso, distancia, entrega));
    }

    public void mudarModalidade(String nomeEntrega, int codPedido) {
        Pedido p = acharPedido(codPedido); // só busca nos ativos (ainda não despachados)
        if (p == null) throw new IllegalArgumentException("Pedido não encontrado ou já despachado.");
        p.setEntrega(acharEntrega(nomeEntrega));
    }

    public void finalizarPedido(int codPedido) {
        Pedido p = acharPedido(codPedido);
        if (p == null) throw new IllegalArgumentException("Pedido não encontrado.");
        pedidosAtivos.remove(p);
        pedidosRealizados.add(p);
    }

    public String listarPedidosAtivos() {
        StringBuilder sb = new StringBuilder();
        for (Pedido p : pedidosAtivos) sb.append(p).append("\n");
        return sb.toString();
    }

    private Pedido acharPedido(int cod) {
        for (Pedido p : pedidosAtivos) if (p.getCod() == cod) return p;
        return null;
    }

    private Cliente acharCliente(String cpf) {
        for (Cliente c : clientes) if (c.getCpf().equals(cpf)) return c;
        return null;
    }

    private Entrega acharEntrega(String nome) {
        for (Entrega e : entregasTipos) if (e.getNome().equalsIgnoreCase(nome)) return e;
        throw new IllegalArgumentException("Modalidade inexistente: " + nome);
    }
}
