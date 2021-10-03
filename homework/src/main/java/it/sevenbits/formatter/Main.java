package it.sevenbits.formatter;

import it.sevenbits.formatter.Formatter.Formatter;

public class Main {
    public static void main(String[] strings) {
        Formatter formatter = new Formatter();

        System.out.println(formatter.format("{{{{}}}}"));
        System.out.println(formatter.format("aaa { bbbb; ccc;}"));
        System.out.println(formatter.format("aaa { bbbb; fff { trtryy; hhhh; } else { bsufg; } ccc;}"));
        System.out.println(formatter.format("public class HelloWorld { public static void main(String[] args) " +
                "{ System.out.println(\"Hello, World\");}}"));
    }
}