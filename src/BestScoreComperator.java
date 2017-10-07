import java.util.Comparator;

public class BestScoreComperator implements Comparator<BestScore> {

	public int compare(BestScore bs1, BestScore bs2) {
		if(bs1.getData()>bs2.getData())
			return 1;
		if(bs1.getData()<bs2.getData())
			return -1;
		return 0;
	}

}
