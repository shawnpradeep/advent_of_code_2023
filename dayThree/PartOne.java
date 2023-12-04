import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class PartOne {

    private static int height = 0;

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

        int sumPartNumbers = 0;
        for (int r = 0; r < schematic.length; r++) {
            StringBuilder sb = new StringBuilder();
            boolean valid = false;
            for (int c = 0; c < schematic[0].length; c++) {
                if (Character.isDigit(schematic[r][c])) {
                    sb.append(schematic[r][c]);
                    if (!valid && search(schematic, r, c)) valid = true;
                } else {
                    if (valid && !sb.toString().equals("")) sumPartNumbers += Integer.parseInt(sb.toString());
                    sb = new StringBuilder(); // clears for next number
                    valid = false; // resets whether we've found an integer
                } //if-else
            } //cols

            // Handles edges: 
            if (valid && !sb.toString().equals("")) sumPartNumbers += Integer.parseInt(sb.toString());
        } //rows

        return sumPartNumbers;
    } //sum

    private static boolean search(char[][] schematic, int r, int c) {
        if (r - 1 >= 0 && validSymbol(schematic[r - 1][c])) return true; // up check
        if (r + 1 < schematic.length && validSymbol(schematic[r + 1][c])) return true; // down check
        if (c - 1 >= 0 && validSymbol(schematic[r][c - 1])) return true; // left check
        if (c + 1 < schematic[0].length && validSymbol(schematic[r][c + 1])) return true; // right check

        if (c - 1 >= 0 && r - 1 >= 0 && validSymbol(schematic[r - 1][c - 1])) return true; // top left
        if (c + 1 < schematic[0].length && r - 1 >= 0 && validSymbol(schematic[r - 1][c + 1])) return true; // top right
        if (c - 1 >= 0 && r + 1 < schematic.length && validSymbol(schematic[r + 1][c - 1])) return true; // bottom left
        if (c + 1 < schematic[0].length && r + 1 < schematic.length && validSymbol(schematic[r + 1][c + 1])) return true; // bottom right

        return false;
    } //search

    private static boolean validSymbol(char c) {
        return !Character.isDigit(c) && c != '.';
    } //validSymbol

} //PartOne  