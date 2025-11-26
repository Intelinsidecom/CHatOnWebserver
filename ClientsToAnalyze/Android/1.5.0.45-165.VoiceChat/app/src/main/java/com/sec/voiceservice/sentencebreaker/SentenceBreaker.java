package com.sec.voiceservice.sentencebreaker;

import java.text.BreakIterator;
import java.util.Locale;

/* loaded from: classes.dex */
public class SentenceBreaker {
    private SentenceListener sentenceListener;
    private int threshold = 1900;

    public void setSentenceListener(SentenceListener sentenceListener) {
        this.sentenceListener = sentenceListener;
    }

    public SentenceListener getSentenceListener() {
        return this.sentenceListener;
    }

    public void setThreshold(int threshold) {
        if (threshold < 0) {
            threshold = 0;
        }
        if (threshold > 10000) {
            threshold = 10000;
        }
        this.threshold = threshold;
    }

    public int getThreshold() {
        return this.threshold;
    }

    /* JADX WARN: Finally extract failed */
    public void breakSentense(Locale locale, String source) {
        int length;
        if (source == null) {
            throw new IllegalArgumentException("Source is null!");
        }
        if (this.sentenceListener == null) {
            throw new IllegalArgumentException("SentenceListener is null!");
        }
        if ("".equals(source)) {
            throw new IllegalArgumentException("Source is empty!");
        }
        BreakIterator boundary = BreakIterator.getSentenceInstance(locale);
        boundary.setText(source);
        StringBuilder result = new StringBuilder();
        boolean isExistBoundary = false;
        int start = boundary.first();
        for (int end = boundary.next(); end != -1 && end - start <= this.threshold; end = boundary.next()) {
            isExistBoundary = true;
            String sentence = source.substring(start, end);
            if (!"".equals(sentence)) {
                result.append(sentence);
                if (result.length() >= this.threshold) {
                    try {
                        try {
                            this.sentenceListener.onSentence(result.toString());
                            result = new StringBuilder();
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new IllegalArgumentException("SentenceListener error!");
                        }
                    } catch (Throwable th) {
                        new StringBuilder();
                        throw th;
                    }
                } else {
                    continue;
                }
            }
            start = end;
        }
        if (result.length() > 0) {
            try {
                this.sentenceListener.onSentence(result.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new IllegalArgumentException("SentenceListener error!!");
            }
        }
        if (!isExistBoundary) {
            int startIndex = start;
            int endIndex = this.threshold;
            for (int i = 0; i < Math.ceil(source.length() / this.threshold); i++) {
                this.sentenceListener.onSentence(source.substring(startIndex, endIndex));
                startIndex = endIndex;
                if ((source.length() - endIndex) / this.threshold > 0) {
                    length = this.threshold;
                } else {
                    length = (source.length() - endIndex) % this.threshold;
                }
                endIndex += length;
            }
        }
    }
}
