package com.tiduswr.model;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.adonax.audiocue.AudioCue;

/**
 * Gerenciador singleton de instâncias de áudio utilizando a biblioteca AudioCue.
 * Ele gerencia múltiplas faixas de áudio, permitindo o uso de um pool de instâncias para tocar efeitos sonoros.
 */
public class AudioCueManager {

    /**
     * Instância única do gerenciador de áudio.
     */
    private static AudioCueManager instance;

    /**
     * Mapa que armazena as instâncias de AudioCue associadas a seus caminhos de arquivo.
     */
    private Map<String, AudioCue> audioCueMap = new HashMap<>();

    /**
     * Tamanho do pool de instâncias de áudio por arquivo.
     */
    private final int POOL_SIZE = 10;

    /**
     * Construtor privado para implementar o padrão singleton.
     */
    private AudioCueManager() {}

    /**
     * Retorna a instância única do AudioCueManager.
     * Se não existir, ela é criada.
     * 
     * @return A instância única do AudioCueManager.
     */
    public static AudioCueManager getInstance() {
        if (instance == null) {
            instance = new AudioCueManager();
        }
        return instance;
    }

    /**
     * Obtém um AudioCue a partir do caminho especificado. Se o AudioCue ainda não foi carregado, ele será criado e armazenado.
     * 
     * @param path O caminho do arquivo de áudio a ser carregado.
     * @return A instância de AudioCue correspondente ao caminho fornecido.
     * @throws IOException Se ocorrer um erro de entrada/saída ao carregar o arquivo de áudio.
     * @throws UnsupportedAudioFileException Se o arquivo de áudio tiver um formato não suportado.
     * @throws LineUnavailableException Se a linha de áudio não estiver disponível.
     */
    public AudioCue getAudioCue(String path) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (!audioCueMap.containsKey(path)) {
            URL url = this.getClass().getResource("/" + path);
            if (url == null) {
                throw new RuntimeException("Arquivo de áudio não encontrado: " + path);
            }
            AudioCue audioCue = AudioCue.makeStereoCue(url, POOL_SIZE);
            audioCue.open(2048);
            audioCueMap.put(path, audioCue);
        }
        return audioCueMap.get(path);
    }

    /**
     * Fecha todas as instâncias de AudioCue gerenciadas e limpa o mapa.
     */
    public void closeAll() {
        for (AudioCue cue : audioCueMap.values()) {
            cue.close();
        }
        audioCueMap.clear();
    }

    /**
     * Fecha uma instância específica de AudioCue e a remove do mapa.
     * 
     * @param audioCue A instância de AudioCue a ser fechada.
     * @param pathToRemove O caminho associado à instância de AudioCue que deve ser removida.
     */
    public void closeInstace(AudioCue audioCue, String pathToRemove) {
        audioCue.close();
        audioCueMap.remove(pathToRemove);
    }
}