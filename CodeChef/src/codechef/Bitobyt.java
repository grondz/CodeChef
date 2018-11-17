package codechefprojects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
    https://www.codechef.com/problems/BITOBYT
 */
public class Bitobyt {

    public static final int BIT_SECONDS = 2;
    public static final int NIBBLE_SECONDS = 8;
    public static final int BYTE_SECONDS = 16;

    public static final BigInteger TWO = new BigInteger("2");

    private static class Entity {

        BigInteger amount;
        int timeElapsed;
    }

    public static void simulatePopulation(int toTime) {
        Entity abit = new Entity();
        Entity anibble = new Entity();
        Entity abyte = new Entity();

        abit.amount = BigInteger.ONE;
        abit.timeElapsed = 0;

        anibble.amount = BigInteger.ZERO;
        anibble.timeElapsed = 0;

        abyte.amount = BigInteger.ZERO;
        abyte.timeElapsed = 0;

        for (int i = 1; i < toTime; ++i) {
            if (abit.amount.compareTo(BigInteger.ZERO) > 0) {
                abit.timeElapsed++;
                if (abit.timeElapsed == BIT_SECONDS) {
                    anibble.amount = abit.amount.add(BigInteger.ZERO);
                    anibble.timeElapsed = 0;
                    abit.amount = BigInteger.ZERO;
                    abit.timeElapsed = 0;
                }
            } else if (anibble.amount.compareTo(BigInteger.ZERO) > 0) {
                anibble.timeElapsed++;
                if (anibble.timeElapsed == NIBBLE_SECONDS) {
                    abyte.amount = anibble.amount.add(BigInteger.ZERO);
                    abyte.timeElapsed = 0;
                    anibble.amount = BigInteger.ZERO;
                    anibble.timeElapsed = 0;
                }
            } else if (abyte.amount.compareTo(BigInteger.ZERO) > 0) {
                abyte.timeElapsed++;
                if (abyte.timeElapsed == BYTE_SECONDS) {
                    abit.amount = abyte.amount.multiply(TWO);
                    abit.timeElapsed = 0;
                    abyte.amount = BigInteger.ZERO;
                    abyte.timeElapsed = 0;
                }
            }

        }

        System.out.println(abit.amount + " " + anibble.amount + " " + abyte.amount);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; ++tc) {
            int timeToEnd = Integer.parseInt(br.readLine());
            simulatePopulation(timeToEnd);

        }
    }
}
