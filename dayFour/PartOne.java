import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class PartOne {
     public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            int sum = 0;
            while (scanner.hasNextLine()) {
                String card = scanner.nextLine();
                sum += Math.pow(2, countWins(card)  - 1);
            }

            System.out.println("Answer: " + sum);
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } //try                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    } //main


    private static int countWins(String card) {
        String nums = card.substring(card.indexOf(":") + 1);
        // System.out.println(nums);

        String winningNumsStr = nums.substring(0, nums.indexOf("|")).trim();
        String playersNumsStr = nums.substring(nums.indexOf("|") + 1).trim();

        // System.out.println(winningNumsStr);
        // System.out.println(playersNumsStr);

        HashSet<String> winningNums = new HashSet<>();
        for (String num : winningNumsStr.split(" ")) {
            if (num.length() == 0) continue;
            winningNums.add(num);
        } //for

        int c = 0;
        for (String num : playersNumsStr.split(" ")) {
            if (num.length() == 0) continue;
            if (!winningNums.add(num)) c++;
        } //for

        return c;
    } //count
} //PartOne
