package entities;

import java.util.Objects;

public class Diretor extends Pessoa {
    private String area;

    public Diretor(String nome, String area) {
        super(nome);
        this.area = area;
    }

    public Diretor() {

    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diretor diretor = (Diretor) o;
        return Objects.equals(area, diretor.area) && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, area);
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "area='" + area + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

}