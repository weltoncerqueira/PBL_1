public class Serie {
    private String titulo;
    private String gender;
    private String anolancamento;
    private String anoEncerramento;
    private String elenco;
    private String tituloOriginal;
    private String ondeVer;

    public String getElenco() {
        return elenco;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public String getAnolancamento() {
        return anolancamento;
    }

    public void setAnolancamento(String anolancamento) {
        this.anolancamento = anolancamento;
    }

    public String getAnoEncerramento() {
        return anoEncerramento;
    }

    public void setAnoEncerramento(String anoEncerramento) {
        this.anoEncerramento = anoEncerramento;
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
}
