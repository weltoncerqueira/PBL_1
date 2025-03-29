// Classe base para itens culturais
package com.pblteste;

import java.util.List;

public class AvaliaLivroFilmeSerie {
    private final CadastraLivroFilmeSerie listcadastro;
   // Scanner scanner = new Scanner(System.in);

    public AvaliaLivroFilmeSerie(CadastraLivroFilmeSerie cadastro) {
        this. listcadastro = cadastro;
    }

    public void AvaliaLivro() {
        List<Livro> listAvaliaLivro =  listcadastro.getListLivro();
        if (listAvaliaLivro.isEmpty()) {
            System.out.println("Nenhum livro cadastrado para avaliação.");
            return;
        }
        for (Livro item : listAvaliaLivro) {
            System.out.print("Avalie o livro (de 1 a 5): ");
            int avaliacao = obterAvaliacao();
            item.setAvaliacao(avaliacao);
            System.out.println("Livro: " + item);
        }
    }

    public void AvaliaFilme() {
        List<Filme> listAvaliaFilme =  listcadastro.getListFilme();
        if (listAvaliaFilme.isEmpty()) {
            System.out.print("Nenhum livro cadastrado para avaliação.");
            return;
        }
        for (Filme item : listAvaliaFilme) {
            System.out.print("Avalie o livro (de 1 a 5): ");
            int avaliacao = obterAvaliacao();
            item.setAvalia_filme(avaliacao);
            System.out.println("Livro: " + item);
        }
    }

    private int obterAvaliacao() {
        System.out.print("Avalie (de 1 a 5): ");
        int avaliacao = 5;

        while (avaliacao < 1 || avaliacao > 5) {
            System.out.print("Avaliação inválida. Insira um valor de 1 a 5: ");
            avaliacao = 3;
        }
        return avaliacao;
    }
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
