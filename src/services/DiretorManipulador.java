package services;

import entities.Diretor;
import entities.Filme;

import java.util.ArrayList;
import java.util.Scanner;

public class DiretorManipulador {

    private static DiretorManipulador manipulador;

    public static DiretorManipulador getManipulador(Scanner sc) {
        if (manipulador == null) {
            manipulador = new DiretorManipulador(sc);
        }
        return manipulador;
    }

    private final Scanner sc;

    private DiretorManipulador(Scanner sc) {
        this.sc = sc;
    }

    public void adicionarDiretores(Filme filme) {
        while (true) {
            System.out.println("Tecle enter sem digitar nada para sair.\n");
            System.out.print("Nome do diretor: ");
            String nome = sc.nextLine();
            if (nome.isBlank()) {
                System.out.println();
                break;
            }

            ArrayList<String> listaAreas = new ArrayList<>();
            while (true) {
                System.out.print("Informe uma área de atuação do diretor ou tecle enter sem digitar nada para sair: ");
                String area = sc.nextLine();
                System.out.println();

                if (area.isBlank() && listaAreas.size() != 0) {
                    System.out.println();
                    break;
                }

                if (!area.isBlank()) listaAreas.add(area);
                if(listaAreas.isEmpty()) {
                    System.out.println("Ao menos uma área de atuação deve ser informada.");
                }
            }

            System.out.println("Áreas adicionadas com sucesso.");
            filme.adicionarDiretor(new Diretor(nome, listaAreas));
        }

    }
    public void editarDiretores(Filme filme) {
        // TODO: lógica de edição aqui
    }

    public void deletarDiretor(Filme filme) {
        // TODO: lógica de deleção aqui
    }

}
