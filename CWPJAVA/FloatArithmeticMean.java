import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class FloatArithmeticMean {
    public static void main(String[] args) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');

        DecimalFormat format = new DecimalFormat("0.000", symbols);
        DecimalFormat formatResult = new DecimalFormat("0.0000", symbols);

        if(args.length==0){
            System.out.println("Brak argumentów programu.");
            return;
        }
        float sum=0;
        int width = 15;

        for(int i =0;i<args.length;i++){
            
            String num = format.format(Float.parseFloat(args[i]));
            System.out.println(String.format("%" + width + "s", num));
            sum+=Float.parseFloat(args[i]);
        }
        System.out.println("---------------");
        
        String num = format.format(sum);
        System.out.println(String.format("%" + width + "s", num));

        System.out.println("Średnia arytmetyczna: " + formatResult.format(sum/args.length));
    }
}
