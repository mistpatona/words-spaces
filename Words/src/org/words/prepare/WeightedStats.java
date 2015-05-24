package org.words.prepare;

public class WeightedStats {
	int count;
	float spaceP; // probability of space, 0 to 1

	WeightedStats(int i, double p) {
		count = i;
		spaceP = (float) p;
	}

	/*
	 * float spaceP() { return spaceP; }
	 * 
	 * float noSpaceP() { return 1 - spaceP; }
	 */

	double weight() { // the more, the better
		return pWeight() * statWeight();
	}

	double statWeight() {
		if (count < 3) {
			return 0.05;
		} else if (count < 6) {
			return 0.5;
		} else if (count < 10) {
			return 2;
		} else
			return 3;// Math.log((double)count);
	}

	double pWeight() {
		double d = Math.abs(spaceP - 0.5);
		if (d > 0.45) {
			return 20; // good match, error < 0.05
		} else if (d > 0.3) {
			return 10;
		} else if (d > 0.17) {
			return 5; // so-so, one sigma (66%)
		} else {
			return 0; // fifty-fifty, no disticnt answer
		}
	}

}
