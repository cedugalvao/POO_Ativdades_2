package model;
import java.util.Scanner;

public class Pessoa {
    public double salario;
    public String name;
    public String email;
    public String senha;
    public Pessoa(double salario, String name, String email, String senha) {
        this.salario = salario;
        this.name = name;
        this.email = email;
        this.senha = senha;
    }
    public static class PessoaBuilder{
        public double salario;
        public String name;
        public String email;
        public String senha;
        public PessoaBuilder(){}
        public PessoaBuilder name(String name){
            this.name = name;
            return this;
        }
        public PessoaBuilder email(String email){
            this.email = email;
            return this;
        }
        public PessoaBuilder senha(String senha){
            this.senha = senha;
            return this;
        }
        public PessoaBuilder salario(double salario){
            this.salario = salario;
            return this;
        }
        public Pessoa CreatePessoa(){
            return new Pessoa(salario, name, email, senha);
        }
    }
    public void printarName() {
        System.out.println(name);
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setsenha(String senha) {
        this.senha = senha;
    }
    public void alterar(){
        System.out.print("Digite o que voce quer que seja  alterado:");
        Scanner s = new Scanner(System.in);
        System.out.print("\n1-nome\n2-email\n3-senha");
        int num = s.nextInt();
        if(num==1){System.out.print("Digite seu novo nome: ");String v = s.next();setName(v);}
        else if(num==2){System.out.print("Digite seu novo email: ");String v = s.next();setEmail(v);}
        else if(num==3){System.out.print("Digite sua nova senha: ");String v = s.next();setsenha(v);}
        else {System.out.print("Erro! numero digitado errado.");}
    }
}
