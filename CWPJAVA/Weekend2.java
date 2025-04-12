import java.util.Calendar;

public class Weekend2 {
    private static final String weekday[] = { "poniedziałek", "wtorek", "środa", "czwartek", "piątek" };

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        int today = c.get(Calendar.DAY_OF_WEEK);
        int toWeekend = 6 - today;
        String wordEnding = "y ";
        String days = " dni";
        if (today == 5) {
            wordEnding = " ";
            days = " dzień";
        } else if (today == 6)
            wordEnding = "o ";
        if (today == 1 || today == 7) {
            System.out.println("Mamy weekend!");
        } else {
            System.out.println("Dziś " + weekday[today - 2] + ", do weekendu pozostał" + wordEnding + toWeekend + days);
        }
    }
}
