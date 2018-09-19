package by.bsu.approximation.util.impl;

import java.util.Arrays;

import by.bsu.approximation.util.Approximator;

public class SecondOrderApproximator extends Approximator {

	public SecondOrderApproximator(String source) {
		super(source);
	}

	public String approximate() {

		StringBuilder sb = new StringBuilder();
		int size = dict.length();

		int[][] counts = new int[size][size];
		double[][] distribution = new double[size][size];

		for (int i = 0; i < source.length(); i++) {
			char prev = i == 0 ? ' ' : source.charAt(i - 1);
			char curr = source.charAt(i);

			int prevIndex = dict.indexOf(prev);
			int currIndex = dict.indexOf(curr);

			counts[prevIndex][currIndex]++;
		}

		for (int i = 0; i < size; i++) {
			int count = Arrays.stream(counts[i]).sum();
			for (int j = 0; j < size; j++) {
				double prevProb = (j == 0) ? 0 : distribution[i][j-1];
				double currProb = (double) counts[i][j] / count;
				distribution[i][j] =
						(j == (size - 1))
						? 1.0
						: prevProb + currProb;
			}
		}

		// generator
		for (int k = 0; k < source.length(); k++) {
			char prev = k == 0 ? ' ' : sb.charAt(k-1);
			int prevIndex = dict.indexOf(prev);
			double rand = Math.random();
			for (int i = 0; i < size; i++) {
				if (rand < distribution[prevIndex][i]) {
					sb.append(dict.charAt(i));
					break;
				}
			}
		}

		return sb.toString();
	}
}
