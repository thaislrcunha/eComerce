public class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome(){
        return this.nome;}
    public void setNome(String nome){
        this.nome = nome;
    }

    public double getPreco(){
        return this.preco; }
    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getEstoque(){
        return this.estoque;}
    public void setEstoque(int estoque){
        this.estoque = estoque;
    }

    public void adicionarEstoque(int quantidade){
        if(quantidade>0){
            this.estoque = this.estoque + quantidade;
        }
    }


    /*void exibirDetalhes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: R$ " + this.preco);
        System.out.println("Estoque: " + this.estoque);
    }*/
}