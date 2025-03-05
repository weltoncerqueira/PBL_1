package com.pblteste;
import java.util.ArrayList;
import java.util.List;

class CadastraLivroFilmeSerie {
    private final List<Livro> listLivro = new ArrayList<>();
    private final List<Filme> listFilme = new ArrayList<>();
    private final List<Serie> listSerie = new ArrayList<>();
    private final List<serieTemporadas> listTemporada = new ArrayList<>();

    // Método para cadastrar livro
    public void cadastraLivro(String titulo, String autor, String editora, String isbn, String publicAno, String gender, String exemplar) {
        if (titulo == null || autor == null || editora == null || isbn == null || publicAno == null || gender == null || exemplar == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        }
        for (Livro item : listLivro){
            if (item.getIsbn().equals(isbn) && item.getIsbn().equals(titulo) && item.getIsbn().equals(autor))
                throw new RuntimeException("Série já cadastrada.");
        } listLivro.add(new Livro(titulo, autor, editora, isbn, publicAno, gender, exemplar));
    }

    //Método para cadastrar Filmes
    public void cadastraFilme(String titulo, String gender, String releaseYear, String closeYear, String durationTime, String direction, String roteiro, String elenco, 
                              String tituloOriginal, String ondeVer){
        Filme filme = new Filme(titulo, gender, releaseYear, closeYear, durationTime, direction, roteiro, elenco, tituloOriginal, ondeVer);
        for (Filme item : listFilme){
            if (item.getTitulo().equals(titulo))
                throw new RuntimeException("Série já cadastrada.");
        } listFilme.add(filme);
    }

    // Método para cadastrar série
    public void cadastraSerie(String titulo, String gender, String inicioAno, String fimAno, String elenco, String tituloOriginal, String ondeVer) {
        if (titulo == null || gender == null || inicioAno == null || fimAno == null || elenco == null || tituloOriginal == null || ondeVer == null)
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");

        for (Serie item : listSerie) {
            if (item.getTitulo().equals(titulo))
                throw new RuntimeException("Série já cadastrada.");
        } listSerie.add(new Serie(titulo, gender, inicioAno, fimAno, elenco, tituloOriginal, ondeVer));
    }

    //Método para cadastrar Temporadas
    public void cadastraTemporada(String ano, String qtdEpisodes){
        if (ano == null || qtdEpisodes == null)
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        listTemporada.add(new serieTemporadas(ano, qtdEpisodes));
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

}


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CadastraLivroFilmeSerie cadastro = new CadastraLivroFilmeSerie();

        cadastro.cadastraLivro("O Senhor dos Anéis", "J.R.R. Tolkien", "HarperCollins", "123456789", "1954", "Fantasia", "1ª Edição");
        cadastro.cadastraFilme("Caminhos", "Jack", "Bethon", "20/2015", "19;00", "Fantasia", "baraq", "loucura", 
                "mazon", "teto");
        cadastro.cadastraSerie("Breaking Bad", "Drama", "2008", "2013", "Bryan Cranston, Aaron Paul", "Breaking Bad", "Netflix");
        cadastro.cadastraTemporada("1", "12");

        cadastro.listarLivros();
        cadastro.listarSeries();
        cadastro.listarTemporadas();
        cadastro.listarFilmes();


    }
}



class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private String isbn;
    private String publicAno;
    private String gender;
    private String exemplar;


    public Livro(String titulo, String autor, String editora, String isbn,  String publicAno, String gender, String exemplar){
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.publicAno = publicAno;
        this.gender = gender;
        this.exemplar = exemplar;
    }
    public String getPublicAno() {
        return publicAno;
    }
    public void setPublicAno(String publicAno) {
        this.publicAno = publicAno;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getExemplar() {
        return exemplar;
    }
    public void setExemplar(String exemplar) {
        this.exemplar = exemplar;
    }
    @Override
    public String toString() {
        return "{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", isbn='" + isbn + '\'' +
                ", anoPublicacao='" + publicAno + '\'' +
                ", genero='" + gender + '\'' +
                ", exemplar='" + exemplar + '\'' +
                '}';
    }
}


class Serie {
    private String titulo;
    private String gender;
    private String releaseYear;
    private String closeYear;
    private String elenco;
    private String tituloOriginal;
    private String ondeVer;

    public Serie(String titulo, String gender, String releaseYear, String closeYear, String elenco, String tituloOriginal, String ondeVer) {
        this.titulo = titulo;
        this.gender = gender;
        this.releaseYear = releaseYear;
        this.closeYear = closeYear;
        this.elenco = elenco;
        this.tituloOriginal = tituloOriginal;
        this.ondeVer = ondeVer;
    }

    public String getElenco() {
        return elenco;
    }
    public String getTituloOriginal() {
        return tituloOriginal;
    }
    public String getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
    public String getCloseYear() {
        return closeYear;
    }
    public void setCloseYear(String closeYear) {
        this.closeYear = closeYear;
    }
    public String getOndeVer() {
        return ondeVer;
    }
    public void setOndeVer(String ondeVer) {
        this.ondeVer = ondeVer;
    }
    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }
    public void setElenco(String elenco) {
        this.elenco = elenco;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + gender + '\'' +
                ", inicioAno='" + releaseYear + '\'' +
                ", fimAno='" + closeYear + '\'' +
                ", elenco='" + elenco + '\'' +
                ", tituloOriginal='" + tituloOriginal + '\'' +
                ", ondeVer='" + ondeVer + '\'' +
                '}';
    }
}

class serieTemporadas{
    private String ano;
    private String qtdEpisodes;

    public serieTemporadas(String ano, String qtdEpisodes){
        this.ano = ano;
        this.qtdEpisodes = qtdEpisodes;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getQtdEpisodes() {
        return qtdEpisodes;
    }
    public void setQtdEpisodes(String qtdEpisodes) {
        this.qtdEpisodes = qtdEpisodes;
    }
    @Override
    public String toString() {
        return "{" +
                "ano: " + ano + '\'' +
                ", qtdEpisodes: " + qtdEpisodes + '\'' +
                '}';
    }
}

class Filme {
    private String titulo;
    private String genero; // Alterado para português para manter consistência com outros exemplos
    private String anoLancamento;
    private String anoEncerramento;
    private String duracao; // Tempo de duração em horas ou minutos
    private String direcao; // Nome do(s) diretor(es)
    private String roteiro; // Nome do(s) roteirista(s)
    private String elenco;  // Nome do(s) ator(es)
    private String tituloOriginal;
    private String ondeAssistir; // Onde o filme está disponível para assistir

    // Construtor com validações simples
    public Filme(String titulo, String genero, String anoLancamento, String anoEncerramento, String duracao,
                 String direcao, String roteiro, String elenco, String tituloOriginal, String ondeAssistir) {

        if (titulo == null || genero == null || anoLancamento == null || duracao == null || tituloOriginal == null || ondeAssistir == null) {
            throw new IllegalArgumentException("Os campos obrigatórios não podem ser nulos.");
        }

        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.anoEncerramento = anoEncerramento;
        this.duracao = duracao;
        this.direcao = direcao;
        this.roteiro = roteiro;
        this.elenco = elenco;
        this.tituloOriginal = tituloOriginal;
        this.ondeAssistir = ondeAssistir;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser vazio ou nulo.");
        }
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getAnoEncerramento() {
        return anoEncerramento;
    }

    public void setAnoEncerramento(String anoEncerramento) {
        this.anoEncerramento = anoEncerramento;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(String roteiro) {
        this.roteiro = roteiro;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public String getOndeAssistir() {
        return ondeAssistir;
    }

    public void setOndeAssistir(String ondeAssistir) {
        this.ondeAssistir = ondeAssistir;
    }

    // Método toString para exibição legível
    @Override
    public String toString() {
        return "Filme{" +
                "Título='" + titulo + '\'' +
                ", Gênero='" + genero + '\'' +
                ", Ano de Lançamento='" + anoLancamento + '\'' +
                ", Ano de Encerramento='" + (anoEncerramento != null ? anoEncerramento : "Ainda em exibição") + '\'' +
                ", Duração='" + duracao + '\'' +
                ", Direção='" + direcao + '\'' +
                ", Roteiro='" + roteiro + '\'' +
                ", Elenco='" + elenco + '\'' +
                ", Título Original='" + tituloOriginal + '\'' +
                ", Onde Assistir='" + ondeAssistir + '\'' +
                '}';
    }
}
