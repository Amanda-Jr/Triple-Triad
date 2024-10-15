package com.tiduswr.view.listeners;

import com.tiduswr.view.CardAddedEvent;

/**
 * Interface para escutar eventos de adição de cartas.
 */
public interface CardAddedListener {
    
    /**
     * Método chamado quando uma carta é adicionada.
     *
     * @param event O evento que contém informações sobre a carta adicionada.
     */
    void onCardAdded(CardAddedEvent event);
}
