package Basic_Data_Structures;

import java.util.Scanner;

public class Ques1 {
    public static void main(String[] args) {
        ArmstrongOrNot armstrongOrNot = new ArmstrongOrNot();
        int num;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        if(armstrongOrNot.armstrongCheck(num)==true){
            System.out.println("Yes");
        }
        else
            System.out.println("No");
    }
}

class ArmstrongOrNot {
    public boolean armstrongCheck(int num){
        int n = num;
        int d=0;
        while(n>0){
            d++;
            n = n/10;
        }
        //System.out.println(d);
        int n1 = num;
        int arm =0;
        while(n1>0){
            int remainder = n1%10;
            arm =arm+ (int)Math.pow(remainder,d);
            n1 = n1/10;
        }

        if(num==arm)
            return true;
        else
            return false;
    }
}