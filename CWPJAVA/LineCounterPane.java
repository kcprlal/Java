import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCounterPane {
    public static void main(String[] args) {
        String nazwaPliku = JOptionPane.showInputDialog(null, "Podaj nazwę pliku:", "LineCounterPane", JOptionPane.QUESTION_MESSAGE);

        if (nazwaPliku == null || nazwaPliku.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nie podano nazwy pliku.", "Błąd", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int liczbaWierszy = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(nazwaPliku))) {
            while (reader.readLine() != null) {
                liczbaWierszy++;
            }
            JOptionPane.showMessageDialog(null, "Liczba wierszy w pliku " + nazwaPliku + " wynosi: " + liczbaWierszy, "Wynik", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Wystąpił błąd podczas odczytu pliku: " + nazwaPliku + "\nSzczegóły: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
