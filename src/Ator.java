class Ator extends Pessoa {
    private String papel;

    public Ator(String nome, int idade, String nacionalidade, String papel) {
        super(nome, idade, nacionalidade);
        this.papel = papel;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }
}


