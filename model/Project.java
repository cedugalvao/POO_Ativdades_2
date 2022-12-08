package model;
import java.util.*;

public class Project {
    public ArrayList<User> userList = new ArrayList<>();
    public ArrayList<Atividade> listaAtividades = new ArrayList<>();
    public Dados dados;
    private Integer bolsa;
    private double valor_bolsa;
    private String periodo_bolsa;
    public Project(Dados dados,Integer bolsa, Double valor_bolsa, String periodobolsa, User user) {
        super();
        this.dados = dados;
        this.bolsa = bolsa;
        this.valor_bolsa = bolsa;
        this.periodo_bolsa = periodobolsa;
        this.userList.add(user);
    }
    public boolean find_user(String name) {
        for (User user : userList) {
            if (user.pessoa.name.equals(name)) {
                return true;
            }
        }
        return false;
    }
    public void relatorio() {
        dados.DadosRelatorio();
        print_activity_projects();
        print_user_projects();
    }
    public void print_user_projects(){
        System.out.print("Lista de Usuarios:\n");
        for (User usuario: this.userList){
            System.out.print(usuario.pessoa.name + "\n");
        }
    }
    public void add_user(User usuario){
        this.userList.add(usuario);
    }
    public void print_activity_projects(){
        System.out.println("Lista de Atividades:");
        for (Atividade atividade: this.listaAtividades){
            System.out.print(atividade.dados.getDescricao() + "\n");
        }
    }
    public void add_atividade(Atividade atividade){
        this.listaAtividades.add(atividade);
    }
    public void setDados(Integer id, String descricao, String datainicio, String datafinal, String status) {
        this.dados = new Dados(id, descricao, datainicio, datafinal, status);
    }
    public Integer getBolsa() {
        return bolsa;
    }
    public void setBolsa(Integer bolsa) {
        this.bolsa = bolsa;
    }
    public String getPeriodo_bolsa() {
        return periodo_bolsa;
    }
    public void setPeriodobolsa(String periodobolsa) {
        this.periodo_bolsa = periodobolsa;
    }
    public double getValor_bolsa() {
        return valor_bolsa;
    }
    public void setValor_bolsa(double valor_bolsa) {
        this.valor_bolsa = valor_bolsa;
    }
}
