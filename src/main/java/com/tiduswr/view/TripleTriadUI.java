package com.tiduswr.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tiduswr.model.CardData;
import com.tiduswr.model.Player;
import com.tiduswr.model.SoundServices;

/**
 * Classe principal da interface gráfica do jogo Triple Triad.
 * <p>
 * Esta classe herda de {@link JFrame} e é responsável por inicializar e gerenciar todos os componentes da interface
 * do jogo, incluindo o tabuleiro, as mãos dos jogadores, o painel de pontuação e o log de jogadas.
 * Também gerencia os serviços de som e interações do jogador com a interface.
 * </p>
 * <p>
 * A interface foi projetada para uma resolução de tela fixa (800x700), onde cada componente é ajustado para se
 * adequar ao espaço disponível.
 * </p>
 */
public class TripleTriadUI extends JFrame {

    /**
     * O tabuleiro principal do jogo onde as cartas são jogadas.
     */
    private Board board;

    /**
     * O painel que exibe o log de jogadas, onde são registradas as ações dos jogadores.
     */
    private GameLog gameLog;

    /**
     * Painel que contém as cartas do jogador 1.
     */
    private PlayerCards p1;

    /**
     * Painel que contém as cartas do jogador 2.
     */
    private PlayerCards p2;

    /**
     * Largura do log de jogadas.
     */
    private final int glW;

    /**
     * Altura do log de jogadas.
     */
    private final int glH;

    /**
     * Largura do painel de cartas dos jogadores.
     */
    private final int plW;

    /**
     * Altura do painel de cartas dos jogadores.
     */
    private final int plH;

    /**
     * Largura do painel de pontuação.
     */
    private final int spW;

    /**
     * Altura do painel de pontuação.
     */
    private final int spH;

    /**
     * Dimensões fixas da janela do jogo.
     */
    private final Dimension SCREEN_SIZE = new Dimension(800, 700);

    /**
     * Serviços de som para tocar músicas e efeitos sonoros no jogo.
     */
    private final SoundServices soundServices;

    /**
     * Construtor da interface gráfica Triple Triad.
     * <p>
     * Inicializa a interface do jogo configurando todos os componentes principais: tabuleiro, mãos dos jogadores, painel de pontuação e log de jogadas.
     * Também configura os serviços de som e define o comportamento ao fechar a janela.
     * </p>
     * 
     * @param cards Lista contendo as informações das cartas que serão utilizadas no jogo.
     * @param soundServices Serviços de som para gerenciar a música de fundo e os efeitos sonoros.
     * @throws IOException Caso ocorra um erro ao carregar os recursos de som.
     */
    public TripleTriadUI(List<CardData> cards, SoundServices soundServices) throws IOException {
        this.soundServices = soundServices;

        // Configura o comportamento ao fechar a janela (encerra a música tema principal)
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                soundServices.getSoundService("main-theme").close();
            }
        });

        // Configurações da janela
        setTitle("Triple Triad");
        setSize(SCREEN_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        // Cálculo das dimensões dos componentes
        plW = (int) (getWidth() * 0.17);
        plH = getHeight();
        glW = getWidth();
        glH = (int) (getHeight() * 0.12);
        spW = getWidth();
        spH = (int) (getHeight() * 0.04);

        // Inicializa o log de jogadas
        gameLog = new GameLog();
        gameLog.setPreferredSize(new Dimension(glW, glH)); 
        gameLog.setBorder(BorderFactory.createTitledBorder("Log de Jogadas"));

        // Wrapper para o tabuleiro do jogo
        JPanel boardWrapper = new JPanel(new BorderLayout());
        board = new Board("/back.png", cards);
        boardWrapper.add(board, BorderLayout.CENTER);
        boardWrapper.setBorder(BorderFactory.createTitledBorder("Campo"));

        // MUDAR ESSA PARTE, POIS É APENAS PARA TESTES!!!
        //Seleção aleatória de 5 cartas para cada jogador
        List<CardData> cardsP1 = new ArrayList<>();
        List<CardData> cardsP2 = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            cardsP1.add(cards.get(random.nextInt(cards.size())));
            cardsP2.add(cards.get(random.nextInt(cards.size())));
        }
        Player jose = new Player("José", cardsP1, Color.decode("#08C2FF")); // Jogador 1
        Player maria = new Player("Maria", cardsP2, Color.decode("#C96868")); // Jogador 2
        p1 = new PlayerCards(this, jose, plW, plH);
        p2 = new PlayerCards(this, maria, plW, plH);
        p2.setCardsActive(false); // Exemplo de como desabilitar a mão de um jogador (pra você ficar mudando os turnos)
        p2.processAllPlayerCardData((indice, carta) -> {
            carta.setFlipped(indice % 2 == 0); // Exemplo de como você pode definir quais cartas vão ficar viradas pra baixo
        });

        JPanel scorePanel = new ScorePanel(p1.getPlayer(), p2.getPlayer());
        scorePanel.setPreferredSize(new Dimension(spW, spH)); // Ajusta a altura do painel de pontuação

        // Cria o painel central que contém o tabuleiro e o log de jogadas
        JPanel centerPanel = new JPanel(new BorderLayout(0, 0));
        centerPanel.add(scorePanel, BorderLayout.NORTH);
        centerPanel.add(boardWrapper, BorderLayout.CENTER);
        centerPanel.add(gameLog, BorderLayout.SOUTH);

        // Adiciona os componentes à interface principal
        add(centerPanel, BorderLayout.CENTER);
        add(p1, BorderLayout.WEST);
        add(p2, BorderLayout.EAST);

        // Configurações finais da janela
        setLocationRelativeTo(null);
        soundServices.getSoundService("main-theme").playThenLoop("theme-loop.wav");
        
        setVisible(true); //Deve ser o ultimo método chamado!
    }

    /**
     * Retorna o tabuleiro do jogo.
     * 
     * @return O tabuleiro {@link Board} onde as cartas são jogadas.
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * Retorna o log de jogadas do jogo.
     * 
     * @return O log de jogadas {@link GameLog} onde as ações dos jogadores são registradas.
     */
    public GameLog getGameLog() {
        return this.gameLog;
    }

    /**
     * Retorna o painel de cartas do jogador 1.
     * 
     * @return O painel de cartas {@link PlayerCards} do jogador 1.
     */
    public PlayerCards getP1() {
        return this.p1;
    }

    /**
     * Retorna o painel de cartas do jogador 2.
     * 
     * @return O painel de cartas {@link PlayerCards} do jogador 2.
     */
    public PlayerCards getP2() {
        return this.p2;
    }

    /**
     * Retorna a largura do log de jogadas.
     * 
     * @return A largura do log de jogadas.
     */
    public int getGlW() {
        return this.glW;
    }

    /**
     * Retorna a altura do log de jogadas.
     * 
     * @return A altura do log de jogadas.
     */
    public int getGlH() {
        return this.glH;
    }

    /**
     * Retorna a largura do painel de cartas dos jogadores.
     * 
     * @return A largura do painel de cartas.
     */
    public int getPlW() {
        return this.plW;
    }

    /**
     * Retorna a altura do painel de cartas dos jogadores.
     * 
     * @return A altura do painel de cartas.
     */
    public int getPlH() {
        return this.plH;
    }

    /**
     * Retorna a largura do painel de pontuação.
     * 
     * @return A largura do painel de pontuação.
     */
    public int getSpW() {
        return this.spW;
    }

    /**
     * Retorna a altura do painel de pontuação.
     * 
     * @return A altura do painel de pontuação.
     */
    public int getSpH() {
        return this.spH;
    }

    /**
     * Retorna as dimensões fixas da tela do jogo.
     * 
     * @return As dimensões {@link Dimension} da janela do jogo.
     */
    public Dimension getSCREEN_SIZE() {
        return this.SCREEN_SIZE;
    }

    /**
     * Retorna os serviços de som utilizados no jogo.
     * 
     * @return Os serviços de som {@link SoundServices} para controlar músicas e efeitos sonoros.
     */
    public SoundServices getSoundServices() {
        return this.soundServices;
    }
}