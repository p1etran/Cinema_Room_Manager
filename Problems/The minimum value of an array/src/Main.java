import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int [] Array = new int[size];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<size;i++)
        {
            Array[i]=scanner.nextInt();
        }
        for(int i=0;i<size;i++)
        {
            if(min>Array[i]) min=Array[i];
        }
        System.out.print(min);
    }
}