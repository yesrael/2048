import java.io.*;
import sun.audio.*;

public class Sound
{
	public  void playSound() 
throws Exception
{
	// open the sound file as a Java input stream
String gongFile = "C:/Users/hom/workspace/2048/button-3.wav";
	InputStream in = new FileInputStream(gongFile);
	
	// create an audiostream from the inputstream
	AudioStream audioStream = new AudioStream(in);
	
	// play the audio clip with the audioplayer class
	AudioPlayer.player.start(audioStream);;
	
}
	public  void playPokemonSound() 
			throws Exception
			{
				// open the sound file as a Java input stream
			String gongFile = "C:/Users/hom/workspace/2048/pokemon-sound.wav";
				InputStream in = new FileInputStream(gongFile);
				
				// create an audiostream from the inputstream
				AudioStream audioStream = new AudioStream(in);
				
				// play the audio clip with the audioplayer class
				AudioPlayer.player.start(audioStream);;
				
			}
	}