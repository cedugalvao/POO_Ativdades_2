package model;
import java.util.*;

public class Aluno extends User implements Payments {
    public Pessoa pessoa;
    public Integer matricula;
    public Aluno(Pessoa pessoa, Integer matricula) {
        super(pessoa);
        this.pessoa = pessoa;
        this.matricula = matricula;
    }
    public static class AlunoBuilder {
        private Pessoa pessoa;
        private int matricula;
        public AlunoBuilder() {}
        public AlunoBuilder pessoa(Pessoa pessoa) {
            this.pessoa = pessoa;
            return this;
        }
        public AlunoBuilder matricula(Integer matricula) {
            this.matricula = matricula;
            return this;
        }
        public Aluno CreateAluno() {
            return new Aluno(pessoa, matricula);
        }
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
        @Override
        public String toString() {
            System.out.println(super.toString());
            System.out.println("Cargo: aluno");
            return "numero de matrícula: " + this.matricula;
        }
        @Override
        public void recebe_salario(double dinheiro) {
            System.out.printf("Salario caiu na conta. R$:%.4f\n", dinheiro);
        }
        @Override
        public void recebe_salario(double dinheiro, String name) {
            System.out.printf("Efetuando pagamento de R$:%.4f na conta do aluno %s\n", dinheiro, name);
        }
        @Override
        public void alterar() {
            Scanner s = new Scanner(System.in);
            pessoa.alterar();
            System.out.println("Digite seu n° de matricula:");
            int v = s.nextInt();
            setMatricula(v);
        }
}
