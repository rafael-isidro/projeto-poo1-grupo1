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

    private FilmeManipulador(Scanner sc) {
        this.sc = sc;
    }

    public void adicionarFilme(List<Filme> filmes) {
        // TODO: lógica de adição aqui
    }

    public void editarFilme(List<Filme> filmes) {
        // TODO: lógica de edição aqui
    }

    public void deletarFilme(List<Filme> filmes) {
        // TODO: lógica de deleção aqui
    }

}
