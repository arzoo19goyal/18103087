public class Main {
    public static void main(String[] args) {
        int sum=0, x=1;
        for(; x<Integer.MAX_VALUE; x++) {
            if(sum >= Integer.MAX_VALUE - x) break;
            sum += x;
            if((int)Math.sqrt(sum)==x)
                System.out.println(x);
        }
        System.out.println("The program ended at "+x);
    }
}
