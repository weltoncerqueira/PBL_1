class Filme {
    private String titulo;
    private String genero; // Alterado para português para manter consistência com outros exemplos
    private Year anoLancamento;
    private String duracao; // Tempo de duração em horas ou minutos
    private String direcao; // Nome do(s) diretor(es)
    private String roteiro; // Nome do(s) roteirista(s)
    private String elenco;  // Nome do(s) ator(es)
    private String tituloOriginal;
    private String ondeAssistir; // Onde o filme está disponível para assistir
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
