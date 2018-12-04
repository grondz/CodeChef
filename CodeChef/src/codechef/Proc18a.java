package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/PROC18A
*/

class Proc18a {

    public static int evaluate(int k, int [] girls) {
        int runningSum = 0;
        for(int i = 0; i < k; ++i) runningSum += girls[i];
        int max = runningSum;
        
        for(int i = k; i < girls.length; i++) {
            runningSum = runningSum - girls[i - k] + girls[i];
            if (max < runningSum) max = runningSum;
        }
        return max;
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCases; ++tc) {
            String[] line = br.readLine().split("\\s+");
            int n = java.lang.Integer.parseInt(line[0]);
            int k = java.lang.Integer.parseInt(line[1]);
            String [] girlsInput = br.readLine().split("\\s+");
            int [] girls = new int[n];
            for(int i = 0; i < n; ++i)
                girls[i] = java.lang.Integer.parseInt(girlsInput[i]);
            System.out.println(evaluate(k, girls));
        }
    }        
}
