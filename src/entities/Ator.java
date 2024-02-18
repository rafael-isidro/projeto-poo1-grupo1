package entities;

import java.util.Objects;

public class Ator extends Pessoa {
    private long id;
    private String cpf;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ator(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Ator{" +
                "nome='" + super.getNome() + '\'' +
                "cpf='" + cpf + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ator ator = (Ator) o;
        return id == ator.id && cpf.equals(ator.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}