package by.bsu.approximation.util;

import by.bsu.approximation.util.impl.FirstOrderApproximator;
import by.bsu.approximation.util.impl.SecondOrderApproximator;
import by.bsu.approximation.util.impl.ThirdOrderApproximator;

public class AppFactory {

    public Approximator getApproximator(AppEnum type, String source) {
        Approximator approximator = null;
        switch (type) {
            case FIRST:
                approximator = new FirstOrderApproximator(source);
                break;
            case SECOND:
                approximator = new SecondOrderApproximator(source);
                break;
            case THIRD:
                approximator = new ThirdOrderApproximator(source);
        }
        return approximator;
    }
}
