package entities;
import java.util.List;

public class Pedido {
    private int id;
    private String endereco;
    private String deadline;
    private List<Integer> itens; // Lista de IDs dos itens do pedido

    public Pedido(int id, String endereco, String deadline, List<Integer> itens) {
        this.id = id;
        this.endereco = endereco;
        this.deadline = deadline;
        this.itens = itens;
    }

    public int getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getDeadline() {
        return deadline;
    }

    public List<Integer> getItens() {
        return itens;
    }
}
