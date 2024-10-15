package com.tiduswr.model;

import java.awt.Color;
import java.util.List;

/**
 * Classe que representa um jogador no jogo Triple Triad.
 */
public class Player {
    
    /**
     * Nome do jogador.
     */
    private String name;

    /**
     * Pontos iniciais do jogador.
     * O jogador começa com 5 pontos.
     */
    private final int points = 5;

    /**
     * Lista de cartas que o jogador possui.
     * O jogador deve começar com exatamente 5 cartas.
     */
    private List<CardData> cards;

    /**
     * Cor associada ao jogador, usada para diferenciar os jogadores visualmente.
     */
    private Color color;

    /**
     * Construtor da classe Player.
     *
     * @param name  Nome do jogador.
     * @param cards Lista de cartas do jogador, que deve conter exatamente 5 cartas.
     * @param color Cor associada ao jogador.
     * @throws RuntimeException Se a lista de cartas não contiver exatamente 5 cartas.
     */
    public Player(String name, List<CardData> cards, Color color) {
        if (cards.size() != 5) throw new RuntimeException("A mão do jogador, inicialmente, precisa conter exatamente 5 cartas!");
        this.cards = cards;
        this.name = name;
        this.color = color;
    }

    /**
     * Retorna o nome do jogador.
     *
     * @return nome do jogador
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retorna os pontos iniciais do jogador.
     *
     * @return pontos iniciais do jogador (sempre 5)
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Retorna a lista de cartas do jogador.
     *
     * @return lista de cartas do jogador
     */
    public List<CardData> getCards() {
        return this.cards;
    }

    /**
     * Retorna a cor associada ao jogador.
     *
     * @return cor do jogador
     */
    public Color getColor() {
        return this.color;
    }
}