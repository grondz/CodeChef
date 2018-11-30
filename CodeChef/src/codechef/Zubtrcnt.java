package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/ZUBTRCNT
 */
class Zubtrcnt {

    public static int countTriangles(int largeSize, int smallSize) {      
        if (smallSize > largeSize) return 0;
        if (smallSize == largeSize) return 1;
        
        int count = largeSize - smallSize + 1;
        count = count * (count + 1) / 2;
        return count;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCases; ++tc) {
            String[] line = br.readLine().split("\\s+");
            System.out.println("Case " + (tc + 1) + ": " + countTriangles(java.lang.Integer.parseInt(line[0]), java.lang.Integer.parseInt(line[1])));
        }
    }
}
