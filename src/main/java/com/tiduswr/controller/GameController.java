package com.tiduswr.controller;

import java.io.IOException;

import javax.swing.SwingUtilities;

import com.tiduswr.model.CardsReader;
import com.tiduswr.model.SoundServices;
import com.tiduswr.view.TripleTriadUI;

/**
 * Classe responsável por controlar a criação da interface do jogo e o gerenciamento de recursos.
 */
public class GameController {
    
    /**
     * Cria a janela do jogo e inicializa os serviços de som e cartas.
     */
    public void createWindow(){
        var cards = CardsReader.readCardsFromCSV();
        var soundServices = new SoundServices();
        soundServices.createSoundService("main-theme", "theme-start.wav");
        soundServices.createSoundService("selection", "selection.wav");
        soundServices.createSoundService("card-placed", "card-placed.wav", 0.7f);
        soundServices.createSoundService("error", "error.wav", 0.7f);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new TripleTriadUI(cards, soundServices);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}