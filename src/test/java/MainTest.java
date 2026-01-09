import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class MainTest {

    @Disabled
    @Timeout(value = 22, unit = TimeUnit.SECONDS)
    @Test
    void ifMainFasterThen22SecondsThenCorrect() throws Exception {
        Main.main(new String[]{"String"});
    }
}