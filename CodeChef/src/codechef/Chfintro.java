package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.codechef.com/DEC18B/problems/CHFINTRO
 */
class Chfintro {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split("\\s+");
        int n = java.lang.Integer.parseInt(line[0]);
        int limitRating = java.lang.Integer.parseInt(line[1]);
        for (int i = 0; i < n; ++i) {
            int contestantsRating = java.lang.Integer.parseInt(br.readLine());
            System.out.println(contestantsRating < limitRating ? "Bad boi": "Good boi");
        }
    }
}
