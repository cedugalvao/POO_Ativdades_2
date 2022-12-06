package app;
import java.util.*;
import model.*;

public class App {
    Scanner s = new Scanner(System.in);
    public ArrayList<Project> listaProjetos = new ArrayList<>();
    public ArrayList<Atividade> listaAtividades = new ArrayList<>();
    public ArrayList<User> userList = new ArrayList<>();
    Acoesatividades acoesa = new Acoesatividades();
    Acoesprojetos acoesp = new Acoesprojetos();
    Consultas consulta = new Consultas();

    public App(ArrayList<User> userList) {
        this.userList.addAll(userList);
        this.programa();
    }

    public void programa() {
        Integer todosatributosp = 0;
        Integer todosatributosa = 0;
        String status = "Em processo de criacao";
        //----Criando Projeto pre-pronto----\\
        this.listaProjetos.add(new Project("concluido", "1", "projeto1", "31/12/2000", "31/12/2022", 1, 1.200, 6, userList.get(0)));
        //----Criando Atividades pre-prontas----\\
        this.listaAtividades.add(new Atividade("1", "atividade1", "01/01/2001", "22/02/2022", null, status, userList.get(0)));
        this.listaAtividades.add(new Atividade("2", "atividade2", "01/01/2001", "22/02/2022", null,  status, userList.get(0)));
        System.out.println("O sistema ja conta com o cadastro de um projeto inicial e duas atividades\n"
        				 + "id do projeto: 1 , id das aatividades são respectivamentes 1 e 2 ");
        int n = 0;
        while (n != -1) {
            System.out.println("Selecione a opcao desejada:\n"
                    + "1-Criar\n"
                    + "2-Alterar\n"
                    + "3-Remover\n"
                    + "4-Relatorio\n"
                    + "5-Pagamento da bolsa\n"
                    + "6-Associar usuario a projeto\n"
                    + "7-Associar atividade a projeto\n"
                    + "8-Associar usuario a atividade\n"
                    + "9-Realizar intercambio\n"
                    + "0-encerrar o programa");
            n = s.nextInt();
            switch (n) {
                case 1:
                	try {
                		int m;
                        System.out.println("""
                                Qual atributo deseja?
                                1-projeto
                                2-atividade
                                """);
                        m = s.nextInt();
                        if (m == 1) {
                            acoesp.criarProjetos(status);
                        } else if (m == 2) {
                            acoesa.criar_atividade(status);
                        }
                	}catch(Exception e) {
                		System.out.println("Digite corretamente.");
                        break;
                	}
                    break;
                case 2:
                	try {
                		int o;
                        System.out.println("""
                                Qual atributo deseja alterar?
                                1-projeto
                                2-atividade
                                """);
                        o = s.nextInt();
                        if (o == 1) {
                            System.out.println("Alterando Projeto.");
                            //----Alterando Projeto----\\
                            acoesp.alterarProjeto(listaProjetos);
                        } else if (o == 2) {
                            //----Alterando Atividade----\\
                            System.out.println("Alterando Atividade.");
                            acoesa.alterar_atividade(listaAtividades);
                        }
                	}catch(Exception e) {
                		System.out.println("Comando não reconhecido.");
                        break;
                	}
                    break;
                case 3:
                	try {
                		int p;
                        System.out.println("Qual atributo deseja remover?\n"
                                + "1-projeto\n"
                                + "2-atividade\n");

                        p = s.nextInt();
                        if (p == 1) {
                            System.out.println("Removendo Projeto.");
                            acoesp.removerprojeto(listaProjetos);
                        } else if (p == 2) {
                            System.out.println("Removendo Atividade.");
                            acoesa.removeratividade(listaAtividades);
                        }
                	}catch(Exception e) {
                		System.out.println("Comando não reconhecido.");
                        break;
                	}
                    break;
                case 4:
                	try {
                		int q;
                        System.out.println("Qual atributo deseja realizar o relatorio?\n"
                                + "1-projeto\n"
                                + "2-atividade\n");
                        q = s.nextInt();
                        if (q == 1) {
                            System.out.println("Consultando Projeto.");
                            consulta.consultarprojeto();
                        } else if (q == 2) {
                            System.out.println("Consultando Atividade.");
                            consulta.consultaratividade();
                        }                        
                	}catch(Exception e) {
                		System.out.println("Comando não reconhecido.");
                        break;
                	}
                	break;
                case 5:
                	try {
                		acoesp.pagar();
                        break;
                	}catch(Exception e) {
            		
                	}
                	break;
                case 6:
                	try {
                		acoesp.linkar_usuario_projeto(todosatributosp);
                        break;
                	}catch(Exception e) {
            		
                	}
                    
                case 7:
                	try {
                		linkar_atividade_projeto(todosatributosp);
                        break;
                	}catch(Exception e) {
            		
                	}
                    
                case 8:
                	try {
                		acoesa.linkiar_usuario_atividade(todosatributosa);
                        break;
                	}catch(Exception e) {
            		
                	}
                    
                case 9:
                	try {
                		intercambio();
                        break;
                	}catch(Exception e) {
            		
                	}
                    
                default:
                    n = -1;
                    break;
            }
        }
    }
    

   
    public void linkar_atividade_projeto(Integer todos_atributos) {
        int i = 0;
        System.out.println("Deseja adicionar alguma atividade a algum projeto?\n1-[Sim]\n0-[Nao]\n");
        int resp = s.nextInt();
        if (resp == 1) {
            System.out.println("Digite o id do projeto:");
            String id_p = s.next();
            for (Project procurar : this.listaProjetos) {
                if (procurar.getId().equals(id_p)) {
                    System.out.println("Digite o id da atividade:");
                    String id_a = s.next();
                    for (Atividade atividade : this.listaAtividades) {
                        if (atividade.getId().equals(id_a)) {
                            i = 1;
                            procurar.add_atividade(atividade);
                            todos_atributos = todos_atributos + 1;
                            if (todos_atributos >= 2 && !procurar.getDescrition().equals("-1")) {
                                String status = "Em andamento";
                                procurar.setStatus(status);
                            }
                        }
                    }
                }
            }
            if (i != 1) {
                System.out.println("Erro! id incorreto ou inexistente");
            }
        }
        if (resp == 0) {
            System.out.println("vc nao quer adicionar.");
        }
    }
    public void intercambio() {
        System.out.println("Qual o usuario que vai fazer o intercambio?");
        String user = s.next();
        for (User usuario : userList) {
            if (usuario instanceof Aluno) {
                if (usuario.getName().equals(user)) {
                    for(Project projeto: listaProjetos){
                        if(projeto.find_user(user)){
                            System.out.print("o usuario pertence a um projeto.\nQual atividade vai ser feito o intercambio?\n");
                            String id = s.next();
                            for (Atividade activity: listaAtividades){
                                if (activity.getId().equals(id)){
                                    activity.add_user(usuario);
                                    System.out.println("Usuario adicionado com sucesso.");
                                }
                            }
                        }
                        else{
                            System.out.print("User nao pertence a um projeto, nao faz sentido o intercambio");
                        }
                    }
                }
            }
        }
    }
}