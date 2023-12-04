import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class PartTwo {

    private static int height = 0;
    private static HashMap<String, int[]> map = new HashMap<>();

    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine() + "\n");
                height++;
            }

            System.out.println("Answer: " + sum(content.toString()));
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } //try                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    } //main

    private static int sum(String content) {
        String[] lines = content.split("\n");
        char[][] schematic = new char[height][lines[0].length()];

        for (int i = 0; i < lines.length; i++) {
            schematic[i] = lines[i].toCharArray();
        } //for

        for (int r = 0; r < schematic.length; r++) {
            StringBuilder sb = new StringBuilder();
            int[] gearCoord = new int[] {-1, -1};
            for (int c = 0; c < schematic[0].length; c++) {
                if (Character.isDigit(schematic[r][c])) {
                    sb.append(schematic[r][c]);
                    gearCoord = gearCoord[0] == -1 ? search(schematic, r, c) : gearCoord;
                } else {
                    if (gearCoord[0] != -1) {
                        String key = "R" + gearCoord[0] + "C" + gearCoord[1];
                        if (!map.containsKey(key)) map.put(key, new int[] {-1, -1});
                        int[] pair = map.get(key);
                        if (pair[0] == -1) pair[0] = Integer.parseInt(sb.toString());
                        else pair[1] = Integer.parseInt(sb.toString());
                    } //if

                    sb = new StringBuilder(); // clears for next number
                    gearCoord = new int[] {-1, -1};// resets whether we've found an integer
                } //if-else
            } //cols
        } //rows

        int sumGearRatios = 0;

        for (int[] gear : map.values()) {
            if (gear[1] == -1) continue;
            sumGearRatios += (gear[0] * gear[1]);
        } //for

        return sumGearRatios;
    } //sum

    private static int[] search(char[][] schematic, int r, int c) {
        if (r - 1 >= 0 && isGear(schematic[r - 1][c])) return new int[] {r - 1, c}; // up check
        if (r + 1 < schematic.length && isGear(schematic[r + 1][c])) return new int[] {r + 1, c}; // down check
        if (c - 1 >= 0 && isGear(schematic[r][c - 1])) return new int[] {r, c - 1}; // left check
        if (c + 1 < schematic[0].length && isGear(schematic[r][c + 1])) return new int[] {r, c + 1}; // right check

        // Checking diagonals:
        if (c - 1 >= 0 && r - 1 >= 0 && isGear(schematic[r - 1][c - 1])) return new int[] {r - 1, c - 1}; // top left
        if (c + 1 < schematic[0].length && r - 1 >= 0 && isGear(schematic[r - 1][c + 1])) return new int[] {r - 1, c + 1}; // top right
        if (c - 1 >= 0 && r + 1 < schematic.length && isGear(schematic[r + 1][c - 1])) return new int[] {r + 1, c - 1}; // bottom left
        if (c + 1 < schematic[0].length && r + 1 < schematic.length && isGear(schematic[r + 1][c + 1])) return new int[] {r + 1, c + 1}; // bottom right

        return new int[] {-1, -1};
    } //search

    private static boolean isGear(char c) {
        return c == '*';
    } //validSymbol
} //PartOne  