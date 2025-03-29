package com.pblteste;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class CadastraLivroFilmeSerie {
    private final List<Livro> listLivro = new ArrayList<>();
    private final List<Filme> listFilme = new ArrayList<>();
    private final List<Serie> listSerie = new ArrayList<>();
    private final List<serieTemporadas> listTemporada = new ArrayList<>();

    // Método para cadastrar livro
    public void cadastraLivro(String titulo, String autor, String editora, String isbn, Year publicAno, String gender, String exemplar, boolean lidoYesNot,
                              int pontuacao, String review, int avaliacao) {

        boolean verificaAno = yearTime(publicAno);

        if (titulo == null || autor == null || editora == null || isbn == null || gender == null || exemplar == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        }

        for (Livro item : listLivro){
            if (item.getIsbn().equals(isbn) && item.getTitulo().equals(titulo) && item.getAutor().equals(autor))
                throw new RuntimeException("Série já cadastrada.");
        }

        listLivro.add(new Livro(titulo, autor, editora, isbn, publicAno, gender, exemplar, lidoYesNot, pontuacao, review, avaliacao));
    }

    //Método para cadastrar Filmes
    public void cadastraFilme(String titulo, String gender, Year anoLancamento, String duracao, String direction, String roteiro, String elenco,
                              String tituloOriginal, String ondeVer, int avaliacao){

        boolean verificaAno = yearTime(anoLancamento);

        if (titulo == null || gender == null || anoLancamento == null || duracao == null || tituloOriginal == null) {
            throw new IllegalArgumentException("Os campos obrigatórios não podem ser nulos.");
        }
        for (Filme item : listFilme){
            if (item.getTitulo().equals(titulo))
                throw new RuntimeException("Filme já cadastrado.");
        } listFilme.add(new Filme(titulo, gender, anoLancamento, duracao, direction, roteiro, elenco, tituloOriginal, ondeVer, avaliacao));
    }

    // Método para cadastrar série
    public void cadastraSerie(String titulo, String gender,Year anoLancamento, Year anoEncerramento, String elenco, String tituloOriginal, String ondeVer) {
        if (titulo == null || gender == null || anoLancamento == null || elenco == null || tituloOriginal == null || ondeVer == null)
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");


        for (Serie item : listSerie) {
            if (item.getTitulo().equals(titulo))
                throw new RuntimeException("Série já cadastrada.");
        } listSerie.add(new Serie(titulo, gender, anoLancamento, anoEncerramento, elenco, tituloOriginal, ondeVer));
    }

    //Método para cadastrar Temporadas
    public void cadastraTemporada(String ano, String qtdEpisodes){
        if (ano == null || qtdEpisodes == null)
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        listTemporada.add(new serieTemporadas(ano, qtdEpisodes));
    }

    private boolean yearTime(Year anoIndicado){
        Year anoAtual = Year.now();
        while(anoAtual.isBefore(anoIndicado)){
            System.out.println("A data atual é anterior à data especificada.");
            anoIndicado = Year.of(2002);
        }
        return true;
    }

    public void listarLivros() {
        for (Livro item : listLivro) {
            System.out.println("Livro: " + item);
        }
    }

    public void listarFilmes(){
        for (Filme item : listFilme){
            System.out.println("Filme: " + item);
        }
    }

    public void listarSeries() {
        for (Serie item : listSerie){
            System.out.println("Series: " + item);
        }
    }

    public void listarTemporadas(){
        for (serieTemporadas item : listTemporada){
            System.out.println("Temporadas: " + item);
        }
    }

    public List<Livro> getListLivro() {
        return new ArrayList<>(listLivro);
    }
    public List<Filme> getListFilme(){
        return new ArrayList<>(listFilme);
    }
    public List<Serie> getListSerie(){
        return new ArrayList<>(listSerie);
    }
}
