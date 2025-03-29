class Serie {
    private String titulo;
    private String gender;
    private Year anoLancamento;
    private Year anoEncerramento;
    private String elenco;
    private String tituloOriginal;
    private String ondeVer;

    public Serie(String titulo, String gender, Year anoLancamento, Year anoEncerramento, String elenco, String tituloOriginal, String ondeVer) {
        this.titulo = titulo;
        this.gender = gender;
        this.anoLancamento = anoLancamento;
        this.anoEncerramento = anoEncerramento;
        this.elenco = elenco;
        this.tituloOriginal = tituloOriginal;
        this.ondeVer = ondeVer;
    }
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
                '}';}
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
