import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
//This class is the added feature if the game.
public class AudioPlayer {
	
	private Clip clip;
	//reads in the audio
	public AudioPlayer(String path, boolean loop) {
		try {
			AudioInputStream audioinputstream = AudioSystem.getAudioInputStream(new File(path));
			this.clip = AudioSystem.getClip();
			clip.open(audioinputstream);
			if(loop)
				clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//This method plays the audio
	public void play() {
		this.clip.start();
	}
	//this method pauses the audio
	public void pause() {
		this.clip.stop();
	}
	//The audio itself.
	public static AudioPlayer menuAudio = new AudioPlayer(" spaceOddyssey.wav",true);
	
}
