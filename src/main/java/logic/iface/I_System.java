package logic.iface;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.TreeMap;

public interface I_System {
    String[] convertTextIntoArrayString(String text);
    long countWordsIntoText(String[] words);
    int countSymbolsIntoText(String text, Character... symbol);
    TreeMap<BigDecimal, BigDecimal> getIndexStartEndWordsIntoText(String text, String searchWord);
}
