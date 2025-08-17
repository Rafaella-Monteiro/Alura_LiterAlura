package br.com.alura.literalura.modelo;


public class Autor {
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    public Autor(String nome, Integer anoNascimento, Integer anoFalecimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public boolean estavaVivoNoAno(int ano) {
        return (anoNascimento != null && ano >= anoNascimento) &&
                (anoFalecimento == null || ano <= anoFalecimento);
    }

    @Override
    public String toString() {
        return nome + " (" +
                (anoNascimento != null ? anoNascimento : "?") + " - " +
                (anoFalecimento != null ? anoFalecimento : "?") + ")";
    }
}