package week2.day05.jungol.반복제어문2;
import java.util.*;

public class 연습문제2_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int sum = 0;
        for(int i=1; i<=num; i++){
            sum += i;
        }

        System.out.println(sum);
    }
}
