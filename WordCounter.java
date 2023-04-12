import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        
        Map<String, Integer> wordCounts = new HashMap<>();

        try {
            
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while (line != null) {
                String word = line.toLowerCase(); 
                if (wordCounts.containsKey(word)) {
                    
                    wordCounts.put(word, wordCounts.get(word) + 1);
                } else {
                    
                    wordCounts.put(word, 1);
                }
                line = reader.readLine();
            }
            reader.close();

            
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            for (String word : wordCounts.keySet()) {
            writer.write(word + " " + wordCounts.get(word));
            writer.newLine();
            }
            writer.close();

            System.out.println("Counted words in input file and wrote results to output file");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}