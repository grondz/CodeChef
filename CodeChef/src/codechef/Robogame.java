package codechefprojects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/ROBOGAME
*/
public class Robogame {

    public static String testRobots(String robotsMap) {
        String result = "safe";
        int firstRobotRight = -1;
        int secondRobotLeft;
        int secondRobotRight;

        for (int i = 0; i < robotsMap.length(); ++i) {
            char c = robotsMap.charAt(i);
            if (c == '.') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                int pos = i;
                int ranges = c - '0';
                secondRobotLeft = java.lang.Math.max(0, pos - ranges);
                secondRobotRight = java.lang.Math.min(robotsMap.length() - 1, pos + ranges);
                if (firstRobotRight >= secondRobotLeft) {
                    return "unsafe";
                }
                firstRobotRight = secondRobotRight;
            } else {
                return "incorrect input";
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; ++tc) {
            String robotsMap = br.readLine();
            System.out.println(testRobots(robotsMap));
        }
    }
}
