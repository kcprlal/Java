import java.io.*;
import java.net.*;

public class FileAndURLCopy {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Brak argumentów programu.");
            System.out.println("Użycie: java FileAndURLCopy źródło [cel]");
            return;
        }

        String sourceArg = args[0];
        String targetArg = (args.length >= 2) ? args[1] : null;

        // Sprawdzamy czy to URL
        if (sourceArg.startsWith("http://") || sourceArg.startsWith("https://")) {
            copyFromURL(sourceArg, targetArg);
        } else {
            copyFromFile(sourceArg, targetArg);
        }
    }

    private static void copyFromFile(String sourcePath, String targetPath) {
        File source = new File(sourcePath);
        File target;

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

        if (targetPath == null) {
            System.out.println("Użycie: java FileAndURLCopy source_file target");
            return;
        }

        target = new File(targetPath);

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
            OutputStream out = new FileOutputStream(target)
        ) {
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

    private static void copyFromURL(String urlString, String targetPath) {
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(5000); // 5 sekund timeout
            connection.setReadTimeout(5000);

            String fileName;
            if (targetPath != null) {
                fileName = targetPath;
            } else {
                fileName = new File(url.getPath()).getName();
                if (fileName.isEmpty()) {
                    fileName = "index.html";
                }
            }

            File target = new File(fileName);

            if (target.exists() && !target.canWrite()) {
                System.out.println("Brak wymaganych uprawnień do zapisu pliku " + target.getName());
                return;
            }

            try (
                InputStream in = connection.getInputStream();
                OutputStream out = new FileOutputStream(target)
            ) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) > 0) {
                    out.write(buffer, 0, bytesRead);
                }
            }

        } catch (MalformedURLException e) {
            System.out.println("Podany adres: '" + urlString + "' jest nieprawidłowy.");
        } catch (UnknownHostException e) {
            System.out.println("Brak połączenia sieciowego.");
        } catch (FileNotFoundException e) {
            System.out.println("Brak dostępu do '" + urlString + "'.");
        } catch (SocketTimeoutException e) {
            System.out.println("Przekroczono czas oczekiwania na odpowiedź z serwera.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas pobierania z adresu URL.");
            System.out.println("Szczegóły: " + e.getMessage());
        }
    }
}

