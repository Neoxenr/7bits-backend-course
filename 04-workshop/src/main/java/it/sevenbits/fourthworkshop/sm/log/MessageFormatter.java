package it.sevenbits.fourthworkshop.sm.log;

import java.util.HashMap;
import java.util.Map;

public class MessageFormatter {
    private final Map<String, String> stringFormats;

    /**
     * Initialization stringFormats and putting elements to map
     */
    public MessageFormatter() {
        stringFormats = new HashMap<>();

        stringFormats.put("MESSAGE", "Part of message: %1$s");
        stringFormats.put("TRASH", "Trash received");
        stringFormats.put("MESSAGE_START", "Message creating started");
        stringFormats.put("MESSAGE_FINISH", "Message creating finished");
    }

    /**
     *
     * @param type - package type
     * @return String - information about package
     */
    public String getStringFormatByType(final String type) {
        return stringFormats.getOrDefault(type, "Unknown package type");
    }
}
