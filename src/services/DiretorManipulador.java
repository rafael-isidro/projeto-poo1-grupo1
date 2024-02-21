package services;

import entities.Diretor;
import entities.Filme;

import java.util.List;
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
            adicionarAreaAtuacao(listaAreas);

            System.out.println("Áreas adicionadas com sucesso.");
            filme.adicionarDiretor(new Diretor(nome, listaAreas));
        }

    }

    private List<String> adicionarAreaAtuacao(List<String> listaAreas) {

        while (true) {
            System.out.print("Informe uma área de atuação a adicionar ou tecle enter sem digitar nada para sair: ");
            String area = sc.nextLine();
            System.out.println();

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

    public void editarDiretores(Filme filme) {
        List<Diretor> diretores = filme.getListaDiretores();
        if (diretores.isEmpty()) {
            System.out.println("O filme não tem diretores cadastrados.\n");
            return;
        }

        while (true) {
            System.out.println("Digite o número do diretor a editar:\n");

            int numero = listarELerOpcao(diretores);
            if (numero == 0) {
                break;
            }

            try {
                this.editarDiretor(diretores.get(numero - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Número inválido, tente novamente.\n");
            }
        }
    }

    private void editarDiretor(Diretor diretor) {
        String apresentacao = """
                >>>> Menu - Edição de Diretor <<<<
                      1 - Editar Nome;
                      2 - Editar Areas de atuação;
                      0 - Sair.
                """;
        while (true) {
            System.out.println("Diretor");
            System.out.println("  Nome: " + diretor.getNome());

            System.out.println("  Areas de atuação:\n");
            if (diretor.getListaAreas().isEmpty()) {
                System.out.println("O Diretor não possui área de atuação cadastrada.");
            } else {
                for (String area : diretor.getListaAreas()) {
                    System.out.printf("  - %s%n", area);
                }
                System.out.println();
            }

            System.out.println(apresentacao);

            System.out.print("> ");
            char opcao = sc.nextLine().charAt(0);
            System.out.println();

            switch (opcao) {
                case '1':
                    editarNome(diretor);
                    break;
                case '2':
                    editarAreas(diretor);
                    break;
                case '0':
                    return;
            }

        }
    }

    private void editarAreas(Diretor diretor) {
        while (true) {
            System.out.println("Tecle enter sem digitar nada para sair.");
            String apresentacaoAreas = """
                    >>>> Menu - Edição de áreas de atuação <<<<
                          1 - Adicionar área;
                          2 - Remover área;
                          0 - Sair.
                    """;
            System.out.println(apresentacaoAreas);
            System.out.print("> ");
            char opcao = sc.nextLine().charAt(0);
            System.out.println();

            switch (opcao) {
                case '1':
                    List<String> listaAreasAtualizada = adicionarAreaAtuacao(diretor.getListaAreas());
                    diretor.setListaAreas(listaAreasAtualizada);
                    break;
                case '2':
                    deletarArea(diretor);
                    break;
                case '0':
                    return;
            }
        }
    }

    private void deletarArea(Diretor diretor) {
        List<String> listaAreasDoDiretor = diretor.getListaAreas();

        while (true) {
            if (listaAreasDoDiretor.isEmpty()) {
                System.out.println("O diretor não possui áreas de atuação cadastradas.\n");
                return;
            }

            int numero = listarELerOpcao(listaAreasDoDiretor);
            System.out.println("Digite o número da área a deletar:\n");

            if (numero == 0) {
                break;
            }
            try {
                String area = listaAreasDoDiretor.remove(numero - 1);
                System.out.printf("Área %s removida com sucesso.%n%n", area);
                diretor.setListaAreas(listaAreasDoDiretor);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Número inválido, tente novamente.\n");
            }
        }
    }

    private void editarNome(Diretor diretor) {
        System.out.println("Tecle enter sem digitar nada para sair.");
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.println();

        if (nome.isBlank()) {
            return;
        }
        diretor.setNome(nome);
    }


    public void deletarDiretor(Filme filme) {
        List<Diretor> diretores = filme.getListaDiretores();

        while (true) {
            if (diretores.isEmpty()) {
                System.out.println("O filme não tem diretores cadastrados.\n");
                return;
            }

            System.out.println("Digite o número do diretor a deletar:\n");

            int numero = listarELerOpcao(diretores);
            if (numero == 0) {
                break;
            }
            try {
                Diretor diretor = diretores.remove(numero - 1);
                System.out.printf("Diretor %s removido com sucesso.%n%n", diretor.getNome());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Número inválido, tente novamente.\n");
            }
        }
    }

    private int listarELerOpcao(List<?> lista) {
        System.out.println("número | nome");
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("%6d - %s;%n", i + 1, lista.get(i) instanceof Diretor ? ((Diretor) lista.get(i)).getNome() : lista.get(i));
        }
        System.out.printf("%6d - sair.%n%n", 0);

        int opcao = sc.nextInt();
        sc.nextLine();

        return opcao;
    }
}
