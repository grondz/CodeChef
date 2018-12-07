package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/PCJ18A
 */
class Pcj18a {
  
    private static final String POSITIVE_ANSWER = "YES";
    private static final String NEGATIVE_ANSWER = "NO";
    
    public static String evaluate(int [] ingredienceVolumes, int minVolume) {
        for(int i = 0; i < ingredienceVolumes.length; ++i)
            if (ingredienceVolumes[i] >= minVolume) return POSITIVE_ANSWER;
        return NEGATIVE_ANSWER;
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCases; ++tc) {
            String[] line = br.readLine().split("\\s+");
            int n = java.lang.Integer.parseInt(line[0]);
            int ingredienceLimit = java.lang.Integer.parseInt(line[1]);
            String [] ingrediencesInput = br.readLine().split("\\s+");
            int [] ingredienceVolumes = new int[n];
            for(int i = 0; i < n; ++i)
                ingredienceVolumes[i] = java.lang.Integer.parseInt(ingrediencesInput[i]);
            System.out.println(evaluate(ingredienceVolumes, ingredienceLimit));
        }
    }    
}
