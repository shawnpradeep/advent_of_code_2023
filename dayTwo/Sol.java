import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Sol {
    public final String MAX_RED = "12 red";
    public final String MAX_GREEN = "13 green";
    public final String MAX_BLUE = "14 blue";

    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            int sum = 0;
            while (scanner.hasNextLine()) {
                String game = scanner.nextLine();

                /******* PART ONE *******/
                // if (valid(new String(game))) {
                //     sum += Integer.parseInt(game.substring(5, game.indexOf(":")));
                // } //if


                sum += partTwo(new String(game));
            } //while                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          

            System.out.println("Answer: " + sum);
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } //try                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    } //main        

    private static boolean valid(String game) {
        game = game.substring(game.indexOf(":") + 2);
        
        String[] rounds = game.split(";");
        
        for (String round : rounds) {
            round = round.trim();
            String[] sets = round.split(", ");
            for (String set : sets) {
                int count = Integer.parseInt(set.substring(0, set.indexOf(" ")));
                char color = set.charAt(set.indexOf(" ") + 1);
                if (color == 'r' && count > 12) return false;
                if (color == 'g' && count > 13) return false;
                if (color == 'b' && count > 14) return false;
            } //for
        } //for

        return true;
    } //valid

    private static int partTwo(String game) {
        game = game.substring(game.indexOf(":") + 2);
        
        String[] rounds = game.split(";");
        int maxRed = Integer.MIN_VALUE;
        int maxGreen = Integer.MIN_VALUE;
        int maxBlue = Integer.MIN_VALUE;

        for (String round : rounds) {
            round = round.trim();
            String[] sets = round.split(", ");
            for (String set : sets) {
                int count = Integer.parseInt(set.substring(0, set.indexOf(" ")));
                char color = set.charAt(set.indexOf(" ") + 1);
                if (color == 'r') maxRed = Math.max(maxRed, count);
                if (color == 'g') maxGreen = Math.max(maxGreen, count);
                if (color == 'b') maxBlue = Math.max(maxBlue, count);
            } //for
        } //for

        return maxRed * maxGreen * maxBlue;
    } //valid
} //Sol