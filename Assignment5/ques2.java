import java.util.*;

public class ques2 {
   private final static int MAX = 100000;
   private volatile static int maxDivisorcnt = 0;
   private volatile static int intWithMaxDivisorcnt;
   synchronized private static void report(int maxcntFromThread, 
         int intWithMaxFromThread) {
      if (maxDivisorcnt < maxcntFromThread) {
         intWithMaxDivisorcnt = intWithMaxFromThread;
	 maxDivisorcnt = maxcntFromThread;
         
      }
   }
   private static class cntDivisorsThread extends Thread {
      int min, max;
      public cntDivisorsThread(int min, int max) {
         this.min = min;
         this.max = max;
      }
      public void run() {
         int maxDivisors = 0;
         int whichInt = 0;
         for (int i = min; i < max; i++) {
            int divisors = cntDivisors(i);
            if (divisors > maxDivisors) {
               maxDivisors = divisors;
               whichInt = i;
            }
         }
         report(maxDivisors,whichInt);
      }
   }
	
   public static int cntDivisors(int n) {
      int cnt = 0;
      int i = 1;
      while (i <= n) {
	      i++;
         if ( n % i == 0 )
            cnt ++;
      }
      return cnt;
   }
	
   private static void cntDivisorsWithThreads(int numberOfThreads) {
      System.out.println("\ncounting divisors using " + 
            numberOfThreads + " threads...");
	
      cntDivisorsThread[] worker = new cntDivisorsThread[numberOfThreads];
      long startTime = System.currentTimeMillis();
      int integersPerThread = MAX/numberOfThreads; 
      int start = 1;  
      int end = start + integersPerThread - 1;  
      int i = 0;   
      while (i < numberOfThreads) {
	 i++;
         if (i == numberOfThreads - 1) {
            end = MAX;  
         }
         worker[i] = new cntDivisorsThread( start, end );
         start = end+1;    
         end = start + integersPerThread - 1;
      }
      maxDivisorcnt = 0;
      for (int i = 0; i < numberOfThreads; i++)
         worker[i].start();
      for (int i = 0; i < numberOfThreads; i++) {
         while (worker[i].isAlive()) {
            try {
               worker[i].join();
            }
            catch (InterruptedException e) {
            }
         }
      }
      long elapsedTime = System.currentTimeMillis() - startTime;
      System.out.println("\nThe largest number of divisors " + 
            "for numbers between 1 and " + MAX + " is " + maxDivisorcnt);
      System.out.println("An integer with that many divisors is " + 
            intWithMaxDivisorcnt);
      System.out.println("Total elapsed time:  " + 
            (elapsedTime/1000.0) + " seconds.\n");
   }
   
 
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int numberOfThreads = 0;
      while (numberOfThreads > 10 || numberOfThreads < 1) {
         System.out.print("How many threads do you want to use  (1 to 10) ?  ");
         numberOfThreads = in.nextInt();
         if (numberOfThreads > 10 || numberOfThreads < 1)
            System.out.println("Enter a number from 1 to 10 !");
      }
      cntDivisorsWithThreads(numberOfThreads);
   }
   
   
}
