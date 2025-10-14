import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//test

public class SistemaPedidos {
    public static void main(String[] args) { //recebe argumentos da linha de cmd, receber parametros
        //Cria CLIENTES
        ClientePF clientePF1 = new ClientePF("Maria", "maria@gmail.com", "009.984.345-01");
        ClientePJ clientePJ1 = new ClientePJ("Lima Engenharia ltda", "contato@lima.com.br", "XX. XXX. XXX/0001-XX");
        //Lista de CLIENTES
        List<Cliente> listClientes = new ArrayList<>();
        listClientes.add(clientePJ1);
        listClientes.add(clientePF1);

        //PRODUTOS
        Produto teclado = new Produto("Fortrek",150.00);
        Produto mousePad = new Produto("Mouse Pad Preto", 10.00);
        Produto mouse = new Produto("Mouse Dell sem fio - WM118", 50.00);
        Produto laptop = new Produto("Laptop Lenovo", 1200.00);

        //PEDIDO 01 -> testar CRÉDITO R$150.00
        Pedido pedido1 = new Pedido(clientePF1, 1, LocalDate.now());
        pedido1.adicionarItem(teclado,1);
        IPagamento cartao1 = new PagamentoCartaoCredito();
        pedido1.setMetodoPagamento(cartao1);
        cartao1.processarPagamento(pedido1.calcularTotal());

        //PEDIDO 02 -> testar CRÉDITO R$500.00
        Pedido pedido2 = new Pedido(clientePJ1, 2, LocalDate.now());
        pedido2.adicionarItem(teclado, 3);
        pedido2.adicionarItem(mouse, 1);
        IPagamento cartao2 = new PagamentoCartaoCredito();
        pedido2.setMetodoPagamento(cartao2);
        cartao2.processarPagamento(pedido2.calcularTotal());

        //PEDIDO 03 -> testar BOLETO R$800.00
        Pedido pedido3 = new Pedido(clientePF1, 3, LocalDate.now());
        pedido3.adicionarItem(teclado, 4);
        pedido3.adicionarItem(mouse, 3);
        pedido3.adicionarItem(mousePad, 5);
        IPagamento boleto1 = new PagamentoBoleto();
        pedido3.setMetodoPagamento(boleto1);
        boleto1.processarPagamento(pedido3.calcularTotal());

        //PEDIDO 04 -> testar BOLETO R$1500.00
        Pedido pedido4 = new Pedido(clientePJ1, 4, LocalDate.now());
        pedido4.adicionarItem(laptop, 1);
        pedido4.adicionarItem(teclado, 1);
        pedido4.adicionarItem(mouse, 3);
        IPagamento boleto2 = new PagamentoBoleto();
        pedido4.setMetodoPagamento(boleto2);
        boleto2.processarPagamento(pedido4.calcularTotal());

        //Lista de PEDIDOS
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
        pedidos.add(pedido4);

        for(Cliente cliente : listClientes) {
            System.out.println("\n\n---Pedidos do Cliente: " + cliente.getNome() + "---\n");
            for (Pedido p : pedidos){
                if(p.getCliente().equals(cliente)){
                    System.out.println("-->Pedido número " + p.getNumero() + "\n");
                    for (ItemPedido item : p.getItens()) {
                        System.out.println("Produto: " + item.getProduto().getNome() + " | Preço: R$ " + item.getProduto().getPreco() + " | Qtde: " + item.getQuantidade() + " | Subtotal: R$ " + item.getSubtotal());
                    }
                    System.out.printf("Total: %.2f \n", p.calcularTotal());
                    boolean aprovado = p.getMetodoPagamento().processarPagamento(p.calcularTotal());
                    if (aprovado) System.out.println("Pagamento APROVADO!\n");
                    else System.out.println("Pagamento RECUSADO!\n");

                }
            }
        }
    }
}