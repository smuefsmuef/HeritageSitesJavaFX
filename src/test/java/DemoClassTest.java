import ch.fhnw.oop2.heritagesites.DemoClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoClassTest {

    @Test
    void testHelloWorld(){
        DemoClass demo = new DemoClass();
        assertEquals("Hello World", demo.helloWorld());
    }

    @Test
    void start() {
    }
}
