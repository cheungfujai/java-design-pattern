package com.learningjava.flyweight;

public class StupidSentence {
    private String plainText;
    public boolean[] capitalizeArray;

    public StupidSentence(String plainText) {
        this.plainText = plainText;
        this.capitalizeArray = new boolean[plainText.length()];
    }

    public void capitalize(int start, int end){
        for(int i = start; i <= end; i++){
            capitalizeArray[i] = true;
        }
    }

    public WordToken getWord(int index) {
        capitalize(6, 9);
        return new WordToken();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < plainText.length(); i++){
            char c = plainText.charAt(i);
            sb.append(capitalizeArray[i] ? Character.toUpperCase(c) : c);
        }
        return sb.toString();
    }

    class WordToken {
        public boolean capitalize;
    }
}
