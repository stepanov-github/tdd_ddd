import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PhoneBookTest {
    static PhoneBook phoneBook;
    @BeforeAll
    public static void initPhoneBook() {
        phoneBook = new PhoneBook();

    }

    @Test
    public void testadd() {

        // given:
        int expected = 1;

        // when:
        int count = phoneBook.add("Petya", "4951112233");

        // then:
        Assertions.assertEquals(expected, count);
    }

    @Test
    public void testFindByNumber() {

        //given:
        phoneBook.add("Vasya","+79161234567");
        phoneBook.add("Olya","+79161111111");
        phoneBook.add("Kolya","+79162222222");
        String expected = "Olya";

        // when:
        String result = phoneBook.findByNumber("+79161111111");

        // then:
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void testFindByName() {

        //given:
        phoneBook.add("Vasya","+79161111111");
        phoneBook.add("Petya","+79162222222");
        phoneBook.add("Kolya","+79163333333");
        String expected = "+79162222222";

        // when:
        String result = phoneBook.findByName("Petya");

        // then:
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPrintAllNames() {

        //given:
        phoneBook.add("Vasya","+79161111111");
        phoneBook.add("Petya","+79162222222");
        phoneBook.add("Kolya","+79163333333");
        String expected = "Kolya\r\n" +
                "Petya\r\n" +
                "Vasya\r\n";

        String consoleOutput = null;
        PrintStream originalOutput = System.out;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(100);
             PrintStream capture = new PrintStream(baos)) {
            System.setOut(capture);
            phoneBook.printAllNames();
            capture.flush();
            System.setOut(originalOutput);


            // when:
            consoleOutput = baos.toString();

            // then:
            Assertions.assertEquals(expected, consoleOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
