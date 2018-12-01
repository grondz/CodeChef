package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/SURVIVE
 */
class Survive {

    public static final int DAYS_OPEN = 6;
    public static final int DAYS_WEEK = 7;
    public static final int IMPOSSIBLE = -1;

    public static int evaluate(int barsInBox, int eatenInDay, int daysToSurvive) {
        if (barsInBox < eatenInDay) {
            return IMPOSSIBLE;
        }

        int boxesNeeded = (int) java.lang.Math.ceil( ((double) daysToSurvive * eatenInDay) / barsInBox);
        int accumulatedInWeek = (barsInBox - eatenInDay) * DAYS_OPEN;

        if (daysToSurvive < DAYS_WEEK) {
            return boxesNeeded;
        }

        return accumulatedInWeek >= eatenInDay ? boxesNeeded : IMPOSSIBLE;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCases; ++tc) {
            String[] line = br.readLine().split("\\s+");
            int n = java.lang.Integer.parseInt(line[0]);
            int k = java.lang.Integer.parseInt(line[1]);
            int s = java.lang.Integer.parseInt(line[2]);
            System.out.println(evaluate(n, k, s));
        }
    }
}
