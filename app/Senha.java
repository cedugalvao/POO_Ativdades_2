package app;

import java.util.ArrayList;
import java.util.Scanner;

import model.Atividade;
import model.Project;
import model.User;

class Senha {
    Scanner scan = new Scanner(System.in);
    public ArrayList<User> user = new ArrayList<User>();
	public ArrayList<Atividade> listaAtv = new ArrayList<Atividade>();
	public ArrayList<Project> listaProj = new ArrayList<Project>();
    private AlteracoesUser cadastro;

	
	
	public void alterarSenha(){
		try {
			System.out.println("Digite seu email");
            String email = scan.nextLine();
            for (User currentUser : this.user) {
                if (currentUser.email.equals(email)) {
                	System.out.println("Digite sua senha antiga:");
                	String senhaAntiga = scan.nextLine();
                	if(currentUser.password.equals(senhaAntiga)) { 
                		System.out.println("Digite sua nova senha");
                		String newpassword = scan.nextLine();
                		currentUser.setPassword(newpassword);
                	}
               	}
            }
		}catch(Exception e) {
			System.out.println("Essa não é a senha original.");
		}
		
	}
}
