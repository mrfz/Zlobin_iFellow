import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


/**
 * Test runner
 */
@TestMethodOrder(OrderAnnotation.class)
public class RunTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Starting tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Tests finished");
    }

    @Test
    @Order(1)
    public void passingTest() {
        System.out.println("Running passing test");
        Assertions.assertEquals("Java Rocks!", "Java Rocks!");
    }

    @Test
    @Order(2)
    public void failingTest() {
        System.out.println("Running failing test");
        Assertions.assertEquals("Java Rocks!", "Java Sucks!");
    }
}