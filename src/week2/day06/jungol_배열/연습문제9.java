package week2.day06.jungol_배열;

import java.util.Arrays;

public class 연습문제9 {
    public static void main(String[] args) {
        int[] arr= {95,75,85,100,50};

        Arrays.sort(arr);

        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
