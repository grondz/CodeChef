package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.codechef.com/problems/SPAMCLAS
*/
public class Spamclas {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; ++tc) {
            String[] data = br.readLine().split("\\s+");
            int netLayers = java.lang.Integer.parseInt(data[0]);
            int minUserId = java.lang.Integer.parseInt(data[1]);
            int maxUserId = java.lang.Integer.parseInt(data[2]);

            int weightCoeff;
            int biasCoeff = 0;

            boolean wasEvenWeight = false;

            for (int i = 0; i < netLayers; ++i) {
                String[] layerInfo = br.readLine().split("\\s+");
                int weight = java.lang.Integer.parseInt(layerInfo[0]);
                int bias = java.lang.Integer.parseInt(layerInfo[1]);
                if (weight % 2 == 0) {
                    wasEvenWeight = true;
                }
                biasCoeff = (biasCoeff * weight + bias) % 2;
            }

            if (wasEvenWeight) {
                weightCoeff = 2;
            } else {
                weightCoeff = 1;
            }

            int amountOfId = maxUserId - minUserId + 1;
            int countNonSpammers = 0;
            int countSpammers = 0;
            int amountOfEvenId;
            int amountOfOddId;
            int evenResult = (2 * weightCoeff + biasCoeff) % 2;;
            int oddResult = (weightCoeff + biasCoeff) % 2;

            if (minUserId % 2 == 0) {
                amountOfOddId = amountOfId / 2;
                amountOfEvenId = amountOfId - amountOfOddId;
            } else {
                amountOfEvenId = amountOfId / 2;
                amountOfOddId = amountOfId - amountOfEvenId;
            }

            if (evenResult == 0) {
                countNonSpammers += amountOfEvenId;
            } else {
                countSpammers += amountOfEvenId;
            }

            if (oddResult == 0) {
                countNonSpammers += amountOfOddId;
            } else {
                countSpammers += amountOfOddId;
            }

            System.out.println(countNonSpammers + " " + countSpammers);
        }
    }
}

/*
Input
3
1 1 2
1 2
2 1 4
2 4
2 3
3 2 1000000000
2 4
2 2
5 4

Output
1 1
0 4
999999999 0
 */
