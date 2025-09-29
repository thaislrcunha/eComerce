import java.time.LocalDate; //incluir pacote
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private LocalDate data;
    private String status;
    private List<ItemPedido> itemPedido; //composição
    private Cliente cliente; //agregação
    private IPagamento metodoPagamento;

    public Pedido(Cliente cliente, int numero, String status, LocalDate data){
        this.numero = numero;
        this.status = status;
        this.data = data;
        this.cliente = cliente;
        this.itemPedido = new ArrayList<>();
    }

    //apenas o Pedido cria os ItemPedido
    public void adicionarItem(Produto produto, int quantidade) {
        ItemPedido item = new ItemPedido(produto, quantidade);
        this.itemPedido.add(item);
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

    public String getStatus(){
        return this.status;}
    public void setStatus(String status){
        this.status = status;
    }

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

}
