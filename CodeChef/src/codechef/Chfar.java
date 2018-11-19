package codechefprojects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

/*
    https://www.codechef.com/problems/CHFAR
 */
public class Chfar {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; ++tc) {
            String[] inputData = br.readLine().split("\\s");
            int valueN = Integer.parseInt(inputData[0]);
            int valueK = Integer.parseInt(inputData[1]);
            java.util.List<Integer> numbers = new java.util.ArrayList<>();
            int largerCount = 0;
            String [] values = br.readLine().split("\\s");
            for (int i = 0; i < values.length; ++i) {
                int value = Integer.parseInt(values[i]);
                if (value > 1) largerCount++;
            }            
            System.out.println(largerCount <= valueK? "YES": "NO");
        }
    }
}


/*

1
2 2
1 2

*/
