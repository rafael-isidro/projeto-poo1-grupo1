package services;

import entities.Filme;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BuscadorFilmesPorCaracteristica {
    private static BuscadorFilmesPorCaracteristica buscador;

    public BuscadorFilmesPorCaracteristica() {
    }

    public static BuscadorFilmesPorCaracteristica getBuscador() {
        if (buscador == null) {
            buscador = new BuscadorFilmesPorCaracteristica();
        }
        return buscador;
    }

    public List<Filme> buscarPorParteDoTitulo(String parteTitulo, List<Filme> filmes) {
        return filmes.stream()
                .filter(filme -> filme.getNome().toLowerCase().contains(parteTitulo.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Filme> buscarPorGenero(String genero, List<Filme> filmes) {
        return filmes.stream()
                .filter(filme -> filme.getListaGeneros().stream()
                        .anyMatch(elem -> elem.equalsIgnoreCase(genero)))
                .collect(Collectors.toList());
    }

    public List<Filme> buscarPorAnoLancamento(Integer anoLancamento, List<Filme> filmes) {
        return filmes.stream()
                .filter(filme -> anoLancamento.equals(filme.getDataLancamento().getYear()))
                .collect(Collectors.toList());
    }

    public List<Filme> buscarPorAtor(String nomeAtor, List<Filme> filmes) {
        return filmes.stream()
                .filter(filme -> filme.getListaAtores().stream()
                        .anyMatch(elem -> elem.getNome().toLowerCase().contains(nomeAtor.toLowerCase())))
                .collect(Collectors.toList());
    }

    public List<Filme> buscarPorDiretor(String nomeDiretor, List<Filme> filmes) {
        return filmes.stream()
                .filter(filme -> filme.getListaDiretores().stream()
                        .anyMatch(elem -> elem.getNome().toLowerCase().contains(nomeDiretor.toLowerCase())))
                .collect(Collectors.toList());
    }

    public List<Filme> filtrarPorDuracao(Duration duracaoMaxima, List<Filme> filmes) {
        return filmes.stream()
                .filter(filme -> filme.getDuracao().compareTo(duracaoMaxima) <= 0)
                .collect(Collectors.toList());
    }
}
