package model;

import java.util.Scanner;

public abstract class User {
    public double salario;
    public String name;
    public String email;
    public String nivel;
    public String password;
    

    public User(double salario, String name, String email, String password) {
        this.setSalario(salario);
        this.name = name;
        this.email = email;
        this.password = password;

    }
    public String getEmail(){
        return this.email;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String toString() {
        return "Nome: " + this.name + ", Email: " + this.email + " ";
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void setNivel(String v) {
    	
    }

    public void alterar() {
    	System.out.println("Oque deseja alterar:\n"
    			+ "1 - Nome\n"
    			+ "2 - Email\n"
    			+ "3 - Nivel(Cursando)");
    	Scanner scan = new Scanner(System.in);
    	int v = scan.nextInt();
    	if(v == 1) {
    		System.out.println("Digite o novo nome:");
    		String temp = scan.nextLine();
    		setName(temp);
    	}else if(v == 2) {
    		System.out.println("Digite o novo email:");
    		String temp = scan.nextLine();
    		setEmail(temp);
    	}else if(v == 3) {
    		System.out.println("Digite o novo Curso:");
    		String temp = scan.nextLine();
    		setNivel(temp);
    	}  	
    }
}
