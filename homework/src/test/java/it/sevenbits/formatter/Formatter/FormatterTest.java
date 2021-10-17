package it.sevenbits.formatter.Formatter;
import it.sevenbits.formatter.Formatter.exceptions.ReadException;
import it.sevenbits.formatter.Formatter.implementations.StringReader;
import it.sevenbits.formatter.Formatter.implementations.StringWriter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class FormatterTest {
    private Formatter formatter;

    @Before
    public void setUp() {
        this.formatter = new Formatter();
    }

    @Test
    public void testFormatFirst() throws ReadException {
        StringBuilder newFormatString = new StringBuilder();

        StringReader stringReader = new StringReader("{{{{ } } } }");
        StringWriter stringWriter = new StringWriter(newFormatString);

        formatter.format(stringReader, stringWriter);

        assertEquals("Wrong formatting", "{\n    {\n        {\n            " +
                "{\n            }\n        }\n    }\n}\n", newFormatString.toString());
    }

    @Test
    public void testFormatSecond() throws ReadException {
        StringBuilder newFormatString = new StringBuilder();

        StringReader stringReader = new StringReader("         public    class   HelloWorld     \n\n  \n     " +
                "{public static void main(String[] args){ System.out.println(\"Hello, World\");         } }");
        StringWriter stringWriter = new StringWriter(newFormatString);

        formatter.format(stringReader, stringWriter);

        assertEquals("Wrong formatting", "public class HelloWorld {\n    public static void main(String[] args) " +
                "{\n        System.out.println(\"Hello, World\");\n    }\n}\n", newFormatString.toString());
    }

    @Test
    public void testFormatThird() throws ReadException {
        StringBuilder newFormatString = new StringBuilder();

        StringReader stringReader = new StringReader("aaa{bbbb;fff { trtryy; hhhh;}else{ bsufg; }ccc;}");
        StringWriter stringWriter = new StringWriter(newFormatString);

        formatter.format(stringReader, stringWriter);

        assertEquals("Wrong formatting", "aaa {\n    bbbb;\n    fff {\n        " +
                "trtryy;\n        hhhh;\n    }\n    else {\n        bsufg;\n    }\n    ccc;\n}\n", newFormatString.toString());
    }

    @Test(expected = ReadException.class)
    public void testThrowingReadException() throws ReadException {
        StringReader stringReader = new StringReader("Hello, World!");
        while (stringReader.hasNext()) {
            char symbol = stringReader.read();
        }
        stringReader.read();
    }
}
