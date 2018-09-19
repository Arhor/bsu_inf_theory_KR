package by.bsu.approximation.util.impl;

import by.bsu.approximation.util.Approximator;

import java.util.Arrays;

public class ThirdOrderApproximator extends Approximator {

	public ThirdOrderApproximator(String source) {
		super(source);
	}
	
	public String approximate() {

		StringBuilder sb = new StringBuilder();
		int size = dict.length();
		
		int[][][] counts = new int[size][size][size];
		double[][][] distribution = new double[size][size][size];
		
		for (int i = 0; i < source.length(); i++) {
			char prePrev = (i == 0 || i == 1) ? ' ' : source.charAt(i - 2);
			char prev = i == 0 ? ' ' : source.charAt(i - 1);
			char curr = source.charAt(i);
			
			int prePrevIndex = dict.indexOf(prePrev);
			int prevIndex = dict.indexOf(prev);
			int currIndex = dict.indexOf(curr);
			
			counts[prePrevIndex][prevIndex][currIndex]++;
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int count = Arrays.stream(counts[i][j]).sum();
				for (int k = 0; k < size; k++) {
					double prevProb = (k == 0) ? 0 : distribution[i][j][k - 1];
					double currProb = (double) counts[i][j][k] / count;
					distribution[i][j][k] = 
							(k == (size - 1)) 
							? 1.0 
							: prevProb + currProb;
				}
			}
		}
		
	    // generator
		for (int k = 0; k < source.length(); k++) {
			char prePrev = (k == 0 || k == 1) ? ' ' : sb.charAt(k - 2);
			char prev = (k == 0) ? ' ' : sb.charAt(k - 1);
			int prePrevIndex = dict.indexOf(prePrev);
			int prevIndex = dict.indexOf(prev);
			double rand = Math.random();
			for (int i = 0; i < size; i++) {
				if (rand < distribution[prePrevIndex][prevIndex][i]) {
					sb.append(dict.charAt(i));
					break;
				}
			}
		}
		
		return sb.toString();
	}

}
