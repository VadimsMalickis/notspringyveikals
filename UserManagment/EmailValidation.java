import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class EmailValidation {
   private static final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
   public static void main(String args[]) {
       //adding  emails to an array list
       List<String> emails = new ArrayList<String>();
       //valid email addresses
       emails.add("alice@example.com");
       emails.add("alice@example.co.in");
       emails.add("alice.bob@example.com");
       emails.add("alice_bob@example.com");
       emails.add("alice@example.company.in");
       //invalid email addresses
       emails.add(".alice@example.com");
       emails.add("alice@example.com.");
       emails.add("alice@example.c");
       emails.add("alice@example.company");
       //initialize the Pattern object
       Pattern pattern = Pattern.compile(regex);
       //searching for occurrences of regex
       for (String value : emails) {
           Matcher matcher = pattern.matcher(value);
           System.out.println("Email " + value + " is " + (matcher.matches() ? "valid" : "invalid"));
       }
   }
}
