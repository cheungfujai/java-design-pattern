package com.learningjava.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Sentence {
    private String[] wordArray;
    private Map<Integer, WordToken> tokenMap = new HashMap<>();

    public Sentence(String plainText) {
        this.wordArray = plainText.split(" ");
    }

    public WordToken getWord(int index) {
        WordToken word = new WordToken();
        tokenMap.put(index, word);
        return tokenMap.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < wordArray.length; i++){
            String word = wordArray[i];
            if(tokenMap.containsKey(i) && tokenMap.get(i).capitalize){
                word = word.toUpperCase();
            }
            sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }

    class WordToken {
        public boolean capitalize;
    }
}
