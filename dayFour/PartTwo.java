import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class PartTwo {
     public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            int sum = 0;
            List<String> lines = new ArrayList();
            while (scanner.hasNextLine()) {
                String card = scanner.nextLine();
                lines.add(card);
            }

            int[] cards = new int[lines.size()];
            Arrays.fill(cards, 1);
            for (int i = 0; i < lines.size(); i++) {
                int matches = countWins(lines.get(i));
                int sets = cards[i];
                for (int j = 1; j < matches + 1; j++) {
                    cards[i + j] += sets;
                } //for
            } //for

            for (int n : cards) {
                sum += n;
            } //for



            /**
             *  [0,0,0,0,0]
             *  [1,1,1,1,1]
             *  [1,2,4,8,1]
             */


            System.out.println("Answer: " + sum);
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } //try                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    } //main


    private static int countWins(String card) {
        String nums = card.substring(card.indexOf(":") + 1);

        String winningNumsStr = nums.substring(0, nums.indexOf("|")).trim();
        String playersNumsStr = nums.substring(nums.indexOf("|") + 1).trim();

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
