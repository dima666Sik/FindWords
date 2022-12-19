package logic;

import logic.enums.ConverctIndexEnum;
import logic.exceptions.EmptyValuesExceptions;
import logic.iface.I_System;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class SystemImpl implements I_System {
    @Override
    public String[] convertTextIntoArrayString(String text) {
        return Arrays.stream(text.split(" "))
                .map((word) -> word.replaceAll("[/.,!?;:+0-9-]", ""))
                .filter((word) -> !word.isEmpty())
                .toArray(String[]::new);
    }

    @Override
    public long countWordsIntoText(String[] words) {
        return Arrays.stream(words).count();
    }

    @Override
    public int countSymbolsIntoText(String text, Character... symbols) { // find general count specified characters
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            for (Character symbol : symbols) {
                if (text.charAt(i) == symbol) ++counter;
            }
        }
        return counter;
    }

    @Override
    public TreeMap<BigDecimal, BigDecimal> getIndexStartEndWordsIntoText(String text, String searchWord) {
        TreeMap<Integer, String> mapStartEndIndexSearchWords = new TreeMap<>();
        TreeMap<Integer, BigDecimal> mapAllStringsSize = new TreeMap<>();
        try {
            String[] arrayStrings = split(text, '.', '!', '?');
            int counter = 0;
            for (int i = 0; i < arrayStrings.length; i++) {
                while (arrayStrings[i].toLowerCase(Locale.ROOT).contains(searchWord.toLowerCase(Locale.ROOT))) {
                    int indexStartWord = arrayStrings[i].toLowerCase(Locale.ROOT).indexOf(searchWord.toLowerCase(Locale.ROOT));
                    int indexEndWord = indexOfEnd(arrayStrings[i].toLowerCase(Locale.ROOT), searchWord.toLowerCase(Locale.ROOT));
                    mapStartEndIndexSearchWords.put(counter++, String.valueOf(i).concat("-").concat(String.valueOf(indexStartWord)).concat("-").concat(String.valueOf(indexEndWord)));
                    arrayStrings[i] = arrayStrings[i].substring(indexEndWord + 1);
                }
                mapAllStringsSize.put(i, BigDecimal.valueOf(arrayStrings[i].length()));
            }
        } catch (EmptyValuesExceptions e) {
            e.printStackTrace();
        }
        return convertFindIndexIntoNormalState(mapStartEndIndexSearchWords, mapAllStringsSize);
    }

    private int indexOfEnd(String text, String searchWord) {
        return text.indexOf(searchWord) + searchWord.length() - 1;
    }

    private String[] split(String text, Character... symbols) throws EmptyValuesExceptions { // for example -> '.', '!', '?'
        if (!text.isEmpty()) {
            String[] arrayStrings = new String[countSymbolsIntoText(text, symbols)];
            int counterIndexArray = 0;
            int start = 0;
            for (int i = 0; i < text.length(); i++) {
                for (Character symbol : symbols) {
                    if (text.charAt(i) == symbol) {
                        arrayStrings[counterIndexArray++] = text.substring(start, i + 1);
                        start = i + 1;
                    }
                }
            }
            return arrayStrings;
        } else
            throw new EmptyValuesExceptions("Text is empty!!! Add text...");
    }

    private TreeMap<BigDecimal, BigDecimal> convertFindIndexIntoNormalState(TreeMap<Integer, String> mapStartEndIndexSearchWords,
                                                                            TreeMap<Integer, BigDecimal> mapAllStringsSize) {
        mapStartEndIndexSearchWords.forEach((k, v) -> System.out.println(k + " " + v));
        mapAllStringsSize.forEach((k, v) -> System.out.println(k + " " + v));
        TreeMap<BigDecimal, BigDecimal> convertIndexingIntoTextLand = new TreeMap<>();
        try {
            BigDecimal counterAllString = new BigDecimal(0);
            int counterWithFoundWords = 0, m = 0;
            for (int i = 0; i < mapAllStringsSize.size(); i++) {
                System.out.println(counterWithFoundWords);
                while (i == returnIndexEnum(mapStartEndIndexSearchWords.get(counterWithFoundWords), ConverctIndexEnum.INDEX_FIRST_STATE)) {
                    if (m == mapStartEndIndexSearchWords.size()) break;
                    convertIndexingIntoTextLand.put(counterAllString
                                    .add(BigDecimal.valueOf(returnIndexEnum(mapStartEndIndexSearchWords.get(m), ConverctIndexEnum.START_INDEX_WORD))),
                            counterAllString
                                    .add(BigDecimal.valueOf(returnIndexEnum(mapStartEndIndexSearchWords.get(m), ConverctIndexEnum.END_INDEX_WORD)))
                    );
                    counterAllString = counterAllString
                            .add(BigDecimal.valueOf(returnIndexEnum(mapStartEndIndexSearchWords.get(m), ConverctIndexEnum.START_INDEX_WORD)).add(new BigDecimal(2)));

                    if (returnIndexEnum(mapStartEndIndexSearchWords.get(counterWithFoundWords), ConverctIndexEnum.INDEX_FIRST_STATE) !=
                            returnIndexEnum(mapStartEndIndexSearchWords.get(counterWithFoundWords + 1), ConverctIndexEnum.INDEX_FIRST_STATE) &&
                            counterWithFoundWords < mapStartEndIndexSearchWords.size())
                        counterWithFoundWords++;
                    m++;
                }
                counterAllString = counterAllString.add(mapAllStringsSize.get(i));
            }
        } catch (EmptyValuesExceptions e) {
            e.printStackTrace();
        }
        return convertIndexingIntoTextLand;
    }

    private int returnIndexEnum(String value, ConverctIndexEnum indexEnum) throws EmptyValuesExceptions {
        String[] arrayIndex = value.split("-");
        switch (indexEnum) {
            case INDEX_FIRST_STATE: {
                return Integer.parseInt(arrayIndex[0]);
            }
            case START_INDEX_WORD: {
                return Integer.parseInt(arrayIndex[1]);
            }
            case END_INDEX_WORD: {
                return Integer.parseInt(arrayIndex[2]);
            }
            default: {
                throw new EmptyValuesExceptions("You write not found index.");
            }
        }
    }

    @Override
    public String getTextWithFoundWords(String text, TreeMap<BigDecimal, BigDecimal> convertIndexingIntoTextLand) {
        for (Map.Entry<BigDecimal, BigDecimal> item : convertIndexingIntoTextLand.entrySet()) {
            //plug
            text = replaceSubstring(text, item.getKey(), item.getValue());
        }
        return text;
    }

    private String replaceSubstring(String text, BigDecimal firstIndex, BigDecimal secondIndex) {
        String tempTextFirst = text.substring(0, firstIndex.intValue());
        String tempTextSecond = text.substring(firstIndex.intValue()
                + (secondIndex.intValue() - firstIndex.intValue() + 1));
        return tempTextFirst + getWord(text, firstIndex, secondIndex) + tempTextSecond;
    }

    private String getWord(String text, BigDecimal firstIndex, BigDecimal secondIndex) {
        String word = "";
        for (int i = 0; i < text.length(); i++) {
            if (i >= firstIndex.intValue() & i <= secondIndex.intValue()) {
//                word += text.charAt(i);
                word += "|";
            }
        }
        return word;
    }
}
