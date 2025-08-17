package br.com.alura.literalura.modelo;


import java.util.List;

public class Livro {
    private String titulo;
    private List<Autor> autores;
    private String idioma;
    private int numeroDownloads;

    public Livro(String titulo, List<Autor> autores, String idioma, int numeroDownloads) {
        this.titulo = titulo;
        this.autores = autores;
        this.idioma = idioma;
        this.numeroDownloads = numeroDownloads;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getNumeroDownloads() {
        return numeroDownloads;
    }

    @Override
    public String toString() {
        return "📖 Título: " + titulo +
                "\n   Idioma: " + idioma +
                "\n   Downloads: " + numeroDownloads +
                "\n   Autor(es): " + autores;
    }
}