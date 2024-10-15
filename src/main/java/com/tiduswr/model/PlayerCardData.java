package com.tiduswr.model;

/**
 * Classe que representa os dados de uma carta pertencente a um jogador no jogo Triple Triad.
 * 
 * Essa classe permite que a mesma instância de uma carta seja utilizada por diferentes jogadores,
 * facilitando a aplicação de regras de modificação e controle de estado durante o jogo.
 */
public class PlayerCardData {

    /**
     * Dados da carta, contendo seus atributos principais.
     */
    private CardData cardData;

    /**
     * Jogador que possui a carta no momento.
     */
    private Player owner;

    /**
     * Modificador utilizado para aplicar regras especiais, como Ascend e Descend.
     * Um valor positivo ou negativo deve ser atribuído para influenciar a comparação
     * dos valores dos lados da carta durante o jogo.
     */
    private int modifier;

    /**
     * Indica se a carta está virada. 
     * Uma carta virada mostra seus valores ao adversário.
     */
    private boolean flipped;

    /**
     * Construtor da classe PlayerCardData.
     *
     * @param cardData Dados da carta.
     * @param owner Jogador que possui a carta.
     * @param modifier Modificador de comparação da carta.
     * @param flipped Estado da carta (virada ou não).
     */
    public PlayerCardData(final CardData cardData, final Player owner, final int modifier, final boolean flipped) {
        this.cardData = cardData;
        this.owner = owner;
        this.modifier = modifier;
        this.flipped = flipped;
    }

    /**
     * Retorna os dados da carta.
     *
     * @return instância de {@link CardData} representando os dados da carta.
     */
    public CardData getCardData() {
        return this.cardData;
    }

    /**
     * Retorna o jogador que possui a carta.
     *
     * @return jogador que possui a carta.
     */
    public Player getOwner() {
        return this.owner;
    }

    /**
     * Retorna o modificador atribuído à carta para as regras especiais.
     *
     * @return valor do modificador (positivo ou negativo).
     */
    public int getModifier() {
        return this.modifier;
    }

    /**
     * Verifica se a carta está virada.
     *
     * @return {@code true} se a carta estiver virada, {@code false} caso contrário.
     */
    public boolean isFlipped() {
        return this.flipped;
    }

    /**
     * Define os dados da carta.
     *
     * @param cardData instância de {@link CardData} representando os dados da carta.
     */
    public void setCardData(final CardData cardData) {
        this.cardData = cardData;
    }

    /**
     * Define o jogador que possui a carta.
     *
     * @param owner jogador que possui a carta.
     */
    public void setOwner(final Player owner) {
        this.owner = owner;
    }

    /**
     * Define o modificador de comparação da carta.
     *
     * @param modifier valor positivo ou negativo que influencia a comparação durante o jogo.
     */
    public void setModifier(final int modifier) {
        this.modifier = modifier;
    }

    /**
     * Define se a carta está virada.
     *
     * @param flipped {@code true} para marcar a carta como virada, {@code false} caso contrário.
     */
    public void setFlipped(final boolean flipped) {
        this.flipped = flipped;
    }
}