package entities;
import java.util.List;
import java.util.Objects;
public class Filme {
    private String nome;
    private String dataLancamento;
    private Double orcamento;
    private String descricao;
    private Diretor diretor;
    private List<Ator> listaAtores;

    public Filme(String nome, String dataLancamento, Double orcamento, String descricao, Diretor diretor, List<Ator> atores) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.diretor = diretor;
        this.listaAtores = atores;
    }
    public Filme(){

    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
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

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<Ator> getListaAtores() {
        return listaAtores;
    }

    public void setListaAtores(List<Ator> listaAtores) {
        this.listaAtores = listaAtores;
    }


    public void adicionarAtor(Ator ator) {
        listaAtores.add(ator);
    }


    public void removerAtor(Ator ator) {
        listaAtores.remove(ator);

    }

    public boolean nomeContem(String nomePesquisa) {
        return nome.toLowerCase().contains(nomePesquisa.toLowerCase());
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", dataLancamento='" + dataLancamento + '\'' +
                ", orcamento=" + orcamento +
                ", descricao='" + descricao + '\'' +
                ", diretor=" + diretor +
                ", atores=" + listaAtores +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(nome, filme.nome) && Objects.equals(dataLancamento, filme.dataLancamento) && Objects.equals(orcamento, filme.orcamento) && Objects.equals(descricao, filme.descricao) && Objects.equals(diretor, filme.diretor) && Objects.equals(listaAtores, filme.listaAtores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataLancamento, orcamento, descricao, diretor, listaAtores);
    }
}
