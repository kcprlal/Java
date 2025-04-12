public class Variables {
    public static void main(String[] args) {
    //primitive dt    
        int age = 21;
        int year = 2025;
        
        System.out.println(age);
        System.out.println("It's "+year);

        double temperature = 20.17;

        System.out.println("Temperature is "+temperature);

        char letter = 'f';

        System.out.println("The letter is "+letter);

        boolean todayIsFriday = false;

        if(todayIsFriday){
            System.out.println("Today is Friday!");
        }
        else {
            System.out.println("It's not Friday :(");
        }
    //reference dt

        String name = "Carlos";

        System.out.println("How do you call Mexican who lost his car? "+name);

    }
    
}
