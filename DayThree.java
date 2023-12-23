import java.io.*;
import java.util.*;

public class DayThree {
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

    public static int partOne(ArrayList<String> input) {
        int sum = 0;
        int length = input.get(0).length();

        // First step, find the current number
        for (int i = 0; i < input.size(); i++) { // Rows
            // Find the starting index of a number
            for (int j = 0; j < length; j++) {
                int num = 0;
                if (!Character.isDigit(input.get(i).charAt(j))) {
                    continue;
                }

                // When a number is found, get the whole number
                int k = j;
                while (k < length && Character.isDigit(input.get(i).charAt(k))) {
                    num = num * 10 + Character.getNumericValue(input.get(i).charAt(k));
                    k++;
                }

                // Determine if the number is adjacent to a special character
                boolean adj = false;
                for (int l = Math.max(0, j - 1); l < Math.min(length, j + 2); l++) {
                    if (i - 1 >= 0 && !Character.isDigit(input.get(i - 1).charAt(l)) && input.get(i - 1).charAt(l) != '.') {
                        adj = true;
                        break;
                    }

                    if (!Character.isDigit(input.get(i).charAt(l)) && input.get(i).charAt(l) != '.') {
                        adj = true;
                        break;
                    }

                    if (i + 1 < input.size() && !Character.isDigit(input.get(i + 1).charAt(l)) && input.get(i + 1).charAt(l) != '.') {
                        adj = true;
                        break;
                    }
                }
                if (adj) {
                    sum += num;
                }
                j = k;   
            }
            // Add the num to total if the number is adjacent to a special character

        }
        return sum;
    }

    public static int partTwo(ArrayList<String> input) {
        int sum = 0;

        return sum;
    }
}
