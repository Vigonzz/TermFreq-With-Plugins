// Violet Gonzalez
// November 8, 2026
// Professor Cristina Videria Lopes SWE 262P

package main;

import java.util.Properties;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) throws Exception{
        // Create a property object
        Properties config = new Properties();

        // Read the config file
        try (FileInputStream input = new FileInputStream("config.properties")) {
            // Load the file
            config.load(input);
        }

        // Loads specific plugin jars and classes from config.properties
        String wordsClass = config.getProperty("words.class");
        String freqClass = config.getProperty("frequencies.class");

        String wordJar = config.getProperty("words.jar");
        String freqJar = config.getProperty("frequencies.jar");

        System.out.println(wordsClass);
        System.out.println(wordJar);
        System.out.println(freqClass);
        System.out.println(freqJar);

    }
}
