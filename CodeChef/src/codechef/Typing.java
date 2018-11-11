package codechef;

import java.util.*;
import java.io.*;

/*
    https://www.codechef.com/problems/TYPING
 */
public class Typing {

    private static enum Hand {
        LEFT_HAND, RIGHT_HAND
    };

    private static final int SAME_HAND_TIME = 4;
    private static final int OTHER_HAND_TIME = 2;

    private static java.util.Map<String, Integer> wordsList;

    private static Hand getHand(char c) {
        return (c == 'd' || c == 'f') ? Hand.LEFT_HAND : Hand.RIGHT_HAND;
    }

    private static int processWord(String word) {
        
        if (wordsList.containsKey(word)) {
            return wordsList.get(word);
        }
        
        int count = OTHER_HAND_TIME;
        Hand actualHand = getHand(word.charAt(0));

        for (int i = 1; i < word.length(); ++i) {
            Hand newHand = getHand(word.charAt(i));
            count += (newHand == actualHand ? SAME_HAND_TIME : OTHER_HAND_TIME);
            actualHand = newHand;
        }
        
        wordsList.put(word, count / 2);
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; ++tc) {
            int wordsToTest = Integer.parseInt(br.readLine());
            wordsList = new HashMap<>();
            int time = 0;
            for (int i = 0; i < wordsToTest; ++i) {
                String word = br.readLine();
                time += processWord(word);
            }
            System.out.println(time);
        }
    }
}

/*
Input:
1
5
fdjkd
dfjdk
dfd
fdjkd
kkjjk

Output:
61

*/
