import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

class HorseTest {

    static String name;
    static int speed;
    static int distance;
    static Horse horse;

    @BeforeAll
    static void setUp() {
        name = "Horse";
        speed = 1;
        distance = 1;
        horse = new Horse(name, speed, distance);
    }

    @Test
    void getName() {
        assertEquals(name, horse.getName());
    }

    @Test
    void getSpeed() {
        assertEquals(speed, horse.getSpeed());
    }

    @Test
    void getDistance() {
        assertEquals(distance, horse.getDistance());
    }

    @Test
    void ifTwoArgsThenReturnZero() {
        Horse horse = new Horse("Horse", 1);
        assertEquals(0, horse.getDistance());
    }


    @Test
    @ExtendWith(MockitoExtension.class)
    void move() {
        try (MockedStatic<Horse> mock = Mockito.mockStatic(Horse.class)) {
            horse.move();
            mock.verify(() ->
                    Horse.getRandomDouble(0.2, 0.9));
        }
    }

//    @Test
//    @ExtendWith(MockitoExtension.class)
//    void ifDistanceCalculationIsCorrect(){
//        //TODO
//    }

}