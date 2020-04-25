package InterviewTests;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter the number which will be the bounder");
        int bounderNum=input.nextInt();
        int a=0;
        int b=1;
        int sum=0;
        while (sum<=bounderNum){
            sum=a+b;
            if (sum>=bounderNum){
                break;
            }
            System.out.print(sum+" ");
            a=b;
            b=sum;
        }
    }
}
