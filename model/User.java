package model;

public class User {
    public Pessoa pessoa;
    public User(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String toString(){
        return "nome: " + pessoa.name + "\n" + "e-mail: " + pessoa.email;
    }

}
