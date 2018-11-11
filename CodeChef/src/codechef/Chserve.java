package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/CHSERVE
*/
public class Chserve {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; ++tc) {
            String[] data = br.readLine().split("\\s+");
            int chefPoints = Integer.parseInt(data[0]);
            int cookPoints = Integer.parseInt(data[1]);
            int serveChangeLimit = Integer.parseInt(data[2]);

            int totalPoints = chefPoints + cookPoints;

            System.out.println((totalPoints / serveChangeLimit) % 2 == 0 ? "CHEF" : "COOK");
        }
    }
}

/*
Input:
3
1 3 2
0 3 2
34 55 2

Output:
CHEF
COOK
CHEF
 */
