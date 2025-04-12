import java.util.Calendar;

public class Weekend1 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
            System.out.println("Dziś jest poniedziałek.");    
            break;
            case Calendar.TUESDAY:
            System.out.println("Dziś jest wtorek.");
            break;
            case Calendar.WEDNESDAY:
            System.out.println("Dziś jest środa.");    
                break;
            case Calendar.THURSDAY:
            System.out.println("Dziś jest czwartek.");
            break;
            case Calendar.FRIDAY:
            System.out.println("Dziś jest piątek.");    
                break;
            case Calendar.SATURDAY:
            System.out.println("Weekend!");
            break;
            case Calendar.SUNDAY:
            System.out.println("Weekend!");    
            break;

            default:
                break;
        }
    }
}
