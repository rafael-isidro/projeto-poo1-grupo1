package services;

import entities.Filme;
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
        // TODO: lógica de adição aqui
    }

    public void editarDiretores(Filme filme) {
        // TODO: lógica de edição aqui
    }

    public void deletarDiretor(Filme filme) {
        // TODO: lógica de deleção aqui
    }

}
