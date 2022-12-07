package app;

import model.Admin;
import model.Aluno;
import model.Pessoa;
import model.User;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    private User section;
    private final ArrayList<User> userList = new ArrayList<>();

    public Runner() {
    	//----Criando um usuario admin inicial----\\
    	Pessoa dadosAdmin = new Pessoa.PessoaBuilder().name("admin").email("admin").senha("admin").salario(0).CreatePessoa();
    	Admin admin = new Admin.AdminBuilder().pessoa(dadosAdmin).cargo("Max_level").CreateAdmin();
    	        //----Criando um usuario inicial----\\
    	Pessoa dadosCarlos = new Pessoa.PessoaBuilder().name("carlos").email("centg@ic.br").senha("1911").salario(0).CreatePessoa();

          
        System.out.println("O sistema ja conta com o cadastro de um usuario(aluno) inicial e um usuario(coordenador)\n"
        		+ "De entrada: email: admin, senha: admin, para o coordenador\n"
        		+ "E nome: carlos, senha: 1911");
        Scanner scan = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            if (this.section == null) {
                System.out.println("1 - Logar\n2 - Criar usuario\n3 - recuperar senha\n4 - deletar usuario\n5 - alterar\n0 - encerrar o programa");
            } else {
                if (section instanceof Admin) {
                    System.out.println("6 - Consultar usuarios\n7 - entrar no programa");
                }
                System.out.println("5 - alterar\n0 - Logout\n");
            }
            int input = scan.nextInt();
            String trash = scan.nextLine();
            //----logout----\\
            if (input == 0) {
                isRunning = false;
            }
          //---- login----\\
            if (input == 1) {
                login(scan);
            }
          //----criando usuario----\\
            if (input == 2) {
                System.out.println("Digite seu nome");
                String name = scan.nextLine();
                System.out.println("Digite seu email");
                String email = scan.nextLine();
                System.out.println("Digite sua senha");
                String senha = scan.nextLine();
                System.out.println("Digite\n1- para ADMIN\n2- para ALUNO");
                int ruleDigit = scan.nextInt();
                String cash = scan.nextLine();
                Pessoa pessoa = new Pessoa(0, name, email, senha);
                if (ruleDigit == 1) {
                    System.out.println("Qual o seu cargo?\n(ex: coordenador, pesquisador, doutorando, pós-graduando...)");
                    String cargo = scan.next();
                    User usuario = new Admin( pessoa, cargo);
                    this.userList.add(usuario);
                }

                if (ruleDigit == 2) {
                    System.out.println("Digite seu n° de matricula: \n");
                    int num_matricula = scan.nextInt();
                    User usuario = new Aluno( pessoa, num_matricula);
                    this.userList.add(usuario);
                }
            }
          //----recuperacao de senha----\\
            if(input == 3) {
                System.out.println("Digite seu email");
                String email = scan.nextLine();
                for (User currentUser : this.userList) {
                    if (currentUser.pessoa.email.equals(email)) {
                        System.out.println("Digite sua nova senha");
                        String newsenha = scan.nextLine();
                        currentUser.pessoa.setsenha(newsenha);
                        this.login(scan);
                    }
                }
            }
          //----removendo usuario----\\
            if(input == 4) {
                System.out.println("Digite seu e-mail");
                String email = scan.nextLine();
                User currentUser = procurauser(email);
                if(currentUser != null){
                    System.out.println("Digite sua senha");
                    String senha = scan.nextLine();
                    if (currentUser.pessoa.senha.equals(senha)) {
                        System.out.println("Usuario " + currentUser.pessoa.name +" removido com sucesso.");
                        userList.remove(currentUser);
                    } else {
                        System.out.println("Senha nao confere\n");
                    }
                }
            }
          //----alterando dados----\\
            if(input == 5){
                System.out.println("Alterar...\nSend your email");
                String email = scan.nextLine();
                User atual = procurauser(email);
                if(atual != null){
                    System.out.println("Alterando dados\n");
                    atual.pessoa.alterar();
                }
            }
          //----consultando----\\
            if (input == 6) {
                for (User currentUser : this.userList) {
                    System.out.println(currentUser.toString());
                    System.out.print("\n");
                }
            }
          //----entrando no sistema----\\
            if (input == 7) {
                System.out.println("entrando no sistema...\n");
                new App(userList, section);
            }
        }
    }
    private void login(Scanner scan) { //
        System.out.println("Digite seu e-mail");
        String email = scan.nextLine();
        System.out.println("Digite sua senha");
        String senha = scan.nextLine();
        for (User currentUser : this.userList) {
            if (currentUser.pessoa.email.equals(email)) {
                if (currentUser.pessoa.senha.equals(senha)){
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
            System.out.println("Usuario " + this.section.pessoa.name + " Logado");
        }
    }
    User procurauser(String email){
        System.out.println("procurando...");
        for (User currentUser : this.userList){
            if (currentUser.pessoa.email.equals(email)) {
                this.section = currentUser;
                return this.section;
            }
        }
        System.out.println("E-mail incorreto ou inexistente.");
        return null;
    }
}