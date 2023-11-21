package com.elenkp;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Parses the sample JSON document stored in squad.json.
 * Prints an array of JSON objects containing the name and age of squad members
 * ordered by descending number of powers.
 */
public class JsonProcessor {

    /**
     * Reads a file and returns a String of all the content in the file, using the
     * specified encoding
     * 
     * @param path     The path to the file
     * @param encoding Which encoding to use
     * @return String of the file content
     * @throws IOException If an error occured while trying to read the file
     */
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read JSON from file
            String jsonString = readFile("jsonprocessor\\src\\main\\resources\\squad.json", Charset.defaultCharset());

            // Map to list of squad members
            List<SquadMember> squadMembers = mapper.readValue(jsonString, Squad.class).getMembers();

            // Sort by decending number of powers
            Collections.sort(squadMembers, new Comparator<SquadMember>() {
                @Override
                public int compare(SquadMember o1, SquadMember o2) {
                    return o2.getNumOfPowers() - o1.getNumOfPowers();
                }
            });

            // Convert to JSON and print results
            mapper.writeValue(System.out, squadMembers);
        } catch (IOException e) {
            System.err.println("There was an exception when trying to read from the file");
            e.printStackTrace();
        }

    }
}