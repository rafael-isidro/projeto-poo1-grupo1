package entities;

import java.util.Objects;

public class Diretor extends Pessoa {
    private long id;
    private String area;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Diretor(String nome, String area) {
        super(nome);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "nome='" + super.getNome() + '\'' +
                "area='" + area + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diretor diretor = (Diretor) o;
        return id == diretor.id && area.equals(diretor.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area);
    }
}