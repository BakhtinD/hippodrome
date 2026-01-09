import static java.util.Objects.isNull;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hippodrome {

    private final List<Horse> horses;
    private static final Logger log = LogManager.getLogger();

    public Hippodrome(List<Horse> horses) {
        System.setProperty("file.encoding", "UTF-8");
        if (isNull(horses)) {
            log.error("Horses list is null");
            throw new IllegalArgumentException("Horses cannot be null.");
        } else if (horses.isEmpty()) {
            log.error("Horses list is empty");
            throw new IllegalArgumentException("Horses cannot be empty.");
        }
        this.horses = horses;
        log.debug("Создание Hippodrome, лошадей [{}]", horses.size());
    }

    public List<Horse> getHorses() {
        return Collections.unmodifiableList(horses);
    }

    public void move() {
        horses.forEach(Horse::move);
    }

    public Horse getWinner() {
        return horses.stream()
                .max(Comparator.comparing(Horse::getDistance))
                .get();
    }
}
