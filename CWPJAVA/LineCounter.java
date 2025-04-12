import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Brak argumentów programu.");
            return;
        }

        String fileName = args[0];
        int lines = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lines++;
            }
            System.out.println("Liczba wierszy w pliku " + fileName + " wynosi: " + lines);
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas odczytu pliku: " + fileName);
            System.out.println("Szczegóły: " + e.getMessage());
        }
    }
}
