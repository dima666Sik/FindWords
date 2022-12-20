package ui;

import logic.SystemImpl;
import logic.iface.I_System;
import ui.swing.Menu;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        // this is plug, I mush to replace this.
//        String testText = "Those who know despair, once knew hope.   " + //39
//                "Those who know loss, once knew love.  " + //39
//                "If there is such a thing like happiness in this world, it should resemble the endless  nothingness.  " + //101
//                "Nihility is having nothing and having nothing to lose. " + //56
//                "If that isn't happiness." + //25
//                "." + //1
//                ". " + //1
//                "then what is?  " + //14
//                "We are nothingness. " + //17
//                "Our head is a void.   " + //20
//                "And without anything around us, we are nothing. " + //13
//                "We become what we perceive."; //10
//
//        I_System i_system = new SystemImpl();
//        String[] u = i_system.convertTextIntoArrayString(testText);
//        System.out.println("Count: " + i_system.countWordsIntoText(u));
//        TreeMap<BigDecimal, BigDecimal> hashMap = i_system.getIndexStartEndWordsIntoText(testText, "is");
//        hashMap.forEach((k, v) -> System.out.println("indexArray: " + k + " value: " + v));
//        System.out.println(i_system.getTextWithFoundWords(testText,hashMap));
        new Menu();
    }
}
