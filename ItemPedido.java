public class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto(){
        return this.produto;}
    public void setProduto(Produto produto){
        this.produto = produto;
    }

    public int getQuantidade(){
        return this.quantidade;}
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public double getSubtotal(){
        return (produto.getPreco()*this.quantidade);
    }
}
