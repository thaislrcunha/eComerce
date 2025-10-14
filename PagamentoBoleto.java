public class PagamentoBoleto implements IPagamento {
    
    private String codigoBarras;
    private StatusPagamento statusPagamento;

    @Override
    public boolean processarPagamento( double valor){
        statusPagamento = statusPagamento.APROVADO;
        return true;
    }

    public String getCodigoBarras(){
        return codigoBarras;}
    public void setCodigoBarras(String codigoBarras){
        this.codigoBarras = codigoBarras;}
}
