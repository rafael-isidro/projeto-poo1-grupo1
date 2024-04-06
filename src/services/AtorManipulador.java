package services;

import entities.Ator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtorManipulador {

    private static AtorManipulador manipulador;

    // Lista geral de atores
    private List<Ator> atores;

    public static AtorManipulador getManipulador(Scanner sc) {
        if (manipulador == null) {
            manipulador = new AtorManipulador(sc);
        }
        return manipulador;
    }

    private final Scanner sc;

    private AtorManipulador(Scanner sc) {
        this.sc = sc;
        this.atores = new ArrayList<>();
    }

    public void adicionarAtor() {
        System.out.println(">>>> Inserção de Ator <<<<");
        System.out.print("Nome do ator: ");
        String nome = sc.nextLine();

        System.out.print("CPF do ator: ");
        String cpf = sc.nextLine();

        Ator novoAtor = new Ator(nome, cpf);
        atores.add(novoAtor);
        System.out.println("Ator adicionado com sucesso!\n");
    }

    public void listarAtores() {
        System.out.println(">>>> Lista de Atores <<<<");
        for (Ator ator : atores) {
            System.out.println(ator.getNome() + " - " + ator.getCpf());
        }
        System.out.println();
    }

    public void editarAtor() {
        System.out.println(">>>> Edição de Ator <<<<");
        listarAtores();
        System.out.print("Digite o número do ator a editar: ");
        int numero = Integer.parseInt(sc.nextLine());
        if (numero >= 1 && numero <= atores.size()) {
            Ator ator = atores.get(numero - 1);
            System.out.print("Novo nome (ou deixe em branco para manter o mesmo): ");
            String novoNome = sc.nextLine();
            if (!novoNome.isBlank()) {
                ator.setNome(novoNome);
            }
            System.out.print("Novo CPF (ou deixe em branco para manter o mesmo): ");
            String novoCpf = sc.nextLine();
            if (!novoCpf.isBlank()) {
                ator.setCpf(novoCpf);
            }
            System.out.println("Ator editado com sucesso!\n");
        } else {
            System.out.println("Número de ator inválido.\n");
        }
    }

    public void removerAtor() {
        System.out.println(">>>> Remoção de Ator <<<<");
        listarAtores();
        System.out.print("Digite o número do ator a remover: ");
        int numero = Integer.parseInt(sc.nextLine());
        if (numero >= 1 && numero <= atores.size()) {
            Ator atorRemovido = atores.remove(numero - 1);
            System.out.println("Ator " + atorRemovido.getNome() + " removido com sucesso!\n");
        } else {
            System.out.println("Número de ator inválido.\n");
        }
    }

    public void adicionarAtores(List<Ator> listaAtores) {
    }
}
