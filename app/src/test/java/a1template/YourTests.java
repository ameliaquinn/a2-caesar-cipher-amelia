// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import org.junit.Test;
import static org.junit.Assert.*;

public class YourTests {
    @Test
    public void encodeTests() {
        CaesarCipher classUnderTest = new CaesarCipher(5);
        assertEquals("frjqnf", classUnderTest.encode("amelia"));
        assertEquals("mjqqt.", classUnderTest.encode("Hello."));
    }

    @Test
    public void decodeTests() {
        CaesarCipher classUnderTest = new CaesarCipher(25);
        assertEquals("hello", classUnderTest.decode("gdkkn"));
        assertEquals("computer science", classUnderTest.decode("dpnqvufs tdjfodf");
    }

}