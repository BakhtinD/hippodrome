import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HippodromeTest {

    @Test
    void getHorses() {
        List<Horse> list = new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(127);
            char character = (char) randomInt;
            Horse horse = new Horse(character + "a", randomInt);
            list.add(horse);
        }
        Hippodrome hippodrome = new Hippodrome(list);
        List<Horse> got = hippodrome.getHorses();
        assertEquals(got, list);
        assertEquals(got.get(1), list.get(1));
    }

    @Test
    void move() {
        List<Horse> list = new ArrayList<>(50);
        for (int i = 0; i < 50; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(127);
            char character = (char) randomInt;

            Horse horse = spy(new Horse(character + "a", randomInt));
            list.add(horse);
        }
        Hippodrome hippodrome = new Hippodrome(list);
        hippodrome.move();
        List<Horse> got = hippodrome.getHorses();
        for (Horse horse : got) {
            verify(horse).move();
        }
    }

//    @Test
//    void getWinner() {
//    }
}