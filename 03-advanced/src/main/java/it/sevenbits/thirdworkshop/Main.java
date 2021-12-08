package it.sevenbits.thirdworkshop;

import it.sevenbits.thirdworkshop.FileChecker.FileChecker;

import java.io.IOException;
import java.util.Scanner;

final class Main {
    /**
     * Input point to program
     * @param args - console arguments
     * @throws IOException - if file will not be found
     */
    public static void main(final String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileChecker fileChecker = new FileChecker("info.txt");
        fileChecker.write(scanner.nextLine());
    }
    private Main() {};
}