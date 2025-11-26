package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class TranslationAsk extends MsgBody {

    /* renamed from: ID */
    private String f24ID;
    private Boolean IsTranslationStart;
    private int NationalFlag;
    private int RecognitionLanguage;
    private String RecognizedText;
    private String TranslatedText;
    private String UserID;
    private int VoiceLanguage;

    public String getID() {
        return this.f24ID;
    }

    public void setID(String id) {
        this.f24ID = id;
    }

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String userId) {
        this.UserID = userId;
    }

    public int getVoiceLanguage() {
        return this.VoiceLanguage;
    }

    public void setVoiceLanguage(int voiceLanguage) {
        this.VoiceLanguage = voiceLanguage;
    }

    public int getRecognitionLanguage() {
        return this.RecognitionLanguage;
    }

    public void setRecognitionLanguage(int recognitionLanguage) {
        this.RecognitionLanguage = recognitionLanguage;
    }

    public String getRecognizedText() {
        return this.RecognizedText;
    }

    public void setRecognizedText(String recognizedText) {
        this.RecognizedText = recognizedText;
    }

    public String getTranslatedText() {
        return this.TranslatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.TranslatedText = translatedText;
    }

    public Boolean getIsTranslationStart() {
        return this.IsTranslationStart;
    }

    public void setIsTranslationStart(boolean isTranslationStart) {
        this.IsTranslationStart = Boolean.valueOf(isTranslationStart);
    }

    public int getNationalFlag() {
        return this.NationalFlag;
    }

    public void setNationalFlag(int nationalFlag) {
        this.NationalFlag = nationalFlag;
    }
}
