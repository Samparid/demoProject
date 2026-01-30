package utilities;

import java.util.UUID;

public class Utility {

    public static String generateEmail() {
        return "test_" + UUID.randomUUID().toString().substring(0, 6) + "@gmail.com";
    }
}
