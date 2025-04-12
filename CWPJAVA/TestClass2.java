import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestClass2 {
    private static int counter = 0;
    private final int objectNum;
    private final long construcTime;

    public TestClass2() {
        counter++;
        this.objectNum = counter;
        this.construcTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return objectNum + ". [" + construcTime + "]";
    }

    public static int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
    LocalDateTime nowT = LocalDateTime.now();
    DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
    
    System.out.println("Witaj! Teraz jest: " + nowT.format(form));
    System.out.println(); // pusty wiersz dla czytelności
    
        if (args.length == 0) {
            System.out.println("Brak argumentów programu.");
            return;
        }

        int ojbectCount = Integer.parseInt(args[0]);

        for (int i = 0; i < ojbectCount; i++) {
            TestClass obj = new TestClass();
            System.out.println(obj);
        }

        System.out.println("Liczba obiektów: " + TestClass.getCounter());
    }
}

