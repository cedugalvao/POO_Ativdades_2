package model;
import java.util.*;

public class Project {
    public ArrayList<User> userList = new ArrayList<>();
    public ArrayList<Atividade> listaAtividades = new ArrayList<>();
    private String status;
    private String id;
    private String descrition;
    private String datainicio;
    private String datafim;
    private Integer bolsa;
    private double valor_bolsa;
    private int tempo_bolsa;

    public boolean find_user(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    public void print_user_projects(){
        System.out.print("Lista de Usuarios:\n");
        for (User usuario: this.userList){
            System.out.print(usuario.getName() + "\n");
        }
    }

    public void add_user(User usuario){
        this.userList.add(usuario);
    }

    public void print_activity_projects(){
        System.out.println("Lista de Atividades:");
        for (Atividade atividade: this.listaAtividades){
            System.out.print(atividade.getDescricao() + "\n");
        }
    }
    public void add_atividade(Atividade atividade){
        this.listaAtividades.add(atividade);
    }
    public Project(String status, String id, String descrition, String datainicio, String datafim,
                   Integer bolsa, Double valor_bolsa, int TempoBolsa, User user) {
        super();
        this.setStatus(status);
        this.id = id;
        this.descrition = descrition;
        this.datainicio = datainicio;
        this.datafim = datafim;
        this.bolsa = bolsa;
        this.valor_bolsa = valor_bolsa;
        this.tempo_bolsa = TempoBolsa;
        this.userList.add(user);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getDataInicio() {
        return datainicio;
    }

    public void setDataInicio(String datainicio) {
        this.datainicio = datainicio;
    }

    public String getDataFim() {
        return datafim;
    }

    public void setDataFim(String dataend) {
        this.datafim = dataend;
    }

    public Integer getBolsa() {
        return bolsa;
    }

    public void setBolsa(Integer bolsa) {
        this.bolsa = bolsa;
    }

    public int getTempoBolsa() {
        return tempo_bolsa;
    }

    public void setTempoBolsa(int TempoBolsa) {
        this.tempo_bolsa = TempoBolsa;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor_bolsa() {
        return valor_bolsa;
    }

    public void setValor_bolsa(double valor_bolsa) {
        this.valor_bolsa = valor_bolsa;
    }

}