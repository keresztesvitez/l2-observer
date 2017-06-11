package com.epam;

public class Application {

    private static final String FILENAME = "/text.txt";
    public static void main(String[] args) {

        WordScanner wordScanner = new WordScanner(FILENAME);

        WordCounterObserver wordCounterObserver = new WordCounterObserver(wordScanner);
        LongestWordObserver longestWordObserver = new LongestWordObserver(wordScanner);
        NumberCounterObserver numberCounterObserver = new NumberCounterObserver(wordScanner);
        ReverseWordObserver reverseWordObserver = new ReverseWordObserver(wordScanner);

        wordScanner.scan();

        System.out.println(wordCounterObserver.getWordCount());
        System.out.println(longestWordObserver.getLongestWord());
        System.out.println(numberCounterObserver.getNumbersCount());
        System.out.println(reverseWordObserver.getReversedWordsFilePath());
    }
}
