package br.com.alura.literalura.repositorio;


import br.com.alura.literalura.modelo.Livro;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("📭 Nenhum livro registrado.");
        } else {
            livros.forEach(System.out::println);
        }
    }

    public void listarAutores() {
        livros.stream()
                .flatMap(l -> l.getAutores().stream())
                .distinct()
                .forEach(System.out::println);
    }

    public void listarAutoresVivosNoAno(int ano) {
        livros.stream()
                .flatMap(l -> l.getAutores().stream())
                .filter(a -> a.estavaVivoNoAno(ano))
                .distinct()
                .forEach(System.out::println);
    }

    public void listarLivrosPorIdioma(String idioma) {
        livros.stream()
                .filter(l -> l.getIdioma().equalsIgnoreCase(idioma))
                .forEach(System.out::println);
    }
}