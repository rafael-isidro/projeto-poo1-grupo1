package entities;

import java.util.Objects;

public class Ator extends Pessoa {

    private String cpf;

    public Ator(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    public Ator() {
        super();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ator ator = (Ator) o;
        return cpf.equals(ator.cpf) && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf);
    }

    @Override
    public String toString() {
        return "Ator{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

}