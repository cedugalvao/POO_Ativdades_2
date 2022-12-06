package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Consultas {
    Scanner s = new Scanner(System.in);
    public ArrayList<User> user = new ArrayList<User>();
	public ArrayList<Atividade> listaAtv = new ArrayList<Atividade>();
	public ArrayList<Project> listaProj = new ArrayList<Project>();
	
    public void consultarprojeto() {
        System.out.println("Digite o id do projeto que vc quer consultar:\n");
        String procura = s.next();
        for (Project projeto : this.listaProj) {
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
    public void consultaratividade() {
        System.out.println("Digite o id da atividade que vc quer consultar:\n");
        String procura = s.next();
        
        for (Atividade atividade : this.listaAtv) {
            if (atividade.getId().equals(procura)) {
            	atividade.relatorio("id");
            }
        }
    }
}
