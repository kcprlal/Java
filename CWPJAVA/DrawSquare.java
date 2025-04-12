import java.util.Arrays;
public class DrawSquare {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Brak argumrntów!");
            return;
        }
        int size = Integer.parseInt(args[0]);
        DrawSquare.square(size);
    }

    private static void square(int size) {
        char[] arr = new char[size*size+size];
        Arrays.fill(arr, ' ');
        for(int i = 0; i<size*size+size; ++i){

            if(i<size){
                arr[i]='#';
                arr[arr.length-i-2]='#';
            }
            if(i%(size+1)==size) arr[i]='\n';
            if(i%(size+1)==size-1) arr[i]='#';
            if(i%(size+1)==0) arr[i]='#';
        }
        System.out.println(arr);
    }
}