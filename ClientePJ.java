public class ClientePJ extends Cliente{
    private String cnpj;

    public ClientePJ(String nome, String email, String cnpj){
        super(nome, email); //constroi os atributos da classe pai, tem que ser o primeiro comando
        this.cnpj = cnpj;
    }

    public String getCNPJ(){ 
        return this.cnpj;}
    public void setCPF(String cnpj){
        this.cnpj = cnpj;
    }
    
}
