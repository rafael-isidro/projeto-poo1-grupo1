package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Filme {
    private String nome;
    private LocalDate dataLancamento;
    private Double orcamento;
    private String descricao;
    private List<Diretor> listaDiretores;
    private List<Ator> listaAtores;
    private List<String> listaGenero;
    private Duration duracao;

    public Filme(String nome, LocalDate dataLancamento, Double orcamento, String descricao, List<Diretor> listaDiretores, List<Ator> listaAtores, List<String> listaGenero, Duration duracao) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.listaDiretores = listaDiretores;
        this.listaAtores = listaAtores;
        this.listaGenero = listaGenero;
        this.duracao = duracao;
    }



    public Filme() {
        this.listaAtores = new ArrayList<>();
        this.listaDiretores = new ArrayList<>();
        this.listaGenero = new ArrayList<>();
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Diretor> getListaDiretores() {
        return listaDiretores;
    }

    public void setListaDiretores(List<Diretor> listaDiretores) {
        this.listaDiretores = listaDiretores;
    }

    public List<Ator> getListaAtores() {
        return listaAtores;
    }

    public void setListaAtores(ArrayList<Ator> listaAtores) {
        this.listaAtores = listaAtores;
    }

    public List<String> getListaGenero() {return listaGenero;}

    public void setListaGenero(List<String> listaGenero) {this.listaGenero = listaGenero;}

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public void adicionarAtor(Ator ator) {
        listaAtores.add(ator);
    }
    public void adicionarGenero(String genero) {
        listaGenero.add(genero);
    }


    public void removerAtor(Ator ator) {
        listaAtores.remove(ator);
    }

    public boolean nomeContem(String nomePesquisa) {
        return nome.toLowerCase().contains(nomePesquisa.toLowerCase());
    }

    public void adicionarDiretor(Diretor diretor) {
        listaDiretores.add(diretor);
    }


    public void removerDiretor(Diretor diretor) {
        listaDiretores.remove(diretor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(nome, filme.nome) && Objects.equals(dataLancamento, filme.dataLancamento) && Objects.equals(orcamento, filme.orcamento) && Objects.equals(descricao, filme.descricao) && Objects.equals(listaDiretores, filme.listaDiretores) && Objects.equals(listaAtores, filme.listaAtores) && Objects.equals(listaGenero, filme.listaGenero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataLancamento, orcamento, descricao, listaGenero,listaDiretores, listaAtores);
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", dataLancamento='" + dataLancamento + '\'' +
                ", orcamento=" + orcamento +
                ", descricao='" + descricao + '\'' +
                ", genero=" + listaGenero + '\''+
                ", diretores=" + listaDiretores +
                ", atores=" + listaAtores +
                '}';
    }

}
