package br.com.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<AuthorsData> authors,
        @JsonAlias("summaries") List<String> summaries,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("download_count") Integer downloads
        ) {
}
