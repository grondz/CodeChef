package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/TRUEDARE
*/
public class Truedare {
    
    
    public static void readIntoSet(int numberOfValues, String [] data, java.util.Set<Integer> setToFill) {
        for(String value: data) {
            setToFill.add(java.lang.Integer.parseInt(value));
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; ++tc) {
            
            String[] data;
            
            java.util.Set<Integer> trueTasksRam = new java.util.HashSet<Integer>();
            java.util.Set<Integer> dareTasksRam = new java.util.HashSet<Integer>();
            boolean canPerformTasks = true;
            
            // true Ram
            data = br.readLine().split("\\s+");
            int truthTasksRamAmount = java.lang.Integer.parseInt(data[0]);
            data = br.readLine().split("\\s+");
            readIntoSet(truthTasksRamAmount, data, trueTasksRam);

            // dare Ram
            data = br.readLine().split("\\s+");
            int dareTasksRamAmount = java.lang.Integer.parseInt(data[0]);
            data = br.readLine().split("\\s+");
            readIntoSet(dareTasksRamAmount, data, dareTasksRam);
            
            // true Shyam
            data = br.readLine().split("\\s+");
            int truthTasksShyamAmount = java.lang.Integer.parseInt(data[0]);
            data = br.readLine().split("\\s+");
            for(String number: data) {
                if (!trueTasksRam.contains(java.lang.Integer.parseInt(number))) canPerformTasks = false;
            }
             
            // dare Shyam
            data = br.readLine().split("\\s+");
            int dareTasksShyamAmount = java.lang.Integer.parseInt(data[0]);
            data = br.readLine().split("\\s+");
            for(String number: data) {
                if (!dareTasksRam.contains(java.lang.Integer.parseInt(number))) canPerformTasks = false;
            }
                     
            System.out.println(canPerformTasks ? "yes": "no");
        }
    }
}

/*
Input:
4
2
1 2
3
1 3 2
1
2
2
3 2
2
1 2
3
1 3 2
1
2
3
3 2 4
3
3 2 5
2
2 100
1
2
1
100
2
1 2
3
1 3 2
1
2
3
3 2 2

Output:
yes
no
yes
yes

*/