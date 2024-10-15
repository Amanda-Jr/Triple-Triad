package com.tiduswr.view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import com.tiduswr.model.CardData;
import com.tiduswr.model.PlayerCardData;
import com.tiduswr.view.listeners.CardAddedListener;
import com.tiduswr.view.listeners.PositionListener;

/**
 * Classe que representa o tabuleiro do jogo Triple Triad, onde as cartas são dispostas
 * e os eventos de interação com o campo são tratados.
 */
public class Board extends BackgroundPanel {
    
    /**
     * Matriz de componentes de cartas que representa as posições do tabuleiro.
     */
    private CardComponent[][] boardButtons;
    
    /**
     * Lista contendo todas as cartas carregadas do arquivo CSV.
     */
    private List<CardData> allCards;
    
    /**
     * Lista de ouvintes para o evento de adição de carta no tabuleiro.
     */
    private List<CardAddedListener> cardAddedListeners;
    
    /**
     * Lista de ouvintes para o evento de clique em uma posição do tabuleiro.
     */
    private List<PositionListener> positionListeners;

    /**
     * Construtor da classe Board que inicializa o tabuleiro com um fundo e uma lista de cartas.
     *
     * @param filename O nome do arquivo da imagem de fundo do tabuleiro.
     * @param allCards A lista de todas as cartas disponíveis.
     */
    public Board(String filename, List<CardData> allCards) {
        super(filename);
        boardButtons = new CardComponent[3][3];
        setLayout(new GridLayout(3, 3));
        this.allCards = allCards;
        this.cardAddedListeners = new ArrayList<>();
        this.positionListeners = new ArrayList<>();
        initializeBoard();
    }

    /**
     * Adiciona um ouvinte que será notificado quando uma carta for adicionada ao tabuleiro.
     *
     * @param listener O ouvinte a ser adicionado.
     */
    public void addCardAddedListener(CardAddedListener listener) {
        cardAddedListeners.add(listener);
    }

    /**
     * Adiciona um ouvinte que será notificado quando uma posição no tabuleiro for clicada.
     *
     * @param listener O ouvinte a ser adicionado.
     */
    public void addPositionListener(PositionListener listener) {
        positionListeners.add(listener);
    }

    /**
     * Adiciona uma carta na posição especificada do tabuleiro.
     *
     * @param cardData Os dados da carta a ser adicionada.
     * @param row A linha onde a carta será adicionada.
     * @param col A coluna onde a carta será adicionada.
     * @return True se a carta foi adicionada com sucesso, false caso contrário.
     */
    public boolean addCard(PlayerCardData cardData, int row, int col) {
        if (boardButtons[row][col].getInfo() != null) return false;
        boardButtons[row][col].setInfo(cardData);
        configureCardAddedListeners(cardData, row, col);
        redrawCards();
        return true;
    }

    /**
     * Atualiza a exibição das cartas no tabuleiro.
     */
    private void redrawCards() {
        removeAll();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(boardButtons[i][j]);
            }
        }
        revalidate();
        repaint();
    }

    /**
     * Configura os ouvintes para serem notificados quando uma carta for adicionada ao tabuleiro.
     *
     * @param card Os dados da carta adicionada.
     * @param row A linha onde a carta foi adicionada.
     * @param col A coluna onde a carta foi adicionada.
     */
    private void configureCardAddedListeners(PlayerCardData card, int row, int col) {
        CardAddedEvent event = createCardAddedEvent(card, row, col);
        cardAddedListeners.forEach(listener -> listener.onCardAdded(event));
    }

    /**
     * Notifica todos os ouvintes sobre um clique em uma posição específica do tabuleiro.
     *
     * @param row A linha da posição clicada.
     * @param col A coluna da posição clicada.
     */
    private void notifyPositionListeners(int row, int col) {
        positionListeners.forEach(listener -> listener.onPositionClicked(row, col));
    }

    /**
     * Cria um evento de adição de carta, contendo as cartas adjacentes (se houver).
     *
     * @param card Os dados da carta adicionada.
     * @param row A linha onde a carta foi adicionada.
     * @param col A coluna onde a carta foi adicionada.
     * @return Um evento de adição de carta, incluindo as cartas adjacentes.
     */
    private CardAddedEvent createCardAddedEvent(PlayerCardData card, int row, int col) {
        PlayerCardData top = (row > 0) ? boardButtons[row - 1][col].getInfo() : null;
        PlayerCardData bottom = (row < 2) ? boardButtons[row + 1][col].getInfo() : null;
        PlayerCardData left = (col > 0) ? boardButtons[row][col - 1].getInfo() : null;
        PlayerCardData right = (col < 2) ? boardButtons[row][col + 1].getInfo() : null;
        return new CardAddedEvent(card, top, bottom, left, right);
    }

    /**
     * Reinicia o tabuleiro, removendo todas as cartas.
     */
    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardButtons[i][j] != null) {
                    boardButtons[i][j].setInfo(null);
                }
            }
        }
        repaint();
    }

    /**
     * Inicializa o tabuleiro criando os componentes de carta para cada posição.
     */
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int row = i;
                final int col = j;
                var card = new CardComponent(null, e -> notifyPositionListeners(row, col), 10);
                boardButtons[i][j] = card;
                add(card);
            }
        }
        revalidate();
    }

    /**
     * Obtém a matriz de componentes de cartas do tabuleiro.
     *
     * @return A matriz de componentes de cartas.
     */
    public CardComponent[][] getBoardCards() {
        return boardButtons;
    }

    /**
     * Obtém a lista de todas as cartas carregadas do arquivo CSV.
     *
     * @return A lista de todas as cartas.
     */
    public List<CardData> getAllCards() {
        return this.allCards;
    }

    /**
     * Obtém a lista de ouvintes para o evento de adição de carta.
     *
     * @return A lista de ouvintes de adição de carta.
     */
    public List<CardAddedListener> getCardAddedListeners() {
        return this.cardAddedListeners;
    }

    /**
     * Obtém a lista de ouvintes para o evento de clique em uma posição do tabuleiro.
     *
     * @return A lista de ouvintes de posição.
     */
    public List<PositionListener> getPositionListeners() {
        return this.positionListeners;
    }
}