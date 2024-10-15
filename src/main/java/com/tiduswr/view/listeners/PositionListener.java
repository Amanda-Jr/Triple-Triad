package com.tiduswr.view.listeners;

/**
 * Interface para escutar eventos de clique em posições.
 */
public interface PositionListener {
    
    /**
     * Método chamado quando uma posição é clicada.
     *
     * @param row A linha da posição clicada.
     * @param col A coluna da posição clicada.
     */
    void onPositionClicked(int row, int col);
}