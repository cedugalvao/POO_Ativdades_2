package app;
import java.util.*;
import model.*;

public class App {
    Scanner s = new Scanner(System.in);
    public ArrayList<Project> listaProjetos = new ArrayList<>();
    public ArrayList<Atividade> listaAtividades = new ArrayList<>();
    public ArrayList<User> userList = new ArrayList<>();

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
                    + "4-Consultar\n"
                    + "5-Pagamento da bolsa\n"
                    + "6-Realizar relatorio\n"
                    + "7-Associar usuario a projeto\n"
                    + "8-Associar atividade a projeto\n"
                    + "9-Associar usuario a atividade\n"
                    + "10-Realizar intercambio\n"
                    + "0-encerrar o programa");
            n = s.nextInt();
            switch (n) {
                case 1:
                    int m;
                    System.out.println("""
                            Qual atributo deseja?
                            1-projeto
                            2-atividade
                            """);
                    m = s.nextInt();
                    if (m == 1) {
                        criarProjetos(status);
                    } else if (m == 2) {
                        criar_atividade(status);
                    } else {
                        System.out.println("Digite corretamente.");
                        break;
                    }
                    break;
                case 2:
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
                        alterarProjeto(listaProjetos);
                    } else if (o == 2) {
                        //----Alterando Atividade----\\
                        System.out.println("Alterando Atividade.");
                        alterar_atividade(listaAtividades);
                    } else {
                        System.out.println("Comando não reconhecido.");
                        break;
                    }
                    break;
                case 3:
                    int p;
                    System.out.println("Qual atributo deseja remover?\n"
                            + "1-projeto\n"
                            + "2-atividade\n");

                    p = s.nextInt();
                    if (p == 1) {
                        System.out.println("Removendo Projeto.");
                        removerprojeto(listaProjetos);
                    } else if (p == 2) {
                        System.out.println("Removendo Atividade.");
                        removeratividade(listaAtividades);
                    } else {
                        System.out.println("Comando não reconhecido.");
                        break;
                    }
                    break;
                case 4:
                    int q;
                    System.out.println("Qual atributo deseja consultar?\n"
                            + "1-projeto\n"
                            + "2-atividade\n");
                    q = s.nextInt();
                    if (q == 1) {
                        System.out.println("Consultando Projeto.");
                        consultarprojeto();
                    } else if (q == 2) {
                        System.out.println("Consultando Atividade.");
                        consultaratividade();
                    } else {
                        System.out.println("Comando não reconhecido.");
                        break;
                    }
                    break;
                case 5:
                    pagar();
                    break;
                case 6:
                    relatorio();
                    break;
                case 7:
                    linkar_usuario_projeto(todosatributosp);
                    break;
                case 8:
                    linkar_atividade_projeto(todosatributosp);
                    break;
                case 9:
                    linkiar_usuario_atividade(todosatributosa);
                    break;
                case 10:
                    intercambio();
                    break;
                default:
                    n = -1;
                    break;
            }
        }
    }

    public void criarProjetos(String status) {
        System.out.println("Criando Projeto.");
        double valor_bolsa = 0;
        int bolsa;
        System.out.print("Quantos projetos deseja criar?");
        int nump = s.nextInt();
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
            listaProjetos.add(proj);
            System.out.println("Projeto adicionado com sucesso.");
        }
    }

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

    public void alterar_atividade(List<Atividade> listaAtividades) {
        String procura;
        System.out.println("Digite o id da atividade que vc quer alterar:\n");
        procura = s.next();
        Atividade atividadeatual = null;
        boolean existeatv = false;

        for (Atividade activity : listaAtividades) {
            if (activity.getId().equals(procura)) {
                atividadeatual = activity;
                System.out.print("A atividade vai ser alterada.\n");
                existeatv = true;
            }
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
            System.out.println("Atividade atualizada com sucesso.");

        } else {
            System.out.println("Atividade inexistente ou nao encontrada.\n");
        }
    }

    public void alterarProjeto(ArrayList<Project> projeto) {
        System.out.println("Digite o id da atividade que vc quer alterar:\n");
        String idprojeto = s.next();
        Project projetoatual = null;
        boolean existeproj = false;

        for (Project projetonovo : listaProjetos) {
            if (projetonovo.getId().equals(idprojeto)) {
                projetoatual = projetonovo;
                System.out.print("parabens deu certo");
                existeproj = true;
            }
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
        } else {
            System.out.println("Projeto inexistente ou nao encontrada.\n");
        }
    }

    public void removeratividade(List<Atividade> listaAtividades) {
        System.out.println("Digite o id da atividade que vc quer remover:\n");
        String procura = s.next();
        for (Atividade activity : listaAtividades) {
            if (activity.getId().equals(procura)) {
                System.out.print("Atividade removida com sucesso.\n");
                listaAtividades.remove(activity); // activity pega o id, para remover
                break;
            }
        }

    }

    public void removerprojeto(ArrayList<Project> projeto) {
        String idprojeto;
        System.out.println("Digite o id da atividade que vc quer alterar:\n");
        idprojeto = s.next();
        Project projetoatual;
        int foiremovido = 0;

        for (Project projetonovo : listaProjetos) {
            if (projetonovo.getId().equals(idprojeto)) {
                projetoatual = projetonovo;
                System.out.print("parabens deu certo\n");
                this.listaProjetos.remove(projetoatual);
                foiremovido = 1;
            }
        }

        if (foiremovido == 1) {
            System.out.print("nao foi removido ou nao existe.\n");
        } else {
            System.out.print("foi removido com sucesso.\n");
        }
    }

    public void consultaratividade() {
        System.out.println("Digite o id da atividade que vc quer consultar:\n");
        String procura = s.next();
        for (Atividade atividade : this.listaAtividades) {
            if (atividade.getId().equals(procura)) {
            	atividade.relatorio("id");
            }
        }
    }
    

    public void consultarprojeto() {
        System.out.println("Digite o id do projeto que vc quer consultar:\n");
        String procura = s.next();
        for (Project projeto : this.listaProjetos) {
            if (projeto.getId().equals(procura)) {
                System.out.println("Projeto(id)" + projeto.getId() +
                        "\nDescricao: " + projeto.getDescrition() +
                        "\nInicio" + projeto.getDataInicio() +
                        "\nfinal:" + projeto.getDataFim() +
                        "\nBolsa tipo:" + projeto.getBolsa() +
                        "\nValor da bolsa:" + projeto.getValor_bolsa() +
                        "\nTempo Valido:" + projeto.getTempoBolsa() + "\n");
                projeto.print_user_projects();
                projeto.print_activity_projects();
                System.out.print("\n");
            }
        }
    }

    public void pagar() {
        System.out.println("Digite o id do projeto que vc quer pagar:\n");
        String procura = s.next();
        for (Project projeto : this.listaProjetos) {
            if (projeto.getId().equals(procura)) {
                System.out.print("Pagamento em andamento do projeto ");
                System.out.println(projeto.getId());
                double salario_bolsa = projeto.getValor_bolsa();
                for (User currentUser : this.userList) {
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

    public void relatorio() {
        for (Project projeto : this.listaProjetos) {
            projeto.relatorio();
        }
    }

    public void linkar_usuario_projeto(Integer todos_atributos) {
        int i = 0;
        for (User usuario : this.userList) {
            if (usuario instanceof Aluno) {
                System.out.println("Aluno(a):" + usuario.getName() + "e-mail:" + usuario.getEmail());
            }
        }
        System.out.println("Quer adicionar algum aluno a algum projeto?\n1-[Sim]\n0-[Nao]");
        int resp = s.nextInt();
        if (resp == 1) {
            System.out.println("vc quer adicionar.\nDigite o id do projeto:");
            String id_p = s.next();
            for (Project procurar : this.listaProjetos) {
                if (procurar.getId().equals(id_p)) {
                    System.out.println("Digite o e-mail do aluno:");
                    String p_email = s.next();
                    for (User usuario : this.userList) {
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

    public void linkar_atividade_projeto(Integer todos_atributos) {
        int i = 0;
        System.out.println("Quer adicionar alguma atividade a algum projeto?\n1-[Sim]\n0-[Nao]");
        int resp = s.nextInt();
        if (resp == 1) {
            System.out.println("vc quer adicionar.\nDigite o id do projeto:");
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