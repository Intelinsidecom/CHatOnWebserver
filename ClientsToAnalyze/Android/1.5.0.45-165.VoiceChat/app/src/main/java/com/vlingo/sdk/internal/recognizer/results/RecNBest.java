package com.vlingo.sdk.internal.recognizer.results;

/* loaded from: classes.dex */
public class RecNBest {
    public boolean capitalized;
    public int choiceIndex;
    public RecChoice[] iChoices;

    /* renamed from: iN */
    public int f3255iN;
    public String iSelectedWord;
    public int iWidth;
    public int iXPosition;
    public int iYPosition;

    /* renamed from: id */
    public int f3256id;
    public boolean noSpace;
    public boolean noSpaceNumber;
    public int numAdded;
    public int numReplaced;
    public RecNBest[] replacedNBests;

    public RecNBest copy() {
        RecNBest c = new RecNBest();
        c.f3256id = this.f3256id;
        c.f3255iN = this.f3255iN;
        c.iSelectedWord = this.iSelectedWord;
        c.iChoices = this.iChoices;
        c.choiceIndex = this.choiceIndex;
        c.clearPosition();
        c.noSpace = this.noSpace;
        c.noSpaceNumber = this.noSpaceNumber;
        c.capitalized = this.capitalized;
        return c;
    }

    public String toString() {
        return "<" + this.iSelectedWord + "|" + (this.iChoices != null ? this.iChoices.length : 0) + ">";
    }

    public int wordLength() {
        return this.iSelectedWord.length();
    }

    public void clearPosition() {
        this.iXPosition = -1;
        this.iYPosition = -1;
        this.iWidth = -1;
    }

    public RecNBest() {
        this.f3256id = -1;
        this.choiceIndex = 0;
        this.numAdded = 1;
        this.numReplaced = 1;
        this.replacedNBests = null;
        this.noSpace = false;
        this.noSpaceNumber = false;
        this.capitalized = false;
        this.iChoices = null;
        this.f3255iN = 0;
        this.iXPosition = -1;
        this.iYPosition = -1;
        this.iWidth = -1;
    }

    public RecNBest(int aMaxChoices) {
        this.f3256id = -1;
        this.choiceIndex = 0;
        this.numAdded = 1;
        this.numReplaced = 1;
        this.replacedNBests = null;
        this.noSpace = false;
        this.noSpaceNumber = false;
        this.capitalized = false;
        this.iChoices = new RecChoice[aMaxChoices];
        this.iSelectedWord = "";
        this.f3255iN = 0;
        this.iXPosition = -1;
        this.iYPosition = -1;
        this.iWidth = -1;
    }

    public RecNBest(String word) {
        this.f3256id = -1;
        this.choiceIndex = 0;
        this.numAdded = 1;
        this.numReplaced = 1;
        this.replacedNBests = null;
        this.noSpace = false;
        this.noSpaceNumber = false;
        this.capitalized = false;
        this.iChoices = null;
        this.iSelectedWord = word;
        this.f3255iN = 0;
        this.iXPosition = -1;
        this.iYPosition = -1;
        this.iWidth = -1;
    }

    public RecChoice addResultsFromString(String aChoice, int aNumAlign) {
        if (this.f3255iN >= this.iChoices.length) {
            return null;
        }
        RecChoice newChoice = new RecChoice(aChoice, aNumAlign);
        this.iChoices[this.f3255iN] = newChoice;
        if (this.f3255iN == 0) {
            setSelectedWord(aChoice);
        }
        this.f3255iN++;
        return newChoice;
    }

    public boolean isPunctuation(char c) {
        return c == '.' || c == ',' || c == '!' || c == '?' || c == ':' || c == ';' || c == ')' || c == ']' || c == '}' || c == '-';
    }

    private boolean isNumber(String string) {
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (!Character.isDigit(c) && c != ',') {
                return false;
            }
        }
        return true;
    }

    public boolean needsSpace(RecNBest previousWord) {
        if (previousWord == null) {
            return false;
        }
        String previousString = previousWord.iSelectedWord;
        if (this.iSelectedWord.length() == 0 || previousString.length() == 0) {
            return true;
        }
        if (this.iChoices != null) {
            RecChoice choice = this.iChoices[this.choiceIndex];
            if (choice.noSpace) {
                return false;
            }
            if (choice.noSpaceNumber && isNumber(previousString)) {
                return false;
            }
        } else {
            if (this.noSpace) {
                return false;
            }
            if (this.noSpaceNumber && isNumber(previousString)) {
                return false;
            }
        }
        char c1 = previousString.charAt(previousString.length() - 1);
        char c2 = this.iSelectedWord.charAt(0);
        return (c1 == '\n' || c2 == '\n' || isPunctuation(c2)) ? false : true;
    }

    public boolean matches(String word, boolean ignoreCase) {
        return ignoreCase ? this.iSelectedWord.equalsIgnoreCase(word) : this.iSelectedWord.equals(word);
    }

    public int length() {
        if (this.iSelectedWord != null) {
            return this.iSelectedWord.length();
        }
        return 0;
    }

    public String getSelectedWord() {
        return this.iSelectedWord;
    }

    public void setSelectedWord(String word) {
        this.iSelectedWord = word;
    }

    public boolean adjustChoiceIndex() {
        for (int i = 0; i < this.iChoices.length; i++) {
            if (this.iSelectedWord.equals(this.iChoices[i].words[0]) && this.iChoices[i].words.length == 1) {
                this.choiceIndex = i;
                return true;
            }
        }
        for (int i2 = 0; i2 < this.iChoices.length; i2++) {
            if (this.iSelectedWord.equals(this.iChoices[i2].words[0])) {
                this.choiceIndex = i2;
                return true;
            }
        }
        return false;
    }
}
