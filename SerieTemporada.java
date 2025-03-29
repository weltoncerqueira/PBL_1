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
    private int pontuacaoMedia;
    private List<SerieTemporadas> temporadas;

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

    public int getPontuacaoMedia() {return pontuacaoMedia;}
    public void setPontuacaoMedia(int pontuacaoMedia) {this.pontuacaoMedia = pontuacaoMedia;}
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
