package services;

import entities.Filme;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BuscadorFilmes {
    private static BuscadorFilmes buscador;
    private final List<Filme> filmes;
    private final Scanner sc;
    private final BuscadorFilmesPorCaracteristica buscadorPorCaracteristica;

    private BuscadorFilmes(Scanner sc, List<Filme> filmes) {
        this.sc = sc;
        this.filmes = filmes;
        this.buscadorPorCaracteristica = BuscadorFilmesPorCaracteristica.getBuscador();
    }

    public static BuscadorFilmes getBuscador(Scanner sc, List<Filme> filmes) {
        if (buscador == null) {
            buscador = new BuscadorFilmes(sc, filmes);
        }
        return buscador;
    }



    public void buscarPorParteDoTitulo() {
        if (checarExistenciaFilmes()) {
            System.out.println("Lista de filmes vazia. Adicione filmes para realizar busca.");
            return;
        }
        System.out.println("Digite a parte do título que deseja buscar: ");
        String parteTitulo = sc.nextLine();

        List<Filme> filmesEncontrados = buscadorPorCaracteristica.buscarPorParteDoTitulo(parteTitulo, this.filmes);
        checarEMostrarResultado(filmesEncontrados, "Nenhum filme encontrado com a parte do título fornecida.");
    }

    public void buscarPorGenero() {
        if (checarExistenciaFilmes()) {
            System.out.println("Lista de filmes vazia. Adicione filmes para realizar busca.");
            return;
        }
        System.out.println("Digite o gênero que deseja buscar: ");
        String genero = sc.nextLine();

        List<Filme> filmesEncontrados = buscadorPorCaracteristica.buscarPorGenero(genero, this.filmes);
        checarEMostrarResultado(filmesEncontrados, "Nenhum filme encontrado com o gênero fornecido.");
    }

    public void buscarPorAnoLancamento() {
        if (checarExistenciaFilmes()) {
            System.out.println("Lista de filmes vazia. Adicione filmes para realizar busca.");
            return;
        }
        System.out.println("Digite o ano de lançamento que deseja buscar: ");
        int anoLancamento = sc.nextInt();
        sc.nextLine();

        List<Filme> filmesEncontrados = buscadorPorCaracteristica.buscarPorAnoLancamento(anoLancamento, this.filmes);
        checarEMostrarResultado(filmesEncontrados, "Nenhum filme encontrado com o ano de lançamento fornecido.");
    }

    public void buscarPorAtor() {
        if (checarExistenciaFilmes()) {
            System.out.println("Lista de filmes vazia. Adicione filmes para realizar busca.");
            return;
        }
        System.out.println("Digite o nome do ator que deseja buscar: ");
        String nomeAtor = sc.nextLine();

        List<Filme> filmesEncontrados = buscadorPorCaracteristica.buscarPorAtor(nomeAtor, this.filmes);
        checarEMostrarResultado(filmesEncontrados, "Nenhum filme encontrado com o ator fornecido.");
    }

    public void buscarPorDiretor() {
        if (checarExistenciaFilmes()) {
            System.out.println("Lista de filmes vazia. Adicione filmes para realizar busca.");
            return;
        }
        System.out.println("Digite o nome do diretor que deseja buscar: ");
        String nomeDiretor = sc.nextLine();

        List<Filme> filmesEncontrados = buscadorPorCaracteristica.buscarPorDiretor(nomeDiretor, this.filmes);
        checarEMostrarResultado(filmesEncontrados, "Nenhum filme encontrado com o diretor fornecido.");
    }

    public void filtrarPorDuracao() {
        if (checarExistenciaFilmes()) {
            System.out.println("Lista de filmes vazia. Adicione filmes para realizar busca.");
            return;
        }
        System.out.println("Digite a duração máxima que deseja buscar (no formato HH:MM:SS): ");
        String duracaoStr = sc.nextLine();

        Duration duracao;
        try {
            duracao = Duration.parse("PT" + duracaoStr);
        } catch (Exception e) {
            System.out.println("Formato de duração inválido.");
            return;
        }

        List<Filme> filmesEncontrados = buscadorPorCaracteristica.filtrarPorDuracao(duracao, this.filmes);
        checarEMostrarResultado(filmesEncontrados, "Nenhum filme encontrado com duração menor do que a fornecida.");
    }

    public boolean checarExistenciaFilmes() {
        return this.filmes.isEmpty();
    }

    public void checarEMostrarResultado(List<Filme> filmesEncontrados, String mensagemNaoEncontrado) {
        Optional<List<Filme>> resultadoBusca = filmesEncontrados.isEmpty() ? Optional.empty() : Optional.of(filmesEncontrados);
        resultadoBusca.ifPresentOrElse(
                filmesEncontradosResultado -> {
                    System.out.println("Filmes encontrados:");
                    filmesEncontradosResultado.forEach(System.out::println);
                },
                () -> System.out.println(mensagemNaoEncontrado)
        );
    }
}
