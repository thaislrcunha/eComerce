public class PagamentoBoleto implements IPagamento {
    
    private String codigoBarras;

    @Override
    public boolean processarPagamento( double valor){
        return valor<1000.0;}

    public String getCodigoBarras(){
        return codigoBarras;}
    public void setCodigoBarras(String codigoBarras){
        this.codigoBarras = codigoBarras;}
}
