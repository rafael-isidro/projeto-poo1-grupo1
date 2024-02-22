package services;

import entities.Filme;

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


    private FilmeManipulador(Scanner sc) {
        this.sc = sc;
        this.diretorManipulador = DiretorManipulador.getManipulador(sc);
        this.atorManipulador = AtorManipulador.getManipulador(sc);
    }

    public void adicionarFilme(List<Filme> filmes) {
        while (true) {
            System.out.println("Tecle enter sem digitar nada para sair.\n");
            System.out.println("Nome do filme: ");
            String nome = sc.nextLine();
            if (nome.isBlank()) {
                System.out.println();
                break;
            }

            System.out.println("Lançamento do filme: ");
            String dataLancamento = sc.nextLine();
            System.out.println("Orçamento do filme: ");
            double orcamento = sc.nextDouble();
            sc.nextLine();
            System.out.println("Descrição do filme: ");
            String descricao = sc.nextLine();
            Filme filme = new Filme();
            filme.setNome(nome);
            filme.setDataLancamento(dataLancamento);
            filme.setDescricao(descricao);
            filme.setOrcamento(orcamento);
            diretorManipulador.adicionarDiretores(filme);
            atorManipulador.adicionarAtores(filme);
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
            System.out.println("Digite o nome do filme que deseja editar:\n");
            String nome = sc.nextLine();

            for (Filme filme : filmes) {
                if (filme.getNome().equals(nome)) {
                    System.out.println("O que você deseja editar?");
                    System.out.println("1. Nome");
                    System.out.println("2. Data de Lançamento");
                    System.out.println("3. Orçamento");
                    System.out.println("4. Descrição");
                    int escolha = sc.nextInt();
                    sc.nextLine();

                    switch (escolha) {
                        case 1:
                            editarNome(filme);
                            break;
                        case 2:
                            editarDataLancamento(filme);
                            break;
                        case 3:
                            editarOrcamento(filme);
                            break;
                        case 4:
                            editarDescricao(filme);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    System.out.println("Filme editado com sucesso!");
                    break;
                }
            }
            System.out.println("Deseja editar outro filme? (S/N)");
            String resposta = sc.nextLine();
            if (!resposta.equalsIgnoreCase("S")) {
                break;
            }
        }
    }

    private void editarNome(Filme filme) {
        System.out.println("Insira o novo nome:");
        String novoNome = sc.nextLine();
        filme.setNome(novoNome);
    }

    private void editarDataLancamento(Filme filme) {
        System.out.println("Insira a nova data de lançamento:");
        String novaDataLancamento = sc.nextLine();
        filme.setDataLancamento(novaDataLancamento);
    }

    private void editarOrcamento(Filme filme) {
        System.out.println("Insira o novo orçamento:");
        double novoOrcamento = sc.nextDouble();
        sc.nextLine(); // Limpar o buffer do Scanner
        filme.setOrcamento(novoOrcamento);
    }

    private void editarDescricao(Filme filme) {
        System.out.println("Insira a nova descrição:");
        String novaDescricao = sc.nextLine();
        filme.setDescricao(novaDescricao);
    }

    public void deletarFilme(List<Filme> filmes) {

        while (true) {
            if (filmes.isEmpty()) {
                System.out.println("Não tem filmes cadastrados.\n");
                return;
            }

            System.out.println("Digite o número do filme a deletar:\n");

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


