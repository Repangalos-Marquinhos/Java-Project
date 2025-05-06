package entities;
import java.util.List;

public class Pedido {

    private int id;
    private String endereco;
    private String deadline;
    private Status status; // Status do pedido (PENDENTE, EM_ANDAMENTO, ENTREGUE)
    //private Status status; // Status do pedido (PENDENTE, EM_ANDAMENTO, ENTREGUE)
    public enum Status {
        PENDENTE,
        EM_ANDAMENTO,
        ENTREGUE
    }
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

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Integer> getItens() {
        return itens;
    }

    public void setItens(List<Integer> itens) {
        this.itens = itens;
    }

}
