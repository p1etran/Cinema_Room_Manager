import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int rows= scanner.nextInt();
        int col= scanner.nextInt();
        int [][] matrix =new int [rows][col];
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                matrix [i][j]= scanner.nextInt();
            }
        }
        int i= scanner.nextInt();
        int j= scanner.nextInt();
        int temp=0;

        for(int k=0;k<rows;k++){
        temp=matrix[k][i];
        matrix[k][i]=matrix[k][j];
        matrix[k][j]=temp;
        }

        for(int l=0;l<rows;l++){
            for(int m=0;m<col;m++){
               System.out.print(matrix [l][m]+" ");
            }
            System.out.println();
        }
    }
}