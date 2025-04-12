public class ArithmeticMean {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Brak argumentów programu :(");
            return;
        }

        if (args.length == 1) {
            System.out.println("Podano tylko jedną wartość: " + args[0]);
            return;
        }
        int sum = 0;
        int number;

        StringBuilder numbers = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            number = Integer.parseInt(args[i]);
            sum += number;
            numbers.append(args[i]);
            if (i < args.length - 1) {
                numbers.append(", ");
            }
        }
        int mean = sum / args.length;
        int rest = sum % args.length;

        System.out.println(
                "Średnia arytmetyczna liczb: " + numbers + " wynosi " + mean + (rest == 0 ? ", reszta: " + rest : ""));
    }
}
