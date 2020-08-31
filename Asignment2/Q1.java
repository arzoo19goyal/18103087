import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner obj=new Scanner (System.in);
        String string1=obj.nextLine();
        String string2=obj.nextLine();
        int i=0;
        int flag=0;
        while(i<string1.length() && i<string2.length())
        {
            if(string1.charAt(i) < string2.charAt(i)) {
                System.out.println(string1 + " is smaller than " + string2 + " lexicographically");
                flag=1;
                break;
            }
            else if(string1.charAt(i) > string2.charAt(i)) {
                System.out.println(string2 + " is smaller than " + string1 + " lexicographically");
                flag=1;
                break;
            }
            else {
                i++;
            }
        }
        if(flag==0)
        {
            if(i!=string1.length() && i==string2.length())
                System.out.println(string2 + " is lexicographically smaller than " + string1);
            else if(i==string1.length() && i!=string2.length())
                System.out.println(string1 + " is lexicographically smaller than " + string2);
            else System.out.println(string2 + " and " + string1 + " are lexicographically equal");
        }
    }
}
