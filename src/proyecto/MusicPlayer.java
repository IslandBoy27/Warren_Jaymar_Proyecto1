package proyecto;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;

public class MusicPlayer {

    public static void playMusic(String filePath) {
        try {
            URL url = MusicPlayer.class.getResource(filePath);
            if (url == null) {
                System.err.println("Archivo de música no encontrado: " + filePath);
                return;
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Reproduce la música en bucle
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playSoundEffect(String filePath) {
        try {
            URL url = MusicPlayer.class.getResource(filePath);
            if (url == null) {
                System.err.println("Archivo de sonido no encontrado: " + filePath);
                return;
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Reproducir el sonido una sola vez
            clip.start();
            
            // Añadir un listener para cerrar el clip una vez que el sonido haya terminado
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        event.getLine().close();
                    }
                }
            });
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
