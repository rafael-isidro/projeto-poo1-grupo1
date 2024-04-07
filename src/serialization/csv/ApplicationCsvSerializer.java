package serialization.csv;

import entities.Filme;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplicationCsvSerializer {

    private final static String FILMES_PATH = "./filmes.csv";
    private final FilmeCsvSerializer filmeCsvSerializer;

    public ApplicationCsvSerializer() {
        // Cuidar para não utilizar separadores utilizados em expressões regulares
        this.filmeCsvSerializer = new FilmeCsvSerializer(";", ",", "@", "%");
    }

    public void serialize(List<Filme> filmes) {
        try (BufferedWriter  writer = new BufferedWriter(new FileWriter(FILMES_PATH))) {
            String strArquivo = filmes.stream()
                    .map(filmeCsvSerializer::serialize)
                    .collect(Collectors.joining("\n"));
            writer.write(strArquivo);
            writer.newLine();

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo. O dados não foram salvos: " + e.getMessage());
        }
    }

    public List<Filme> deserialize() {
        try (Stream<String> lines = Files.lines(Paths.get(FILMES_PATH))) {
            return lines
                    .map(filmeCsvSerializer::deserialize)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (NoSuchFileException e) {
            System.out.println("O arquivo não existe");
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
