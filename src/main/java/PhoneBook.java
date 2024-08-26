import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String,String> phones = new HashMap<>();

    public int add(String name, String number) {
        if (phones.containsKey(name)) {
            System.out.println("Это имя уже есть в телефонной книге");
        } else {
        phones.put(name,number);
        }
        return phones.size();
    }

    public String findByNumber(String number) {
        return null;
    }
}
