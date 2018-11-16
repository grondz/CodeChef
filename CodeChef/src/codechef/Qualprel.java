package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/QUALPREL
*/

class Qualprel {

    public static int evaluateQualification(java.util.List<Integer> scores, int K) {
        int counter = K;
        int goalScore = scores.get(K - 1);
        int i = K;
        while (i < scores.size() && scores.get(i++) >= goalScore) {
            counter++;            
        }
        return counter;
    }
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; ++tc) {
            String[] data = br.readLine().split("\\s+");
            int N = java.lang.Integer.parseInt(data[0]);
            int K = java.lang.Integer.parseInt(data[1]);

            String [] scoresLine = br.readLine().split("\\s+");
            java.util.List<Integer> scores = new java.util.ArrayList<>();
            
            for(int i = 0; i < N; ++i) {
                scores.add(java.lang.Integer.parseInt(scoresLine[i]));
            }
            
            java.util.Collections.sort(scores, (o1, o2) -> o2.compareTo(o1));            
            System.out.println(evaluateQualification(scores, K));
            
        }
    }
}

/*
INput:
2
5 1
3 5 2 4 5
6 4
6 5 4 3 2 1

Output:
2
4
*/