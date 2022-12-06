package model;
import java.util.Scanner;

import app.Listas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Acoesatividades implements Listas {

    public ArrayList<User> userList = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    public ArrayList<Atividade> listaAtividades = new ArrayList<>();
    
	public void criar_atividade(String status) {
        System.out.println("Deseja adicionar atividade.");
        int numa;
        System.out.println("Quantas atividades vão ser registradas?");
        numa = s.nextInt();
        for (int i = 0; i < numa; i++) {
            System.out.printf("Atividade %d:\n", i);
            System.out.println("Id da atividade: ");
            String id = s.next();
            System.out.println("Descricao da atividade:\n(Se nao houver digitar -1)");
            String descritiona = s.next();
            System.out.println("(formato dd/MM/yyyy)\nData de inicio: ");
            String datainicio = s.next();
            System.out.println("(formato dd/MM/yyyy)\nData de termino:\n(se não acabou digite -1)");
            String datafinal = s.next();

            if (datafinal.equals("-1")) {
                status = "Iniciado";
            }

            if (!Objects.equals(descritiona, "-1")) {
                status = "Concluido";
            }

            System.out.println("Digite o e-mail do responsavel:");
            String resp = s.next();
            User coord = null;
            for (User usuario : userList) {
                if (usuario.getEmail().equals(resp)) {
                    coord = usuario;
                }
                break;
            }

            Atividade atividade = new Atividade(id, descritiona, datainicio, datafinal, coord, status, null);
            this.listaAtividades.add(atividade);
            System.out.println("Atividade adicionada com sucesso.");
        }
    }
	public void removeratividade(List<Atividade> listaAtividades) {
        System.out.println("Digite o id da atividade que vc quer remover:\n");
        String procura = s.next();
        int n = 1;
        while(n==1) {
        	for (Atividade activity : listaAtividades) {
            	try {
            		if (activity.getId().equals(procura)) {
                        System.out.print("Atividade removida com sucesso.\n");
                        listaAtividades.remove(activity); // activity pega o id, para remover
                        n = 0;
                        break;
                        }
            	}catch(Exception e) {
            		System.out.println("Atividade não encontarda");
            	}
                
            }
        } 
    }
    
    public void alterar_atividade(List<Atividade> listaAtividades) {
        String procura;
        System.out.println("Digite o id da atividade que vc quer alterar:\n");
        procura = s.next();
        Atividade atividadeatual = null;
        boolean existeatv = false;
        int n = 1;
		while(n ==1) {
			try {
				for (Atividade activity : listaAtividades) {
					if (activity.getId().equals(procura)) {
						atividadeatual = activity;
			            System.out.print("A atividade vai ser alterada.\n");
			            existeatv = true;
			        }
					if (existeatv) {
						String novoid;
				        System.out.println("Digite o id:\n");
				        novoid = s.next();
				        atividadeatual.setId(novoid);
				        String novadescricao;
				        System.out.println("Digite descricao:\n");
				        novadescricao = s.next();
				        atividadeatual.setDescricao(novadescricao);
				        String novadatainicio;
				        System.out.println("Digite data de inicio:\n");
				        novadatainicio = s.next();
				        atividadeatual.setDatainicio(novadatainicio);
				        String novadatafinal;
				        System.out.println("Digite data final:\n");
				        novadatafinal = s.next();
				        atividadeatual.setDatafinal(novadatafinal);
				
			            System.out.println("Digite o e-mail do novo responsavel:");
			            String resp = s.next();
			            User coord = null;
			            for (User usuario : userList) {
			                if (usuario.getEmail().equals(resp)) {
			                		coord = usuario;
				            }
			                break;
			            }
				        atividadeatual.setResponsavel(coord);
				        System.out.println("Atividade alterada com sucesso.");
					}
		        }
					n = 0;
		   }catch(Exception e) {
				System.out.println("Atividade inexistente ou nao encontrada.\n");			        
			}
		}
    }
    public void linkiar_usuario_atividade(Integer todos_atributos) {
        System.out.print("...");
        int i = 0;
        System.out.println("""
                Quer adicionar algum usuario a alguma atividade?
                1-[Sim]
                0-[Nao]""");
        int resp = s.nextInt();
        if (resp == 1) {
            System.out.println("vc quer adicionar.\n"
                    + "Digite o id da atividade:");
            String id_a = s.next();
            for (Atividade procurar : this.listaAtividades) {
                if (procurar.getId().equals(id_a)) {
                    System.out.println("Digite o e-mail do usuario");
                    String email = s.next();

                    for (User currentUser : this.userList) {
                        System.out.println(currentUser.toString());
                        System.out.print("\n");
                    }

                    for (User usuario : this.userList) {
                        if (usuario instanceof Aluno) {
                            if (usuario.getEmail().equals(email)) {
                                procurar.add_user(usuario);
                                System.out.println("usuario adicionado com sucesso.");
                                i = 1;
                                todos_atributos = todos_atributos + 1;
                                if (todos_atributos >= 2 && !procurar.getDescricao().equals("-1")) {
                                    String status = "Em andamento";
                                    procurar.setStatus(status);
                                }
                            }
                        }
                    }
                }
            }
            if (i != 1) {
                System.out.println("Erro! id incorreto ou inexistente");
                System.out.println("!!Obs: Só é permitido adicionar alunos.!!");
            }
        }
        if (resp == 0) {
            System.out.println("Não deseja adicionar.");
        }
    }

	
	@Override
	public void listaAtividades(ArrayList<Atividade> listaAtividades) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listaUser(ArrayList<User> userList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listaProjetos(ArrayList<Project> listaProjetos) {
		// TODO Auto-generated method stub
		
	}
}
