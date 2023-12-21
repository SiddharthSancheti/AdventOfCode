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
        System.out.println(partTwo(input));
    }

    /*
     * Gets the first and the last digit found a line of the arraylist
     * Combines the first and last digits into a two digit number
     * Add the new number to the total sum.
     * 
     * Returns the total sum
     */
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

    /**
     * Takes the first and the last digit found in a line, combines them, and adds the number to the sum total.
     * This method will also check for written numbers such as 'one' and 'nine'.
     * 
     * @param input An ArrayList of every line in the input.
     * @return The total sum of the first digit times ten plus the second digit of every line.
     */
    public static int partTwo(ArrayList<String> input) {
        int sum = 0;

        // Creating a HashMap assigning an Integer to the String representations of the numbers
        HashMap<String, Integer> numberMap = new HashMap<>();
        numberMap.put("one", 1); numberMap.put("1", 1);
        numberMap.put("two", 2); numberMap.put("2", 2);
        numberMap.put("three", 3); numberMap.put("3", 3);
        numberMap.put("four", 4); numberMap.put("4", 4);
        numberMap.put("five", 5); numberMap.put("5", 5);
        numberMap.put("six", 6); numberMap.put("6", 6);
        numberMap.put("seven", 7); numberMap.put("7", 7);
        numberMap.put("eight", 8); numberMap.put("8", 8);
        numberMap.put("nine", 9); numberMap.put("9", 9);
        numberMap.put("zero", 0); numberMap.put("0", 0);

        for (String line : input) {
            // Go from left to right
            Integer firstDigit = null, secondDigit = null;
            for (int i = 1; i <= line.length(); ++i) {
                String firstDigitSubstring = line.substring(0, i);
                // Check if the string contains a key from the HashMap using the .contains method
                for (String key : numberMap.keySet()) {
                    if (firstDigitSubstring.contains(key)) {
                        firstDigit = numberMap.get(key);
                        i = line.length();
                    }
                }
            }

            for (int i = line.length() - 1; i >= 0; --i) {
                String secondDigitSubstring = line.substring(i);
                for (String key : numberMap.keySet()) {
                    if (secondDigitSubstring.contains(key)) {
                        secondDigit = numberMap.get(key);
                        i = 0;
                    }
                }
            }
            sum += firstDigit * 10 + secondDigit;
        }

        return sum;
    }
}