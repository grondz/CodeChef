package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.codechef.com/problems/THREEFR
*/
public class Threefr {

    public static boolean testPossibility(int x, int y, int z) {
        return (x + y == z) || (x + z == y) || (z + y == x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; ++tc) {
            String[] data = br.readLine().split("\\s+");
            int x = java.lang.Integer.parseInt(data[0]);
            int y = java.lang.Integer.parseInt(data[1]);
            int z = java.lang.Integer.parseInt(data[2]);

            System.out.println(testPossibility(x, y, z) ? "yes" : "no");

        }
    }
}

/*
Input:
2
1 2 1
1 1 1

Output:
yes
no
*/