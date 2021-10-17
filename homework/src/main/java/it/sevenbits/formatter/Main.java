package it.sevenbits.formatter;

import it.sevenbits.formatter.Formatter.Formatter;
import it.sevenbits.formatter.Formatter.exceptions.ReadException;
import it.sevenbits.formatter.Formatter.implementations.StringReader;
import it.sevenbits.formatter.Formatter.implementations.StringWriter;

/**
 * Main application entry point
 */
final class Main {
    /**
     * Main function for app
     * @param args - console arguments
     * @throws ReadException - warning
     */
    public static void main(final String[] args) throws ReadException {
        Formatter formatter = new Formatter();

        // 1 print
        StringBuilder newFormatString1 = new StringBuilder();
        StringReader stringReader1 = new StringReader("{{{{}}}}");
        StringWriter stringWriter1 = new StringWriter(newFormatString1);

        formatter.format(stringReader1, stringWriter1);

        System.out.println(newFormatString1);


        // 2 print
        StringBuilder newFormatString2 = new StringBuilder();
        StringReader stringReader2 = new StringReader("aaa { bbbb; ccc;}");
        StringWriter stringWriter2 = new StringWriter(newFormatString2);

        formatter.format(stringReader2, stringWriter2);

        System.out.println(newFormatString2);


        // 3 print
        StringBuilder newFormatString3 = new StringBuilder();
        StringReader stringReader3 = new StringReader("aaa { bbbb; fff { trtryy; hhhh; } else { bsufg; } ccc;}");
        StringWriter stringWriter3 = new StringWriter(newFormatString3);

        formatter.format(stringReader3, stringWriter3);

        System.out.println(newFormatString3);


        // 4 print
        StringBuilder newFormatString4 = new StringBuilder();
        StringReader stringReader4 = new StringReader("public class HelloWorld { public static void main(String[] args) " +
                "{ System.out.println(\"Hello, World\");}}");
        StringWriter stringWriter4 = new StringWriter(newFormatString4);

        formatter.format(stringReader4, stringWriter4);

        System.out.println(newFormatString4);
    }
    private Main() {}
}