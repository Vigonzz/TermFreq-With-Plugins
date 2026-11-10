// Violet Gonzalez
// November 8, 2026
// Professor Cristina Videria Lopes SWE 262P

package main;

import java.net.URI;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.File;
import java.net.URLClassLoader;
import java.net.URL;
import interfaces.TFWords;
import interfaces.TFFreqs;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        // Create a property object
        Properties config = new Properties();

        // Read the config file
        try (FileInputStream input = new FileInputStream("config.properties")) {
            // Load the file
            config.load(input);
        }

        // Get plugin jars and classes names from config.properties
        String wordsClass = config.getProperty("words.class");
        String freqClass = config.getProperty("frequencies.class");

        String wordJar = config.getProperty("words.jar");
        String freqJar = config.getProperty("frequencies.jar");

        // For words:
        // Creates a file object for the jar path
        File wordFile = new File(wordJar);

        // Convert the URI to a URL for the class loader
        URL urlWordFile = wordFile.toURI().toURL();

        // Create a loader object per plugin
        URLClassLoader urlWordLoader = new URLClassLoader(new URL[] {urlWordFile});

        // load the class
        Class<?> wordsPluginClass = urlWordLoader.loadClass(wordsClass);

        // For Freqs:
        File freqFile = new File(freqJar);
        URL urlFreqFile = freqFile.toURI().toURL();
        URLClassLoader urlFreqLoader = new URLClassLoader(new URL[] {urlFreqFile});
        Class<?> freqsPluginClass = urlFreqLoader.loadClass(freqClass);

        // Instantiate each plugin and cast it to its interface
        TFWords tfwords = (TFWords) wordsPluginClass.getDeclaredConstructor().newInstance();
        TFFreqs tffreqs = (TFFreqs) freqsPluginClass.getDeclaredConstructor().newInstance();
    }
}
