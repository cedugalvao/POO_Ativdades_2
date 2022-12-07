package model;

public class Dados {
    private Integer id;
    private String descricao;
    private String datainicio;
    private String datafinal;
    private String status;
    public Dados(Integer id, String descricao, String datainicio, String datafinal, String status) {
        this.id = id;
        this.descricao = descricao;
        this.datainicio = datainicio;
        this.datafinal = datafinal;
        this.status = status;
    }
    public void DadosRelatorio(){
        System.out.printf("id: %d\n", id);
        System.out.printf("descricao: %s\n", descricao);
        System.out.printf("Data de inicio: %s\n", datainicio);
        System.out.printf("Data de término: %s\n", datafinal);
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDatainicio() {
        return datainicio;
    }
    public void setDatainicio(String datainicio) {
        this.datainicio = datainicio;
    }
    public String getDatafinal() {
        return datafinal;
    }
    public void setDatafinal(String datafinal) {
        this.datafinal = datafinal;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
