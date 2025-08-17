package br.com.alura.literalura;


import br.com.alura.literalura.modelo.Livro;
import br.com.alura.literalura.repositorio.Biblioteca;
import br.com.alura.literalura.servico.ConsumoApi;
import br.com.alura.literalura.servico.ConversorJson;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String ENDERECO_API = "https://gutendex.com/books/?search=";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        ConsumoApi consumoApi = new ConsumoApi();
        ConversorJson conversor = new ConversorJson();

        while (true) {
            System.out.println("""
                📚 Menu Literalura
                1 - Buscar livro por título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em um determinado ano
                5 - Listar livros por idioma
                0 - Sair
                """);

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();
                    String json = consumoApi.obterDados(ENDERECO_API + titulo.replace(" ", "%20"));

                    Livro livro = conversor.converterJsonParaLivro(json);
                    biblioteca.adicionarLivro(livro);
                    System.out.println("✅ Livro adicionado: " + livro);
                }
                case 2 -> biblioteca.listarLivros();
                case 3 -> biblioteca.listarAutores();
                case 4 -> {
                    System.out.println("Digite o ano:");
                    int ano = scanner.nextInt();
                    biblioteca.listarAutoresVivosNoAno(ano);
                }
                case 5 -> {
                    System.out.println("Digite o idioma (ex: 'en' ou 'pt'):");
                    String idioma = scanner.nextLine();
                    biblioteca.listarLivrosPorIdioma(idioma);
                }
                case 0 -> {
                    System.out.println("👋 Saindo...");
                    return;
                }
                default -> System.out.println("❌ Opção inválida!");
            }
        }
    }
}
