package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/SPLST
*/

class Splst {
    
    public static final String POSITIVE_ANSWER = "YES";
    public static final String NEGATIVE_ANSWER = "NO";
    
    private static boolean testCase(long a, long b, long c, long x, long y) {
        long difxb = x - b;
        long difyc = y - c;
        long difxc = x - c;
        long difyb = y - b;
        
        return (
                (difxb >= 0 && difyc >= 0 && difxb + difyc == a) ||  
                (difxc >= 0 && difyb >= 0 && difxc + difyb == a)
               );
    }
    
    public static String evaluate(long a, long b, long c, long x, long y) {
        if (a + b + c != x + y) return NEGATIVE_ANSWER;
        if (testCase(a, b, c, x, y)) return POSITIVE_ANSWER;
        if (testCase(b, a, c, x, y)) return POSITIVE_ANSWER;
        if (testCase(c, b, a, x, y)) return POSITIVE_ANSWER;
        
        return NEGATIVE_ANSWER;
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCases; ++tc) {
            String[] line = br.readLine().split("\\s+");
            long a = java.lang.Integer.parseInt(line[0]);
            long b = java.lang.Integer.parseInt(line[1]);
            long c = java.lang.Integer.parseInt(line[2]);
            long x = java.lang.Integer.parseInt(line[3]);
            long y = java.lang.Integer.parseInt(line[4]);
            System.out.println(evaluate(a, b, c, x, y));
        }
    }    
}
