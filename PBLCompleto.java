package com.pblteste;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.time.Year;
import java.util.Scanner;

class CadastraLivroFilmeSerie {
    private final List<Livro> listLivro = new ArrayList<>();
    private final List<Filme> listFilme = new ArrayList<>();
    private final List<Serie> listSerie = new ArrayList<>();

    // Método para cadastrar livro
    public void cadastraLivro(String titulo, String autor, String editora, String isbn, Year anoLancamento, String gender, String exemplar, boolean lidoYesNot,
                              int pontuacao, String review, int avaliacao) {
        if (titulo == null || autor == null || editora == null || isbn == null || gender == null)
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");

        yearTime(anoLancamento);

        for (Livro item : listLivro){
            if (item.getIsbn().toLowerCase().trim().equals(isbn.toLowerCase().trim()))
                throw new RuntimeException("Série já cadastrada.");
        } listLivro.add(new Livro(titulo, autor, editora, isbn, anoLancamento, gender, exemplar, lidoYesNot, pontuacao, review, avaliacao));
    }

    //Método para cadastrar Filmes
    public void cadastraFilme(String titulo, String gender, Year anoLancamento, String duracao, String direction, String roteiro, String elenco,
                              String tituloOriginal, String ondeVer, int avaliacao){
        if (gender == null || titulo == null)
            throw new IllegalArgumentException("Os campos obrigatórios não podem ser nulos.");

        yearTime(anoLancamento);

        for (Filme item : listFilme){
            if (item.getTitulo().toLowerCase().trim().equals(titulo.toLowerCase().trim()))
                throw new RuntimeException("Filme já cadastrado.");
        } listFilme.add(new Filme(titulo, gender, anoLancamento, duracao, direction, roteiro, elenco, tituloOriginal, ondeVer, avaliacao));
    }

    // Método para cadastrar série
    public void cadastraSerie(String titulo, String gender,Year anoLancamento, Year anoEncerramento, String elenco, String tituloOriginal, String ondeVer, int num_episodios,
                              Year temporada_ano, int pontuacao, String review) {
        if (titulo == null || gender == null || elenco == null)
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");

        yearTime(anoLancamento);

        for (Serie item : listSerie) {
            if (item.getTitulo().toLowerCase().trim().equals(titulo.toLowerCase().trim()))
                throw new RuntimeException("Série já cadastrada.");}

        Serie serie = new Serie(titulo, gender, anoLancamento, anoEncerramento, elenco, tituloOriginal, ondeVer);
        SerieTemporadas temporadas = new SerieTemporadas(num_episodios, temporada_ano, pontuacao, review);
        serie.adicionarTemporada(temporadas);
        listSerie.add(serie);
    }

    private void yearTime(Year anoIndicado){
        Year anoAtual = Year.now();
        while(anoAtual.isBefore(anoIndicado)){
            anoIndicado = Year.of(2002);
        }
    }

    public void listarLivros() {
        for (Livro item : listLivro)
            System.out.println("Livro: " + item);}

    public void listarFilmes(){
        for (Filme item : listFilme)
            System.out.println("Filme: " + item);}

    public void listarSeries() {
        for (Serie item : listSerie)
            System.out.println("Series: " + item);}

    public List<Livro> getListLivro() {return new ArrayList<>(listLivro);}
    public List<Filme> getListFilme(){return new ArrayList<>(listFilme);}
    public List<Serie> getListSerie(){return new ArrayList<>(listSerie);}
}

class AvaliaLivroFilmeSerie {
    private final CadastraLivroFilmeSerie listcadastro;

    public AvaliaLivroFilmeSerie(CadastraLivroFilmeSerie cadastro) {
        this. listcadastro = cadastro;
    }

    public boolean avaliaLivro(int avaliacaoUsuario, String titulo) {
        List<Livro> listAvaliaLivro =  listcadastro.getListLivro();
        if (listAvaliaLivro.isEmpty()) {
            System.out.println("Nenhum livro cadastrado para avaliação.");
            return false;
        }
        for (Livro livro : listAvaliaLivro) {
            if (livro.getTitulo().toLowerCase().trim().equals(titulo.toLowerCase().trim())) {
                livro.setAvaliacao(avaliacaoUsuario);
                return true;
            }
        } return false;
    }

    public boolean avaliaFilme(int avaliacaoUsuario, String titulo) {
        List<Filme> listAvaliaFilme = listcadastro.getListFilme();
        if (listAvaliaFilme.isEmpty()) {
            System.out.print("Nenhum Filme cadastrado para avaliação.");
            return false;
        }
        for (Filme filme : listAvaliaFilme) {
            if (filme.getTitulo().toLowerCase().trim().equals(titulo.toLowerCase().trim())) {
                filme.setAvalia_filme(avaliacaoUsuario);
                return true;
            }
        } return false;
    }

    public boolean avaliaSerie(int avaliacaoUsuario, String titulo){
        List<Serie> listAvaliaTemporada = listcadastro.getListSerie();

        if (listAvaliaTemporada.isEmpty()) {
            System.out.println("Nenhuma série cadastrada para avaliação.");
            return false;
        }
        for (Serie serie : listAvaliaTemporada) {
            if (serie.getTitulo().toLowerCase().trim().equals(titulo.toLowerCase().trim())) {
                serie.getTemporada().getFirst().setPontuacao(avaliacaoUsuario);

                float novaPontuacaoMedia = calculaPontuacaoMedia();

                for (Serie item : listAvaliaTemporada) {
                    item.setPontuacaoMedia(novaPontuacaoMedia);
                } return true;
            }
        } return false;
    }

    public boolean temporadasReview(String review, String titulo){
        List<Serie> listAvaliaTemporada = listcadastro.getListSerie();
        if (listAvaliaTemporada.isEmpty()) {
            System.out.println("Nenhuma série cadastrada para avaliação.");
            return false;
        }
        for (Serie serie : listAvaliaTemporada){
            if(serie.getTitulo().toLowerCase().trim().equals(titulo.toLowerCase().trim())){
                serie.getTemporada().getFirst().setReview(review);
                return true;
            }
        } return false;
    }

    private float calculaPontuacaoMedia() {
        List<Serie> listAvaliaTemporada = listcadastro.getListSerie();
        if (listAvaliaTemporada.isEmpty()) {
            System.out.println("Nenhuma série cadastrada para avaliação.");
            return 0;
        }
        int pontuacaoTotal = 0;
        int contaAvaliacoes = 0;

        for (Serie serie : listAvaliaTemporada) {
            for (SerieTemporadas temporada : serie.getTemporada()) {
                pontuacaoTotal += temporada.getPontuacao();
                contaAvaliacoes += 1;
            }

        } if (contaAvaliacoes > 0) {
            return ((float) pontuacaoTotal / contaAvaliacoes);
        }return pontuacaoTotal;
    }
}

class BuscaFilmeSerie {
    private final CadastraLivroFilmeSerie cadastro;
    public BuscaFilmeSerie(CadastraLivroFilmeSerie cadastro) {this.cadastro = cadastro;}

    public Filme porTitulo(String titulo){
        List<Filme> listBuscaFilme = cadastro.getListFilme();
        for (Filme filme : listBuscaFilme){
            if (filme.getTitulo().toLowerCase().trim().equalsIgnoreCase(titulo.toLowerCase().trim()))
                return filme;
        } return null;
    }

    public Filme porDiretor(String diretor){
        List<Filme> listBuscaFilme = cadastro.getListFilme();
        for (Filme filme : listBuscaFilme){
            if (filme.getDirecao().toLowerCase().trim().equalsIgnoreCase(diretor.toLowerCase().trim()))
                return filme;
        } return null;
    }

    public Filme porGenero(String genero){
        List<Filme> listBuscaFilme = cadastro.getListFilme();
        for (Filme filme : listBuscaFilme){
            if (filme.getGenero().toLowerCase().trim().equalsIgnoreCase(genero.toLowerCase().trim()))
                return filme;
        } return null;
    }

    public Filme porAnoLancamento(Year ano){
        List<Filme> listBuscaFilme = cadastro.getListFilme();
        for (Filme filme : listBuscaFilme){
            if (filme.getAnoLancamento().equals(ano))
                return filme;
        } return null;
    }

    // ator no elenco
    public Filme porAtor(String ator){
        List<Filme> listBuscaFilme = cadastro.getListFilme();
        for (Filme filme : listBuscaFilme){
            if(filme.getElenco().toLowerCase().trim().contains(ator.toLowerCase().trim())){
                return filme;
            }
        }return null;
    }

    public Serie buscaSeriePorTitulo(String titulo){
        List<Serie> listBuscaSerie = cadastro.getListSerie();
        for (Serie serie : listBuscaSerie){
            if (serie.getTitulo().toLowerCase().trim().contains(titulo.toLowerCase().trim()))
                return serie;
        } return null;
    }
}

class BuscaLivro {
    private final CadastraLivroFilmeSerie cadastro;
    public BuscaLivro(CadastraLivroFilmeSerie cadastro) {this.cadastro = cadastro;}

    public Livro porTitulo(String titulo) {
        List<Livro> listAvaliaLivro = cadastro.getListLivro();
        for (Livro livro : listAvaliaLivro) {
            if (livro.getTitulo().toLowerCase().trim().equalsIgnoreCase(titulo.toLowerCase().trim()))
                return livro;
        } return null;
    }

    public Livro porAutor(String autor){
        List<Livro> listAvaliaLivro =  cadastro.getListLivro();
        for (Livro livro : listAvaliaLivro) {
            if (livro.getAutor().toLowerCase().trim().equalsIgnoreCase(autor.toLowerCase().trim()))
                return livro;
        } return null;
    }

    public Livro porGenero(String genero){
        List<Livro> listAvaliaLivro =  cadastro.getListLivro();
        for (Livro livro : listAvaliaLivro) {
            if (livro.getGender().toLowerCase().trim().equalsIgnoreCase(genero.toLowerCase().trim()))
                return livro;
        } return null;
    }

    public Livro porAno(Year ano){
        List<Livro> listAvaliaLivro =  cadastro.getListLivro();
        for (Livro livro : listAvaliaLivro) {
            if (livro.getPublicAno().equals(ano))
                return livro;
        } return null;
    }

    public Livro porISBN(String isbn){
        List<Livro> listAvaliaLivro =  cadastro.getListLivro();
        for (Livro livro : listAvaliaLivro) {
            if (livro.getIsbn().toLowerCase().trim().equals(isbn.toLowerCase().trim()))
                return livro;
        } return null;
    }
}

class ListaLivro {
    private final CadastraLivroFilmeSerie cadastro;

    public ListaLivro(CadastraLivroFilmeSerie cadastro) {
        this.cadastro = cadastro;
    }

    public List<Livro> obterLivrosOrdenadosPorAvaliacaoCrescente() {
        List<Livro> listLivro = cadastro.getListLivro();
        if (listLivro.isEmpty()) {
            throw new IllegalStateException("Nenhum livro cadastrado.");
        }
        listLivro.sort(Comparator.comparingInt(Livro::getAvaliacao));
        return listLivro;
    }

    public List<Livro> obterLivrosOrdenadosPorAvaliacaoDecrescente() {
        List<Livro> listLivro = cadastro.getListLivro();
        if (listLivro.isEmpty()) {
            throw new IllegalStateException("Nenhum livro cadastrado.");
        }
        listLivro.sort(Comparator.comparingInt(Livro::getAvaliacao).reversed());
        return listLivro;
    }

    public List<Livro> obterLivrosOrdenadosPorGenero() {
        List<Livro> listLivro = cadastro.getListLivro();
        if (listLivro.isEmpty()) {
            throw new IllegalStateException("Nenhum livro cadastrado.");
        }
        listLivro.sort(Comparator.comparing(Livro::getGender));
        return listLivro;
    }

    public List<Livro> obterLivrosOrdenadosPorAnoLancamento() {
        List<Livro> listLivro = cadastro.getListLivro();
        if (listLivro.isEmpty()) {
            throw new IllegalStateException("Nenhum livro cadastrado.");
        }
        listLivro.sort(Comparator.comparing(Livro::getPublicAno));
        return listLivro;
    }
}

class ListaFilme {
    private final CadastraLivroFilmeSerie cadastro;

    public ListaFilme(CadastraLivroFilmeSerie cadastro) {
        this.cadastro = cadastro;
    }

    public List<Filme> obterFilmesOrdenadosPorAvaliacaoCrescente() {
        List<Filme> listFilme = cadastro.getListFilme();
        if (listFilme.isEmpty())
            throw new IllegalStateException("Nenhum Filme cadastrado.");

        listFilme.sort(Comparator.comparingInt(Filme::getAvalia_filme));
        return listFilme;
    }

    public List<Filme> obterFilmesOrdenadosPorAvaliacaoDecrescente() {
        List<Filme> listFilme = cadastro.getListFilme();
        if (listFilme.isEmpty())
            throw new IllegalStateException("Nenhum Filme cadastrado.");

        listFilme.sort(Comparator.comparingInt(Filme::getAvalia_filme).reversed());
        return listFilme;
    }

    public List<Filme> obterFilmesOrdenadosPorGenero() {
        List<Filme> listFilme = cadastro.getListFilme();
        if (listFilme.isEmpty())
            throw new IllegalStateException("Nenhum Filme cadastrado.");

        listFilme.sort(Comparator.comparing(Filme::getGenero));
        return listFilme;
    }

    public List<Filme> obterFilmesOrdenadosAnoLancamento() {
        List<Filme> listFilme = cadastro.getListFilme();
        if (listFilme.isEmpty())
            throw new IllegalStateException("Nenhum Filme cadastrado.");

        listFilme.sort(Comparator.comparing(Filme::getAnoLancamento));
        return listFilme;
    }
}

class ListaSerie{
    private final CadastraLivroFilmeSerie cadastro;

    public ListaSerie (CadastraLivroFilmeSerie cadastro) {
        this.cadastro = cadastro;
    }

    public List<Serie> obterSerieOrdenadosPorAvaliacaoCrescente(){
        List<Serie> listSerie = cadastro.getListSerie();
        if (listSerie.isEmpty())
            throw new IllegalStateException("Nenhuma Série cadastrada.");

        listSerie.sort(Comparator.comparing(Serie::getPontuacaoMedia));
        return listSerie;
    }

    public List<Serie> obterSerieOrdenadosPorAvaliacaoDecrescente(){
        List<Serie> listSerie = cadastro.getListSerie();
        if (listSerie.isEmpty())
            throw new IllegalStateException("Nenhuma Série cadastrada.");

        listSerie.sort(Comparator.comparing(Serie::getPontuacaoMedia).reversed());
        return listSerie;
    }

    public List<Serie> obterSerieOrdenadosPorGenero(){
        List<Serie> listSerie = cadastro.getListSerie();
        if (listSerie.isEmpty())
            throw new IllegalStateException("Nenhuma Série cadastrada.");

        listSerie.sort(Comparator.comparing(Serie::getGender));
        return listSerie;
    }

    public List<Serie> obterSerieOrdenadosAnoLancamento(){
        List<Serie> listSerie = cadastro.getListSerie();
        if (listSerie.isEmpty())
            throw new IllegalStateException("Nenhuma Série cadastrada.");

        listSerie.sort(Comparator.comparing(Serie::getAnoLancamento));
        return listSerie;
    }

}

class RemoveLivroFilmeSerie {
    private final CadastraLivroFilmeSerie cadastro;
    public RemoveLivroFilmeSerie (CadastraLivroFilmeSerie cadastro) {this.cadastro = cadastro;}

    public void removeLivro(String titulo){
        List<Livro> listLivro = cadastro.getListLivro();
        if (listLivro.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;}
        listLivro.removeIf(livro -> livro.getTitulo().toLowerCase().trim().equalsIgnoreCase(titulo.toLowerCase().trim()));
    }

    public void removeFilme(String titulo) {
        List<Filme> listFilme = cadastro.getListFilme();
        if (listFilme.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;}
        listFilme.removeIf(filme -> filme.getTitulo().toLowerCase().trim().equalsIgnoreCase(titulo.toLowerCase().trim()));
    }

    public void removeSerie(String titulo){
        List<Serie> listSerie = cadastro.getListSerie();
        if (listSerie.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;}
        listSerie.removeIf(serie -> serie.getTitulo().toLowerCase().trim().equalsIgnoreCase(titulo.toLowerCase().trim()));
    }
}


public class Main {
    public static void main(String[] args) {
        CadastraLivroFilmeSerie cadastro = new CadastraLivroFilmeSerie();
        AvaliaLivroFilmeSerie avalia = new AvaliaLivroFilmeSerie(cadastro);
        BuscaLivro buscalivro = new BuscaLivro(cadastro);
        BuscaFilmeSerie buscafilmeserie = new BuscaFilmeSerie(cadastro);
        ListaLivro listalivro = new ListaLivro(cadastro);
        ListaFilme listafilme = new ListaFilme(cadastro);
        ListaSerie listaserie = new ListaSerie(cadastro);
        Review review = new Review();

        cadastro.cadastraLivro("Livro A", "Autor A", "Editora A", "ISBN001", Year.of(2020), "Ficção", "Exemplar A", true, 4, "Bom livro", 4);
        cadastro.cadastraLivro("Livro B", "Autor B", "Editora B", "ISBN002", Year.of(2018), "Não Ficção", "Exemplar B", false, 5, "Excelente livro", 2);
        cadastro.cadastraLivro("Livro C", "Autor C", "Editora C", "ISBN003", Year.of(2019), "Ficção", "Exemplar C", true, 3, "Livro médio", 3);
        System.out.println("\n");

        cadastro.cadastraFilme("Caminhos", "Jack", Year.of(2001), "19;00", "Fantasia", "Eduard", "parkison Lucas liane Jesiane", "mazon", "teto", 1);
        cadastro.cadastraFilme("Livro A", "Autor A", Year.of(2006), "ISBN001", "Marlon", "Ficção", "Exemplar A", "true", "4", 3);
        cadastro.cadastraFilme("Livro B", "Autor B",Year.of(2003), "ISBN002", "Borda", "Não Ficção", "Exemplar B", "false", "lá", 4);


        cadastro.cadastraSerie("Breaking Bad", "Drama", Year.of(2003), Year.of(2026), "Bryan Cranston, Aaron Paul", "Breaking Bad", "Netflix", 2, Year.of(2025), 4, "hee");
        cadastro.cadastraSerie("Livro A", "Autor A", Year.of(2003), Year.of(2008), "matusalen", "Ficção", "Exemplar A", 12, Year.of(2018), 3, "branco");
        cadastro.cadastraSerie("Livro B", "Autor B", Year.of(2003), Year.of(2010), "Year.of(2018)", "Não Ficção", "Exemplar B", 11, Year.of(2018), 2, "five");

        cadastro.listarLivros();
        cadastro.listarFilmes();
        cadastro.listarSeries();

        boolean a1 = avalia.avaliaLivro(3, "O Senhor dos Anéis");
        boolean a2 = avalia.avaliaFilme(4, "Caminhos");
        boolean a3 = avalia.avaliaSerie(1, "Breaking Bad");

        boolean r1 = avalia.temporadasReview("Uma porcaria", "Breaking Bad");

        System.out.println("\n\n");
        Livro ano_livro = buscalivro.porAno(Year.of(2026));
        Livro isbn_livro = buscalivro.porISBN("123456789");
        Livro titulo_livro = buscalivro.porTitulo("O Senhor dos Anéis");
        Livro genero_livro = buscalivro.porGenero("Fantasia");
        Livro autor_livro = buscalivro.porAutor("HarperCollins");

        Filme ator_filme = buscafilmeserie.porAtor("LiaNe");
        Filme ano_filme = buscafilmeserie.porAnoLancamento(Year.of(2026));
        Filme diretor_filme = buscafilmeserie.porDiretor("Eduard");
        Filme genero_filme = buscafilmeserie.porGenero("Fantasia");
        Filme titulo_filme = buscafilmeserie.porTitulo("Caminhos");

        Serie titulo_serie = buscafilmeserie.buscaSeriePorTitulo("Breaking Bad");
        System.out.print("\n\n");
        List<Livro> list1 = listalivro.obterLivrosOrdenadosPorAvaliacaoCrescente();
        List<Livro> list12 = listalivro.obterLivrosOrdenadosPorAvaliacaoDecrescente();
        List<Filme> list21 = listafilme.obterFilmesOrdenadosPorAvaliacaoDecrescente();
        List<Serie> list31 = listaserie.obterSerieOrdenadosPorAvaliacaoCrescente();

        System.out.println("CrescenteLivro: " + list1.get(0).getAvaliacao() + " " + list1.get(1).getAvaliacao() + " " + list1.get(2).getAvaliacao());
        System.out.println("DecrescenteFilme: " +list21.get(0).getAvalia_filme() + " " + list21.get(1).getAvalia_filme() + " " + list21.get(2).getAvalia_filme());
        System.out.println("CrescenteSerie: " + list31.get(0).getPontuacaoMedia() + " " + list31.get(1).getPontuacaoMedia() + " " + list31.get(2).getPontuacaoMedia());
    }
}

class Review {
    Scanner scanner = new Scanner(System.in);
    public int pontuarLivroFilmeserie() {
        int avaliacao;
        do {
            System.out.print("Avalie (de 1 a 5): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. Insira um número de 1 a 5: ");
                scanner.next();
            }
            avaliacao = scanner.nextInt();
            if (avaliacao < 1 || avaliacao > 5) {
                System.out.println("Avaliação fora do intervalo permitido. Tente novamente.");
            }
        } while (avaliacao < 1 || avaliacao > 5);
        return avaliacao;
    }
}

class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private String isbn;
    private Year publicAno;
    private String gender;
    private String exemplar;
    private int avaliacao;

    public Livro(String titulo, String autor, String editora, String isbn, Year publicAno, String gender, String exemplar, boolean lido, int pontuacao, String review, int avaliacao){
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.publicAno = publicAno;
        this.gender = gender;
        this.exemplar = exemplar;
        this.avaliacao = avaliacao;
    }
    public Year getPublicAno() {return publicAno;}
    public void setPublicAno(Year publicAno) {this.publicAno = publicAno;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getAutor() {return autor;}
    public void setAutor(String autor) {this.autor = autor;}
    public String getEditora() {return editora;}
    public void setEditora(String editora) {this.editora = editora;}
    public String getIsbn() {return isbn;}
    public void setIsbn(String isbn) {this.isbn = isbn;}
    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}
    public String getExemplar() {return exemplar;}
    public void setExemplar(String exemplar) {this.exemplar = exemplar;}
    public int getAvaliacao() {return avaliacao;}
    public void setAvaliacao(int avaliacao) {this.avaliacao = avaliacao;}
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
                ", Avaliacao='" + avaliacao +
                '}';}
}

class Filme {
    private String titulo;
    private String genero;
    private Year anoLancamento;
    private String duracao;
    private String direcao;
    private String roteiro;
    private String elenco;
    private String tituloOriginal;
    private String ondeAssistir;
    private int avaliafilme;

    // Construtor com validações simples
    public Filme(String titulo, String genero, Year anoLancamento, String duracao,
                 String direcao, String roteiro, String elenco, String tituloOriginal, String ondeAssistir, int avalia_filme) {
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.duracao = duracao;
        this.direcao = direcao;
        this.roteiro = roteiro;
        this.elenco = elenco;
        this.tituloOriginal = tituloOriginal;
        this.ondeAssistir = ondeAssistir;
        this.avaliafilme = avalia_filme;
    }

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}
    public Year getAnoLancamento() {return anoLancamento;}
    public void setAnoLancamento(Year anoLancamento) {this.anoLancamento = anoLancamento;}
    public String getDuracao() {return duracao;}
    public void setDuracao(String duracao) {this.duracao = duracao;}
    public String getDirecao() {return direcao;}
    public void setDirecao(String direcao) {this.direcao = direcao;}
    public String getRoteiro() {return roteiro;}
    public void setRoteiro(String roteiro) {this.roteiro = roteiro;}
    public String getElenco() {return elenco;}
    public void setElenco(String elenco) {this.elenco = elenco;}
    public String getTituloOriginal() {return tituloOriginal;}
    public void setTituloOriginal(String tituloOriginal) {this.tituloOriginal = tituloOriginal;}
    public String getOndeAssistir() {return ondeAssistir;}
    public void setOndeAssistir(String ondeAssistir) {this.ondeAssistir = ondeAssistir;}
    public int getAvalia_filme() {return avaliafilme;}
    public void setAvalia_filme(int avalia_filme) {this.avaliafilme = avalia_filme;}
    // Método toString para exibição legível
    @Override
    public String toString() {
        return "Filme{" +
                "Título='" + titulo + '\'' +
                ", Gênero='" + genero + '\'' +
                ", Ano de Lançamento='" + anoLancamento + '\'' +
                ", Duração='" + duracao + '\'' +
                ", Direção='" + direcao + '\'' +
                ", Roteiro='" + roteiro + '\'' +
                ", Elenco='" + elenco + '\'' +
                ", Título Original='" + tituloOriginal + '\'' +
                ", Onde Assistir='" + ondeAssistir + '\'' +
                ", Avaliacao='" + avaliafilme + '}';}
}

class SerieTemporadas {
    private Year temporada_ano;
    private int qtdEpisodes;
    private int pontuacao;
    private String review;

    public SerieTemporadas(int qtdEpisodes, Year ano, int pontuacao, String review){
        this.temporada_ano = ano;
        this.qtdEpisodes = qtdEpisodes;
        this.pontuacao = pontuacao;
        this.review = review;
    }

    public Year getTemporada_ano() {return temporada_ano;}
    public void setTemporada_ano(Year temporada_ano) {this.temporada_ano = temporada_ano;}
    public int getPontuacao() {return pontuacao;}
    public void setPontuacao(int pontuacao) {this.pontuacao = pontuacao;}
    public String getReview() {return review;}
    public void setReview(String review) {this.review = review;}
    public Year getAno() {return temporada_ano;}
    public void setAno(Year ano) {this.temporada_ano = ano;}
    public int getQtdEpisodes() {return qtdEpisodes;}
    public void setQtdEpisodes(int qtdEpisodes) {this.qtdEpisodes = qtdEpisodes;}
    @Override
    public String toString() {
        return "{" +
                "ano: " + temporada_ano.getValue() + // Exibindo o ano como número inteiro
                ", qtdEpisodes: " + qtdEpisodes +
                ", review: '" + review + '\'' +
                ", pontuacao: " + pontuacao +
                '}';}
}

class Serie {
    private String titulo;
    private String gender;
    private Year anoLancamento;
    private Year anoEncerramento;
    private String elenco;
    private String tituloOriginal;
    private String ondeVer;
    private float pontuacaoMedia;
    private final List<SerieTemporadas> temporadas;

    public Serie(String titulo, String gender, Year anoLancamento, Year anoEncerramento, String elenco, String tituloOriginal, String ondeVer) {
        this.titulo = titulo;
        this.gender = gender;
        this.anoLancamento = anoLancamento;
        this.anoEncerramento = anoEncerramento;
        this.elenco = elenco;
        this.tituloOriginal = tituloOriginal;
        this.ondeVer = ondeVer;
        this.temporadas = new ArrayList<>();
    }
    public void adicionarTemporada(SerieTemporadas temporada) {this.temporadas.add(temporada);}
    public List<SerieTemporadas> getTemporada() {return this.temporadas;}
    public void removeTemporada(SerieTemporadas temporada) {temporadas.remove(temporada);}

    public float getPontuacaoMedia() {return pontuacaoMedia;}
    public void setPontuacaoMedia(float pontuacaoMedia) {this.pontuacaoMedia = pontuacaoMedia;}
    public String getElenco() {return elenco;}
    public String getTituloOriginal() {return tituloOriginal;}
    public Year getAnoLancamento() {return anoLancamento;}
    public void setAnoLancamento(Year anoLancamento) {this.anoLancamento = anoLancamento;}
    public Year getAnoEncerramento() {return anoEncerramento;}
    public void setAnoEncerramento(Year anoEncerramento) {this.anoEncerramento = anoEncerramento;}
    public String getOndeVer() {return ondeVer;}
    public void setOndeVer(String ondeVer) {this.ondeVer = ondeVer;}
    public void setTituloOriginal(String tituloOriginal) {this.tituloOriginal = tituloOriginal;}
    public void setElenco(String elenco) {this.elenco = elenco;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}
    @Override
    public String toString() {
        return "{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + gender + '\'' +
                ", anoLancamento='" + anoLancamento + '\'' +
                ", anoEncerramento='" + anoEncerramento + '\'' +
                ", elenco='" + elenco + '\'' +
                ", tituloOriginal='" + tituloOriginal + '\'' +
                ", ondeVer='" + ondeVer + '\'' +
                ", temporadas=" + temporadas +
                '}';}
}
