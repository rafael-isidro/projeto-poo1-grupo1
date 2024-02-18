package services;

import entities.Diretor;
import entities.Filme;

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

    private FilmeManipulador(Scanner sc) {
        this.sc = sc;
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
        sc.nextLine(); // Limpar o buffer do Scanner
        System.out.println("Descrição do filme: ");
        String descricao = sc.nextLine();
        Filme novoFilme = new Filme(nome, dataLancamento, orcamento, descricao, new Diretor(), new ArrayList<>());
        filmes.add(novoFilme);
        System.out.println("Filme adicionado com sucesso!");

    }

}

    public void editarFilme(List<Filme> filmes) {
        System.out.println("Por favor, insira o nome do filme que deseja editar:");
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
                        System.out.println("Insira o novo nome:");
                        filme.setNome(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Insira a nova data de lançamento:");
                        filme.setDataLancamento(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("Insira o novo orçamento:");
                        filme.setOrcamento(sc.nextDouble());
                        sc.nextLine(); // Limpar o buffer do Scanner
                        break;
                    case 4:
                        System.out.println("Insira a nova descrição:");
                        filme.setDescricao(sc.nextLine());
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                System.out.println("Filme editado com sucesso!");
                return;
            }
        }
        System.out.println("Filme não encontrado.");
    }

    public void deletarFilme(List<Filme> filmes) {
        System.out.println("Por favor, insira o nome do filme que deseja deletar:");
        String nome = sc.nextLine();

        for (Filme filme : filmes) {
            if (filme.getNome().equals(nome)) {
                filmes.remove(filme);
                System.out.println("Filme deletado com sucesso!");
                return;
            }
        }
        System.out.println("Filme não encontrado.");
    }
}

