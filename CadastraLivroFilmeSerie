import java.util.HashMap;
import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastraLivroFilmeSerie {

    public void CadastraLivro(String titulo, String autor, String editora, String isbn, String publicAno, String gender, String exemplar) {
        if (titulo == null || autor == null || editora == null || isbn == null || publicAno == null || gender == null || exemplar == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        }
        Map<String, Livro> diclivro = new HashMap<>();
        for (Map.Entry<String, Livro> entry : diclivro.entrySet()) {
            if (entry.getValue().equals(isbn)) {
                throw new RuntimeException("Livro Já cadastrado.");}
        } diclivro.put(isbn, new Livro(titulo, autor, editora, isbn, publicAno, gender, exemplar));
    }

    public void CadastraSerie(String titulo, String gender, String inicioAno, String fimAno, String elenco, String tituloOriginal, String ondeVer) {
        if (titulo == null || gender == null || inicioAno == null || fimAno == null || elenco == null || tituloOriginal == null || ondeVer == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        }
        Map<String, Serie> dicSerie = new HashMap<>();
        for (Map.Entry<String, Serie> entry : dicSerie.entrySet()) {
            if (entry.getValue().equals(titulo)) {
                throw new RuntimeException("Série Já cadastrada.");}
        }  dicSerie.put(tituloOriginal, new Serie());
    }

}
