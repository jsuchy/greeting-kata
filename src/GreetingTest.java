import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GreetingTest {
    @Test
    public void withName() {
        assertEquals("Hello, Bobby.", greeting("Bobby"));
    }

    @Test
    public void defaultGreeting() {
        assertEquals("Hello, my friend.", greeting(null));
        assertEquals("Hello, my friend.", greeting());
    }

    @Test
    public void shout() {
        assertEquals("HELLO JERRY!", greeting("JERRY"));
    }

    @Test
    public void twoNames() {
        assertEquals("Hello, Jill and Jane.", greeting("Jill", "Jane"));
    }

    @Test
    public void multipleNames() {
        assertEquals("Hello, Amy, Brian, and Charlotte.", greeting("Amy", "Brian", "Charlotte"));
    }

    @Ignore
    @Test
    public void mixedShouts() {
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!", greeting("Amy", "BRIAN", "Charlotte"));
    }

    private String greeting(String... names) {
        if (names == null || names.length == 0)
            return "Hello, my friend.";

        if (names.length == 1) {
            if (names[0] == names[0].toUpperCase()) {
                return "HELLO " + names[0] + "!";
            } else {
                return "Hello, " + names[0] + ".";
            }
        }

        if (names.length == 2) {
            return "Hello, " + names[0] + " and " + names[1] + ".";
        }

        if (names.length > 2) {
            return "Hello, " + String.join(", ", Arrays.copyOfRange(names, 0, names.length - 1)) + ", and " + names[names.length - 1] + ".";
        }

        return "OH NO";
    }
}
