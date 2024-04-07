import entities.Filme;
import services.FilmeManipulador;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static final DateTimeFormatter LOCAL_DATE_FORMATER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String... args) {
        Locale.setDefault(Locale.ENGLISH);

        Scanner sc = new Scanner(System.in);
        List<Filme> filmes = new ArrayList<>();
        FilmeManipulador filmeManipulador = FilmeManipulador.getManipulador(sc);

        loopApp:
        while (true) {
            String apresentacao = """
                    >>>> Menu <<<<
                          1 - Listar filmes;
                          2 - Adicionar filmes;
                          3 - Editar filmes;
                          4 - Deletar filmes;
                          5 - Listar filmes com detalhes;
                          6 - Pesquisar;
                          7 - Filtrar por duração;
                          8 - Salvar filmes em arquivo CSV;
                          9 - Ler filmes de arquivo CSV;
                          0 - Sair.""";
            System.out.print(apresentacao + "\n> ");
            try {
                char opcao = Character.toUpperCase(sc.nextLine().charAt(0));
                System.out.println();

                switch (opcao) {
                    case '1':
                        listarFilmes(filmes, false);
                        break;
                    case '2':
                        filmeManipulador.adicionarFilme(filmes);
                        break;
                    case '3':
                        filmeManipulador.editarFilme(filmes);
                        break;
                    case '4':
                        filmeManipulador.deletarFilme(filmes);
                        break;
                    case '5':
                        listarFilmes(filmes, true);
                        break;
                    case '6':
                        apresentarOpcoesPesquisa();
                        char opcaoPesquisa = Character.toUpperCase(sc.nextLine().charAt(0));
                        executarPesquisa(opcaoPesquisa);
                        break;
                    case '7':
                        // Implementar filtrar por duração
                        break;
                    case '8':
                        // Implementar salvar em arquivo CSV
                        break;
                    case '9':
                        // Implementar ler de arquivo CSV
                        break;
                    case '0':
                        break loopApp;
                    default:
                        System.out.println("Opção inválida.\n");
                }
            } catch (StringIndexOutOfBoundsException ignored) {
                System.out.println("Digite uma opção válida.\n");
            }

        }

        System.out.println("Obrigado por utilizar o programa!");

        System.out.println("""
                Esta aplicação foi desenvolvida no programa Santander Coders aplicado pela Ada Tech no módulo de Programação Orientada a Objetos com os objetivos de fixação de conteúdo e avaliação.
                
                Professor: Vinicius Conceição
                Desenvolvedores:
                    Bruno Samuel da Silva;
                    Fabiola Santana dos Santos;
                    Rafael Maia
                    Rafael Santos Isidro; e
                    Wagner Costa Thomazini.
                Turma: Santander Coders 2023 | 2º Semestre - Java (1)|#1111
                Data: 08 de abril de 2024.""");

        sc.close();
    }

    private static void listarFilmes(List<? extends Filme> filmes, boolean mostrarDescricao) {
        if (filmes.isEmpty()) {
            System.out.println("Não há filmes cadastrados.\n");
            return;
        }

        System.out.println("Filmes:");
        if (mostrarDescricao) {
            for (Filme f : filmes) {
                System.out.printf("  %s (%s) - %s%n", f.getNome(), f.getDataLancamento(), f.getDescricao());
            }
        } else {
            for (Filme f : filmes) {
                System.out.printf("  %s (%s)%n", f.getNome(), f.getDataLancamento());
            }
        }
        System.out.println();
    }

    private static void apresentarOpcoesPesquisa() {
        System.out.println(">>>> Opções de Pesquisa <<<<");
        System.out.println("A) Por título;");
        System.out.println("B) Por gênero;");
        System.out.println("C) Por ano de lançamento;");
        System.out.println("D) Por atores;");
        System.out.println("E) Por diretor;");
        System.out.print("> ");
    }

    private static void executarPesquisa(char opcaoPesquisa) {
        switch (opcaoPesquisa) {
            case 'A':
                // Implementar pesquisa por título
                break;
            case 'B':
                // Implementar pesquisa por gênero
                break;
            case 'C':
                // Implementar pesquisa por ano de lançamento
                break;
            case 'D':
                // Implementar pesquisa por atores
                break;
            case 'E':
                // Implementar pesquisa por diretor
                break;
            default:
                System.out.println("Opção de pesquisa inválida.\n");
        }
    }
}
