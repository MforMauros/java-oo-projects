package gr.aueb.cf.ch20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidatorApp {

    public static boolean validatePassword(String pswrd) {
        Pattern pattern = Pattern.compile("(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[!@#$%^&*()-+=])^.{8,}$");
        Matcher matcher = pattern.matcher(pswrd);
        return matcher.find();
    }

    public static void main(String[] args) {
        String password = "xbeh312gie";

        boolean isValid = validatePassword(password);

        if (isValid) {
            System.out.println("The password is valid!");
        } else {
            System.out.println("The password is NOT valid");
        }
    }
}
