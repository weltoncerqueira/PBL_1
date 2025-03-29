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
