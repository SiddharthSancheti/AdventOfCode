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
        int r = input.size();
        int c = input.get(0).length();
        int ret = 0;

        for (int i = 0; i < r; i++) {
            int j = 0;
            while (j < c) {
                if (!Character.isDigit(input.get(i).charAt(j))) {
                    j += 1;
                    continue;
                }
                int k = j;
                int numval = 0;
                while (k < c && Character.isDigit(input.get(i).charAt(k))) {
                    numval = 10 * numval + (input.get(i).charAt(k) - '0');
                    k++;
                }

                boolean adj = false;
                for (int a = Math.max(0, j - 1); a < Math.min(c, k + 1); a++) {
                    if (i - 1 >= 0 && !Character.isDigit(input.get(i - 1).charAt(a)) && input.get(i - 1).charAt(a) != '.') {
                        adj = true;
                    }
                    if (!Character.isDigit(input.get(i).charAt(a)) && input.get(i).charAt(a) != '.') {
                        adj = true;
                    }
                    if (i + 1 < r && !Character.isDigit(input.get(i + 1).charAt(a)) && input.get(i + 1).charAt(a) != '.') {
                        adj = true;
                    }
                }

                if (adj) {
                    ret += numval;
                }
                j = k;
            }
        }
        return ret;
    }

    public static int partTwo(ArrayList<String> input) {
        int sum = 0;

        return sum;
    }
}
