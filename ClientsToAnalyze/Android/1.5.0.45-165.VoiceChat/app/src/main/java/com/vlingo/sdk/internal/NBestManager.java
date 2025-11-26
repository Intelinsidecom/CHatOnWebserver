package com.vlingo.sdk.internal;

import com.vlingo.sdk.internal.recognizer.results.TaggedResults;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class NBestManager {
    private static final int MAX_RESULTS = 5;
    private static final String WORD_SEPARATORS = ". ,;:!?\n()[]*&@{}/<>_+=|\"";
    private ArrayList<TaggedResults> previousResults = new ArrayList<>();

    public void registerResults(TaggedResults results) {
        this.previousResults.add(0, results);
        while (this.previousResults.size() > 5) {
            this.previousResults.remove(this.previousResults.size() - 1);
        }
    }

    public Vector<String> getNBestForWord(String word) {
        int resnum = this.previousResults.size();
        for (int i = 0; i < resnum; i++) {
            Vector<String> result = this.previousResults.get(i).getNBestForWord(word);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public List<String> getNBestForWord(String phrase, int cursorPosition) {
        String word;
        char[] charPhrase = phrase.toCharArray();
        int adjustedCursor = moveCursorIfInSpace(charPhrase, cursorPosition);
        if (adjustedCursor < 0 || (word = getCurrentWord(charPhrase, adjustedCursor)) == null) {
            return null;
        }
        String[] previousWords = new String[3];
        String[] nextWords = new String[3];
        int numPreviousWords = getWordsBefore(previousWords, charPhrase, adjustedCursor);
        int numNextWords = getWordsAfter(nextWords, charPhrase, adjustedCursor);
        int resnum = this.previousResults.size();
        int numMatchingWords = 0;
        List<String> result = new LinkedList<>();
        for (int i = 0; i < resnum; i++) {
            numMatchingWords = this.previousResults.get(i).getNBestForWordIfBetterMatch(result, word, previousWords, numPreviousWords, nextWords, numNextWords, numMatchingWords);
        }
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    private int moveCursorIfInSpace(char[] phrase, int cursorPosition) {
        if (cursorPosition < 0 || cursorPosition >= phrase.length) {
            return -1;
        }
        if (Character.isSpace(phrase[cursorPosition])) {
            if (cursorPosition > 0 && !Character.isSpace(phrase[cursorPosition - 1])) {
                return cursorPosition - 1;
            }
            cursorPosition++;
        }
        if (cursorPosition >= phrase.length || Character.isSpace(phrase[cursorPosition])) {
            return -1;
        }
        return cursorPosition;
    }

    private int getWordsBefore(String[] wordsBefore, char[] phrase, int cursorPosition) {
        int count = 0;
        int i = cursorPosition;
        while (i >= 0 && !isWordSeparator(phrase[i])) {
            i--;
        }
        while (count < wordsBefore.length) {
            while (i >= 0 && isWordSeparator(phrase[i])) {
                i--;
            }
            int endIndex = i + 1;
            if (endIndex <= 0) {
                break;
            }
            while (i >= 0 && !isWordSeparator(phrase[i])) {
                i--;
            }
            int startIndex = i + 1;
            if (startIndex < endIndex) {
                wordsBefore[count] = new String(phrase, startIndex, endIndex - startIndex);
                count++;
            }
        }
        return count;
    }

    private int getWordsAfter(String[] wordsAfter, char[] phrase, int cursorPosition) {
        int count = 0;
        int i = cursorPosition;
        int len = phrase.length;
        while (i < len && !isWordSeparator(phrase[i])) {
            i++;
        }
        while (count < wordsAfter.length) {
            while (i < len && isWordSeparator(phrase[i])) {
                i++;
            }
            int startIndex = i;
            if (startIndex >= len) {
                break;
            }
            while (i < len && !isWordSeparator(phrase[i])) {
                i++;
            }
            int endIndex = i;
            if (startIndex < endIndex) {
                wordsAfter[count] = new String(phrase, startIndex, endIndex - startIndex);
                count++;
            }
        }
        return count;
    }

    private static boolean isWordSeparator(char c) {
        return WORD_SEPARATORS.contains(String.valueOf(c));
    }

    private String getCurrentWord(char[] phrase, int cursorPosition) {
        if (isWordSeparator(phrase[cursorPosition])) {
            return new String(phrase, cursorPosition, 1);
        }
        int startIndex = 0;
        int endIndex = phrase.length;
        int i = cursorPosition;
        while (true) {
            if (i >= phrase.length) {
                break;
            }
            if (!isWordSeparator(phrase[i])) {
                i++;
            } else {
                endIndex = i;
                break;
            }
        }
        int i2 = cursorPosition;
        while (true) {
            if (i2 < 0) {
                break;
            }
            if (!isWordSeparator(phrase[i2])) {
                i2--;
            } else {
                startIndex = i2 + 1;
                break;
            }
        }
        return new String(phrase, startIndex, endIndex - startIndex);
    }
}
