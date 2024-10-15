package com.tiduswr.model;

import java.awt.image.BufferedImage;

/**
 * Classe que representa os dados de uma carta no jogo Triple Triad.
 */
public class CardData {
    
    /**
     * Imagem da carta.
     */
    private BufferedImage image;

    /**
     * Identificador único da carta.
     */
    private int cardId;

    /**
     * Nome da carta.
     */
    private String name;

    /**
     * Valor da carta na direção para cima.
     */
    private int up;

    /**
     * Valor da carta na direção para baixo.
     */
    private int down;

    /**
     * Valor da carta na direção para a esquerda.
     */
    private int left;

    /**
     * Valor da carta na direção para a direita.
     */
    private int right;

    /**
     * Tipo da carta, representando sua classe ou elemento.
     */
    private String type;

    /**
     * Ícone que representa o tipo da carta.
     */
    private BufferedImage typeIcon;

    /**
     * Retorna a imagem da carta.
     *
     * @return imagem da carta
     */
    public BufferedImage getImage() {
        return this.image;
    }

    /**
     * Retorna o identificador único da carta.
     *
     * @return ID da carta
     */
    public int getCardId() {
        return this.cardId;
    }

    /**
     * Retorna o nome da carta.
     *
     * @return nome da carta
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retorna o valor da carta na direção para cima.
     *
     * @return valor para cima
     */
    public int getUp() {
        return this.up;
    }

    /**
     * Retorna o valor da carta na direção para baixo.
     *
     * @return valor para baixo
     */
    public int getDown() {
        return this.down;
    }

    /**
     * Retorna o valor da carta na direção para a esquerda.
     *
     * @return valor para a esquerda
     */
    public int getLeft() {
        return this.left;
    }

    /**
     * Retorna o valor da carta na direção para a direita.
     *
     * @return valor para a direita
     */
    public int getRight() {
        return this.right;
    }

    /**
     * Retorna o tipo da carta.
     *
     * @return tipo da carta
     */
    public String getType() {
        return this.type;
    }

    /**
     * Retorna o ícone que representa o tipo da carta.
     *
     * @return ícone do tipo da carta
     */
    public BufferedImage getTypeIcon() {
        return this.typeIcon;
    }

    /**
     * Define a imagem da carta.
     *
     * @param image imagem da carta
     */
    public void setImage(final BufferedImage image) {
        this.image = image;
    }

    /**
     * Define o identificador único da carta.
     *
     * @param cardId ID da carta
     */
    public void setCardId(final int cardId) {
        this.cardId = cardId;
    }

    /**
     * Define o nome da carta.
     *
     * @param name nome da carta
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Define o valor da carta na direção para cima.
     *
     * @param up valor para cima
     */
    public void setUp(final int up) {
        this.up = up;
    }

    /**
     * Define o valor da carta na direção para baixo.
     *
     * @param down valor para baixo
     */
    public void setDown(final int down) {
        this.down = down;
    }

    /**
     * Define o valor da carta na direção para a esquerda.
     *
     * @param left valor para a esquerda
     */
    public void setLeft(final int left) {
        this.left = left;
    }

    /**
     * Define o valor da carta na direção para a direita.
     *
     * @param right valor para a direita
     */
    public void setRight(final int right) {
        this.right = right;
    }

    /**
     * Define o tipo da carta.
     *
     * @param type tipo da carta
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Define o ícone que representa o tipo da carta.
     *
     * @param typeIcon ícone do tipo da carta
     */
    public void setTypeIcon(final BufferedImage typeIcon) {
        this.typeIcon = typeIcon;
    }
}