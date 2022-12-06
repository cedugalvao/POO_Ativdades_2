package app;

import model.Admin;
import model.Aluno;
import model.User;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    Scanner s = new Scanner(System.in);
    User section;
    final ArrayList<User> userList = new ArrayList<>();
    private AlteracoesUser cadastro;
    private Senha senha;

    public Runner() {
    	//----Criando um usuario admin inicial----\\
        this.userList.add(new Admin(0001, "Admin", "admin", "admin", "coordenador"));

        //----Criando um usuario inicial----\\
          this.userList.add(new Aluno(0, "Carlos", "centg@ic.br", "1911", "graduacao", 19110974));
          
        System.out.println("O sistema ja conta com o cadastro de um usuario(aluno) inicial e um usuario(coordenador)\n"
        		+ "De entrada: email: admin, senha: admin, para o coordenador\n"
        		+ "E email: centg@ic.br, senha: 1911");

        Scanner scan = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
        	int n;
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
        	n = s.nextInt();
        	while(n!=0) {
        		switch (n) {
        		case 0:
        			isRunning = false;
        		
        		case 1:
        			cadastro.Login(null, scan);
        		case 2:
        			cadastro.cadastroUser();
        		case 3:
        			senha.alterarSenha();
        		case 4:
        			cadastro.DeletarUser();
        		case 5:
        			System.out.println("Digite seu email");
                    String email = scan.nextLine();
                    for (User atual : this.userList){
                    	try {
                    		if(atual.email.equals(email)) {
                    			System.out.println("Alterando dados\n");
                    			atual.alterar();
                    		}
                        } catch(Exception e) {
                        	System.out.println("Email não existente");	
                        	break;
                        }
                    	
                    }
        		case 6:
        			for (User currentUser : this.userList) {
                        System.out.println(currentUser.toString());
                        System.out.print("\n");
                    }
        		case 7:	
        			new App(userList);
        		}
        	}
        }
    }
}
