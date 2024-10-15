package com.tiduswr.model;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.adonax.audiocue.AudioCue;
import com.adonax.audiocue.AudioCueInstanceEvent;
import com.adonax.audiocue.AudioCueListener;

/**
 * Classe responsável pelo gerenciamento e reprodução de sons no jogo.
 */
public class SoundService {

    /**  Objeto que representa a reprodução do áudio */
    private AudioCue audioCue; 
    /**  Volume do áudio */
    private float vol; 
    /**  Caminho do arquivo de áudio */
    private String path; 

    /**
     * Construtor que inicializa o serviço de som com o caminho do arquivo de áudio.
     *
     * @param path Caminho do arquivo de áudio
     */
    public SoundService(String path) {
        this.path = path;
        initializeAudioCue(path);
    }

    /**
     * Construtor que inicializa o serviço de som com o caminho do arquivo de áudio e o volume.
     *
     * @param path Caminho do arquivo de áudio
     * @param volume Volume do áudio
     */
    public SoundService(String path, float volume) {
        this(path);
        this.vol = volume;
    }

    /**
     * Inicializa o objeto AudioCue com base no caminho fornecido.
     *
     * @param path Caminho do arquivo de áudio
     */
    private void initializeAudioCue(String path) {
        try {
            audioCue = AudioCueManager.getInstance().getAudioCue(path);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reproduz o áudio uma vez.
     */
    public void play() {
        play(false);
    }

    /**
     * Reproduz o áudio com a opção de looping.
     *
     * @param loop Se verdadeiro, o áudio será reproduzido em loop
     */
    public void play(boolean loop) {
        if (audioCue != null) {
            audioCue.play(vol, 0.0, 1.0, loop ? -1 : 0);
        }
    }

    /**
     * Reproduz o áudio e, em seguida, o repete em loop.
     *
     * @param wavToLoopPath Caminho do arquivo de áudio a ser reproduzido em loop
     */
    public void playThenLoop(String wavToLoopPath) {
        play();
        audioCue.addAudioCueListener(new AudioCueListener() {

            @Override
            public void audioCueOpened(long now, int threadPriority, int bufferSize, AudioCue source) {}

            @Override
            public void audioCueClosed(long now, AudioCue source) {}

            @Override
            public void instanceEventOccurred(AudioCueInstanceEvent event) {
                switch (event.type) {
                    case STOP_INSTANCE:
                        try {                            
                            var manager = AudioCueManager.getInstance();
                            manager.closeInstace(audioCue, path);
                            path = wavToLoopPath;

                            audioCue = manager.getAudioCue(path);
                            play(true);
                        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                            e.printStackTrace();
                        }
                        break;
                
                    default:
                        break;
                }
            }
            
        });
    }

    /**
     * Fecha todos os objetos de áudio gerenciados.
     */
    public void close() {
        AudioCueManager.getInstance().closeAll();
    }
}