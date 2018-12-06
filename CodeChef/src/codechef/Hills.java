package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/HILLS
*/

public class Hills {

    public static int process(int u, int d, int [] hills) {
        int lastPosition = 0;
        boolean parachuteUsed = false;
        
        while(lastPosition < hills.length - 1) {
            int nextPeak = hills[lastPosition + 1];
            int actualPeek = hills[lastPosition];
            if (nextPeak >= actualPeek) {
                if (nextPeak - actualPeek <= u ) {
                    lastPosition++;
                } else break;
            } else {
                if (actualPeek - nextPeak <= d) {
                    lastPosition++;
                } else { 
                    if (!parachuteUsed) {
                        parachuteUsed = true;
                        lastPosition++;
                    } else break;
                }                
            }
        }
        
        return lastPosition + 1;
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCases; ++tc) {
            String[] line = br.readLine().split("\\s+");
            int n = java.lang.Integer.parseInt(line[0]);
            int u = java.lang.Integer.parseInt(line[1]);
            int d = java.lang.Integer.parseInt(line[2]);
            String [] hilsInput = br.readLine().split("\\s+");
            int [] hils = new int[n];
            for(int i = 0; i < n; ++i)
                hils[i] = java.lang.Integer.parseInt(hilsInput[i]);
            System.out.println(process(u, d, hils));
        }
    }     
}
