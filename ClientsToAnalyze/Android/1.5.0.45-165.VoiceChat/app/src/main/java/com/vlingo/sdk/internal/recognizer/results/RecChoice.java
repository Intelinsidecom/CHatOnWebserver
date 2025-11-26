package com.vlingo.sdk.internal.recognizer.results;

/* loaded from: classes.dex */
public class RecChoice {
    public int numAlign;
    public String originalChoice;
    public String[] words;
    public boolean noSpace = false;
    public boolean noSpaceNumber = false;
    public boolean capitalized = false;

    public RecChoice(String aChoice, int aNumAlign) {
        String[] inputWords = new String[10];
        this.originalChoice = aChoice;
        int n = 0;
        int wordStart = 0;
        int len = aChoice.length();
        char[] choiceArray = aChoice.toCharArray();
        int wordEnd = 0;
        while (wordStart < len) {
            int i = wordStart;
            while (true) {
                if (i >= len) {
                    break;
                }
                if (choiceArray[i] != ' ') {
                    i++;
                } else {
                    wordEnd = i;
                    break;
                }
            }
            wordEnd = i == len ? len : wordEnd;
            if (wordEnd > wordStart) {
                inputWords[n] = new String(choiceArray, wordStart, wordEnd - wordStart);
                n++;
            }
            int i2 = wordEnd;
            while (i2 < len && choiceArray[i2] == ' ') {
                i2++;
            }
            wordStart = i2;
        }
        this.words = new String[n];
        for (int i3 = 0; i3 < n; i3++) {
            this.words[i3] = inputWords[i3];
        }
        this.numAlign = aNumAlign;
    }
}
