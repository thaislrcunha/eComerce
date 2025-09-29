public class PagamentoCartaoCredito implements IPagamento {

    private String numeroCartao;

    @Override
    public boolean processarPagamento( double valor){
        return valor<200.0; //para o if não ficar redundante
    }

    public String getNumeroCartao(){
        return numeroCartao;}
    public void setNumeroCartao(String numeroCartao){
        this.numeroCartao = numeroCartao;}
 
}
