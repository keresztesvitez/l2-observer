package com.epam;

public class WordCounterObserver implements Observer {

    private int wordCounter;
    private Subject wordScanner;

    public WordCounterObserver(Subject wordScanner) {
        wordCounter = 0;
        this.wordScanner = wordScanner;
        wordScanner.registerObserver(this);
    }

    @Override
    public void notify(String word) {
        wordCounter++;
    }

    public int getWordCount() {
        return wordCounter;
    }
}
