package com.epam;

public class LongestWordObserver implements Observer {

    private String longestWord;
    private Subject wordScanner;

    public LongestWordObserver(Subject wordScanner) {
        this.wordScanner = wordScanner;
        wordScanner.registerObserver(this);
        longestWord = "";
    }

    @Override
    public void notify(String word) {
        if (word.length() > longestWord.length()) {
            longestWord = word;
        }
    }

    public String getLongestWord() {
        return  longestWord;
    }
}
