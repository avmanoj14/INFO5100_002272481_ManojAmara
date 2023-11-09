import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

    public static void main(String[] args) {
        // Subject strings for testing
        String positiveEmail = "john.doe@example.com";
        String negativeEmail = "invalid.email@.com";

        String positivePhone = "123-456-7890";
        String negativePhone = "987-65-4321";

        String positiveDate = "2023-10-26";
        String negativeDate = "26/10/2023";

        String positiveUsername = "user123";
        String negativeUsername = "user#456";

        String positivePassword = "P@ssw0rd";
        String negativePassword = "password123";

        // Regular expression patterns
        String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        String phonePattern = "^\\d{3}-\\d{3}-\\d{4}$";
        String datePattern = "^\\d{4}-\\d{2}-\\d{2}$";
        String usernamePattern = "^[A-Za-z0-9_]{5,}$";
        String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";

        // Test positive cases
        testPattern(positiveEmail, emailPattern, "Email");
        testPattern(positivePhone, phonePattern, "Phone");
        testPattern(positiveDate, datePattern, "Date");
        testPattern(positiveUsername, usernamePattern, "Username");
        testPattern(positivePassword, passwordPattern, "Password");

        System.out.println("\n--------------------------------------\n");

        // Test negative cases
        testPattern(negativeEmail, emailPattern, "Email");
        testPattern(negativePhone, phonePattern, "Phone");
        testPattern(negativeDate, datePattern, "Date");
        testPattern(negativeUsername, usernamePattern, "Username");
        testPattern(negativePassword, passwordPattern, "Password");
    }

    private static void testPattern(String input, String pattern, String description) {
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(input);

        if (matcher.matches()) {
            System.out.println(description + " Test - Positive Case:");
            System.out.println("   Input: " + input);
            System.out.println("   Result: Match\n");
        } else {
            System.out.println(description + " Test - Negative Case:");
            System.out.println("   Input: " + input);
            System.out.println("   Result: No match\n");
        }
    }
}
