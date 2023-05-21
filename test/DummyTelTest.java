import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTelTest {

    private final Date startDate = new Date();

    @Test
    void testTimeDiscounted() {

        DummyTel dummyTel = new DummyTel(startDate, 360);
        double expectedResult = 0.151;
        double actualResult = dummyTel.feeCalculator();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testTimeNotDiscounted() {

        DummyTel dummyTel = new DummyTel(startDate, 3601);
        double expectedResult = 0.23;
        double actualResult =dummyTel.feeCalculator();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testLongDuration() {

        DummyTel dummyTel = new DummyTel(startDate, 3800);

        double expectedResult = 0.24;
        double actualResult = dummyTel.feeCalculator();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testShortDuration() {

        DummyTel dummyTel = new DummyTel(startDate, 158);

        double expectedResult = 0.07;
        double actualResult = dummyTel.feeCalculator();

        assertEquals(expectedResult, actualResult);
    }
}
