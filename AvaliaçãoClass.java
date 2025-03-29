class AvaliaLivroFilmeSerie {
    private final CadastraLivroFilmeSerie listcadastro;

    public AvaliaLivroFilmeSerie(CadastraLivroFilmeSerie cadastro) {
        this. listcadastro = cadastro;
    }

    public void AvaliaLivro(int avaliacaoUsuario, String tituloOriginal) {
        List<Livro> listAvaliaLivro =  listcadastro.getListLivro();
        if (listAvaliaLivro.isEmpty()) {
            System.out.println("Nenhum livro cadastrado para avaliação.");
            return;
        }
        for (Livro livro : listAvaliaLivro) {
            if (!livro.getTitulo().equals(tituloOriginal))
                System.out.println("Livro não encontrado no banco de dados");
            else {
                livro.setAvaliacao(avaliacaoUsuario);
                System.out.println("Livro: " + livro);
            }
        }
    }

    public void AvaliaFilme(int avaliacaoUsuario, String tituloOriginal) {
        List<Filme> listAvaliaFilme =  listcadastro.getListFilme();
        if (listAvaliaFilme.isEmpty()) {
            System.out.print("Nenhum Filme cadastrado para avaliação.");
            return;
        }
        for (Filme filme : listAvaliaFilme) {
            if (!filme.getTitulo().equals(tituloOriginal))
                System.out.println("Filme não encontrado no banco de dados");
            else {
                filme.setAvalia_filme(avaliacaoUsuario);
                System.out.println("Livro: " + filme);
            }
        }
    }

    public void AvaliaSerie(int avaliacaoUsuario, String tituloOriginal){
        List<Serie> listAvaliaTemporada = listcadastro.getListSerie();

        if (listAvaliaTemporada.isEmpty()) {
            System.out.println("Nenhuma série cadastrada para avaliação.");
            return;}
        for (Serie serie : listAvaliaTemporada){
            if(!serie.getTitulo().equals(tituloOriginal))
                System.out.println("Série não encontrada no banco de dados");
            else{
                serie.getTemporada().getFirst().setPontuacao(avaliacaoUsuario);
                System.out.println("AvaliaSerie: " + serie.getTemporada().getFirst().getPontuacao());
            }
        }
    }

    public void TemporadasReview(String review, String tituloOriginal){
        List<Serie> listAvaliaTemporada = listcadastro.getListSerie();
        if (listAvaliaTemporada.isEmpty()) {
            System.out.println("Nenhuma série cadastrada para avaliação.");
            return;}
        for (Serie serie : listAvaliaTemporada){
            if(!serie.getTitulo().equals(tituloOriginal)){
                System.out.println("Série não encontrada no banco de dados");
            } else{
                serie.getTemporada().getFirst().setReview(review);
                System.out.println("Review: " + serie.getTemporada().getFirst().getReview());
            }
        }
    }
}
