package model;
import java.util.Scanner;
public class Admin extends User implements Payments {
    public Pessoa pessoa;
    public String cargo;
    public Admin(Pessoa pessoa, String cargo) {
            super(pessoa);
            this.pessoa = pessoa;
            this.cargo = cargo;
        }

    public static class AdminBuilder {
        private Pessoa pessoa;
        private String cargo;
        public AdminBuilder() {}
        public AdminBuilder pessoa(Pessoa pessoa){
            this.pessoa = pessoa;
            return this;
        }

        public AdminBuilder cargo(String cargo){
            this.cargo = cargo;
            return this;
        }
        public Admin CreateAdmin(){
            return new Admin(pessoa, cargo);
        }

    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    // Uso de Overriding
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "cargo: " + this.cargo;
    }
    @Override
    public void recebe_salario(double dinheiro) {
        System.out.printf("Salario caiu na conta. R$:%.4f\n", dinheiro);
    }
    @Override
    public void recebe_salario(double dinheiro, String name) {
        System.out.printf("Efetuando pagamento de R$:%.4f na conta do profissional %s\n", dinheiro, name);
    }

    @Override
    public void alterar() {
        Scanner s = new Scanner(System.in);
        pessoa.alterar();
        System.out.println("Digite seu cargo:");
        String v = s.next();
        setCargo(v);
    }
}