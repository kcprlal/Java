import java.io.*;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        final String configFile = "ustawienia.properties";
        Properties props = new Properties();

        int minValue = 1;
        int maxValue = 10;
        int minRepeats = 10;
        int maxRepeats = 25;
        int passPercentage = 70;

        try {
            File file = new File(configFile);
            if (!file.exists()) {
                System.out.println("Plik konfiguracyjny nie istnieje. Tworzenie domyślnego...");
                props.setProperty("wartosc_minimum", String.valueOf(minValue));
                props.setProperty("wartosc_maksimum", String.valueOf(maxValue));
                props.setProperty("powtorzen_minimum", String.valueOf(minRepeats));
                props.setProperty("powtorzen_maksimum", String.valueOf(maxRepeats));
                props.setProperty("procent", String.valueOf(passPercentage));
                props.store(new FileWriter(file), "Ustawienia do ćwiczeń z tabliczki mnożenia");
            } else {
                props.load(new FileReader(file));
                minValue = Integer.parseInt(props.getProperty("wartosc_minimum", "1"));
                maxValue = Integer.parseInt(props.getProperty("wartosc_maksimum", "10"));
                minRepeats = Integer.parseInt(props.getProperty("powtorzen_minimum", "10"));
                maxRepeats = Integer.parseInt(props.getProperty("powtorzen_maksimum", "25"));
                passPercentage = Integer.parseInt(props.getProperty("procent", "70"));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Błąd wczytywania pliku ustawień: " + e.getMessage());
            return;
        }

        // Rozpoczęcie quizu
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int correctAnswers = 0;
        int totalQuestions = 0;

        while (totalQuestions < maxRepeats) {
            int a = rand.nextInt(maxValue - minValue + 1) + minValue;
            int b = rand.nextInt(maxValue - minValue + 1) + minValue;

            System.out.print(a + " * " + b + " = ");
            int userAnswer = -1;

            try {
                userAnswer = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba! Przechodzę do następnego pytania.");
            }

            if (userAnswer == a * b) {
                correctAnswers++;
            }

            totalQuestions++;

            int currentPercentage = (correctAnswers * 100) / totalQuestions;

            if (totalQuestions >= minRepeats && currentPercentage >= passPercentage) {
                break;
            }
        }

        System.out.println("\nPodsumowanie:");
        System.out.println("Poprawne odpowiedzi: " + correctAnswers);
        System.out.println("Liczba pytań: " + totalQuestions);
        int finalPercentage = (correctAnswers * 100) / totalQuestions;
        System.out.println("Procent poprawnych odpowiedzi: " + finalPercentage + "%");

        if (finalPercentage >= passPercentage) {
            System.out.println("Gratulacje! Osiągnięto wymagany wynik.");
        } else {
            System.out.println("Nie udało się osiągnąć wymaganej liczby poprawnych odpowiedzi.");
        }

        scanner.close();
    }
}
