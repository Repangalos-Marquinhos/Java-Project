package entities;

public class Item {

    private int id;
    private int lote;
    private int quantidade;
    private String tamanho;
    private String descricao;
    private String categoria;
    private String prazo;

    public Item() {

    }

    public Item(int id, int lote, int quantidade, String tamanho, String descricao, String categoria, String prazo) {
        this.id = id;
        this.lote = lote;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
        this.descricao = descricao;
        this.categoria = categoria;
        this.prazo = prazo;
    }

    // Getters and Setters
    // Id não tem setter pois é um valor qu so podera ser alterado pelo metodo de
    // cadastro
    public int getId() {
        return id;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    // toString
    public String toString() {
        return "ID: " + id + "\nLote: " + lote + "\nQuantidade: " + quantidade + "\nTamanho: " + tamanho
                + "\nDescrição: " + descricao + "\nCategoria: " + categoria + "\nPrazo: " + prazo;
    }

    // Método

    public void retirarQntProduto(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
        } else {
            System.out.println("Quantidade insuficiente");
        }
    }

    public void cadastrarQntProduto(int quantidade) {
        this.quantidade += quantidade;
    }


}
