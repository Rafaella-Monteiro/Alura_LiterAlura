package br.com.alura.literalura.servico;

import br.com.alura.literalura.modelo.Autor;
import br.com.alura.literalura.modelo.Livro;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.ArrayList;
import java.util.List;

public class ConversorJson {
    private final ObjectMapper mapper = new ObjectMapper();

    public Livro converterJsonParaLivro(String json) {
        try {
            JsonNode raiz = mapper.readTree(json);
            JsonNode livroNode = raiz.get("results").get(0);

            String titulo = livroNode.get("title").asText();

            List<Autor> autores = new ArrayList<>();
            for (JsonNode autorNode : livroNode.get("authors")) {
                String nome = autorNode.get("name").asText();
                Integer nascimento = autorNode.get("birth_year").isNull() ? null : autorNode.get("birth_year").asInt();
                Integer falecimento = autorNode.get("death_year").isNull() ? null : autorNode.get("death_year").asInt();
                autores.add(new Autor(nome, nascimento, falecimento));
            }

            String idioma = livroNode.get("languages").get(0).asText();
            int downloads = livroNode.get("download_count").asInt();

            return new Livro(titulo, autores, idioma, downloads);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para Livro", e);
        }
    }
}
