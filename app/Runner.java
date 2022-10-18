package app;

import model.Admin;
import model.Aluno;
import model.User;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    private User section;
    private final ArrayList<User> userList = new ArrayList<>();

    public Runner() {
    	//----Criando um usuario admin inicial----\\
        this.userList.add(new Admin(0001, "Admin", "admin", "admin", "coordenador"));
      //----Criando um usuario inicial----\\
        this.userList.add(new Aluno(1911, "Carlos", "centg@ic.br", "carlos", "graduacao", 19110974));

        Scanner scan = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            if (this.section == null) {
                System.out.println("1 - Logar\n"
                		+ "2 - Criar usuario\n"
                		+ "3 - Recuperar senha\n"
                		+ "4 - Deletar usuario\n"
                		+ "5 - Alterar\n"
                		+ "0 - Encerrar o programa");
            } else {
                if (section instanceof Admin) {
                    System.out.println("6 - Consultar usuarios\n"
                    		+ "7 - Entrar no programa");
                }
                System.out.println("5 - Alterar\n"
                		+ "0 - Sair\n");
            }
            int input = scan.nextInt();
          //----Limpando entrada----\\
            @SuppressWarnings("unused")
			String lixo = scan.nextLine();
            if (input == 0) {
                isRunning = false;
            }
          //----Chamando login----\\
            if (input == 1) {
            	
                login(scan);
            }
          //----Realizando cadastro----\\

            if (input == 2) {
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
                    this.userList.add(usuario);
                }

                if (priviledioAdm == 2) {
                	System.out.println("Qual o seu nivel(Graduacao,Mestrado,Doutorado):");
                	String nivel = scan.nextLine();
                    System.out.println("Digite seu numero de matricula: \n");
                    int num_matricula = scan.nextInt();
                    User usuario = new Aluno( 0, name, email, password, nivel, num_matricula);
                    this.userList.add(usuario);
                }
            }

            if(input == 3) {
                System.out.println("Digite seu email");
                String email = scan.nextLine();
                for (User currentUser : this.userList) {
                    if (currentUser.email.equals(email)) {
                    	System.out.println("Digite sua senha antiga:");
                    	String senhaAntiga = scan.nextLine();
                    	if(currentUser.password.equals(senhaAntiga)) { 
                    		System.out.println("Digite sua nova senha");
                    		String newpassword = scan.nextLine();
                    		currentUser.setPassword(newpassword);
                    		this.login(scan);
                        }
                    	else {
                        	System.out.println("Essa não é a senha original.");
                        	break;
                        }
                    break;                    
                    }
                }
            }

            if(input == 4) {
                System.out.println("Digite seu email");
                String email = scan.nextLine();
                System.out.println("Digite seu password");
                String password = scan.nextLine();
                for (User currentUser : this.userList) {
                    if (currentUser.email.equals(email)) {
                        if (currentUser.password.equals(password)) {
                            System.out.println("Usuario " + currentUser.getName() +" foi removido com sucesso.");
                            userList.remove(currentUser);
                        } else {
                            System.out.println("Senha incorreta\n");
                        }
                        break;
                    }
                }
            }
          //----Alterando dados gerais----\\
            if(input == 5){
                System.out.println("Digite seu email");
                String email = scan.nextLine();
                for (User atual : this.userList){
                    if (atual.email.equals(email)){
                        System.out.println("Alterando dados\n");
                        atual.alterar();
                        break;
                    }
                }
            }
          //----Chamando relatorio----\\
            if (input == 6) {
                for (User currentUser : this.userList) {
                    System.out.println(currentUser.toString());
                    System.out.print("\n");
                }
            }

            if (input == 7) {
                new App(userList);
            }
        }
    }

    private void login(Scanner scan) {
        System.out.println("Send your email");
        String email = scan.nextLine();
        System.out.println("Send your password");
        String password = scan.nextLine();
        for (User currentUser : this.userList) {
            if (currentUser.email.equals(email)) {
                if (currentUser.password.equals(password)){
                    this.section = currentUser;
                } else {
                    System.out.println("Senha nao confere\n");
                    break;
                }
            }
        }
        if (this.section == null) {
            System.out.println("Usuário nao encontrado.\ntente recuperar senha.\n");
        } else {
            System.out.println("Usuario " + this.section.name + " Logado");
        }
    }
}
