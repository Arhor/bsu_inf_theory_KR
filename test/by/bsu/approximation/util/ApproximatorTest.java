package by.bsu.approximation.util;

import by.bsu.approximation.util.impl.ThirdOrderApproximator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ApproximatorTest {

    private static final Logger LOG = LogManager.getLogger(ApproximatorTest.class);

    @Test
    public void testApproximate() {
        String source = "It was a quiet morning, the town covered over with "
                + "darkness and at ease in bed. Summer gathered in the weather,"
                + " the wind had the proper touch, the breathing of the world"
                + " was long and warm and slow. You had only to rise, lean from"
                + " your window, and know that this indeed was the first real "
                + "time of freedom and living, this was the first morning of "
                + "summer. Douglas Spaulding, twelve, freshly wakened, let "
                + "summer idle him on its early-morning stream. Lying in his "
                + "third-story cupola bedroom, he felt the tall power it gave "
                + "him, riding high in the June wind, the grandest tower in "
                + "town. At night, when the trees washed together, he flashed "
                + "his gaze like a beacon from this lighthouse in all "
                + "directions over swarming seas of elm and oak and maple. ";

        AppFactory factory = new AppFactory();
        Approximator approximator = factory.getApproximator(AppEnum.FIRST, source);

        LOG.info(approximator.approximate());
    }

}