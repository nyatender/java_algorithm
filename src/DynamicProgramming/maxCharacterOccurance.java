package DynamicProgramming;

import java.util.*;

public class maxCharacterOccurance {
    static class CharFreq {
        public int index;
        public int freq;
        public char ch;
        CharFreq(int index, int freq, char ch) {
            this.ch = ch;
            this.freq = freq;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        String str = "baaccb";
        int i = str.charAt(0);
        //System.out.println(i);
        System.out.println(CountFre(str));
    }
    static char  CountFre(String input) {
        HashMap<Character, CharFreq> sequnce = new LinkedHashMap<>();
        PriorityQueue<CharFreq> charFreqsQueue = new PriorityQueue<CharFreq>((i, j) -> (j.freq - i.freq));
        for(char i = 0; i<input.length();i++) {
            char key = input.charAt(i);
            if(sequnce.containsKey(key)) {
                sequnce.get(key).freq++;
                sequnce.put(key, sequnce.get(key));
            }
            else {
                sequnce.put(key, new CharFreq(i, 1, key));
            }
        }
        charFreqsQueue.addAll(sequnce.values());
        CharFreq ans = charFreqsQueue.poll();
        while(!charFreqsQueue.isEmpty()) {
            if(ans.freq == charFreqsQueue.peek().freq) {
                if(ans.index < charFreqsQueue.peek().index) {
                    return ans.ch;
                }
                else {
                   ans = charFreqsQueue.poll();
                   continue;
                }
            }
            break;
        }

        return ans != null ? ans.ch : '0';
    }
}
