package com.sec.amsoma.structure;

/* loaded from: classes.dex */
public class AMS_OBJECT_POINT_INFO {
    int m_nPointNum;
    int m_nSimpleNum;
    char[] m_pcSimpleFlag;
    short[] m_pnAMSPointX;
    short[] m_pnAMSPointY;

    public int getM_nPointNum() {
        return this.m_nPointNum;
    }

    public int getM_nSimpleNum() {
        return this.m_nSimpleNum;
    }

    public char getM_pcSimpleFlag(int i) {
        return this.m_pcSimpleFlag[i];
    }

    public char[] getM_pcSimpleFlag() {
        return this.m_pcSimpleFlag;
    }

    public short getM_pnAMSPointX(int i) {
        return this.m_pnAMSPointX[i];
    }

    public short[] getM_pnAMSPointX() {
        return this.m_pnAMSPointX;
    }

    public short getM_pnAMSPointY(int i) {
        return this.m_pnAMSPointY[i];
    }

    public short[] getM_pnAMSPointY() {
        return this.m_pnAMSPointY;
    }

    public void setM_nPointNum(int i) {
        this.m_nPointNum = i;
    }

    public void setM_nSimpleNum(int i) {
        this.m_nSimpleNum = i;
    }

    public void setM_pcSimpleFlag(char[] cArr) {
        this.m_pcSimpleFlag = cArr;
    }

    public void setM_pnAMSPointX(short[] sArr) {
        this.m_pnAMSPointX = sArr;
    }

    public void setM_pnAMSPointY(short[] sArr) {
        this.m_pnAMSPointY = sArr;
    }
}
