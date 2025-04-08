package com.pblteste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;
class BuscaFilmeSerieTest {
    private CadastraLivroFilmeSerie cadastro;
    private BuscaFilmeSerie buscaFilmeSerie;

    @BeforeEach
    public void setUp() {
        cadastro = new CadastraLivroFilmeSerie();
        buscaFilmeSerie = new BuscaFilmeSerie(cadastro);

        // Adicionando filmes de exemplo ao cadastro
        cadastro.cadastraFilme("Filme Exemplo", "Ação", Year.of(2020), "120 min", "Diretor Exemplo", "Roteirista Exemplo", "Ator Exemplo", "Título Original", "Netflix", 5);
        cadastro.cadastraFilme("Outro Filme", "Comédia", Year.of(2019), "90 min", "Outro Diretor", "Outro Roteirista", "Outra Atriz", "Outro Título", "Amazon Prime", 4);
    }

    @Test
    public void testBuscaPorTitulo() {
        Filme filme = buscaFilmeSerie.porTitulo("Filme Exemplo");
        assertNotNull(filme);
        assertEquals("Filme Exemplo", filme.getTitulo());
    }

    @Test
    public void testBuscaPorDiretor() {
        Filme filme = buscaFilmeSerie.porDiretor("Diretor Exemplo");
        assertNotNull(filme);
        assertEquals("Diretor Exemplo", filme.getDirecao());
    }

    @Test
    public void testBuscaPorGenero() {
        Filme filme = buscaFilmeSerie.porGenero("Ação");
        assertNotNull(filme);
        assertEquals("Ação", filme.getGenero());
    }

    @Test
    public void testBuscaPorAnoLancamento() {
        Filme filme = buscaFilmeSerie.porAnoLancamento(Year.of(2020));
        assertNotNull(filme);
        assertEquals(Year.of(2020), filme.getAnoLancamento());
    }

    @Test
    public void testBuscaPorAtor() {
        Filme filme = buscaFilmeSerie.porAtor("Ator Exemplo");
        assertNotNull(filme);
        assertTrue(filme.getElenco().contains("Ator Exemplo"));
    }

    @Test
    public void testBuscaSeriePorTitulo() {
        // Adicionando uma série de exemplo ao cadastro
        cadastro.cadastraSerie("Série Exemplo", "Drama", Year.of(2021), Year.of(2022), "Elenco Exemplo", "Título Original Série", "HBO Max", 10, Year.of(2021), 5, "Ótima série");

        Serie serie = buscaFilmeSerie.buscaSeriePorTitulo("Série Exemplo");
        assertNotNull(serie);
        assertEquals("Série Exemplo", serie.getTitulo());
    }
}
