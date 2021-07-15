package algoexpert.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Minimum Characters For Words
Write a function that takes in an array of words and returns the smallest
array of characters needed to form all of the words. The characters don't
need to be in any particular order.
For example, the characters ["y", "r", "o", "u"] are needed to
form the words ["your", "you", "or", "yo"] .
Note: the input words won't contain any spaces; however, they might
contain punctuation and/or special characters.
Sample Input
words = ["this", "that", "did", "deed", "them!", "a"]
Sample Output
["t", "t", "h", "i", "s", "a", "d", "d", "e", "e", "m", "!"]
// The characters could be ordered differently.
 */
public class minimumCharacterForWords {
    public static void main(String[] args) {
        String[] words = { "this", "that", "did", "deed", "them!", "a" };
        char[] result = minimumCharactersForWords(words);
        for(int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }
    // O(n * l) time | O(c) space - where n is the number of words,
    // l is the length of the longest word, and c is the number of
    // unique characters across all words
    // See notes under video explanation for details about the space comple
    static public char[] minimumCharactersForWords(String[] words) {
        HashMap<Character, Integer> maximumCharacterFrequencies = new HashMap<Character, Integer>();
        for (String word : words) {
            HashMap<Character, Integer> characterFrequencies = countCharacterFrequencies(word);
            updateMaximumFrequencies(characterFrequencies, maximumCharacterFrequencies);
        }
        return makeArrayFromCharacterFrequencies(maximumCharacterFrequencies);
    }

    static public HashMap<Character, Integer> countCharacterFrequencies(String string) {
        HashMap<Character, Integer> characterFrequencies = new HashMap<Character, Integer>();
        for (char character : string.toCharArray()) {
            characterFrequencies.put(character, characterFrequencies.getOrDefault(character, 0) + 1);
        }
        return characterFrequencies;
    }

    static public void updateMaximumFrequencies(
            HashMap<Character, Integer> frequencies, HashMap<Character, Integer> maximumFrequencies) {
        for (Map.Entry<Character, Integer> frequency : frequencies.entrySet()) {
            char character = frequency.getKey();
            int characterFrequency = frequency.getValue();
            if (maximumFrequencies.containsKey(character)) {
                maximumFrequencies.put(
                        character, Math.max(characterFrequency, maximumFrequencies.get(character)));
            } else {
                maximumFrequencies.put(character, characterFrequency);
            }
        }
    }

    static public char[] makeArrayFromCharacterFrequencies(
            HashMap<Character, Integer> characterFrequencies) {
        ArrayList<Character> characters = new ArrayList<Character>();
        for (Map.Entry<Character, Integer> frequency : characterFrequencies.entrySet()) {
            char character = frequency.getKey();
            int characterFrequency = frequency.getValue();
            for (int idx = 0; idx < characterFrequency; idx++) {
                characters.add(character);
            }
        }
        char[] charactersArray = new char[characters.size()];
        for (int idx = 0; idx < characters.size(); idx++) {
            charactersArray[idx] = characters.get(idx);
        }
        return charactersArray;
    }
}

