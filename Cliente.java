public class Cliente {
    private String nome; //so pode ser modificado e alterado na classe
    private String email;
    private int idade;

    public Cliente(String nome, int idade){  //construtor, como será construido o objevo
        this.nome = nome;
        this.idade = idade; }
    public Cliente(String nome){ //somente o nome
        this.nome = nome;}
    public Cliente(String nome, String email){ //nome e email
        this.nome = nome;
        this.email = email;
    }

    public String getNome(){ //obter valor da variável Nome
        return this.nome;}
    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){ //obter idade
        return this.idade; }
    public void setIdade(int idade){ //alterar idade
        this.idade = idade;
    }

    public String getEmail(){ //obter email
        return this.email;}
    public void setEmail(String email){ //alterar email
        this.email = email;
    }

}
