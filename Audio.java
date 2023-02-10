import javax.sound.sampled.*;
import java.io.File;
public class Audio {
    private final String filename;
    private AudioInputStream ais;
    public Audio(String f){
        filename=f;
    }
    public void play(){
        try {
            ais = AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }
        catch(Exception e){
            System.out.println(e);
            System.exit(4);
        }
    }
    public void playloop(){
        try {
            ais = AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
        catch(Exception e){
            System.out.println(e);
            System.exit(4);
        }
    }
}
