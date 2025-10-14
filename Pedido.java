import java.time.LocalDate; //incluir pacote
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private LocalDate data;
    //private String status;
    private List<ItemPedido> itemPedido; //composição
    private Cliente cliente; //agregação
    private IPagamento metodoPagamento;
    private double desconto;
    private StatusPedido statusPedido = StatusPedido.PENDENTE;

    public Pedido(Cliente cliente, int numero, LocalDate data){
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.itemPedido = new ArrayList<>();
    }

    //apenas o Pedido cria os ItemPedido
    public void adicionarItem(Produto produto, int quantidade) {
        for (ItemPedido item:this.itemPedido) {
            if (item.getProduto().equals(produto)){ //verificar se o produto já existe
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        ItemPedido item = new ItemPedido(produto, quantidade);
        this.itemPedido.add(item);
    }

    //remover itens
    public void removerItem(ItemPedido item){
        this.itemPedido.remove(item);
    }

    public List<ItemPedido> getItens() {
        return itemPedido;
    }

    //GET SETs
    public int getNumero(){
        return this.numero;}
    public void setNumero(int numero){
        this.numero = numero;
    }

    public StatusPedido getStatus(){
        return this.statusPedido;}

    public LocalDate getData(){
        return this.data;}
    public void setData(LocalDate data){
        this.data = data;
    }

    public Cliente getCliente(){
            return this.cliente;}
    public void setStatus(Cliente cliente){
            this.cliente = cliente;
    }

    //PAGAMENTO
    public IPagamento getMetodoPagamento(){
        return metodoPagamento;}
    public void setMetodoPagamento(IPagamento metodoPagamento){
        this.metodoPagamento = metodoPagamento;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : this.itemPedido) {
            total += item.getSubtotal();
        }
        return total;
    }

    public double aplicarDesconto(double desconto){
        double total = calcularTotal();
        double valorFinal = total - (total * (desconto/100));
        return valorFinal;
    }

    public boolean confirmarPedido(){
        if (statusPedido != StatusPedido.PENDENTE) return false;
        
        if (metodoPagamento == null) return false;
    
        boolean aprovado = metodoPagamento.processarPagamento(this.calcularTotal());
        
        /*if (aprovado){
            statusPedido = StatusPedido.PROCESSANDO;
        } else  statusPedido = StatusPedido.PENDENTE;
         */
        aprovado? statusPedido = StatusPedido.PROCESSANDO : StatusPedido.PENDENTE;
        
        
        return aprovado;
    }


}
