public class Main extends Thread {
    public void run() {
        int i = 0;
        while(i<100) {
            System.out.println(i+1);
            if((i+1)%10 == 0) {
                System.out.println();
                System.out.println("10 numbers printed");
            }
            try {
                Thread.sleep(1000);
            }
            catch(Exception e){
                err.printStackTrace();
            }
            i++;
        }
    }
    public static void main(String[] args)
    {
        Main obj = new Main();
        obj.start();
    }
}
