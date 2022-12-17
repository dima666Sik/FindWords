package ui;

import logic.SystemImpl;
import logic.iface.I_System;

public class Main {
    public static void main(String[] args) {
        // this is plug, I mush to replace this.
        String testText = "Those who know despair, once knew hope.   " +
                "Those who know loss, once knew love.  " +
                "If there is such a thing like happiness in this world, it should resemble the endless  nothingness.  " +
                "Nihility is having nothing and having nothing to lose. " +
                "If that isn't happiness... then what is?  " +
                "We are nothingness. " +
                "Our head is a void.   " +
                "And without anything around us, we are nothing. We become what we perceive.";

        I_System i_system = new SystemImpl();
        String[] u = i_system.convertTextIntoArrayString(testText);
        System.out.println("Count: "+i_system.countWordsIntoText(u));
    }
}
