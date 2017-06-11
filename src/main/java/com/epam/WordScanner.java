package com.epam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordScanner implements Subject {

    private List<Observer> observers;
    private String fileName;
    private String currentWord;

    private static final Logger LOGGER = LoggerFactory.getLogger(WordScanner.class);

    public WordScanner(String fileName) {
        this.fileName = fileName;
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            observers.remove(index);
        }
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.notify(currentWord);
        }
    }

    private Scanner getScanner() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(this.getClass().getResource( fileName ).toURI()));
        } catch (FileNotFoundException | URISyntaxException e) {
            LOGGER.error("Scanner initialization failed", e);
        }
        return scanner;
    }

    public void scan() {
        Scanner scanner = getScanner();
        while(scanner != null && scanner.hasNext()) {
            String word = scanner.next();
            currentWord = word;
            notifyObservers();
        }
    }
}
