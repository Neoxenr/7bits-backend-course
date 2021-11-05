package it.sevenbits.thirdpractice.threads.Example;

import it.sevenbits.thirdpractice.threads.FileReader.FileReader;
import java.io.IOException;

public class Example {
    private int maxCharCount = 0;

     /**
     *
     * @param fileReader - reading strings from input file
     * @return int - max string's length from input file
     * @throws IOException - if nothing read
     */
    public int getLongestLineCharsCount(final FileReader fileReader) throws IOException {
        while (fileReader.hasMoreLines()) {
            String tempString = fileReader.readLine();
            if (tempString.length() > maxCharCount) {
                maxCharCount = tempString.length();
            }
        }
        return maxCharCount;
    }
}
