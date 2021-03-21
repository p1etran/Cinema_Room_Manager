package cinema;
import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    private static char[][] matrix;
    static int seatChosen;
    static int rowChosen;
    static int rows;
    static int seats;
    static int totalTickets;
    static int currentIncome;


    private static final Scanner scanner= new Scanner(System.in);
   // char[][] matrix;


    public static void seatMap(int rows) {
//        System.out.println("Cinema:");
//        System.out.print(" ");
//        for(int i=1; i< seats+1;i++) {
//            System.out.print(" "+i);
//        }
//        System.out.printf("%n");
        for (int i = 0; i < rows; i++) {
            Arrays.fill(matrix[i], 'S');
        }
//        for (int i = 0; i < rows; i++) {
//            System.out.print(i + 1);
//            for (int j = 0; j < seats; j++) {
//                System.out.print(" ");
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
    }

    public static void takeSeat(int row, int seat){
        matrix[row-1][seat-1]='B';
        totalTickets++;
    }
    public static void printSeats(int rows, int seats){
        System.out.println("Cinema:");
        System.out.print(" ");
        for(int i=1; i< seats+1;i++) {
            System.out.print(" "+i);
        }
        System.out.printf("%n");
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats; j++) {
                System.out.print(" ");
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    //starting rows,seats size
    public static void cinemaSize() {
        System.out.println("Enter the number of rows:");
        System.out.print(">");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print(">");
        int seats = scanner.nextInt();
    }

    public static void income(int rows, int seats){
        int totalSeats = rows * seats;
        int totalIncome;
        if (totalSeats > 60) {
            totalIncome = (rows / 2) * seats * 10 + (rows % 2 + rows / 2) * seats * 8;
        } else totalIncome = totalSeats * 10;
        System.out.println("Total income: $" + totalIncome);
       // System.out.print("$" + totalIncome);
    }
    //calculating ticket price based on seat coordinates
    public static void ticketPrice(int row, int seat, int rows, int seats){
        int totalSeats = rows * seats;
        if (totalSeats > 60) {
                if(row<(rows/2+rows%2)){ currentIncome+=10; System.out.println("Ticket price: $10");}
                else {currentIncome+=8; System.out.println("Ticket price: $8");}
        } else {currentIncome+=10; System.out.println("Ticket price: $10");}
    }
    //printing menu
    public static int menu(){
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int w = scanner.nextInt();
        return w;
    }
    public static void choseSeat(){
        System.out.println("Enter a row number:");
        System.out.print(">");
        rowChosen = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        System.out.print(">");
        seatChosen = scanner.nextInt();
        if(rowChosen<=0|| rowChosen>rows||seatChosen>seats||seatChosen<=0){
            System.out.println("Wrong input!");
            choseSeat();
        }
        if(matrix[rowChosen-1][seatChosen-1]=='B') {
            System.out.println("That ticket has already been purchased!");
            choseSeat();
        }
    }

    public static void main(String[] args) {
        //Cinema cinema = new Cinema();
        totalTickets = 0;
        System.out.println("Enter the number of rows:");
        System.out.print(">");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print(">");
        seats = scanner.nextInt();
        matrix = new char[rows][seats];
        seatMap(rows);
        int buttonPressed = menu();
        while(buttonPressed!=0)
        {
            switch(buttonPressed){
                case 1:
                    printSeats(rows,seats);
                    break;
                case 2:
                    choseSeat();
                    ticketPrice(rowChosen,seatChosen, rows, seats);
                    takeSeat(rowChosen,seatChosen);
                    break;
                case 3:
                    System.out.println("Number of purchased tickets: "+ totalTickets);
                    System.out.printf("Percentage: %.2f%%%n", (totalTickets * 100.0f) / (rows*seats));
                    System.out.println("Current income: $"+ currentIncome);
                    income(rows,seats);
            }
            buttonPressed=menu();
        }
        return;

//        System.out.println("Enter a row number:");
//        System.out.print(">");
//        int rowChosen = scanner.nextInt();
//        System.out.println("Enter a seat number in that row:");
//        System.out.print(">");
//        int seatChosen = scanner.nextInt();
//        ticketPrice(rowChosen,seatChosen, rows, seats);
//        takeSeat(rowChosen,seatChosen);
//        printSeats(rows,seats);
    }
}