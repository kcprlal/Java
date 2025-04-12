import java.util.Arrays;
import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Podaj rozmiar kwadratu: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                System.out.println("Rozmiar musi być większy do zera!");
                return;
            }

            square(size);
        } catch (Exception e) {
            System.out.println("Nieprawidłowa wartość!");
        } finally {
            scanner.close();
        }
    }

    private static void square(int size) {
        char[] arr = new char[size * size + size];
        Arrays.fill(arr, ' ');
        for (int i = 0; i < size * size + size; ++i) {

            if (i < size) {
                arr[i] = '#';
                arr[arr.length - i - 2] = '#';
            }
            if (i % (size + 1) == size)
                arr[i] = '\n';
            if (i % (size + 1) == size - 1)
                arr[i] = '#';
            if (i % (size + 1) == 0)
                arr[i] = '#';
        }
        System.out.println(arr);
    }
}