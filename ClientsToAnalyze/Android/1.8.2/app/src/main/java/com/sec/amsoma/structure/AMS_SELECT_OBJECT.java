package com.sec.amsoma.structure;

/* loaded from: classes.dex */
public class AMS_SELECT_OBJECT {
    int m_UserStampHeight;
    int[] m_UserStampMemory;
    int m_UserStampWidth;
    int m_nExcludedDrawingBPP;
    int m_nExcludedDrawingHeight;
    int m_nExcludedDrawingWidth;
    int m_nSelectObjectBPP;
    int[] m_pExcludedDrawingMemory;
    int m_pSelectObjectData;
    int m_pSelectObjectNode;

    public int[] getM_pExcludedDrawingMemory() {
        return this.m_pExcludedDrawingMemory;
    }

    public void setM_pExcludedDrawingMemory(int[] iArr, int i, int i2) {
        int i3 = i * i2;
        this.m_pExcludedDrawingMemory = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            this.m_pExcludedDrawingMemory[i4] = iArr[i4];
        }
    }

    public int getM_nExcludedDrawingWidth() {
        return this.m_nExcludedDrawingWidth;
    }

    public void setM_nExcludedDrawingWidth(int i) {
        this.m_nExcludedDrawingWidth = i;
    }

    public int getM_nExcludedDrawingHeight() {
        return this.m_nExcludedDrawingHeight;
    }

    public void setM_nExcludedDrawingHeight(int i) {
        this.m_nExcludedDrawingHeight = i;
    }

    public int getM_nExcludedDrawingBPP() {
        return this.m_nExcludedDrawingBPP;
    }

    public void setM_nExcludedDrawingBPP(int i) {
        this.m_nExcludedDrawingBPP = i;
    }

    public int getM_pSelectObjectNode() {
        return this.m_pSelectObjectNode;
    }

    public void setM_pSelectObjectNode(int i) {
        this.m_pSelectObjectNode = i;
    }

    public int getM_pSelectObjectData() {
        return this.m_pSelectObjectData;
    }

    public void setM_pSelectObjectData(int i) {
        this.m_pSelectObjectData = i;
    }

    public int[] getM_UserStampMemory() {
        return this.m_UserStampMemory;
    }

    public void setM_UserStampMemory(int[] iArr, int i, int i2) {
        int i3 = i * i2;
        this.m_UserStampMemory = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            this.m_UserStampMemory[i4] = iArr[i4];
        }
    }

    public int getM_UserStampWidth() {
        return this.m_UserStampWidth;
    }

    public void setM_UserStampWidth(int i) {
        this.m_UserStampWidth = i;
    }

    public int getM_UserStampHeight() {
        return this.m_UserStampHeight;
    }

    public void setM_UserStampHeight(int i) {
        this.m_UserStampHeight = i;
    }

    public int getM_nSelectObjectBPP() {
        return this.m_nSelectObjectBPP;
    }

    public void setM_nSelectObjectBPP(int i) {
        this.m_nSelectObjectBPP = i;
    }
}
