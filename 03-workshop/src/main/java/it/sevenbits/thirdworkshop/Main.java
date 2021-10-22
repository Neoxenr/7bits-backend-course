package it.sevenbits.thirdworkshop;

import it.sevenbits.thirdworkshop.FileCreator.FileCreator;

import java.io.IOException;
import java.util.Scanner;

final class Main {
    /**
     *
     * @param args - console arguments
     * @throws IOException - if file will be not found
     */
    public static void main(final String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileCreator fileCreator = new FileCreator("newFile.txt");
        fileCreator.write(scanner.nextLine());
    }
    private Main() {};
}
