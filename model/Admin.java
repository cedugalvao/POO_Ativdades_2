package model;
import view.Payments;

import java.util.Scanner;

public class Admin extends User implements Payments {
    public String cargo;
    public Admin(double salario, String name, String email, String password, String cargo) {
            super(salario, name, email, password);
            this.cargo = cargo;
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

    // Uso de Abstract Class - uso tambem de convenção v para value
    @Override
    public void alterar(){
        System.out.print("Digite o que voce quer que seja  alterado:");
        Scanner s = new Scanner(System.in);
        System.out.print("\n1-nome\n2-email\n3-senha\n4-cargo\n");
        int num = s.nextInt();
        if(num==1){
        	System.out.print("Digite seu novo nome: ");
        	String v = s.next();
        	setName(v);
        	}
        else if(num==2){
        	System.out.print("Digite seu novo email: ");
        	String v = s.next();
        	setEmail(v);
        	}
        else if(num==3){
        	System.out.print("Digite sua nova senha: ");
        	String v = s.next();
        	setPassword(v);
        	}
        else if(num==4){
        	System.out.print("Digite seu novo cargo ");
        	String v = s.next();
        	setCargo(v);}
        else{System.out.print("Erro!");}
    }

    @Override
    public void recebe_salario(double dinheiro) {
        System.out.printf("Salario caiu na conta. R$:%.4f\n", dinheiro);
    }

    @Override
    public void recebe_salario(double dinheiro, String name) {
        System.out.printf("Efetuando pagamento de R$:%.4f na conta do profissional %s\n", dinheiro, name);
    }
}