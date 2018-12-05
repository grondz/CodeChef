package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/MAGICHF
 */
public class Magichf {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCases; ++tc) {
            String[] line = br.readLine().split("\\s+");
            int n = java.lang.Integer.parseInt(line[0]);
            int actualPosition = java.lang.Integer.parseInt(line[1]);
            int s = java.lang.Integer.parseInt(line[2]);

            for (int i = 0; i < s; ++i) {
                String[] positionsInput = br.readLine().split("\\s+");
                int a = java.lang.Integer.parseInt(positionsInput[0]);
                int b = java.lang.Integer.parseInt(positionsInput[1]);
                if (actualPosition == a) {
                    actualPosition = b;
                } else if (actualPosition == b) {
                    actualPosition = a;
                }
            }
            System.out.println(actualPosition);
        }
    }
}
