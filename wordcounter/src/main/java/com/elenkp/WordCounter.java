package com.elenkp;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Counts how many times a word occurs in the text from
 * https://www.gutenberg.org/cache/epub/1184/pg1184.txt.
 * Prints the 5 most and 5 least used words.
 */
public class WordCounter {

    /**
     * Reads text from URL and converts into a String
     * 
     * @param URL The URL to read the text from
     * @return A String representation of the text from the URL
     * @throws IOException If an error occurred while trying to read from the URL
     */
    private static String readStringFromURL(String URL) throws IOException {
        try (Scanner scanner = new Scanner(new URL(URL).openStream(), StandardCharsets.UTF_8.toString())) {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }

    /**
     * Counts the occurrences of all words in the input text
     * 
     * @param text The text to count the word occurrences for
     * @return A Map with each word in the text and its number of occurrences
     */
    private static Map<String, Long> countOccurrences(String text) {
        return Arrays.stream(text.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(final String[] args) {
        try {
            // Read text from URL, remove all non-words, and convert to lower case
            String text = readStringFromURL("https://www.gutenberg.org/cache/epub/1184/pg1184.txt")
                    .replaceAll("[^A-Za-z\\s]", "").toLowerCase();

            // Get occurrences for all words
            Map<String, Long> occurrences = countOccurrences(text);

            // Get the 5 most used words
            Map<String, Long> topFive = occurrences.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(5)
                    .collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            // Get the 5 least used words
            Map<String, Long> bottomFive = occurrences.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .limit(5)
                    .collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            // Print the most and least used words
            System.out.println("Top five most used words: " + topFive);
            System.out.println("Five least used words: " + bottomFive);
        } catch (IOException e) {
            System.err.println("Could not read string from URL");
            e.printStackTrace();
        }
    }
}
