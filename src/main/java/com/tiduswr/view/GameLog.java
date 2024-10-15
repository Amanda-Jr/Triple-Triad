package com.tiduswr.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Componente que representa o registro de mensagens do jogo.
 * Exibe mensagens de log com timestamp em um painel com rolagem.
 */
public class GameLog extends JPanel {
    /** Área onde as mensagens de log são exibidas */
    private JTextPane logArea; 
    
    /**
     * Construtor da classe GameLog.
     * Inicializa o painel e a área de texto para exibir mensagens de log.
     */
    public GameLog() {
        setLayout(new BorderLayout());
        
        logArea = new JTextPane();
        logArea.setEditable(false);
        logArea.setContentType("text/html");

        JScrollPane scrollPane = new JScrollPane(logArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Adiciona uma mensagem de log à área de log com um timestamp.
     *
     * @param message A mensagem a ser adicionada ao log.
     */
    public void addLogMessage(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);

        Style style = logArea.addStyle("Bold", null);
        StyleConstants.setBold(style, true); 
        StyleConstants.setForeground(style, Color.BLACK);

        StyledDocument doc = logArea.getStyledDocument();

        try {
            doc.insertString(doc.getLength(), "[" + timestamp + "] ", logArea.getStyle("Bold"));
            doc.insertString(doc.getLength(), message + "\n", null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Rola para a última linha
        logArea.setCaretPosition(doc.getLength());
    }
}