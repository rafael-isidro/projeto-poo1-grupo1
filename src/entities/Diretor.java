package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Diretor extends Pessoa {
    private List<String> listaAreas;

    public Diretor(String nome, List<String> listaAreas) {
        super(nome);
        this.listaAreas = listaAreas;
    }

    public Diretor() {
        this.listaAreas = new ArrayList<>();
    }

    public List<String> getListaAreas() {
        return listaAreas;
    }

    public void setListaAreas(List<String> listaAreas) {
        this.listaAreas = listaAreas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Diretor diretor = (Diretor) o;
        return Objects.equals(listaAreas, diretor.listaAreas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, listaAreas);
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "listaAreas=" + listaAreas +
                ", nome='" + nome + '\'' +
                '}';
    }
}