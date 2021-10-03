package it.sevenbits.formatter.Formatter;

public class Formatter {
    public String format(String string) {
        StringBuilder newFormatString = new StringBuilder();

        StringBuilder indent = new StringBuilder();

        for (String word : string.split(" ")) {
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == '{') {
                    indent.append("    ");
                    newFormatString.append("{\n").append(indent);
                } else if (word.charAt(j) == '}') {
                    indent.replace(indent.length() - 4, indent.length(), "");
                    newFormatString.replace(newFormatString.length() - 4, newFormatString.length(), "");
                    newFormatString.append("}\n").append(indent);
                } else if (word.charAt(j) == ';') {
                    newFormatString.append(word.charAt(j)).append('\n').append(indent);
                } else {
                    newFormatString.append(word.charAt(j));
                    if (j == word.length() - 1) {
                        newFormatString.append(" ");
                    }
                }
            }
        }

        return newFormatString.toString();
    }
}
