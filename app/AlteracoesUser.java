package app;

import java.util.ArrayList;
import java.util.Scanner;

import model.Admin;
import model.Aluno;
import model.Atividade;
import model.Project;
import model.User;

public class AlteracoesUser {
    Scanner scan = new Scanner(System.in);
    public ArrayList<User> user = new ArrayList<User>();
	public ArrayList<Atividade> listaAtv = new ArrayList<Atividade>();
	public ArrayList<Project> listaProj = new ArrayList<Project>();
	int n = 1;
	
    public void cadastroUser(){
    	System.out.println("Digite seu nome"); 
    	String name = scan.nextLine();
        System.out.println("Digite seu email");
        String email = scan.nextLine();
        System.out.println("Digite sua senha");
        String password = scan.nextLine();
        System.out.println("Digite\n1- para ADMIN\n"
        		+ "2- para ALUNO");
        int priviledioAdm = scan.nextInt();
        
        //----Limpando Entrada----\\
        @SuppressWarnings("unused")
		String lixo01 = scan.nextLine();

        if (priviledioAdm == 1) {
            System.out.println("Qual o seu cargo?(Professor, Pesquisador, Profissionais	(Desenvolvedor,	Testador ou Analista)");
            String cargo = scan.next();
            User usuario = new Admin( 0, name, email, password, cargo);
            this.user.add(usuario);
        }

        if (priviledioAdm == 2) {
        	System.out.println("Qual o seu nivel(Graduacao,Mestrado,Doutorado):");
        	String nivel = scan.nextLine();
            System.out.println("Digite seu numero de matricula: \n");
            int num_matricula = scan.nextInt();
            User usuario = new Aluno( 0, name, email, password, nivel, num_matricula);
            this.user.add(usuario);
        }
    }

	public void Login(Runner runner, Scanner scan) {
	    System.out.println("Send your email");
	    String email = scan.nextLine();
	    
	    while(n == 1) {
	    	try {
		    	for (User currentUser : runner.userList) {
			        if (currentUser.email.equals(email)) {
			        	System.out.println("Send your password");
			    	    String password = scan.nextLine();
			    	    if (currentUser.password.equals(password)){
			                runner.section = currentUser;
			                break;
			            }
			        }
			        System.out.println("Usuário nao encontrado.\ntente recuperar senha.\n");
	                n = 0;		        
		    	}
		    }catch(Exception e) {
			    	System.out.println("Senha nao confere\n");
			    }
	    	}       
	    n = 1;
	    if (runner.section != null) {
	    	System.out.println("Usuario " + runner.section.name + " Logado");
	    }
	}  	
	public void DeletarUser(){
		System.out.println("Digite seu email");
		while(n == 1) {
			try {
				 String email = scan.nextLine();
			        System.out.println("Digite seu password");
			        String password = scan.nextLine();
			        for (User currentUser : this.user) {
			            if (currentUser.email.equals(email)) {
			                if (currentUser.password.equals(password)) {
			                    System.out.println("Usuario " + currentUser.getName() +" foi removido com sucesso.");
			                    user.remove(currentUser);
			                    break;
			                }
			            }
			        }
			}catch(Exception e) {
		    	 System.out.println("Senha incorreta\n");
		    }
		}
	}
	
}
