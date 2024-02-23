import entities.Filme;
import services.FilmeManipulador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {
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
                          0 - Sair.""";
            System.out.print(apresentacao + "\n> ");
            try {
                char opcao = sc.nextLine().charAt(0);
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
                    case '0':
                        break loopApp;
                    default:
                        System.out.println("Opção inválida.\n");
                }
            } catch (StringIndexOutOfBoundsException ignored) {
            }

        }

        System.out.println("Obrigado por utilizar o programa!");

        System.out.println("""
                Esta aplicação foi desenvolvida no programa Santander Coders aplicado pela Ada Tech no módulo de Programação Orientada a Objetos com os objetivos de fixação de conteúdo e avaliação.
                
                Professor: Vinicius Conceição
                Desenvolvedores:
                    Bruno Samuel da Silva;
                    Fabiola Santana dos Santos;
                    Rafael Santos Isidoro; e
                    Wagner Costa Thomazini.
                Turma: Santander Coders 2023 | 2º Semestre - Java (1)|#1111
                Data: 23 de fevereiro de 2024.""");
        // TODO: Arrumar nome completo de todos

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

}