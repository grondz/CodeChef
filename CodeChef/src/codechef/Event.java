package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/EVENT
*/

class Event {
    
    public static final int DAYS_IN_WEEK = 7;
       
    public static int convertDayStringToInt(String dayName) {
        switch (dayName) {
            case "monday": return 0;
            case "tuesday": return 1;
            case "wednesday": return 2;
            case "thursday": return 3;
            case "friday": return 4;
            case "saturday": return 5;
            case "sunday": return 6;
            default: throw new IllegalArgumentException("Unacceptable day name:" + dayName);
        }
    }

    public static int numberOfDays(String firstDay, String lastDay) {
        int first = convertDayStringToInt(firstDay);
        int last = convertDayStringToInt(lastDay);
        int days = last - first + 1;
        if (days <= 0) days = DAYS_IN_WEEK + days;
        
        return days;
    }
    
    public static String evaluate(String firstDay, String lastDay, int minDays, int maxDays) {
        int first = convertDayStringToInt(firstDay);
        int last = convertDayStringToInt(lastDay);
        int days = numberOfDays(firstDay, lastDay);
        
        int daysCount = 0;
        int daysMatch = 0;
        for(int i = days; i <= maxDays; i+=DAYS_IN_WEEK) {
            if (i >= minDays && i <= maxDays) {
                daysCount++;
                daysMatch = i;
            }
        }
        switch (daysCount) {
            case 0: return "impossible";
            case 1: return "" + daysMatch;
            default: return "many";            
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCases; ++tc) {
            String [] line = br.readLine().split("\\s+");
            System.out.println(evaluate(line[0], line[1], java.lang.Integer.parseInt(line[2]), java.lang.Integer.parseInt(line[3])));
        }
    }    
}
