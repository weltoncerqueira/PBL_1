// Classe base para itens culturais
public abstract class ItemCultural {
    private String titulo;
    private String genero;
    private int anoLancamento;
    private double avaliacaoMedia;
    private int numeroAvaliacoes;

    // Construtor
    public ItemCultural(String titulo, String genero, int anoLancamento) {
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.avaliacaoMedia = 0.0;
        this.numeroAvaliacoes = 0;
    }

    // Métodos getters e setters
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getAnoLancamento() { return anoLancamento; }
    public double getAvaliacaoMedia() { return avaliacaoMedia; }

    // Método para adicionar uma avaliação
    public void adicionarAvaliacao(int estrelas) {
        if (estrelas < 1 || estrelas > 5) {
            throw new IllegalArgumentException("A avaliação deve ser entre 1 e 5 estrelas.");
        }
        double totalEstrelas = this.avaliacaoMedia * this.numeroAvaliacoes;
        totalEstrelas += estrelas;
        this.numeroAvaliacoes++;
        this.avaliacaoMedia = totalEstrelas / this.numeroAvaliacoes;
    }
}

// Classe Livro que herda de ItemCultural
public class Livro extends ItemCultural {
    private String autor;
    private String editora;
    private String isbn;

    // Construtor
    public Livro(String titulo, String genero, int anoLancamento, String autor, String editora, String isbn) {
        super(titulo, genero, anoLancamento);
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
    }

    // Métodos getters e setters
    public String getAutor() { return autor; }
    public String getEditora() { return editora; }
    public String getIsbn() { return isbn; }
}

// Classe Filme que herda de ItemCultural
public class Filme extends ItemCultural {
    private String diretor;
    private int duracao; // em minutos

    // Construtor
    public Filme(String titulo, String genero, int anoLancamento, String diretor, int duracao) {
        super(titulo, genero, anoLancamento);
        this.diretor = diretor;
        this.duracao = duracao;
    }

    // Métodos getters e setters
    public String getDiretor() { return diretor; }
    public int getDuracao() { return duracao; }
}

// Classe Serie que herda de ItemCultural
public class Serie extends ItemCultural {
    private int numeroTemporadas;

    // Construtor
    public Serie(String titulo, String genero, int anoLancamento, int numeroTemporadas) {
        super(titulo, genero, anoLancamento);
        this.numeroTemporadas = numeroTemporadas;
    }

    // Métodos getters e setters
    public int getNumeroTemporadas() { return numeroTemporadas; }
}
