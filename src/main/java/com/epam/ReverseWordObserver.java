package com.epam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class ReverseWordObserver implements Observer {

    public static final String FILE_NAME = "reversed.txt";
    private static final Logger LOGGER = LoggerFactory.getLogger(ReverseWordObserver.class);
    private Subject wordScanner;

    public ReverseWordObserver(Subject wordScanner) {
        this.wordScanner = wordScanner;
        wordScanner.registerObserver(this);
    }

    @Override
    public void notify(String word) {
        String reversed = reverse(word);
        writeToFile(reversed);
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    private void writeToFile(String word) {
        try(FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(word);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public String getReversedWordsFilePath() {
        File file = new File(FILE_NAME);
        String path = file.getAbsolutePath();
        return path;
    }
}
