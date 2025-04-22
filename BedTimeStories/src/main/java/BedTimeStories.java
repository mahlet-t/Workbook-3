import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedTimeStories {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Available stories");
            System.out.println("goldilocks.txt ");
            System.out.println("hansel_and_gretel.txt");
            System.out.println("mary_had_a_little_lamb.txt");
            System.out.println("\nEnter the name of the story to read:");
            String filename = input.nextLine();
            try {
                File file = new File("DataFiles/" + filename);
                Scanner fileReader = new Scanner(file);
                int lineNumber = 1;
                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    System.out.println(lineNumber + "." + line);
                    lineNumber++;
                }
                fileReader.close();
                break;

            } catch (FileNotFoundException e) {
                System.out.println("sorry,that file was not found.");
            }
        }
    }
}
