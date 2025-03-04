public class Livro {
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

}
