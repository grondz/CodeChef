package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.codechef.com/DEC18B/problems/MAXEP
 */
public class Maxep {

    public static final String CONNECT_VOLATGE_OP = "1 ";
    public static final String REPAIR_PANEL_OP = "2";
    public static final String REPRORT_RESULT_OP = "3 ";

    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_BROKEN_PANEL = 1;
    public static final int RESULT_INVALID = -1;

    public static final int SUCCESS_COST = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split("\\s+");
        int n = java.lang.Integer.parseInt(line[0]);
        int repairCost = java.lang.Integer.parseInt(line[1]);

        int step = (int) java.lang.Math.ceil((java.lang.Math.sqrt(8.0 * n + 1.0) - 1.0) / 2.0);
        int minGoodVoltage = 0;
        int testVoltage = step;
        int response;
        int coins = 1000;

        // phase One
        do {
            System.out.println(CONNECT_VOLATGE_OP + testVoltage);
            System.out.flush();
            response = java.lang.Integer.parseInt(br.readLine());
            switch (response) {
                case RESULT_SUCCESS:
                    step -= 1;
                    minGoodVoltage = testVoltage;
                    testVoltage = java.lang.Math.min(minGoodVoltage + step, n);
                    coins -= SUCCESS_COST;
                    break;
                case RESULT_BROKEN_PANEL:
                    System.out.println(REPAIR_PANEL_OP);
                    System.out.flush();
                    coins -= repairCost;
                    break;
                default:
                    System.exit(-1);
            }
        } while (response == RESULT_SUCCESS);

        // testVoltage breaks the panel
        // continue from last known good voltage up
        testVoltage = java.lang.Math.min(minGoodVoltage, n);
        response = RESULT_SUCCESS;

        while (testVoltage < n && response == RESULT_SUCCESS) {
            testVoltage = java.lang.Math.min(testVoltage + 1, n);
            System.out.println(CONNECT_VOLATGE_OP + testVoltage);
            System.out.flush();
            response = java.lang.Integer.parseInt(br.readLine());
        };

        System.out.println(REPRORT_RESULT_OP + testVoltage);
        System.out.flush();
    }
}
