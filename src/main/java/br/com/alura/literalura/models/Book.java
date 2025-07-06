package br.com.alura.literalura.models;

import java.util.List;

public class Book {
    private String title;
    private Author author;
    private Integer downloads;
    private String language;
    private List<String> summaries;

    public Book(BookData bookData, Author author){
        this.title = bookData.title();
        this.downloads = bookData.downloads();
        this.author = author;
        this.summaries = bookData.summaries();
        this.language = bookData.languages().getFirst();
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<String> summaries) {
        this.summaries = summaries;
    }

    @Override
    public String toString() {
        return """
                ------ Livro ------
                 Título: %s
                 Autor: %s
                 Idioma: %s
                 Número de downloads: %d
                -------------------
                """.formatted(title, author.getName(), language, downloads)
                ;
    }
}
