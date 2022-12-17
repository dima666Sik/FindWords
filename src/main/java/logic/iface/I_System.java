package logic.iface;

import java.math.BigDecimal;
import java.util.HashMap;

public interface I_System {
    String[] convertTextIntoArrayString(String text);
    BigDecimal countWordsIntoText(String[] words);
    HashMap<BigDecimal,BigDecimal> getIndexStartEndWordsIntoText();
}
