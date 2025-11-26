package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RecognitionAsk extends MsgBody {

    /* renamed from: ID */
    private String f16ID;
    private Boolean IsRecognitionStart;
    private int NationalFlag;
    private int RecognitionLanguage;
    private String RecognizedText;
    private String UserID;
    private int VoiceLanguage;

    public String getID() {
        return this.f16ID;
    }

    public void setID(String id) {
        this.f16ID = id;
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

    public Boolean getIsRecognitionStart() {
        return this.IsRecognitionStart;
    }

    public void setIsRecognitionStart(boolean isRecognitionStart) {
        this.IsRecognitionStart = Boolean.valueOf(isRecognitionStart);
    }

    public int getNationalFlag() {
        return this.NationalFlag;
    }

    public void setNationalFlag(int nationalFlag) {
        this.NationalFlag = nationalFlag;
    }
}
