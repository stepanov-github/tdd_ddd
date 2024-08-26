import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {

    @Test
    public void testadd() {

        // given:
        PhoneBook phoneBook = new PhoneBook();
        int expected = 1;

        // when:
        int count = phoneBook.add("Petya", "4951112233");

        // then:
        Assertions.assertEquals(expected,count);
    }
}
