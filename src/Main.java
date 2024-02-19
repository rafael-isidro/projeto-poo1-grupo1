import entities.Ator;
import entities.Diretor;
import entities.Filme;
import services.AtorManipulador;
import services.DiretorManipulador;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        AtorManipulador atorManipulador = AtorManipulador.getManipulador(sc);
        DiretorManipulador diretorManipulador = DiretorManipulador.getManipulador(sc);

        ArrayList<Ator> atores = new ArrayList<>();
        ArrayList<Diretor> diretores = new ArrayList<>();

        ArrayList<String> listaAreas = new ArrayList<>();
        listaAreas.add("Comédia");
        listaAreas.add("Aventura");

        diretores.add(new Diretor("Paul Weitz", listaAreas));

        atores.add(new Ator("Jason Biggs", null));
        atores.add(new Ator("Seann William Scott", null));
        Filme americanPie = new Filme("American Pie", "1999/10/29", 11_000_000d, null, diretores, atores);

        atorManipulador.adicionarAtores(americanPie);
        atorManipulador.editarAtores(americanPie);
        atorManipulador.deletarAtor(americanPie);

        diretorManipulador.adicionarDiretores(americanPie);
//        diretorManipulador.editarDiretores(americanPie);
//        diretorManipulador.deletarDiretor(americanPie);
        sc.close();
    }

}