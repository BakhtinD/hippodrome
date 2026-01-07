import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class HippodromeConstructorTest {

    @Test
    void ifNullThenException() {
        Class<IllegalArgumentException> exceptionClass = IllegalArgumentException.class;
        assertThrows(exceptionClass, () -> new Hippodrome(null));
    }

    @Test
    void ifNullThenNameCannotBeNull() {
        String expected = "Horses cannot be null.";
        try {
            new Hippodrome(null);
        } catch (Exception e) {
            String actual = e.getMessage();
            assertEquals(expected, actual);
        }
    }

    @Test
    void ifEmptyThenException() {
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;
        assertThrows(expected, () -> new Hippodrome(Collections.emptyList()));
    }

    @Test
    void ifEmptyThenHorsesCannotBeEmpty() {
        String expected = "Horses cannot be empty.";
        try {
            new Hippodrome(Collections.emptyList());
        } catch (Exception e) {
            String actual = e.getMessage();
            assertEquals(expected, actual);
        }
    }
}