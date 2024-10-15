package com.tiduswr.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Classe que representa um painel com um fundo personalizado.
 */
public class BackgroundPanel extends JPanel {

    /** 
     * Imagem de fundo
     */
    private BufferedImage backgroundImage;

    /**
     * Construtor que carrega a imagem de fundo a partir do nome do arquivo fornecido.
     *
     * @param fileName O nome do arquivo da imagem de fundo.
     */
    public BackgroundPanel(String fileName) {
        try {
            backgroundImage = ImageIO.read(getClass().getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que pinta o componente, desenhando a imagem de fundo.
     *
     * @param g O objeto Graphics utilizado para desenhar no painel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}