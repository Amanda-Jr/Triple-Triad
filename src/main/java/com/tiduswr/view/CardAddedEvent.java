package com.tiduswr.view;

import com.tiduswr.model.PlayerCardData;

/**
 * Classe que representa um evento de adição de uma carta no tabuleiro.
 * Esse evento armazena informações sobre a carta que foi adicionada e suas
 * cartas adjacentes (se houver), facilitando a aplicação de regras baseadas
 * na proximidade das cartas.
 */
public class CardAddedEvent {
    
    /**
     * A carta que foi adicionada ao tabuleiro.
     */
    private PlayerCardData card;
    
    /**
     * A carta que está acima da carta adicionada, se houver.
     */
    private PlayerCardData top;
    
    /**
     * A carta que está abaixo da carta adicionada, se houver.
     */
    private PlayerCardData bottom;
    
    /**
     * A carta que está à esquerda da carta adicionada, se houver.
     */
    private PlayerCardData left;
    
    /**
     * A carta que está à direita da carta adicionada, se houver.
     */
    private PlayerCardData right;

    /**
     * Construtor da classe `CardAddedEvent`.
     * Inicializa o evento com a carta adicionada e suas cartas adjacentes.
     *
     * @param card A carta que foi adicionada ao tabuleiro.
     * @param top A carta que está acima, ou null se não houver.
     * @param bottom A carta que está abaixo, ou null se não houver.
     * @param left A carta que está à esquerda, ou null se não houver.
     * @param right A carta que está à direita, ou null se não houver.
     */
    public CardAddedEvent(final PlayerCardData card, final PlayerCardData top, final PlayerCardData bottom, final PlayerCardData left, final PlayerCardData right) {
        this.card = card;
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    /**
     * Obtém a carta que foi adicionada ao tabuleiro.
     *
     * @return A carta adicionada.
     */
    public PlayerCardData getCard() {
        return this.card;
    }

    /**
     * Define a carta que foi adicionada ao tabuleiro.
     *
     * @param card A carta a ser definida.
     */
    public void setCard(final PlayerCardData card) {
        this.card = card;
    }

    /**
     * Obtém a carta que está acima da carta adicionada.
     *
     * @return A carta acima, ou null se não houver.
     */
    public PlayerCardData getTop() {
        return this.top;
    }

    /**
     * Define a carta que está acima da carta adicionada.
     *
     * @param top A carta acima a ser definida.
     */
    public void setTop(final PlayerCardData top) {
        this.top = top;
    }

    /**
     * Obtém a carta que está abaixo da carta adicionada.
     *
     * @return A carta abaixo, ou null se não houver.
     */
    public PlayerCardData getBottom() {
        return this.bottom;
    }

    /**
     * Define a carta que está abaixo da carta adicionada.
     *
     * @param bottom A carta abaixo a ser definida.
     */
    public void setBottom(final PlayerCardData bottom) {
        this.bottom = bottom;
    }

    /**
     * Obtém a carta que está à esquerda da carta adicionada.
     *
     * @return A carta à esquerda, ou null se não houver.
     */
    public PlayerCardData getLeft() {
        return this.left;
    }

    /**
     * Define a carta que está à esquerda da carta adicionada.
     *
     * @param left A carta à esquerda a ser definida.
     */
    public void setLeft(final PlayerCardData left) {
        this.left = left;
    }

    /**
     * Obtém a carta que está à direita da carta adicionada.
     *
     * @return A carta à direita, ou null se não houver.
     */
    public PlayerCardData getRight() {
        return this.right;
    }

    /**
     * Define a carta que está à direita da carta adicionada.
     *
     * @param right A carta à direita a ser definida.
     */
    public void setRight(final PlayerCardData right) {
        this.right = right;
    }
}