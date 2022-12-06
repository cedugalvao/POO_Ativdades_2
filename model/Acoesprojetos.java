package model;
import java.util.Scanner;

import app.Listas;

import java.util.ArrayList;
import java.util.Objects;


public class Acoesprojetos implements Listas{
	Scanner s = new Scanner(System.in);
	public ArrayList<User> user = new ArrayList<User>();
	public ArrayList<Atividade> listaAtv = new ArrayList<Atividade>();
	public ArrayList<Project> listaProj = new ArrayList<Project>();
	
	public void criarProjetos(String status) {
        System.out.println("Criando Projeto.");
        double valor_bolsa = 0;
        int bolsa;
        System.out.print("Quantos projetos deseja criar?");
        int nump = s.nextInt();
        try {
        	for (int i = 1; i <= nump; i++) {
                System.out.printf("Projeto %d:\n", i);
                System.out.println("Id do projeto: ");
                String id = s.next();
                System.out.println("Descricao do projeto:\n"
                        + "(se não houver descricao ainda digite -1)");
                String descrition = s.next();
                if (!descrition.equals("-1")) {
                    status = "concluido";
                }
                System.out.println("(formato dd/MM/yyyy)\n"
                        + "Data de inicio: ");
                String datainicio = s.next();
                System.out.println("(formato dd/MM/yyyy)\n"
                        + "Data de termino(Se nao houver data de finalização digite -1):");
                String datafim = s.next();
                System.out.println("Tem bolsa?\n"
                        + "1 - sim\n"
                        + "0- - nao\n");
                bolsa = s.nextInt();
                if (bolsa == 1) {
                    System.out.println("Qual o valor da bolsa?");
                    valor_bolsa = s.nextDouble();
                }
                System.out.println("Periodo da bolsa:");
                int TempoBolsa = s.nextInt();
                if (datafim.equals("-1")) {
                    status = "Iniciado";
                }
                if (!Objects.equals(descrition, "-1")) {
                    status = "Concluido";
                }

                Project proj = new Project(status, id, descrition, datainicio, datafim, bolsa, valor_bolsa, TempoBolsa, null);
                listaProj.add(proj);
                System.out.println("Projeto adicionado com sucesso.");
            }
        }catch(Exception e) {
        	
        }
        
    }
	public void alterarProjeto(ArrayList<Project> projeto) {
        System.out.println("Digite o id do projeto que vc quer alterar:\n");
        String idprojeto = s.next();
        Project projetoatual = null;
        boolean existeproj = false;
        int n = 1;
        while(n==1) {
        	try{
        		for (Project projetonovo : listaProj) {
                    if (projetonovo.getId().equals(idprojeto)) {
                        projetoatual = projetonovo;
                        System.out.print("Projeto será alterado");
                        existeproj = true;
                    }
                    if (existeproj) {
                        System.out.println("Id do projeto: ");
                        String id = s.next();
                        projetoatual.setId(id);
                        System.out.println("Descricao do projeto:");
                        String descrition = s.next();
                        projetoatual.setDescrition(descrition);
                        System.out.println("Data de inicio: ");
                        String datainicio = s.next();
                        projetoatual.setDataInicio(datainicio);
                        System.out.println("Data de termino: ");
                        String datafim = s.next();
                        projetoatual.setDataFim(datafim);
                        System.out.println("Valor da bolsa ");
                        Integer bolsa = s.nextInt();
                        projetoatual.setBolsa(bolsa);
                        System.out.println("Quantidade de periodos da bolsa:");
                        int TempoBolsa = s.nextInt();
                        projetoatual.setTempoBolsa(TempoBolsa);
                        System.out.println("Valor da bolsa:");
                        int novovalorbolsa = s.nextInt();
                        projetoatual.setValor_bolsa(novovalorbolsa);
                        break;
                    }
                }
        	}catch(Exception e) {
                    System.out.println("Projeto inexistente ou nao encontrada.\n");
           	}
        } 
    }
	public void removerprojeto(ArrayList<Project> projeto) {
        int idprojeto;
        System.out.println("Digite o id da atividade que vc quer alterar:\n");
        idprojeto = s.nextInt();
        Project projetoatual;
        int n = 1;
        while(n==1) {
        	for (Project projetonovo : listaProj) {
            	try {
            		if (projetonovo.getId().equals(idprojeto)) {
                        projetoatual = projetonovo;
                        System.out.printf("Projeto : %s", projetonovo.getId()+" foi deletado\n");
                        this.listaProj.remove(projetoatual);
                    }
            	}catch(Exception e) {
            		System.out.println("Atividade não encontarda"
            				+ "\n digite 1 - para tentar novamente "
            				+ "\n 2 - cancelar");
            		n = s.nextInt();
            	}
                
            }
        }        
    }
	
	public void linkar_usuario_projeto(Integer todos_atributos) {
        int i = 0;
        for (User usuario : this.user) {
            if (usuario instanceof Aluno) {
                System.out.println("Aluno(a):" + usuario.getName() + "e-mail:" + usuario.getEmail());
            }
        }
        System.out.println("Quer adicionar algum aluno a algum projeto?\n1-[Sim]\n0-[Nao]");
        int resp = s.nextInt();
        if (resp == 1) {
            System.out.println("vc quer adicionar.\nDigite o id do projeto:");
            String id_p = s.next();
            for (Project procurar : this.listaProj) {
                if (procurar.getId().equals(id_p)) {
                    System.out.println("Digite o e-mail do aluno:");
                    String p_email = s.next();
                    for (User usuario : this.user) {
                        if (usuario instanceof Aluno) {
                            if (usuario.email.equals(p_email)) {
                                i = 1;
                                procurar.add_user(usuario);//adicionando nesse projeto esse usuario pelo e-mail dele
                                todos_atributos = todos_atributos + 1;
                                if (todos_atributos >= 2 && !procurar.getDescrition().equals("-1")) {
                                    String status = "Em andamento";
                                    procurar.setStatus(status);
                                }
                            }
                        }
                    }
                }
            }
            if (i != 1) {
                System.out.println("Erro! e-mail incorreto ou inexistente ou Projeto inexistente!");
            }

        }
        if (resp == 0) {
            System.out.println("vc nao quer adicionar.");
        }
    }
	 public void pagar() {
	        System.out.println("Digite o id do projeto que deseja pagar:\n");
	        String procura = s.next();
	        for (Project projeto : this.listaProj) {
	            if (projeto.getId().equals(procura)) {
	                System.out.print("Pagamento do projeto em andamento:");
	                System.out.println(projeto.getId());
	                double salario_bolsa = projeto.getValor_bolsa();
	                for (User currentUser : this.user) {
	                    if (currentUser instanceof Aluno) {
	                        ((Aluno) currentUser).recebe_salario(salario_bolsa, currentUser.getName());
	                        ((Aluno) currentUser).recebe_salario(salario_bolsa);
	                    }
	                    if (currentUser instanceof Admin) {
	                        ((Admin) currentUser).recebe_salario(salario_bolsa, currentUser.getName());
	                        ((Admin) currentUser).recebe_salario(salario_bolsa);
	                    }
	                }
	                break;
	            }
	            break;
	        }
	    }

	@Override
	public void listaProjetos(ArrayList<Project> listaProjetos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listaAtividades(ArrayList<Atividade> listaAtividades) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listaUser(ArrayList<User> userList) {
		// TODO Auto-generated method stub
		
	}
}
