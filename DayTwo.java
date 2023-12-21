import java.util.*;
import java.io.*;
public class DayTwo {
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

    /**
     * Check for games that may have a possible configuration of 12 red, 13 green, and 14 blue.
     * 
     * @param input
     * @return Sum of the IDs of games who have only 12 red, 13 green, and 14 blue
     */
    public static int partOne(ArrayList<String> input) {
        int sumOfIDs = 0;
        for (int i = 1; i <= input.size(); ++i) {
            String shownCubes = input.get(i - 1).split(":")[1];
            int red = 12, green = 13, blue = 14;
            String[] cubes = shownCubes.split("[\s,;]", 0);
            List<String> list = new ArrayList<>(Arrays.asList(cubes));
            list.removeIf(String::isEmpty);

            boolean isPossible = true;
            // Now that the data has been cleaned, we can check every value
            for (int j = 1; j < list.size(); j += 2) {
                if (list.get(j).equals("red")) {
                    if (Integer.parseInt(list.get(j - 1)) > red) {
                        isPossible = false;
                        break;
                    }
                } else if (list.get(j).equals("green")) {
                    if (Integer.parseInt(list.get(j - 1)) > green) {
                        isPossible = false;
                        break;
                    } 
                } else if (list.get(j).equals("blue")) {
                    if (Integer.parseInt(list.get(j - 1)) > blue) {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) 
                sumOfIDs += i;
        }

        return sumOfIDs;
    }

    public static int partTwo(ArrayList<String> input) {
        int sumOfIDs = 0;
        for (int i = 1; i <= input.size(); ++i) {
            String shownCubes = input.get(i - 1).split(":")[1];
            int red = 0, green = 0, blue = 0;
            String[] cubes = shownCubes.split("[\s,;]", 0);
            List<String> list = new ArrayList<>(Arrays.asList(cubes));
            list.removeIf(String::isEmpty);

            boolean isPossible = true;
            // Now that the data has been cleaned, we can check every value
            for (int j = 1; j < list.size(); j += 2) {
                if (list.get(j).equals("red")) {
                    if (Integer.parseInt(list.get(j - 1)) > 12) {
                        isPossible = false;
                        break;
                    }
                } else if (list.get(j).equals("green")) {
                    if (Integer.parseInt(list.get(j - 1)) > 13) {
                        isPossible = false;
                        break;
                    } 
                } else if (list.get(j).equals("blue")) {
                    if (Integer.parseInt(list.get(j - 1)) > 14) {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) 
                sumOfIDs += i;
        }

        return sumOfIDs;
    }
}
