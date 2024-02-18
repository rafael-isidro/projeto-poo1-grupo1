package entities;

import java.util.Objects;

// Classe abstrata para encapsular os atributos comuns entre Ator e Diretor
abstract class Pessoa {

    protected String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome);
    }

}