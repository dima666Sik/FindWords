package logic;

import logic.iface.I_System;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;

public class SystemImpl implements I_System {
    @Override
    public String[] convertTextIntoArrayString(String text) {
        return Arrays.stream(text.split(" "))
                .map((word)->word.replaceAll("[/.,!?-]",""))
                .filter((word)->!word.isEmpty())
                .toArray(String[]::new);
    }

    @Override
    public BigDecimal countWordsIntoText(String[] words) {
        return BigDecimal.valueOf(Arrays.stream(words).count());
    }

    @Override
    public HashMap<BigDecimal, BigDecimal> getIndexStartEndWordsIntoText() {
        return null;
    }


}
