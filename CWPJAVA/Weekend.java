import java.util.Date;

public class Weekend {
    public static void main(String[] args) {
        Date currentDate = new Date();
        int days;

        if (currentDate.getDay() <= 0 && currentDate.getDay() > 5)
            days = 0;
        else {
            days = 5 - currentDate.getDay(); 
        }
        System.out.println("Liczba dni do weekendu: " + days);
    }
}
