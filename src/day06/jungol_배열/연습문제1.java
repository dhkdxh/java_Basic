package day06.jungol_배열;
import java.util.*;

public class 연습문제1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        for(int i=0; i<5; i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0; i<5; i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
