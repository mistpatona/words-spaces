package org.words.prepare;

public class WeightedStats {
	int count;
	float spaceP; // probability of space, 0 to 1

	WeightedStats(int i, double p) {
		count = i;
		spaceP = (float) p;
	}

	public double weight() { // the more, the better
		return pWeight() * statWeight();
	}

	double statWeight() {  // depends on how many observations the answer is based on
		if (count < 3) {
			return 0.05;
		} else if (count < 6) {
			return 0.5;
		} else if (count < 10) {
			return 2;
		} else
			return 3;// Math.log((double)count);
	}

	double pWeight() { // what is an estimation of error probability
		double d = Math.abs(spaceP - 0.5);
		if (d > 0.45) {
			return 20; // good match, error < 0.05
		} else if (d > 0.3) {
			return 10; // error below 20%
		} else if (d > 0.17) {
			return 5; // so-so, one sigma (66% correct)
		} else {
			return 0; // fifty-fifty, no distinct answer
		}
	}

}
