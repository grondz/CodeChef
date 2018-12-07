package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.codechef.com/DEC18B/problems/CHFIDEAL
 */
class Chfideal {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1");
        System.out.flush();
        String line = br.readLine();
        int answer = java.lang.Integer.parseInt(line);
        if (answer == 2) {
            System.out.println("3");
        } else {
            System.out.println("2");
        }
        System.out.flush();
    }
}
