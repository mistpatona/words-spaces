package org.words.prepare;

public class WordStats implements Comparable<WordStats> {
	int spaces;
	int nospaces;

	public WordStats(Boolean isSpace) {
		spaces = isSpace ? 1 : 0;
		nospaces = isSpace ? 0 : 1;
	}

	public void add(Boolean                isSpace) {
		if (isSpace) {
			spaces++;
		} else {
			nospaces++;
		}
	}

	public int getSpaces() {
		return spaces;
	}

	public int getNospaces() {
		return nospaces;
	}

	public double spaceProbability() {
		return (double) spaces / (spaces + nospaces);
	}

	public Boolean noDoubt() {
		return ((spaces == 0) || (nospaces == 0));
	}

	public Boolean definitelySpace() {
		return ((nospaces == 0) && (spaces > 0));
	}

	public int statSize() {
		return spaces + nospaces;
	}
	
	public WeightedStats weightedStats(){
		return new WeightedStats(statSize(), spaceProbability());
	}

	public String toString() {
		return "Space prob: " + spaceProbability() * 100 + ",statistics: "
				+ statSize() + ",WS: "
				+ weightedStats().weight();
				//+ new WeightedStats(statSize(), spaceProbability()).weight();
	}

	@Override
	public int compareTo(WordStats w) {
		// TODO Auto-generated method stub
		double my = weightedStats().weight();
		double he = w.weightedStats().weight();
		if (Math.abs(my - he) < 1e-5) { return 0;
		} else if (my > he ) {return -1;
		} else {return 1;} // compares for the highest scores to be first
	
	}
}
