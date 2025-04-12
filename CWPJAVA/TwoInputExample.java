import javax.swing.*;

public class TwoInputExample {
    public static void main(String[] args) {
        JTextField pole1 = new JTextField();
        JTextField pole2 = new JTextField();

         Object[] komunikat = {
             "Wartość 1:", pole1,
             "Wartość 2:", pole2
         };

        int wynik = JOptionPane.showConfirmDialog(null, komunikat, "Podaj dwie wartości", JOptionPane.OK_CANCEL_OPTION);

        if (wynik == JOptionPane.OK_OPTION) {
            String wartosc1 = pole1.getText();
            String wartosc2 = pole2.getText();
            System.out.println("Wartość 1: " + wartosc1);
            System.out.println("Wartość 2: " + wartosc2);
        } else {
            System.out.println("Anulowano.");
        }
    }
}

