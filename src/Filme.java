import java.util.ArrayList;
import java.util.List;

public class Filme {
    private String nome;
    private String dataLancamento;
    private Double orcamento;
    private String descricao;
    private Diretor diretor;
    private List<ator> atores;

    public Filme(String nome, String dataLancamento, Double orcamento, String descricao, Diretor diretor, List<ator> atores) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.diretor = diretor;
        this.atores = new ArrayList<>();
    }

    public void adicionarAtor(Ator ator) {
        atores.add(ator);
    }

    public String getNome() {
        return nome;
    }

    // Método para pesquisar filme pelo nome (ignorando maiúsculas/minúsculas)
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
                ", atores=" + atores +
                '}';
    }

}
