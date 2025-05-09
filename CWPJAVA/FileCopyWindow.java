import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FileCopyWindow {
    public static void main(String[] args) {
        JTextField fileToCopy = new JTextField();
        JTextField targetToCopy = new JTextField();

        Object[] com = {
                "Podaj plik do skopiowania: ", fileToCopy,
                "Miejsce docelowe", targetToCopy
        };
        int userInput = JOptionPane.showConfirmDialog(null, com, "Kopiowanie pliku", JOptionPane.OK_CANCEL_OPTION);

        if(userInput == JOptionPane.OK_OPTION)
        {
            String fileToCopyS = fileToCopy.getText();
            String targetToCopyS = targetToCopy.getText();
            File source = new File(fileToCopyS);
            File target = new File(targetToCopyS);
            

            if (!source.exists()) {
                System.out.println("Plik " + source.getName() + " nie istnieje.");
                return;
            }

            if (source.isDirectory()) {
                System.out.println(source.getName() + " jest katalogiem.");
                return;
            }

            if (!source.canRead()) {
                System.out.println("Brak dostępu do pliku " + source.getName());
                return;
            }

            if (target.exists() && target.isDirectory()) {
                target = new File(target, source.getName());
            }

            if (target.exists()) {
                if (!target.canWrite()) {
                    System.out.println("Brak wymaganych uprawnień do zapisu pliku " + target.getName());
                    return;
                }

                if (!target.isFile()) {
                    System.out.println("Nie można nadpisać pliku " + target.getName());
                    return;
                }
            } else {
                File parent = target.getParentFile();
                if (parent != null && !parent.exists()) {
                    System.out.println("Katalog docelowy nie istnieje: " + parent.getPath());
                    return;
                }
                if (parent != null && !parent.canWrite()) {
                    System.out.println("Brak wymaganych uprawnień do katalogu " + parent.getPath());
                    return;
                }
            }

            try (
                    InputStream in = new FileInputStream(source);
                    OutputStream out = new FileOutputStream(target)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) > 0) {
                    out.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                System.out.println("Wystąpił błąd podczas kopiowania pliku.");
                System.out.println("Szczegóły: " + e.getMessage());
            }
        }
    }
}
