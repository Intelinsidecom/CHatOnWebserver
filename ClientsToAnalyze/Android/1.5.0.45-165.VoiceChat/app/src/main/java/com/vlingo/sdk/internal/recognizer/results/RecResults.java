package com.vlingo.sdk.internal.recognizer.results;

import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class RecResults {
    static final char END_DELIM = '}';
    static final char START_DELIM = '{';
    public int choiceIndex;
    public String guttid;
    public RecNBest iMostRecentRecEnd;
    public RecNBest iMostRecentRecStart;
    public int iNumWords;
    private RecNBest[] iResults;
    private String mostRecentString;
    private int totalStringHash;
    public int upDownArrowWordIndex;
    public RecNBest[][] uttList;
    public String[] uttListCannonical;
    public float[] uttListConf;
    public RecNBest[] wordList;

    public void clear() {
        for (int i = 0; i < this.iNumWords; i++) {
            this.iResults[i] = null;
        }
        this.iNumWords = 0;
    }

    public void clearMostRecentRecognition() {
        this.iMostRecentRecStart = null;
        this.iMostRecentRecEnd = null;
    }

    public Vector<String> getNBestForWord(String word) {
        Vector<String> nbest = new Vector<>();
        int i = 0;
        while (true) {
            if (i >= this.iNumWords) {
                break;
            }
            RecChoice[] choices = this.iResults[i].iChoices;
            if (choices.length > 0) {
                for (RecChoice recChoice : choices) {
                    String choice = recChoice.originalChoice;
                    if (word.equalsIgnoreCase(choice)) {
                        for (RecChoice recChoice2 : choices) {
                            nbest.add(recChoice2.originalChoice);
                        }
                    }
                }
            }
            i++;
        }
        return nbest;
    }

    public int getNBestForWordIfBetterMatch(List<String> result, String word, String[] previousWords, int numPreviousWords, String[] nextWords, int numNextWords, int bestNumMatchingWordsSoFar) {
        int matchingContextCount;
        int bestWordIndex = -1;
        int bestNumMatches = bestNumMatchingWordsSoFar;
        int bestMatchingNbest = result.size();
        for (int i = 0; i < this.iNumWords; i++) {
            RecChoice[] choices = this.iResults[i].iChoices;
            for (RecChoice recChoice : choices) {
                String choice = recChoice.originalChoice;
                if (word.equalsIgnoreCase(choice) && (((matchingContextCount = countMatchingContextWords(i, previousWords, numPreviousWords, nextWords, numNextWords) + 1) > bestNumMatches || (bestMatchingNbest < 2 && choices.length > 1)) && (choices.length > 1 || bestNumMatches == 0))) {
                    bestNumMatches = matchingContextCount;
                    bestWordIndex = i;
                    bestMatchingNbest = choices.length;
                }
            }
        }
        if (bestWordIndex >= 0) {
            result.clear();
            for (RecChoice recChoice2 : this.iResults[bestWordIndex].iChoices) {
                result.add(recChoice2.originalChoice);
            }
        }
        return bestNumMatches;
    }

    private int countMatchingContextWords(int index, String[] previousWords, int numPreviousWords, String[] nextWords, int numNextWords) {
        int numFound = 0;
        for (int i = 0; i < numPreviousWords; i++) {
            if (hasMatchingWord(previousWords[i], index - (numPreviousWords + 2), index)) {
                numFound++;
            }
        }
        for (int i2 = 0; i2 < numNextWords; i2++) {
            if (hasMatchingWord(nextWords[i2], index + 1, numNextWords + 2 + index)) {
                numFound++;
            }
        }
        return numFound;
    }

    private boolean hasMatchingWord(String word, int startIndex, int endIndex) {
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (endIndex > this.iNumWords) {
            endIndex = this.iNumWords;
        }
        for (int i = startIndex; i < endIndex; i++) {
            RecChoice[] choices = this.iResults[i].iChoices;
            for (RecChoice recChoice : choices) {
                String choice = recChoice.originalChoice;
                if (word.equalsIgnoreCase(choice)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int removeRangeOfWords(RecNBest start, RecNBest end, int cursor) {
        int startIndex = -1;
        int endIndex = -1;
        int i = 0;
        while (true) {
            if (i >= this.iNumWords) {
                break;
            }
            if (this.iResults[i] == start) {
                startIndex = i;
            }
            if (this.iResults[i] != end) {
                i++;
            } else {
                endIndex = i;
                break;
            }
        }
        if (startIndex >= 0 && endIndex >= 0) {
            int numToDelete = (endIndex + 1) - startIndex;
            this.iNumWords -= numToDelete;
            for (int i2 = startIndex; i2 < this.iNumWords; i2++) {
                this.iResults[i2] = this.iResults[i2 + numToDelete];
            }
            for (int i3 = this.iNumWords; i3 < this.iNumWords + numToDelete; i3++) {
                this.iResults[i3] = null;
            }
            int newCursor = startIndex;
            return newCursor;
        }
        return -1;
    }

    public RecNBest getWord(int index) {
        if (index < 0 || index >= this.iNumWords) {
            return null;
        }
        return this.iResults[index];
    }

    public int getWordLength(int index) {
        if (index < 0 || index >= this.iNumWords) {
            return 0;
        }
        RecNBest w = this.iResults[index];
        return w.length();
    }

    public RecResults(int aMaxWords) {
        this(aMaxWords, null);
    }

    public RecResults(int aMaxWords, String guttid) {
        this.iNumWords = 0;
        this.mostRecentString = null;
        this.totalStringHash = 0;
        this.wordList = null;
        this.uttList = null;
        this.uttListConf = null;
        this.uttListCannonical = null;
        this.upDownArrowWordIndex = -1;
        this.iMostRecentRecStart = null;
        this.iMostRecentRecEnd = null;
        this.iResults = new RecNBest[aMaxWords];
        this.guttid = guttid;
    }

    public void updateSentenceCap() {
        boolean lastWasPeriod = false;
        for (int i = 0; i < this.iNumWords; i++) {
            RecNBest word = getWord(i);
            if (word.iSelectedWord.trim().length() != 0) {
                if (word.iSelectedWord.equals(".")) {
                    lastWasPeriod = true;
                } else if (lastWasPeriod) {
                    if (!word.capitalized && Character.isLowerCase(word.iSelectedWord.charAt(0))) {
                        String newWord = word.iSelectedWord.substring(0, 1).toUpperCase();
                        if (word.iSelectedWord.length() > 1) {
                            newWord = String.valueOf(newWord) + word.iSelectedWord.substring(1);
                        }
                        word.iSelectedWord = newWord;
                    }
                    lastWasPeriod = false;
                }
            }
        }
    }

    private void moveWords(int aWordIndex, int aNumNewWords) {
        int newNumWords = this.iNumWords + aNumNewWords;
        if (newNumWords > this.iResults.length) {
            growResults(newNumWords * 2);
        }
        for (int i = newNumWords - 1; i >= aWordIndex + aNumNewWords; i--) {
            this.iResults[i] = this.iResults[i - aNumNewWords];
        }
        this.iNumWords += aNumNewWords;
    }

    private void growResults(int n) {
        RecNBest[] newResults = new RecNBest[n];
        for (int i = 0; i < this.iNumWords; i++) {
            newResults[i] = this.iResults[i];
        }
        this.iResults = null;
        this.iResults = newResults;
    }

    public void addWord(int aNewIndex, String aNewString) {
        if (this.iNumWords + 1 >= this.iResults.length) {
            growResults(this.iNumWords * 2);
        }
        moveWords(aNewIndex, 1);
        this.iResults[aNewIndex] = new RecNBest(aNewString);
    }

    public void addNBest(int aNewIndex, RecNBest recNBest) {
        if (this.iNumWords + 1 >= this.iResults.length) {
            growResults(this.iNumWords * 2);
        }
        moveWords(aNewIndex, 1);
        this.iResults[aNewIndex] = recNBest;
    }

    public void append(String aNewString) {
        if (this.iNumWords >= this.iResults.length - 1) {
            growResults(this.iNumWords * 2);
        }
        RecNBest[] recNBestArr = this.iResults;
        int i = this.iNumWords;
        this.iNumWords = i + 1;
        recNBestArr[i] = new RecNBest(aNewString);
    }

    public void append(RecNBest w) {
        if (this.iNumWords >= this.iResults.length - 1) {
            growResults(this.iNumWords * 2);
        }
        RecNBest[] recNBestArr = this.iResults;
        int i = this.iNumWords;
        this.iNumWords = i + 1;
        recNBestArr[i] = w;
    }

    public int insert(RecResults input, int aCursorWord, int aCursorChar) {
        int wordIndex;
        if (aCursorChar == 0) {
            wordIndex = aCursorWord;
        } else {
            wordIndex = aCursorWord + 1;
        }
        if (wordIndex > this.iNumWords) {
            wordIndex = this.iNumWords;
        }
        int numNewWords = input.iNumWords;
        if (this.iNumWords + numNewWords >= this.iResults.length) {
            growResults((this.iNumWords * 2) + numNewWords);
        }
        moveWords(wordIndex, numNewWords);
        for (int i = 0; i < numNewWords; i++) {
            this.iResults[i + wordIndex] = input.iResults[i];
        }
        return numNewWords;
    }

    public int findNumChoice(int aWordIndex) {
        RecNBest w = this.iResults[aWordIndex];
        return w.f3255iN;
    }

    public void deleteWord(int aWordIndex) {
        if (aWordIndex >= 0 && aWordIndex < this.iNumWords) {
            for (int i = aWordIndex; i < this.iNumWords - 1; i++) {
                this.iResults[i] = this.iResults[i + 1];
            }
            this.iNumWords--;
        }
    }

    public void clearPositions(int fromIndex) {
        for (int i = fromIndex; i < this.iNumWords; i++) {
            if (this.iResults[i] != null) {
                RecNBest w = this.iResults[i];
                w.clearPosition();
            }
        }
    }

    public int size() {
        int num = 0;
        for (int i = 0; i < this.iNumWords; i++) {
            RecNBest w1 = this.iResults[i];
            String s1 = w1.iSelectedWord;
            num += s1.length();
            if (i < this.iNumWords - 1) {
                RecNBest w2 = this.iResults[i + 1];
                if (w2.needsSpace(w1)) {
                    num++;
                }
            }
        }
        return num;
    }

    public int size(int startIndex, int endIndex) {
        int num = 0;
        for (int i = startIndex; i < endIndex && i < this.iNumWords; i++) {
            RecNBest w1 = this.iResults[i];
            String s1 = w1.iSelectedWord;
            num += s1.length();
            if (i < this.iNumWords - 1 && i < endIndex - 1) {
                RecNBest w2 = this.iResults[i + 1];
                if (w2.needsSpace(w1)) {
                    num++;
                }
            }
        }
        return num;
    }

    public int getChars(char[] data) {
        int index = 0;
        for (int i = 0; i < this.iNumWords; i++) {
            RecNBest w1 = this.iResults[i];
            String s1 = w1.iSelectedWord;
            int len = s1.length();
            s1.getChars(0, len, data, index);
            index += len;
            if (i < this.iNumWords - 1) {
                RecNBest w2 = this.iResults[i + 1];
                if (w2.needsSpace(w1)) {
                    data[index] = ' ';
                    index++;
                }
            }
        }
        return index;
    }

    public String toString() {
        return getString();
    }

    public String getString() {
        int totalHash = 0;
        if (this.iNumWords == 0) {
            return "";
        }
        for (int i = 0; i < this.iNumWords; i++) {
            RecNBest w = this.iResults[i];
            String s = w.iSelectedWord;
            totalHash += s.hashCode();
        }
        if (this.mostRecentString != null && totalHash == this.totalStringHash) {
            return this.mostRecentString;
        }
        int len = size();
        char[] data = new char[len];
        int len2 = getChars(data);
        this.mostRecentString = new String(data, 0, len2);
        this.totalStringHash = totalHash;
        return this.mostRecentString;
    }

    public int indexOf(RecNBest word) {
        for (int i = 0; i < this.iNumWords; i++) {
            RecNBest w = this.iResults[i];
            if (w == word) {
                return i;
            }
        }
        return -1;
    }

    public String[] getPhraseLevel() {
        String[] plChoices;
        if (this.uttList != null && this.uttList.length > 0) {
            RecNBest[][] sentences = this.uttList;
            plChoices = new String[sentences.length];
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < sentences.length; i++) {
                sb.setLength(0);
                RecNBest[] sentence = sentences[i];
                if (sentence == null) {
                    return null;
                }
                if (sentence.length > 0) {
                    sb.append(sentence[0].getSelectedWord());
                    for (int j = 1; j < sentence.length; j++) {
                        sb.append(" ");
                        sb.append(sentence[j].getSelectedWord());
                    }
                }
                plChoices[i] = sb.toString();
            }
        } else {
            plChoices = new String[]{getString()};
        }
        return plChoices;
    }
}
