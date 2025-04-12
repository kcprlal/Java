import java.util.Date;
import java.text.SimpleDateFormat;

public class HelloDate {
    public static void main(String[] args){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        System.out.println("Witaj! Teraz jest: " + format.format(date));
    }
}
