package services;

import entities.Ator;
import entities.Filme;

import java.util.List;
import java.util.Scanner;

public class AtorManipulador {

    private static AtorManipulador manipulador;

    public static AtorManipulador getManipulador(Scanner sc) {
        if (manipulador == null) {
            manipulador = new AtorManipulador(sc);
        }
        return manipulador;
    }

    private final Scanner sc;

    private AtorManipulador(Scanner sc) {
        this.sc = sc;
    }

    public void adicionarAtores(Filme filme) {
        while (true) {
            System.out.println("Tecle enter sem digitar nada para sair.\n");
            System.out.print("Nome do ator: ");
            String nome = sc.nextLine();
            if (nome.isBlank()) {
                System.out.println();
                break;
            }

            System.out.print("CPF do ator: ");
            String cpf = sc.nextLine();
            System.out.println();

            filme.adicionarAtor(new Ator(nome, cpf));
        }

    }

    public void editarAtores(Filme filme) {
        List<Ator> atores = filme.getListaAtores();
        if (atores.isEmpty()) {
            System.out.println("O filme não tem atores cadastrados.\n");
            return;
        }

        while (true) {
            System.out.println("Digite o número do ator a editar:\n");

            int numero = listarELerOpcao(atores);
            if (numero == 0) {
                break;
            }

            try {
                this.editarAtor(atores.get(numero - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Número inválido, tente novamente.\n");
            }
        }
    }

    private void editarAtor(Ator ator) {
        String apresentacao = """
                >>>> Menu - Edição de Ator <<<<
                      1 - Editar Nome;
                      2 - Editar CPF;
                      0 - Sair.
                """;
        while (true) {
            System.out.println("Ator");
            System.out.println("  Nome: " + ator.getNome());
            System.out.println("  CPF: " + ator.getCpf() + '\n');
            System.out.println(apresentacao);

            System.out.print("> ");
            char opcao = sc.nextLine().charAt(0);
            System.out.println();

            switch (opcao) {
                case '1':
                    editarNome(ator);
                    break;
                case '2':
                    editarCpf(ator);
                    break;
                case '0':
                    return;
            }

        }
    }

    private void editarNome(Ator ator) {
        System.out.println("Tecle enter sem digitar nada para sair.");
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.println();

        if (nome.isBlank()) {
            return;
        }
        ator.setNome(nome);
    }

    private void editarCpf(Ator ator) {
        System.out.println("Tecle enter sem digitar nada para sair.");
        System.out.print("Novo CPF: ");
        String cpf = sc.nextLine();
        System.out.println();

        if (cpf.isBlank()) {
            return;
        }
        ator.setCpf(cpf);
    }

    public void deletarAtor(Filme filme) {
        List<Ator> atores = filme.getListaAtores();

        while (true) {
            if (atores.isEmpty()) {
                System.out.println("O filme não tem atores cadastrados.\n");
                return;
            }

            System.out.println("Digite o número do ator a deletar:\n");

            int numero = listarELerOpcao(atores);
            if (numero == 0) {
                break;
            }
            try {
                Ator ator = atores.remove(numero - 1);
                System.out.printf("Ator %s removido com sucesso.%n%n", ator.getNome());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Número inválido, tente novamente.\n");
            }
        }
    }

    private int listarELerOpcao(List<Ator> atores) {
        System.out.println("número | nome");
        for (int i = 0; i < atores.size(); i++) {
            System.out.printf("%6d - %s;%n", i + 1, atores.get(i).getNome());
        }
        System.out.printf("%6d - sair.%n%n", 0);

        int opcao = sc.nextInt();
        sc.nextLine();

        return opcao;
    }

}
