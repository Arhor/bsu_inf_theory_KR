package by.bsu.approximation.util.impl;

import by.bsu.approximation.util.Approximator;

public class FirstOrderApproximator extends Approximator {

	public FirstOrderApproximator(String source) {
	    super(source);
    }

	@Override
	public String approximate() {

	    StringBuilder sb = new StringBuilder();
	    int size = dict.length();
				
		int[] counts = new int[size];
		double[] distribution = new double[size];
		
		for (char c : source.toCharArray()) {
			int index = dict.indexOf(c);
			counts[index]++;
		}
		
		for (int i = 0; i < distribution.length; i++) {
			double currentProbability = (double)counts[i] / source.length();
			double prevProbability = (i == 0 ? 0 : distribution[i-1]);
			distribution[i] =
					(i != distribution.length - 1)
					? currentProbability + prevProbability
					: 1;
		}
		
		// generator
		for (int i = 0; i < source.length(); i++) {
			double rand = Math.random();
			for (int j = 0; j < distribution.length; j++) {
				if (rand < distribution[j]) {
					sb.append(dict.charAt(j));
					break;
				}
			}
		}
		
		return sb.toString(); // STUB !!!
	}
	
}
