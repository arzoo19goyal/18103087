import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter +ve number");
        String n = obj.nextLine();
        int flag=0;
        do {
            flag=0;
            for (int i = 0; i < n.length(); i++)
                if (n.charAt(i) > '9' || n.charAt(i) < '0') {
                    flag = 1;
                    break;
                }
            if (flag == 1) {
                System.out.println("Better chose a positive number. Try again");
                n = obj.nextLine();
            }
        }
        while(flag!=0);
        long nk = Long.valueOf(n);
        if(nk > Integer.MAX_VALUE) {
            System.out.println(nk + " is beyond integer limits. Program entered into self destruct mode.");
        }
        else if(nk==0)
            System.out.println(0);
        else {

            while (nk < 0) {
                System.out.println("Negative numbers are so not allowed. Chose a positive number. Try again");
                nk = obj.nextInt();
            }
            if (nk == 1)
                System.out.println(nk);
            while (nk != 1) {
                if (nk > Integer.MAX_VALUE) {
                    System.out.println(nk + " is beyond integer limits. Program entered into self destruct mode.");
                    break;
                }
                if (nk % 2 != 0)
                {
                    if (nk * 3 + 1 > Integer.MAX_VALUE) {
                        System.out.println(nk + "*3+1 is beyond integer limits. Program entered into self destruct mode.");
                        break;
                    } else
                        nk = nk * 3 + 1;
                }
                else 
                    nk /= 2;
                System.out.println(nk);
            }
        }
    }
}
