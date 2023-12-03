import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Sol {

    private static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            int sum = 0;
            initMap(map);

            while (scanner.hasNextLine()) {
                sum += partTwo(scanner.nextLine());
            } //while                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          

            System.out.println("Answer: " + sum);
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } //try                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    } //main                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   


    private static int partOne(String s) {
        char[] ca = s.toCharArray();
        String calibration_value = "";
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] >= '1' && ca[i] <= '9') {
                calibration_value += ca[i];
                break;
            } //if                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
        } //for                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                

        for (int i = ca.length - 1; i >= 0; i--) {
            if (ca[i] >= '1' && ca[i] <= '9') {
                calibration_value += ca[i];
                break;
            } //if                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
        } //for                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                

        return Integer.parseInt(calibration_value);
    } //parse                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  


    private static int partTwo(String s) {
        int firstOccurence = Integer.MAX_VALUE;
        int lastOccurence = Integer.MIN_VALUE;
        int firstValue = 0, lastValue = 0;

        for (String key : map.keySet()) {
            int idx1 = s.indexOf(key);
            int idx2 = s.lastIndexOf(key);

            if (idx1 != -1 && idx1 < firstOccurence) {
                firstOccurence = idx1;
                firstValue = map.get(key);
            } //if                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

            if (idx2 != -1 && idx2 > lastOccurence) {
                lastOccurence = idx2;
                lastValue = map.get(key);
            } //if                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
        } //for                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                

        return (firstValue * 10) + lastValue;
    } //parse2                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 

    private static void initMap(HashMap<String, Integer> map) {
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    } //initMap                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
} //Sol     