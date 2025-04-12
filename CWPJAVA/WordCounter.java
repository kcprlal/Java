import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) {
        boolean cword = false;
        boolean cline = false;
        boolean cchar = false;
        String fileName = null;

        if (args.length == 0) {
            System.out.println("Brak argumentów programu.");
            return;
        }

        for (String arg : args) {
            if (arg.startsWith("-")) {
                for (char opt : arg.substring(1).toCharArray()) {
                    switch (opt) {
                        case 'w':
                            cword = true;
                            break;
                        case 'l':
                            cline = true;
                            break;
                        case 'c':
                            cchar = true;
                            break;
                        default:
                            break;
                    }
                }
            } else {
                fileName = arg;
            }
        }

        if (!cchar && !cline && !cword) {
            cchar = true;
            cword = true;
            cline = true;
        }

        int lines = 0;
        int words = 0;
        int chars = 0;
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                lines++;
                chars += line.length();
                String[] wordList = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    words += wordList.length;
                }
            }
            if(cline) System.out.println("Liczba wierszy w pliku " + fileName + " wynosi: " + lines);
            if(cword) System.out.println("Liczba słów w pliku " + fileName + " wynosi: " + words);
            if(cchar) System.out.println("Liczba znaków w pliku " + fileName + " wynosi: " + chars);
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas odczytu pliku: " + fileName);
            System.out.println("Szczegóły: " + e.getMessage());
        }
    }
}
