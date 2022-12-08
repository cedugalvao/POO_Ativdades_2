package app;
import java.util.*;
import model.*;
public class App {
    Scanner s = new Scanner(System.in);
    public ArrayList<Project> listaProjetos = new ArrayList<>();
    public ArrayList<Atividade> listaAtividades = new ArrayList<>();
    public ArrayList<User> userList = new ArrayList<>();
    public User current;
    public App(ArrayList<User> userList, User usuario) {
        this.current = usuario;
        this.userList.addAll(userList);
        this.programa();
    }
    public void programa() {
        Integer todosatributosp = 0;
        Integer todosatributosa = 0;
        String status = "Em processo de criacao";
        Dados dados1 = new Dados(10, "projeto1", "01/01/2001", "31/12/2022", "Em andamento");
        Dados dados2 = new Dados(11, "projeto2", "11/08/2020", "11/08/2022", "concluido");
        //----Criando Projeto pre-pronto----\\
        this.listaProjetos.add(new Project(dados1, 1, 1.200, "15/10/2022", userList.get(0)));
        //----Criando Atividades pre-prontas----\\
        this.listaAtividades.add(new Atividade(dados1, current, userList.get(0)));
        this.listaAtividades.add(new Atividade(dados2, current, userList.get(0)));
        System.out.println("O sistema ja conta com o cadastro de dois projetos iniciais e duas atividades\n"
        				 + "ids do projeto: 10 e 11 respectivamente , id das atividades são respectivamentes 10 e 11 ");
        int n = 0;
        while (n != -1) {
            System.out.println("""
                    Selecione a opcao desejada:
                    1 - Criar
                    2 - Alterar
                    3 - Remover
                    4 - Consultar
                    5 - Pagar a bolsa
                    6 - Mostrar relatorio
                    7 - Associar usuario a projeto
                    8 - Associar atividade a projeto
                    9 - Associar usuario a atividade
                    10 - Realizar intercambio
                    0 - Finalizar""");
            n = process();

            switch (n) {
                case 1 : {
                	int m = opcao();
                	try {
                		
                        if (m == 1) {
                            criar_projeto(status);
                        } else if (m == 2) {
                            criar_atividade(status);
                        }
            	    }catch(Exception e) {
            	    	if(m==1) {
            	            System.out.println("Projeto não adicionado.");
            	    	}else if(m==2) {
            	            System.out.println("Atividade não adicionada.");
            	    	}
            	    }
                }
                case 2 : {
                    System.out.println("Deseja alterar.");
                    int o = opcao();
                    try {
                    	if (o == 1) {
                            alterarprojeto();
                        } else if (o == 2) {
                            alterar_atividade();
                        }
            	    }catch(Exception e) {
            	    	if(o==1) {
            	            System.out.println("Projeto não adicionado.");
            	    	}else if(o==2) {
            	            System.out.println("Atividade não adicionada.");

            	    	}
            	    }
                }
                case 3 : {
                	System.out.println("Deseja realizar remoção.");
                	int p = opcao();
                	try {
                		
                        if (p == 1) {
                            removerprojeto();
                        } else if (p == 2) {
                            removeratividade();
                        }
            	    }catch(Exception e) {
            	    	if(p==1) {
            	            System.out.println("Projeto não adicionado.");
            	    	}else if(p==2) {
            	            System.out.println("Atividade não adicionada.");

            	    	}
            	    }
                }
                case 4 : {
                	int c = opcao();
                	try {
                        if (c == 1) {
                            consultarprojeto();
                        } else if (c == 2) {
                            consultaratividade();
                        }
            	    }catch(Exception e) {
            	    	if(c==1) {
            	            System.out.println("Projeto não adicionado.");
            	    	}else if(c==2) {
            	            System.out.println("Atividade não adicionada.");
            	    	}
            	    }
                }
                case 5 :
	                try {
	                	pagar();
	        	    }catch(Exception e) {
	        	    	System.out.println("Não existem bolsas para realizar pagamentos.");
	        	    }
                case 6 :
                	try {
                		relatorio();
                	}catch(Exception e) {
                		System.out.println("Dados insulficientes para gerar relátorio.");
                	}
                case 7 : 
                	try {
                		associar_usuario_projeto(status, todosatributosp);
                	}catch(Exception e) {
                		System.out.println("Erro! e-mail incorreto ou inexistente.");
                	}
                case 8 : 
                		associar_atividade_projeto(status, todosatributosp);
                case 9 : 
                		associar_usuario_atividade(status, todosatributosa);
                case 10 : 
                	intercambio();
                case 0 : 
                	n = -1;
                default : 
                	System.out.print("Comando não compreendido.");
            }
        }
    }
    public void menu() {
        System.out.println("Qual atributo deseja?\n"
        		+ "1 - Projeto\n"
        		+ "2 - Atividade\n");
    }
    public int opcao(){
        menu();
        while(true){        	
        	try {
        		int q = process();
        		if (q == 1 || q == 2){
                    return q;
                }
    	    }catch(Exception e) {
    	    	System.out.println("Digite corretamente");
    	    }
        }
    }
    public void criar_projeto(String status) {
        System.out.println("Adicionando projetos.");
        double valor_bolsa = 0;
        int bolsa;
        System.out.print("Quantos projetos deseja registrar?");
        int nump = process();
        for (int i = 1; i <= nump; i++) {
            System.out.printf("Projeto %d:\n", i);
            System.out.println("Id do projeto: ");
            Integer id = s.nextInt();
            System.out.println("Descricao do projeto:\n(se não houver descricao ainda digite -1)");
            String descrition = s.next();
            if (!descrition.equals("-1")) {
                status = "concluido";
            }
            System.out.println("(formato dd/MM/yyyy)\nData de inicio: ");
            String databegin = s.next();
            System.out.println("(formato dd/MM/yyyy)\nData de termino:\n(Se nao tiver acabado digite -1)");
            String dataend = s.next();
            System.out.println("Tem bolsa?\n1 - sim\n0- - nao\n");
            bolsa = process();
            if (bolsa == 1) {
                System.out.println("Qual o valor da bolsa?");
                valor_bolsa = s.nextDouble();
            }
            System.out.println("Periodo da bolsa:");
            String periodobolsa = s.next();
            if (dataend.equals("-1")) {
                status = "Iniciado";
            }
            if (!Objects.equals(descrition, "-1")) {
                status = "Concluido";
            }

            Dados dados = new Dados(id, descrition, databegin, dataend, status);
            Project proj = new Project(dados, bolsa, valor_bolsa, periodobolsa, current);
            listaProjetos.add(proj);
            System.out.println("Projeto adicionado com sucesso.");
        }
    }
    public void criar_atividade(String status) {
        System.out.println("Adicionando atividade.");
        System.out.println("Quantas atividades deseja registrar?");
        int numa = process();
        for (int i = 0; i < numa; i++) {
            System.out.printf("Atividade %d:\n", i);
            System.out.println("Id da atividade: ");
            Integer ida = process();
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

            Dados dados = new Dados(ida, descritiona, datainicio, datafinal, status);
            Atividade atividade = new Atividade(dados, current, current);
            this.listaAtividades.add(atividade);
            System.out.println("Atividade adicionada com sucesso.");
        }
    }
    public void alterar_atividade() {
        System.out.println("Digite o id da atividade que deseja alterar:\n");
        int procura = process();
        Atividade atividadeatual = procuratividade(procura);

        if (atividadeatual != null) {
            System.out.println("Digite o id:\n");
            int novoid = process();
            atividadeatual.dados.setId(novoid);
            String novadescricao;
            System.out.println("Digite descricao:\n");
            novadescricao = s.next();
            atividadeatual.dados.setDescricao(novadescricao);
            String novadatainicio;
            System.out.println("Digite data de inicio:\n");
            novadatainicio = s.next();
            atividadeatual.dados.setDatainicio(novadatainicio);
            String novadatafinal;
            System.out.println("Digite data final:\n"); // dps pega essa data final só com numero e se ela for antes da data de hoje então status encerrado
            novadatafinal = s.next();
            atividadeatual.dados.setDatafinal(novadatafinal);
            User coord = current;
            atividadeatual.setResponsavel(coord);
            System.out.println("Atividade atualizada com sucesso.");

        }
    }
    public void alterarprojeto() {
        System.out.println("Digite o id do projeto que deseja alterar:\n");
        int idprojeto = process();
        Project projetoatual = procurarprojeto(idprojeto);
        if (projetoatual != null) {
            System.out.println("Id: ");
            Integer id = process();
            projetoatual.dados.setId(id);
            System.out.println("Descricao:");
            String descrition = s.next();
            projetoatual.dados.setDescricao(descrition);
            System.out.println("Data de inicio:");
            String databegin = s.next();
            projetoatual.dados.setDatainicio(databegin);
            System.out.println("Data de termino:");
            String dataend = s.next();
            projetoatual.dados.setDatafinal(dataend);
            System.out.println("Valor da bolsa ");
            Integer bolsa = process();
            projetoatual.setBolsa(bolsa);
            System.out.println("Periodo da bolsa:");
            String periodobolsa = s.next();
            projetoatual.setPeriodobolsa(periodobolsa);
            System.out.println("Valor da bolsa:");
            int novovalorbolsa = process();
            projetoatual.setValor_bolsa(novovalorbolsa);
        }
    }
    public void removeratividade() {
        System.out.println("Digite o id da atividade que deseja remover:\n");
        int procura = process();
        Atividade activity = procuratividade(procura);
        if(activity != null){
            this.listaAtividades.remove(activity);
            System.out.println("Atividade removida com sucesso.");
        }
    }
    public void removerprojeto() {
        System.out.println("Digite o id da atividade que deseja remover:");
        int idprojeto = process();
        Project projetoatual = procurarprojeto(idprojeto);
        if(projetoatual != null){
            this.listaProjetos.remove(projetoatual);
            System.out.println("Projeto removido com sucesso.");
        }
    }
    public void consultaratividade() {
        System.out.println("Digite o id da atividade que deseja consultar:\n");
        int procura = process();
        Atividade atividade = procuratividade(procura);
        if(atividade != null){
            atividade.relatorio();
        }
    }
    public void consultarprojeto() {
        System.out.println("Digite o id do projeto que deseja consultar:\n");
        int procura = process();
        Project projeto = procurarprojeto(procura);
        if(projeto != null){
                projeto.relatorio();
            }
    }
    public void pagar() {
        System.out.println("Digite o id do projeto que realizar o pagamento:\n");
        int procura = process();
        Project projeto = procurarprojeto(procura);
        if(projeto != null){
            System.out.printf("Pagamento em andamento do projeto %d\n", projeto.dados.getId());
            double salario_bolsa = projeto.getValor_bolsa();
            for (User currentUser : this.userList) {
                if (currentUser instanceof Aluno) { // se não tiver aluno talvez de um erro checar.
                    ((Aluno) currentUser).recebe_salario(salario_bolsa, currentUser.pessoa.name);
                    ((Aluno) currentUser).recebe_salario(salario_bolsa);
                }
                if (currentUser instanceof Admin) {
                    ((Admin) currentUser).recebe_salario(salario_bolsa, currentUser.pessoa.name);
                    ((Admin) currentUser).recebe_salario(salario_bolsa);
                }
            }
        }
    }
    public void relatorio() {
        for (Project projeto : this.listaProjetos) {
            System.out.println("Mostrando relatorio...");
            System.out.printf("status: %s\n", projeto.dados.getStatus());
            projeto.relatorio();
        }
    }
    public void associar_usuario_projeto(String status, Integer todos_atributos) {
        int i = 0;
        listaaluno();
        System.out.println("Adicionando aluno a um projeto.\nDigite o id do projeto:");
        int id_p = process();
        Project procurar = procurarprojeto(id_p);
        if(procurar != null){
                System.out.println("Digite o e-mail do aluno:");
                String p_email = s.next();
                for (User usuario : this.userList) {
                    if (usuario instanceof Aluno) {
                        if (usuario.pessoa.email.equals(p_email)) {
                            i = 1;
                            procurar.add_user(usuario);//adicionando nesse projeto esse usuario pelo e-mail dele
                            System.out.printf("%s associado com sucesso.\n", usuario.pessoa.name);
                            todos_atributos = todos_atributos + 1;
                            if (todos_atributos >= 2 && !procurar.dados.getDescricao().equals("-1"))
                            {   status = "Em andamento";
                                procurar.dados.setStatus(status);
                            }
                        }
                    }
                }
            }
    }
    public void associar_atividade_projeto(String status, Integer todos_atributos) {
        int i = 0;
        System.out.println("Adicionadno atividade ao projeto.\nDigite o id do projeto:");
        int id_p = process();
        Project procurar = procurarprojeto(id_p);
		try {
			if(procurar != null){
	            System.out.println("Digite o id da atividade:");
	            int id_a = process();
	            for (Atividade atividade : this.listaAtividades) {
	                if (atividade.dados.getId().equals(id_a)) {
	                    i = 1;
	                    procurar.add_atividade(atividade);
	                    System.out.println("Atividade associada com sucesso.");
	                    todos_atributos = todos_atributos + 1;
	                    if (todos_atributos >= 2 && !procurar.dados.getDescricao().equals("-1")) {
	                        status = "Em andamento";
	                        procurar.dados.setStatus(status);
	                    }
	                }
	            }
	        }
		}catch(Exception e) {
			System.out.println("Erro! id incorreto ou inexistente");
		}
    }
    public void associar_usuario_atividade(String status, Integer todos_atributos) {
        System.out.print("...");
        int i = 0;
        System.out.println("vc quer adicionar.\nDigite o id da atividade:");
        int id_a = process();
        Atividade procurar = procuratividade(id_a);
        try {
        	if(procurar != null){
                System.out.println("Digite o e-mail do usuario");
                String email = s.next();
                for (User usuario : this.userList) {
                    if (usuario instanceof Aluno) {
                        if (usuario.pessoa.email.equals(email) && !procurar.find_user(email)) {
                            procurar.add_user(usuario);
                            System.out.printf("%s associado com sucesso.\n", usuario.pessoa.name);
                            i = 1;
                            todos_atributos = todos_atributos + 1;
                            if (todos_atributos >= 2 && !procurar.dados.getDescricao().equals("-1")) {
                                status = "Em andamento";
                                procurar.dados.setStatus(status);
                            }
                        }
                    }
                }
            }
	    }catch(Exception e) {
	    	System.out.println("Erro! id incorreto ou inexistente");
            System.out.println("!!Obs: Só é permitido adicionar alunos.!!");
	    }
    }
    public void intercambio() {
        System.out.println("Qual o usuario que vai fazer o intercambio?");
        String user = s.next();
        for (User usuario : userList) {
        	 if (usuario instanceof Aluno) {
                 if (usuario.pessoa.name.equals(user)) {
                	 try {
                		 for(Project projeto: listaProjetos){
                             if(projeto.find_user(user)){
                                 System.out.print("o usuario pertence a um projeto.\nQual atividade vai ser feito o intercambio?\n");
                                 int id = process();
                                 Atividade activity = procuratividade(id);
                                 if(activity != null){
                                     activity.add_user(usuario);
                                     System.out.println("Usuario adicionado com sucesso.");
                                 }
                             }
                		 }
                	 }catch(Exception e) {
                         System.out.print("User nao pertence a um projeto, nao faz sentido o intercambio");

                	 }
                }
            }
        }
    }
    public void listaaluno(){
        for (User usuario : this.userList) {
            if (usuario instanceof Aluno) {
                System.out.println("Aluno(a):" + usuario.pessoa.name + "e-mail:" + usuario.pessoa.email);
            }
        }
    }
    public int process() {
        while (true) {
            try {
                return Integer.parseInt(s.next());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
    public Atividade procuratividade(int id){
        for (Atividade atividade : this.listaAtividades) {
            if (atividade.dados.getId().equals(id)) {
                return atividade;
            }
        }
        System.out.println("Id incorreto ou inexistente.");
        return null;
    }
    public Project procurarprojeto(int id){
        System.out.println("procurando...");
        for (Project projeto : this.listaProjetos) {
            if (projeto.dados.getId().equals(id)) {
                return projeto;
            }
        }
        System.out.println("Id incorreto ou inexistente.");
        return null;
    }
}