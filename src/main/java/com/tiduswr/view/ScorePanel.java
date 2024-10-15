package com.tiduswr.view;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tiduswr.model.Player;

/**
 * Painel responsável por exibir a pontuação de dois jogadores durante um jogo.
 * A pontuação é exibida em um formato que segue o padrão "Jogador 1 : Jogador 2".
 * <p>
 * Este painel é utilizado para manter o usuário informado sobre a pontuação atualizada de cada jogador
 * e pode ser atualizado dinamicamente quando a pontuação de um dos jogadores mudar.
 * </p>
 */
public class ScorePanel extends JPanel {
    
    /**
     * Rótulo que exibe a pontuação atual dos jogadores.
     */
    private JLabel scoreLabel;
    
    /**
     * Primeiro jogador cujo placar será exibido.
     */
    private Player p1;
    
    /**
     * Segundo jogador cujo placar será exibido.
     */
    private Player p2;

    /**
     * Construtor da classe ScorePanel.
     * <p>
     * Inicializa o painel com os dois jogadores fornecidos e cria a interface gráfica 
     * que exibirá a pontuação de cada jogador.
     * </p>
     * 
     * @param p1 O primeiro jogador cuja pontuação será exibida.
     * @param p2 O segundo jogador cuja pontuação será exibida.
     */
    public ScorePanel(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        createScorePanel();
    }

    /**
     * Método auxiliar para configurar a interface do painel de pontuação.
     * <p>
     * Este método define o layout do painel como uma disposição vertical (BoxLayout),
     * cria o rótulo de pontuação com o formato "Pontuação do Jogador 1 : Pontuação do Jogador 2"
     * e define o estilo da fonte.
     * </p>
     * <p>
     * O rótulo é centralizado e o painel recebe uma borda superior para espaçamento.
     * </p>
     */
    private void createScorePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        scoreLabel = new JLabel(String.format("%d : %d", p1.getPoints(), p2.getPoints()));
        scoreLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        setBorder(new EmptyBorder(5, 0, 0, 0)); // Adiciona espaçamento na parte superior
        add(scoreLabel);
    }

    /**
     * Atualiza o rótulo de pontuação para refletir os pontos atuais dos jogadores.
     * <p>
     * Este método deve ser chamado sempre que a pontuação de um dos jogadores mudar, 
     * para garantir que o placar exibido esteja atualizado.
     * </p>
     */
    public void updateScores() {
        scoreLabel.setText(String.format("%d : %d", p1.getPoints(), p2.getPoints()));
    }

    /**
     * Retorna o rótulo responsável por exibir a pontuação.
     * <p>
     * Este método pode ser usado para modificar diretamente as propriedades do rótulo,
     * caso seja necessário alterar o estilo ou o comportamento da exibição da pontuação.
     * </p>
     * 
     * @return O rótulo {@link JLabel} que exibe a pontuação atual.
     */
    public JLabel getScoreLabel() {
        return this.scoreLabel;
    }

    /**
     * Retorna o primeiro jogador, p1, cuja pontuação está sendo exibida.
     * 
     * @return O primeiro jogador {@link Player} no painel de pontuação.
     */
    public Player getP1() {
        return this.p1;
    }

    /**
     * Retorna o segundo jogador, p2, cuja pontuação está sendo exibida.
     * 
     * @return O segundo jogador {@link Player} no painel de pontuação.
     */
    public Player getP2() {
        return this.p2;
    }
}