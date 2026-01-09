import static java.util.Objects.isNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Horse {

    private final String name;
    private final double speed;
    private double distance;
    private static final Logger log = LogManager.getLogger();

    public Horse(String name, double speed, double distance) {
        System.setProperty("file.encoding", "UTF-8");
        if (isNull(name)) {
            log.error("Name is null");
            throw new IllegalArgumentException("Name cannot be null.");
        } else if (name.isBlank()) {
            log.error("Name is blank");
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        if (speed < 0) {
            log.error("Speed is negative");
            throw new IllegalArgumentException("Speed cannot be negative.");
        }
        if (distance < 0) {
            log.error("Distance is negative");
            throw new IllegalArgumentException("Distance cannot be negative.");
        }

        this.name = name;
        this.speed = speed;
        this.distance = distance;
        log.debug("Создание Horse, имя [{}], скорость [{}]", name, speed);
    }

    public Horse(String name, double speed) {
        this(name, speed, 0);
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public void move() {
        distance += speed * getRandomDouble(0.2, 0.9);
    }

    public static double getRandomDouble(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }
}
