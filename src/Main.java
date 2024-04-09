import entities.Filme;
import serialization.csv.ApplicationCsvSerializer;
import services.BuscadorFilmes;
import services.FilmeManipulador;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static final DateTimeFormatter LOCAL_DATE_FORMATER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String... args) throws InterruptedException{
        Locale.setDefault(Locale.ENGLISH);

        Scanner sc = new Scanner(System.in);
        List<Filme> filmes = new ArrayList<>();
        FilmeManipulador filmeManipulador = FilmeManipulador.getManipulador(sc);
        BuscadorFilmes buscadorFilmes = BuscadorFilmes.getBuscador(sc, filmes);
        ApplicationCsvSerializer serializer = new ApplicationCsvSerializer();
        ApplicationCsvSerializer deserializer = new ApplicationCsvSerializer();
        List<Filme> filmesDoArquivo = deserializer.deserialize();
        System.out.println("Pressione 'C' para carregar os filmes salvos, ou qualquer tecla para continuar");
        if (sc.nextLine().equalsIgnoreCase("c")){
            filmes = filmesDoArquivo;
            System.out.println("Filmes lidos do arquivo CSV com sucesso!");
        }
        loopApp:
        while (true) {
            Thread.sleep(1000);
            String apresentacao = """
                    >>>> Menu <<<<
                          1 - Listar filmes;
                          2 - Adicionar filmes;
                          3 - Editar filmes;
                          4 - Deletar filmes;
                          5 - Pesquisar;
                          6 - Filtrar por duração;
                          0 - Sair.""";
            System.out.print(apresentacao + "\n> ");
            try {
                String opcao = sc.nextLine();

                switch (opcao) {
                    case "1":
                        listarFilmes(filmes, sc);
                        break;
                    case "2":
                        filmeManipulador.adicionarFilme(filmes);
                        break;
                    case "3":
                        filmeManipulador.editarFilme(filmes);
                        break;
                    case "4":
                        filmeManipulador.deletarFilme(filmes);
                        break;
                    case "5":
                        apresentarOpcoesPesquisa();
                        char opcaoPesquisa = Character.toUpperCase(sc.nextLine().charAt(0));
                        executarPesquisa(buscadorFilmes, opcaoPesquisa);
                        break;
                    case "6":
                        buscadorFilmes.filtrarPorDuracao();
                        break;
                    case "0":
                        serializer.serialize(filmes);
                        System.out.println("Filmes salvos em arquivo CSV com sucesso!\n");
                        Thread.sleep(500);
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
                
                Professor: Jesse Haniel
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

    private static void listarFilmes(List<? extends Filme> filmes, Scanner sc) {
        if (filmes.isEmpty()) {
            System.out.println("Não há filmes cadastrados.\n");
            return;
        }
        System.out.println("""
                            Qual o modo de exibição?
                            1 - Resumido
                            2 - Detalhado""");
        String opcao = sc.nextLine();
        try{
            switch (opcao){
                case "1":
                    for (Filme f : filmes) {
                        System.out.println(f.gerarDescricaoResumida() + "\n");
                    }
                    break;
                case "2":
                    for (Filme f : filmes) {
                        System.out.println(f.gerarDescricaoCompleta() + "\n");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        } catch (NullPointerException e){
            System.err.println(e.getMessage());
        }

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

    private static void executarPesquisa(BuscadorFilmes buscador, char opcaoPesquisa) {
        switch (opcaoPesquisa) {
            case 'A':
                buscador.buscarPorParteDoTitulo();
                break;
            case 'B':
                buscador.buscarPorGenero();
                break;
            case 'C':
                buscador.buscarPorAnoLancamento();
                break;
            case 'D':
                buscador.buscarPorAtor();
                break;
            case 'E':
                buscador.buscarPorDiretor();
                break;
            default:
                System.out.println("Opção de pesquisa inválida.\n");
        }
    }
}
