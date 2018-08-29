package assignment1;
import stdlib.*; 
import stdlib.StdAudio;


public class PlaySimpleChords {

	public static void playChord(double duration, double... frequencies) {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			for (double frequency: frequencies) {
				slices[i] += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
			}
			slices[i] /= frequencies.length;
		}
		StdAudio.play(slices);	
	}

	public static void main(String[] args) {

		algs31.BinarySearchST<String,Double> ChordStuff = new algs31.BinarySearchST<String,Double>();

		StdIn.fromFile("data/notes_frequencies.txt");
		while (StdIn.hasNextLine()) {

			String line = StdIn.readLine();
			String[] fields = line.split("\\s+");

			String note = fields[0];
			//convert frequency from string to double 
			double frequencies = Double.parseDouble(fields[1]);

			ChordStuff.put(note, frequencies);			
		}
		
		StdIn.fromFile("data/sample_simple_chords.txt");

		while (StdIn.hasNextLine()) {

			String line = StdIn.readLine();
			String[] fields = line.split("\\s+");

			String note1 = fields[0];
			String note2 = fields[1];
			Double duration = Double.parseDouble(fields[2]);

			double frequency_1=ChordStuff.get(note1);
			double frequency_2=ChordStuff.get(note2);
			playChord(duration, frequency_1, frequency_2);
		}
	}
}