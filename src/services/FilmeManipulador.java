package services;

import entities.Ator;
import entities.Diretor;
import entities.Filme;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmeManipulador {
    private static FilmeManipulador manipulador;

    public static FilmeManipulador getManipulador(Scanner sc) {
        if (manipulador == null) {
            manipulador = new FilmeManipulador(sc);
        }
        return manipulador;
    }

    private final Scanner sc;
    private final DiretorManipulador diretorManipulador;
    private final AtorManipulador atorManipulador;
    private final List<Diretor> diretores;
    private final List<Ator> atores;


    private FilmeManipulador(Scanner sc) {
        this.sc = sc;
        this.diretores = new ArrayList<>();
        this.atores = new ArrayList<>();
        this.diretorManipulador = DiretorManipulador.getManipulador(sc);
        this.atorManipulador = AtorManipulador.getManipulador(sc);
    }


    public void adicionarFilme(List<Filme> filmes) {
        while (true) {
            System.out.println("Tecle enter sem digitar nada para sair.\n");
            System.out.print("Nome do filme: ");
            String nome = sc.nextLine();
            if (nome.isBlank()) {
                System.out.println();
                break;
            }

            System.out.print("Lançamento do filme (formato: YYYY-MM-DD): ");
            String dataLancamentoStr = sc.nextLine();
            System.out.print("Orçamento do filme: ");
            double orcamento = sc.nextDouble();
            sc.nextLine();
            System.out.print("Descrição do filme: ");
            String descricao = sc.nextLine();
            System.out.print("Duração do filme (em minutos): ");
            long duracaoEmMinutos = sc.nextLong();
            Duration duracao = Duration.ofMinutes(duracaoEmMinutos);
            Filme filme = new Filme();
            filme.setNome(nome);
            filme.setDataLancamento(LocalDate.parse(dataLancamentoStr));
            filme.setDescricao(descricao);
            filme.setOrcamento(orcamento);
            filme.setDuracao(duracao);
            System.out.println();


            diretorManipulador.adicionarDiretores(filme, diretores);
            atorManipulador.adicionarAtores(filme, atores);

            filmes.add(filme);
            System.out.println("Filme adicionado com sucesso!");

        }
    }

    public void editarFilme(List<Filme> filmes) {
        if (filmes.isEmpty()) {
            System.out.println("Não tem filmes cadastrados.\n");
            return;
        }

        while (true) {
            System.out.print("Digite o número do ator a editar: ");

            int numero = listarELerOpcao(filmes);
            if (numero == 0) {
                break;
            }

            try {
                this.editarFilme(filmes.get(numero - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Número inválido, tente novamente.\n");
            }
        }

    }

    private void editarFilme(Filme filme) {
        String apresentacao = """
                >>>> Menu - Edição de Filme <<<<
                      1 - Editar Nome;
                      2 - Editar data de lançamento;
                      3 - Editar orçamento;
                      4 - Editar descrição;
                      5 - Editar genero;
                      6 - Editar duração;              
                      0 - Sair.
                """;
        while (true) {
            System.out.println("Filme");
            System.out.println("  Nome: " + filme.getNome());
            System.out.println("  Data de lançamento: " + filme.getDataLancamento());
            System.out.println("  Orçamento: " + filme.getOrcamento());
            System.out.println("  Descrição: " + filme.getDescricao());
            System.out.println("  Genero: " + filme.getListaGenero());
            System.out.println("  Duração: " + filme.getDuracao());
            System.out.println(apresentacao);

            System.out.print("> ");
            char opcao = sc.nextLine().charAt(0);
            sc.nextLine();

            switch (opcao) {
                case '1':
                    editarNome(filme);
                    break;
                case '2':
                    editarDataLancamento(filme);
                    break;
                case '3':
                    editarOrcamento(filme);
                    break;
                case '4':
                    editarDescricao(filme);
                    break;
                case '5':
                    editarGenero(filme);
                    break;
                case '6':
                    editarDuracao(filme);
                    break;
                case '0':
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("Filme editado com sucesso!");
        }
    }

    private void editarDuracao(Filme filme) {
        System.out.print("Insira a nova duração do filme (em minutos): ");
        long novaDuracaoEmMinutos = sc.nextLong();
        Duration novaDuracao = Duration.ofMinutes(novaDuracaoEmMinutos);
        filme.setDuracao(novaDuracao);
    }


    private void editarNome(Filme filme) {
        System.out.print("Insira o novo nome: ");
        String novoNome = sc.nextLine();
        filme.setNome(novoNome);
    }

    private void editarDataLancamento(Filme filme) {
        System.out.print("Insira a nova data de lançamento (no formato YYYY-MM-DD): ");
        String novaDataLancamentoInput = sc.nextLine();
        LocalDate novaDataLancamento = LocalDate.parse(novaDataLancamentoInput, DateTimeFormatter.ISO_LOCAL_DATE);
        filme.setDataLancamento(novaDataLancamento);
    }

    private void editarOrcamento(Filme filme) {
        System.out.print("Insira o novo orçamento: ");
        double novoOrcamento = sc.nextDouble();
        sc.nextLine(); // Limpar o buffer do Scanner
        filme.setOrcamento(novoOrcamento);
    }

    private void editarDescricao(Filme filme) {
        System.out.print("Insira a nova descrição: ");
        String novaDescricao = sc.nextLine();
        filme.setDescricao(novaDescricao);
    }

    private void editarGenero(Filme filme) {
        System.out.println("Insira o novo gênero: ");
        String novoGenero = sc.nextLine();;
        filme.adicionarGenero(novoGenero);
    }

    public void deletarFilme(List<Filme> filmes) {

        while (true) {
            if (filmes.isEmpty()) {
                System.out.println("Não tem filmes cadastrados.\n");
                return;
            }

            System.out.print("Digite o número do filme a deletar:");

            int numero = listarELerOpcao(filmes);
            if (numero == 0) {
                break;
            }
            try {
                Filme filme = filmes.remove(numero - 1);
                System.out.printf("Filme %s removido com sucesso.%n%n", filme.getNome());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Número inválido, tente novamente.\n");
            }

        }
    }

    private int listarELerOpcao(List<Filme> filmes) {
        System.out.println("número | nome");
        for (int i = 0; i < filmes.size(); i++) {
            System.out.printf("%6d - %s;%n", i + 1, filmes.get(i).getNome());
        }
        System.out.printf("%6d - sair.%n%n", 0);

        int opcao = sc.nextInt();
        sc.nextLine();

        return opcao;
    }
}


