public class PagamentoCartaoCredito implements IPagamento {

    private String numeroCartao;
    private StatusPagamento statusPagamento;

    @Override
    public boolean processarPagamento( double valor){
        if(valor<5000.00){
            statusPagamento = StatusPagamento.APROVADO;
            return true;
        } else {
            statusPagamento = StatusPagamento.RECUSADO;
            return false;
        }
    }

    public String getNumeroCartao(){
        return numeroCartao;}
    public void setNumeroCartao(String numeroCartao){
        this.numeroCartao = numeroCartao;}
 
}
