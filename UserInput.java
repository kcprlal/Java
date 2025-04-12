import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       /*  System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("How old r u? ");
        int age = scanner.nextInt();

        System.out.println("Your name is: " + name + " D:");
        System.out.println("U r " + age + " yo");
        
        // COMMON ISSUES int -> string

        System.out.print("What is your gpa? ");
        double gpa = scanner.nextDouble();
        //Empty read buffer of \n
        scanner.nextLine();
        //-------------
        System.out.print("What is your faculty? ");
        String faculty = scanner.nextLine();

        System.out.println("Your gpa is: " + gpa);
        System.out.println("Your faculty is " + faculty);

         */
        // Excersise: Calculate area of rectangle
        double height = 0, width = 0, area = 0;
        
        System.out.print("Height: ");
        height = scanner.nextDouble();
        System.out.print("Width: ");
        width = scanner.nextDouble();
        
        area = width * height;

        System.out.print("Area of rectangle is: " + area +"cm^2");
        
        scanner.close();
    }
}
