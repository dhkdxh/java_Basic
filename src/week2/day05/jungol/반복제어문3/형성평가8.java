package week2.day05.jungol.반복제어문3;
import java.util.*;

public class 형성평가8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int n = 1;
        for(int i=1; i<=num; i++){
            for(int j=1; j<=2*(i-1); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=num-i+1; j++){
                System.out.print(n+" ");
                n++;
            }
            System.out.println();
        }
    }
}
