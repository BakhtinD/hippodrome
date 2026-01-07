import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;

class HippodromeTest {

    @Test
    void getHorses() {
        List<Horse> list = new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(127);
            char character = (char) randomInt;
            Horse horse = new Horse(Character.toString(character), randomInt);
            list.add(horse);
        }
        Hippodrome hippodrome = new Hippodrome(list);
        List<Horse> got = hippodrome.getHorses();
        assertEquals(got, list);
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
    }
}