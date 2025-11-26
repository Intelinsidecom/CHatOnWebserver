package com.sec.amsoma.structure;

/* loaded from: classes.dex */
public class AMS_OPTION {
    boolean m_bBGROrder;
    public byte m_cSimplificationBufSize;
    public byte m_cTurnPageEffect;
    public int m_eSamplingOption;
    public int m_eSmoothingOption;
    public float m_fGenerationCurvature;
    public float m_fSimplificationTolerance;
    public int m_nGenerationAddPointGap;
    public int m_nGenerationExceptMaxLength;
    public int m_nGenerationExceptMinLength;
    public int m_nImageBPP;
    public int m_nMaxPageNum;

    public void init() {
        this.m_nMaxPageNum = 3;
        this.m_nImageBPP = 24;
        this.m_bBGROrder = false;
        this.m_cSimplificationBufSize = (byte) 6;
        this.m_fSimplificationTolerance = 2.0f;
        this.m_eSmoothingOption = 0;
        this.m_eSamplingOption = 2;
        this.m_nGenerationExceptMinLength = 7;
        this.m_nGenerationExceptMaxLength = 60;
        this.m_nGenerationAddPointGap = 5;
        this.m_fGenerationCurvature = 3.0f;
        this.m_cTurnPageEffect = (byte) 1;
    }

    public int getM_nMaxPageNum() {
        return this.m_nMaxPageNum;
    }

    public void setM_nMaxPageNum(int i) {
        this.m_nMaxPageNum = i;
    }

    public int getM_nImageBPP() {
        return this.m_nImageBPP;
    }

    public void setM_nImageBPP(int i) {
        this.m_nImageBPP = i;
    }

    public boolean isM_bBGROrder() {
        return this.m_bBGROrder;
    }

    public void setM_bBGROrder(boolean z) {
        this.m_bBGROrder = z;
    }

    public float getM_fSimplificationTolerance() {
        return this.m_fSimplificationTolerance;
    }

    public void setM_fSimplificationTolerance(float f) {
        this.m_fSimplificationTolerance = f;
    }

    public int getM_eSmoothingOption() {
        return this.m_eSmoothingOption;
    }

    public void setM_eSmoothingOption(int i) {
        this.m_eSmoothingOption = i;
    }

    public int getM_eSamplingOption() {
        return this.m_eSamplingOption;
    }

    public void setM_eSamplingOption(int i) {
        this.m_eSamplingOption = i;
    }

    public int getM_nGenerationExceptMinLength() {
        return this.m_nGenerationExceptMinLength;
    }

    public void setM_nGenerationExceptMinLength(int i) {
        this.m_nGenerationExceptMinLength = i;
    }

    public int getM_nGenerationExceptMaxLength() {
        return this.m_nGenerationExceptMaxLength;
    }

    public void setM_nGenerationExceptMaxLength(int i) {
        this.m_nGenerationExceptMaxLength = i;
    }

    public int getM_nGenerationAddPointGap() {
        return this.m_nGenerationAddPointGap;
    }

    public void setM_nGenerationAddPointGap(int i) {
        this.m_nGenerationAddPointGap = i;
    }

    public float getM_fGenerationCurvature() {
        return this.m_fGenerationCurvature;
    }

    public void setM_fGenerationCurvature(float f) {
        this.m_fGenerationCurvature = f;
    }
}
