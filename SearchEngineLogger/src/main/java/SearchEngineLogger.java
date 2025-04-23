import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {
        logAction("launch");
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a search name or X to exit");
            String search = input.nextLine();
            if (search.equalsIgnoreCase("X")) {
                logAction("exit");
                break;
            } else {
                logAction("search: " + search);
            }
        }
    }

    public static void logAction(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String Times = now.format(formatter);
        //
        try {
            FileWriter writer = new FileWriter("logs.txt", true);
            writer.write(Times + " " + message + "\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("Failed to write log: " + e.getMessage());
        }
    }
}
