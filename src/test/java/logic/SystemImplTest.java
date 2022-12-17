package logic;

import logic.iface.I_System;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemImplTest {
    private static final String testText = "Those who know despair, once knew hope.   " +
            "Those who know loss, once knew love.  " +
            "If there is such a thing like happiness in this world, it should resemble the endless  nothingness.  " +
            "Nihility is having nothing and having nothing to lose. " +
            "If that isn't happiness... then what is?  " +
            "We are nothingness. " +
            "Our head is a void.   " +
            "And without anything around us, we are nothing. We become what we perceive.";

    private static final String[] testRightStringArray = new String[]{
            "Those",
            "who",
            "know",
            "despair",
            "once",
            "knew",
            "hope",
            "Those",
            "who",
            "know",
            "loss",
            "once",
            "knew",
            "love",
            "If",
            "there",
            "is",
            "such",
            "a",
            "thing",
            "like",
            "happiness",
            "in",
            "this",
            "world",
            "it",
            "should",
            "resemble",
            "the",
            "endless",
            "nothingness",
            "Nihility",
            "is",
            "having",
            "nothing",
            "and",
            "having",
            "nothing",
            "to",
            "lose",
            "If",
            "that",
            "isn't",
            "happiness",
            "then",
            "what",
            "is",
            "We",
            "are",
            "nothingness",
            "Our",
            "head",
            "is",
            "a",
            "void",
            "And",
            "without",
            "anything",
            "around",
            "us",
            "we",
            "are",
            "nothing",
            "We",
            "become",
            "what",
            "we",
            "perceive",
    };
    private static final int COUNT_WORDS_IN_THE_TEXT = 68;

    private final I_System i_system = new SystemImpl();

    @Test
    void convertTextIntoArrayString() {
        assertArrayEquals(testRightStringArray, i_system.convertTextIntoArrayString(testText));
    }

    @Test
    void countWordsIntoText() {
        assertEquals(COUNT_WORDS_IN_THE_TEXT, i_system.countWordsIntoText(i_system.convertTextIntoArrayString(testText)));
    }
}