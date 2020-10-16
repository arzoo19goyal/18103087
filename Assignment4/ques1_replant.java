import java.util.*;

class ques1 {
    
     public static void main(String[] args){
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.nextLine();
        String[] crops = new String[n];
        for (int i=0;i<n;i++){
            crops[i]=in.nextLine().trim();
        }
        System.out.print(replant(crops);
    }

    
    public static int replant(String[] crops) {
        int n=crops.length;     
        int m=crops[0].length();
        String[] c= new String[n];
        if(n>=0)
            System.arraycopy(crops, 0, c, 0, n);
        int rep1=0, rep2=0;
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++) {
                if(!isValid(crops, i, j)) {
                    crops[i] = crops[i].substring(0, j) + available(crops, i, j) + crops[i].substring(j + 1);
                    rep1++;
                }
            }

        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++) {
                if(!isValid(c, i, j) || making_triangle(crops, i, j)) {
                    c[i] = c[i].substring(0, j) + available(c, i, j) + c[i].substring(j + 1);
                    rep2++;
                }
            }
        return Math.min(rep1, rep2);
    }
    
                         
    public static boolean isValid(String[] crops, int i, int j) {
        return !(
                ((i>0)? crops[i].charAt(j)==crops[i-1].charAt(j): false)
                ||
                ((j>0)? crops[i].charAt(j)==crops[i].charAt(j-1): false)
        );
    }

    public static char available(String crops, int row, int col) {
        for(char x='a'; x<='z'; x++)
            if(validate(crops, x, row, col))
                return x;
    }
    public static boolean validate(String[] crops, char x, int row, int col) {
        if(row>0)
            if(x==crops[row-1].charAt(col))
                return false;
        if(col>0)
            if(x==crops[row].charAt(col-1))
                return false;
        if(row<crops.length)
            if(x==crops[row+1].charAt(col))
                return false;
        if(col<crops[0].length())
            if(x==crops[row].charAt(col+1))
                return false;
        return true;
    }

    public static boolean making_triangle (String[] crops, int row, int col) {
        return (row+1<crops.length && crops[row].charAt(col)==crops[row+1].charAt(col) &&
                col+1<crops[0].length() && crops[row].charAt(col)==crops[row].charAt(col+1));
    }

}
