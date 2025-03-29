class BuscaFilmeSerie {
    private final CadastraLivroFilmeSerie cadastro;
    public BuscaFilmeSerie(CadastraLivroFilmeSerie cadastro) {this.cadastro = cadastro;}

    public Filme PorTitulo(String titulo){
        List<Filme> listBuscaFilme = cadastro.getListFilme();
        for (Filme filme : listBuscaFilme){
            if (filme.getTitulo().toLowerCase().trim().equalsIgnoreCase(titulo.toLowerCase().trim()))
                return filme;
        } return null;
    }

    public Filme PorDiretor(String diretor){
        List<Filme> listBuscaFilme = cadastro.getListFilme();
        for (Filme filme : listBuscaFilme){
            if (filme.getDirecao().toLowerCase().trim().equalsIgnoreCase(diretor.toLowerCase().trim()))
                return filme;
        } return null;
    }

    public Filme PorGenero(String genero){
        List<Filme> listBuscaFilme = cadastro.getListFilme();
        for (Filme filme : listBuscaFilme){
            if (filme.getGenero().toLowerCase().trim().equalsIgnoreCase(genero.toLowerCase().trim()))
                return filme;
        } return null;
    }

    public Filme PorAnoLancamento(Year ano){
        List<Filme> listBuscaFilme = cadastro.getListFilme();
        for (Filme filme : listBuscaFilme){
            if (filme.getAnoLancamento().equals(ano))
                return filme;
        } return null;
    }

    // ator no elenco
    public Filme PorAtor(String ator){
        List<Filme> listBuscaFilme = cadastro.getListFilme();
        for (Filme filme : listBuscaFilme){
            if(filme.getElenco().toLowerCase().trim().contains(ator.toLowerCase().trim())){
                return filme;
            }
        }return null;
    }

    public Serie BuscaSeriePorTitulo(String titulo){
        List<Serie> listBuscaSerie = cadastro.getListSerie();
        for (Serie serie : listBuscaSerie){
            if (serie.getElenco().toLowerCase().trim().contains(titulo.toLowerCase().trim()))
                return serie;
        } return null;
    }
}

class BuscaLivro {
    private final CadastraLivroFilmeSerie cadastra;
    public BuscaLivro(CadastraLivroFilmeSerie cadastro) {this.cadastra = cadastro;}

    public Livro PorTitulo(String titulo) {
        List<Livro> listAvaliaLivro = cadastra.getListLivro();
        for (Livro livro : listAvaliaLivro) {
            if (livro.getTitulo().toLowerCase().trim().equalsIgnoreCase(titulo.toLowerCase().trim()))
                return livro;
        } return null;
    }

    public Livro PorAutor(String autor){
        List<Livro> listAvaliaLivro =  cadastra.getListLivro();
        for (Livro livro : listAvaliaLivro) {
            if (livro.getAutor().toLowerCase().trim().equalsIgnoreCase(autor.toLowerCase().trim()))
                return livro;
        } return null;
    }

    public Livro PorGenero(String genero){
        List<Livro> listAvaliaLivro =  cadastra.getListLivro();
        for (Livro livro : listAvaliaLivro) {
            if (livro.getGender().toLowerCase().trim().equalsIgnoreCase(genero.toLowerCase().trim()))
                return livro;
        } return null;
    }

    public Livro PorAno(Year ano){
        List<Livro> listAvaliaLivro =  cadastra.getListLivro();
        for (Livro livro : listAvaliaLivro) {
            if (livro.getPublicAno().equals(ano))
                return livro;
        } return null;
    }

    public Livro PorISBN(String isbn){
        List<Livro> listAvaliaLivro =  cadastra.getListLivro();
        for (Livro livro : listAvaliaLivro) {
            if (livro.getIsbn().toLowerCase().trim().equals(isbn.toLowerCase().trim()))
                return livro;
        } return null;
    }
}
