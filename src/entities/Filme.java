package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Filme {

    private static final DateTimeFormatter LOCAL_DATE_FORMATER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String nome;
    private LocalDate dataLancamento;
    private Double orcamento;
    private String descricao;
    private Duration duracao;
    private final List<Diretor> listaDiretores;
    private final List<Ator> listaAtores;
    private final List<String> listaGeneros;

    public Filme(String nome, LocalDate dataLancamento, Double orcamento, String descricao, Duration duracao, List<Diretor> diretores, List<Ator> atores, List<String> generos) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.duracao = duracao;
        this.listaDiretores = diretores;
        this.listaAtores = atores;
        this.listaGeneros = generos;
    }

    public Filme() {
        this.listaAtores = new ArrayList<>();
        this.listaDiretores = new ArrayList<>();
        this.listaGeneros = new ArrayList<>();
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

    public String getDataLancamentoString() {
        return dataLancamento.format(LOCAL_DATE_FORMATER);
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = LocalDate.parse(dataLancamento, LOCAL_DATE_FORMATER);
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

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public List<Diretor> getListaDiretores() {
        return listaDiretores;
    }

    public List<Ator> getListaAtores() {
        return listaAtores;
    }

    public List<String> getListaGeneros() {
        return listaGeneros;
    }

    public void adicionarAtor(Ator ator) {
        listaAtores.add(ator);
    }

    public void adicionarGenero(String genero) {
        listaGeneros.add(genero);
    }


    public void removerAtor(Ator ator) {
        listaAtores.remove(ator);
    }

    public void removerGenero(String genero) {
        listaGeneros.remove(genero);
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
        return Objects.equals(nome, filme.nome)
                && Objects.equals(dataLancamento, filme.dataLancamento)
                && Objects.equals(orcamento, filme.orcamento)
                && Objects.equals(descricao, filme.descricao)
                && Objects.equals(duracao, filme.duracao)
                && Objects.equals(listaDiretores, filme.listaDiretores)
                && Objects.equals(listaGeneros, filme.listaGeneros)
                && Objects.equals(listaAtores, filme.listaAtores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataLancamento, orcamento, descricao, duracao, listaDiretores, listaAtores, listaGeneros);
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", dataLancamento='" + dataLancamento + '\'' +
                ", orcamento=" + orcamento +
                ", descricao='" + descricao + '\'' +
                ", duracao='" + duracao + '\'' +
                ", diretores=" + listaDiretores +
                ", atores=" + listaAtores +
                ", generos=" + listaGeneros +
                '}';
    }

}
