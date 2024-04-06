package services;

import entities.Diretor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiretorManipulador {

    private static DiretorManipulador manipulador;

    private List<Diretor> diretores;

    public static DiretorManipulador getManipulador(Scanner sc) {
        if (manipulador == null) {
            manipulador = new DiretorManipulador(sc);
        }
        return manipulador;
    }

    private final Scanner sc;

    private DiretorManipulador(Scanner sc) {
        this.sc = sc;
        this.diretores = new ArrayList<>();
    }

    public void adicionarDiretor() {
        System.out.println(">>>> Inserção de Diretor <<<<");
        System.out.print("Nome do diretor: ");
        String nome = sc.nextLine();

        ArrayList<String> listaAreas = new ArrayList<>();
        adicionarAreaAtuacao(listaAreas);

        System.out.println("Áreas adicionadas com sucesso.");
        Diretor novoDiretor = new Diretor(nome, listaAreas);
        diretores.add(novoDiretor);
        System.out.println("Diretor adicionado com sucesso!\n");
    }

    public void listarDiretores() {
        System.out.println(">>>> Lista de Diretores <<<<");
        for (Diretor diretor : diretores) {
            System.out.println(diretor.getNome());
        }
        System.out.println();
    }

    public void editarDiretor() {
        System.out.println(">>>> Edição de Diretor <<<<");
        listarDiretores();
        System.out.print("Digite o número do diretor a editar: ");
        int numero = Integer.parseInt(sc.nextLine());
        if (numero >= 1 && numero <= diretores.size()) {
            Diretor diretor = diretores.get(numero - 1);
            System.out.print("Novo nome (ou deixe em branco para manter o mesmo): ");
            String novoNome = sc.nextLine();
            if (!novoNome.isBlank()) {
                diretor.setNome(novoNome);
            }
            System.out.println("Diretor editado com sucesso!\n");
        } else {
            System.out.println("Número de diretor inválido.\n");
        }
    }

    public void removerDiretor() {
        System.out.println(">>>> Remoção de Diretor <<<<");
        listarDiretores();
        System.out.print("Digite o número do diretor a remover: ");
        int numero = Integer.parseInt(sc.nextLine());
        if (numero >= 1 && numero <= diretores.size()) {
            Diretor diretorRemovido = diretores.remove(numero - 1);
            System.out.println("Diretor " + diretorRemovido.getNome() + " removido com sucesso!\n");
        } else {
            System.out.println("Número de diretor inválido.\n");
        }
    }

    private List<String> adicionarAreaAtuacao(List<String> listaAreas) {
        while (true) {
            System.out.print("Informe uma área de atuação a adicionar ou tecle enter sem digitar nada para sair: ");
            String area = sc.nextLine();

            if (area.isBlank() && !listaAreas.isEmpty()) {
                System.out.println();
                break;
            }

            if (!area.isBlank()) listaAreas.add(area);
            if (listaAreas.isEmpty()) {
                System.out.println("Ao menos uma área de atuação deve ser informada.");
            }
        }
        return listaAreas;
    }

    public void adicionarDiretores(List<Diretor> listaDiretores) {
    }

}
