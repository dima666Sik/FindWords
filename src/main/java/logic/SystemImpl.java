package logic;

import logic.iface.I_System;

import java.util.Arrays;

public class SystemImpl implements I_System {
    @Override
    public String[] convertTextIntoArrayString(String text) {
        return Arrays.stream(text.split(" "))
                .map((word)->word.replaceAll("[/.|,!?-]",""))
                .filter((word)->!word.isEmpty())
                .toArray(String[]::new);
    }
}
