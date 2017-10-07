import java.io.*; 
import java.util.Arrays;

import static java.lang.System.*;

public class TXTFile {
	private BestScore[] _scores;
	
	public TXTFile(){
		this._scores = getArrayOfBestScores2();
	}
	
	public void set_scores (String str){
		String [] tmp = new String [2];
		tmp = str.split(":");
		int data = Integer.parseInt(tmp[1]);
		String name = tmp[0];
		BestScore bestScore = new BestScore(data, name);
		BestScore[] tmpScores = new BestScore[getSize() + 1];
		for(int i=0 ; i<_scores.length ; i++)
			tmpScores[i]=_scores[i];
		tmpScores [getSize()] = bestScore;
		Arrays.sort(tmpScores, new BestScoreComperator());
		this._scores = tmpScores;
	}
	
	public void WriteToFile(String str){
		set_scores (str);
		try {
			FileWriter fw = new FileWriter("BestScores.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(int i =(_scores.length) -1; i>=0;i--){
			pw.println(_scores[i].toString());
			}
			pw.close();
		} catch (IOException e) {
			out.println("WRITING TO FILE ERROR");
		} 
	}
	 
	public BestScore[] readFromFile(){
		return getArrayOfBestScores2();
	}
	
	public int getSize(){
		int counter=0;
		try {
			FileReader fr = new FileReader("BestScores.txt");
			BufferedReader br = new BufferedReader(fr);
		    
			String s1;
			try {
				while((s1 = br.readLine()) != null){
					counter++;
				}
			} catch (IOException e1) {
			}
			try {
				br.close();
			} catch (IOException e) {
			}
		}		
		 catch (FileNotFoundException e) {
			out.println("READING FROM FILE ERROR");
		} 
		return counter;	
	}
	
	public String[] getArrayOfBestScores(){
		String[] ans = new String[getSize()];
		int i =0;
		try {
			FileReader fr = new FileReader("BestScores.txt");
			BufferedReader br = new BufferedReader(fr);
			String s1;
			try {
				if((s1 = br.readLine()) == null)
					ans =new String[0];
				else{
				while(s1 != null){
					ans [i] = s1;
					i++;
					s1= br.readLine();
				}
			}
			}
				catch (IOException e1) {
			}
			try {
				br.close();
			} catch (IOException e) {
			}
		}
		catch (FileNotFoundException e) {
			out.println("READING FROM FILE ERROR");
		}
	  return ans;
	}
	
	public BestScore[] getArrayOfBestScores2(){
		String[] scores = getArrayOfBestScores();
		BestScore[] ans =new BestScore[ getSize()];
		if (scores==null){
			ans = new BestScore[0];
		}
 		for(int i =0; i<scores.length ; i++){
			String tmp = scores[i];
			String[] tmp1 = new String[2];
			tmp1 = tmp.split(":");
			int data = Integer.parseInt(tmp1[1]);
			String name = tmp1[0];
			BestScore bestScore = new BestScore(data, name);
			ans [i]= bestScore;
		}
 		return ans;
	}
	
}
