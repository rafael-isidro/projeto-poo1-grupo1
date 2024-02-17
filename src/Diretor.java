class Diretor extends Pessoa {
    private int quantidadeFilmesDirigidos;

    public Diretor(String nome, int idade, String nacionalidade, int quantidadeFilmesDirigidos) {
        super(nome, idade, nacionalidade);
        this.quantidadeFilmesDirigidos = quantidadeFilmesDirigidos;
    }

     public int getQuantidadeFilmesDirigidos() {
        return quantidadeFilmesDirigidos;
    }

    public void setQuantidadeFilmesDirigidos(int quantidadeFilmesDirigidos) {
        this.quantidadeFilmesDirigidos = quantidadeFilmesDirigidos;
    }
}
