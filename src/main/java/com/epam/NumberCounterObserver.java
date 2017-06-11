package com.epam;

public class NumberCounterObserver implements Observer {

    private int numberCounter;
    private Subject wordScanner;

    public NumberCounterObserver(Subject wordScanner) {
        this.wordScanner = wordScanner;
        wordScanner.registerObserver(this);
        numberCounter = 0;
    }

    @Override
    public void notify(String word) {
        countNumbers(word);
    }

    private void countNumbers(String word) {
        if (isNumber(word)) {
            numberCounter++;
        }
    }

    private boolean isNumber(String word) {
        boolean isNumber = true;
        try {
            Integer.valueOf(word);
        } catch (NumberFormatException e) {
            isNumber = false;
        }
        return isNumber;
    }

    public int getNumbersCount() {
        return numberCounter;
    }
}
