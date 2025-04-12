public class TestClass {
    private static int counter = 0;
    private final int objectNum;
    private final long construcTime;

    public TestClass() {
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

