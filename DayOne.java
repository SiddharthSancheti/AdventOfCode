import java.io.*;
import java.util.*;
public class DayOne {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(partOne(input));
    }

    public static int partOne(ArrayList<String> input) {
        int sum = 0;
        for (String arg : input) {
            boolean firstDigitTaken = false;
            int firstDigit = 0, secondDigit = 0;
            for (int i = 0; i < arg.length(); i++) {
                if (Character.isDigit(arg.charAt(i))) {
                    if (!firstDigitTaken) {
                        firstDigit = Character.getNumericValue(arg.charAt(i));
                        secondDigit = firstDigit;
                        firstDigitTaken = true;
                    } else {
                        secondDigit = Character.getNumericValue(arg.charAt(i));
                    }
                }
            }
            sum += firstDigit * 10 + secondDigit;

        }

        return sum;
    }
}