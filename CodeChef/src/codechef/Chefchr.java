package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/CHEFCHR
 */

class Chefchr {
    
    public static final String NORMAL_SENTENCE = "normal";
    public static final String LOVELYSENTENCE = "lovely ";
    
    public static final int SEARCHED_STRING = 4;
    
    public static boolean checkForSentence(int [] counters) {
        return (counters['c' - 'a'] == 1 && counters['h' - 'a'] == 1 && 
                counters['e' - 'a'] == 1 && counters['f' - 'a'] == 1);
    }
    
    public static String evaluateSentence(String sentence) {
        
        int [] counter = new int['z' - 'a' + 1] ;
        for(int i = 0; i < counter.length; ++i) {
            counter[i] = 0;
        }
        
        int chefCount = 0;
        if (sentence.length() < SEARCHED_STRING) return NORMAL_SENTENCE;
        
        for(int i = 0; i < SEARCHED_STRING; ++i)
            counter[sentence.charAt(i) - 'a']++;
        if (checkForSentence(counter)) chefCount++;
        
        for(int i = SEARCHED_STRING; i < sentence.length(); ++i) {
            counter[sentence.charAt(i) - 'a']++;
            counter[sentence.charAt(i - SEARCHED_STRING) - 'a']--;
            if (checkForSentence(counter)) {
                chefCount++;               
            }            
        }
        
        return chefCount <= 0 ? NORMAL_SENTENCE : LOVELYSENTENCE + chefCount;
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCases; ++tc) {
            String line = br.readLine();
            System.out.println(evaluateSentence(line));
        }
    }     
    
}
