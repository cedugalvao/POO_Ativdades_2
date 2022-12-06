package app;

import java.util.ArrayList;

import model.Atividade;
import model.Project;
import model.User;

public interface Listas {
    public void listaProjetos(ArrayList<Project> listaProjetos);
    public void listaAtividades(ArrayList<Atividade> listaAtividades);
    public void listaUser(ArrayList<User> userList);
}
