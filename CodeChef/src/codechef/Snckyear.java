package codechefprojects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/SNCKYEAR
*/
public class Snckyear {
    
    public static java.util.Set<Integer> snackDownHostedYears = new java.util.HashSet<>(java.util.Arrays.asList(2010, 2015, 2016, 2017, 2019));
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; ++tc) {
            int testedYear = java.lang.Integer.parseInt(br.readLine());
            System.out.println(snackDownHostedYears.contains(testedYear)? "HOSTED" : "NOT HOSTED");
        }
    }
}    
