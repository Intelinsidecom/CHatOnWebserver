package com.vlingo.sdk.recognition;

import com.vlingo.sdk.internal.recognizer.results.RecChoice;
import com.vlingo.sdk.internal.recognizer.results.RecNBest;
import com.vlingo.sdk.internal.recognizer.results.RecResults;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NBestData {
    private static final String WORD_SEPARATORS = ". ,;:!?\n()[]*&@{}/<>_+=|\"";
    private RecResults mUttResults;

    public NBestData(RecResults uttResults) {
        this.mUttResults = uttResults;
    }

    public List<String> getWords() {
        throw new UnsupportedOperationException();
    }

    public List<String> getWordChoices(int wordIndex) {
        RecNBest nbest = this.mUttResults.getWord(wordIndex);
        List<String> nbestRes = new ArrayList<>();
        RecChoice[] choices = nbest.iChoices;
        if (choices.length > 0) {
            for (RecChoice recChoice : choices) {
                nbestRes.add(recChoice.originalChoice);
            }
        }
        return nbestRes;
    }

    public List<String> getWordChoices(String currentString, int startSelection, int endSelection) {
        String selectedText = currentString.substring(startSelection, endSelection);
        return this.mUttResults.getNBestForWord(selectedText);
    }
}
