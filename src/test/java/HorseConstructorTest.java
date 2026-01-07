import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HorseConstructorTest {

    @Test
    void ifFirstArgIsNullThenThrowException() {
        Class<IllegalArgumentException> exceptionClass = IllegalArgumentException.class;
        assertThrows(exceptionClass, () -> new Horse(null, 1));
    }

    @Test
    void ifFirstArgIsNullThenNameCannotBeNull() {
        String expected = "Name cannot be null.";
        try {
            new Horse(null, 1);
        } catch (Exception e) {
            String actual = e.getMessage();
            assertEquals(expected, actual);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t"})
    void ifFirstArgIsEmptyThenException(String input) {
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;
        assertThrows(expected, () -> new Horse(input, 1));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t"})
    void ifFirstArgIsEmptyThenNameCannotBeBlank(String input) {
        String expected = "Name cannot be blank.";
        try {
            new Horse(input, 1);
        } catch (Exception e) {
            String actual = e.getMessage();
            assertEquals(expected, actual);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -999999})
    void ifSecondArgIsNegativeThenException(int input) {
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;
        assertThrows(expected, () -> new Horse("Horse", input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -999999})
    void ifSecondArgIsEmptyThenSpeedCannotBeNegative(int input) {
        String expected = "Speed cannot be negative.";
        try {
            new Horse("Horse", input);
        } catch (Exception e) {
            String actual = e.getMessage();
            assertEquals(expected, actual);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -999999})
    void ifThirdArgIsNegativeThenException(int input) {
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;
        assertThrows(expected, () -> new Horse("Horse", 1, input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -999999})
    void ifThirdArgIsEmptyThenDistanceCannotBeNegative(int input) {
        String expected = "Distance cannot be negative.";
        try {
            new Horse("Horse", 1, input);
        } catch (Exception e) {
            String actual = e.getMessage();
            assertEquals(expected, actual);
        }
    }

}