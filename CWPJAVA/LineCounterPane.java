import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCounterPane {
    public static void main(String[] args) {
        String fileName = JOptionPane.showInputDialog(null, "Podaj nazwę pliku:", "LineCounterPane", JOptionPane.QUESTION_MESSAGE);

        if (fileName == null || fileName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nie podano nazwy pliku.", "Błąd", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
            JOptionPane.showMessageDialog(null, "Liczba wierszy w pliku " + fileName + " wynosi: " + lineCount, "Wynik", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Wystąpił błąd podczas odczytu pliku: " + fileName + "\nSzczegóły: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
