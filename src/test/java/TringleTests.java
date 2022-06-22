import Lesson4.Function;
import Lesson4.NegativeValueOfParameterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TringleTests {

    @ParameterizedTest
    @CsvSource({"43.30127018922193"})
    void checkResult (double expectedResult) {
        double result = Function.tringleSquare(10, 10, 10);
        Assertions.assertEquals(result, expectedResult);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-7.1, -1, -8})
    void checkWhenNegativeParamException (double a) throws NegativeValueOfParameterException {
        Assertions.assertThrows(NegativeValueOfParameterException.class, () -> Function.isNegative(a));
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.1, 10.1, 100.8})
    void calculateSquare(double check) {
        double result = Function.tringleSquare(10, 10, 10);
        Assertions.assertNotEquals(result, check);
    }
}
