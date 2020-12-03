import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportRepair {
    public static void main(String[] args) {
        ArrayList<String> fileLines = new ArrayList<String>();
        try {
            File inputFile = new File("aoc-ReportRepair/src/input.txt");
            Scanner fileReader = new Scanner(inputFile);
            while  (fileReader.hasNextLine()){
                fileLines.add(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("oh no");
        }

        for (String line: fileLines
             ) {
            for (String line2: fileLines
                 ) {
                for (String line3 : fileLines) {
                    int sum = Integer.parseInt(line) + Integer.parseInt(line2) + Integer.parseInt(line3);
                    if (sum == 2020) {
                        System.out.println(Integer.parseInt(line) * Integer.parseInt(line2) * Integer.parseInt(line3));
                    }
                }
            }

        }



    }
}
