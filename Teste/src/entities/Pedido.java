package entities;

public class Pedido {

    int id;
    String endereco;
    String deadline;
    int Itens; // lista de itens

    public Pedido(){

    }

    public Pedido(int id, String endereco, String deadline, int Itens){
        this.id = id;
        this.endereco = endereco;
        this.deadline = deadline;
        this.Itens = Itens;
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

    public int getItens() {
        return Itens;
    }

    public void setItens(int Itens) {
        this.Itens = Itens;
    }
    
}
