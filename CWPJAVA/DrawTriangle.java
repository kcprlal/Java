import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("wprowadz liczbe: ");
            int size = scan.nextInt();
            if (size < 2) {
                System.out.println("musi byc wiekszy od 1");
                return;
            }
            triangle(size);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            scan.close();
        }
        return;
    }

    private static void triangle(int size) {
        for (int i = 0; i < size; ++i) {
            for (int j = 1; j < size - i; ++j) {
                System.out.print(" ");
            }

            for (int j = 0; j < (i * 2) + 1; ++j) {
                System.out.print("#");
            }

            for (int j = 1; j < size - i; ++j) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
