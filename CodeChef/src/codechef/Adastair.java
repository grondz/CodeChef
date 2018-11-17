package codechefprojects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/ADASTAIR 
*/
public class Adastair {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; ++tc) {
            String [] data = br.readLine().split("\\s+");
            int N = java.lang.Integer.parseInt(data[0]);
            int K = java.lang.Integer.parseInt(data[1]);
            
            int counter = 0;
            int height0 = 0;
            
            String [] heights = br.readLine().split("\\s+");
            for(int i = 0; i < heights.length; ++i) {
                int height1 = java.lang.Integer.parseInt(heights[i]);
                int diff = (height1 - height0);
                if (diff > K) {
                    counter += diff / K;
                    if (diff % K == 0) counter--;
                }
                height0 = height1;
            }
            
            System.out.println(counter);
        }
    }
}

/*
Input:
1
4 3
2 4 8 16

Output:
3
*/
