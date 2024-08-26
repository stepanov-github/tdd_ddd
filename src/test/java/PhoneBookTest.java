import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        String result = phoneBook.findByNumber("79161111111");

        // then:
        Assertions.assertEquals(expected, result);

    }
}
