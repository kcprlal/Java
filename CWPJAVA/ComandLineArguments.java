public class ComandLineArguments {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Brak argumentów");
        } else {
            System.out.println("Liczba argumentów: " + args.length);
        }
        for (int i = 0; i < args.length; i++) {
            System.out.println((i + 1) + ". " + args[i]);
        }
    }
}
