package model;

import java.util.ArrayList;
public class Atividade {
    public Dados dados;
    private User responsavel;
    public ArrayList<User> userList = new ArrayList<>();
    public Atividade(Dados dados, User responsavel, User user) {
        super();
        this.dados = dados;
        this.responsavel = responsavel;
        this.userList.add(user);
    }
    public void relatorio(){
        dados.DadosRelatorio();
        printar_coord();
        activity_users();
    }
    public boolean find_user(String email) {
        for (User user : userList) {
            if (user.pessoa.email.equals(email)) {
                return true;
            }
        }
        return false;
    }
    public void add_user(User usuario){
        this.userList.add(usuario);
    }
    public void activity_users(){
        System.out.println("Lista de usuarios: ");
        for (User usuario: userList){
            usuario.pessoa.printarName();
        }
    }
    public void printar_coord(){
        System.out.print("Responsavel: ");
        responsavel.pessoa.printarName();
    }
    public void setResponsavel(User responsavel) {
        this.responsavel = responsavel;
    }
}