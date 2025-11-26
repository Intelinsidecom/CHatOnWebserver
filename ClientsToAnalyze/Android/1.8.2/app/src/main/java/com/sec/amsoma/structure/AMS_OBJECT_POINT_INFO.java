package com.sec.amsoma.structure;

/* loaded from: classes.dex */
public class AMS_OBJECT_POINT_INFO {
    boolean m_bPressureFlag;
    int m_nPointNum;
    int m_nSimpleNum;
    char[] m_pcSimpleFlag;
    short[] m_pnAMSPointPressure;
    short[] m_pnAMSPointX;
    short[] m_pnAMSPointY;

    public int getM_nPointNum() {
        return this.m_nPointNum;
    }

    public void setM_nPointNum(int i) {
        this.m_nPointNum = i;
    }

    public short[] getM_pnAMSPointX() {
        return this.m_pnAMSPointX;
    }

    public short getM_pnAMSPointX(int i) {
        if (i < this.m_pnAMSPointX.length) {
            return this.m_pnAMSPointX[i];
        }
        return (short) 0;
    }

    public void setM_pnAMSPointX(short[] sArr) {
        this.m_pnAMSPointX = sArr;
    }

    public short[] getM_pnAMSPointY() {
        return this.m_pnAMSPointY;
    }

    public short getM_pnAMSPointY(int i) {
        if (i < this.m_pnAMSPointY.length) {
            return this.m_pnAMSPointY[i];
        }
        return (short) 0;
    }

    public void setM_pnAMSPointY(short[] sArr) {
        this.m_pnAMSPointY = sArr;
    }

    public int getM_nSimpleNum() {
        return this.m_nSimpleNum;
    }

    public void setM_nSimpleNum(int i) {
        this.m_nSimpleNum = i;
    }

    public char[] getM_pcSimpleFlag() {
        return this.m_pcSimpleFlag;
    }

    public char getM_pcSimpleFlag(int i) {
        if (i < this.m_pcSimpleFlag.length) {
            return this.m_pcSimpleFlag[i];
        }
        return (char) 0;
    }

    public void setM_pcSimpleFlag(char[] cArr) {
        this.m_pcSimpleFlag = cArr;
    }

    public short[] getM_pnAMSPointPressure() {
        return this.m_pnAMSPointPressure;
    }

    public short getM_pnAMSPointPressure(int i) {
        if (i < this.m_pnAMSPointPressure.length) {
            return this.m_pnAMSPointPressure[i];
        }
        return (short) 0;
    }

    public void setM_pnAMSPointPressure(short[] sArr) {
        this.m_pnAMSPointPressure = sArr;
    }

    public boolean getM_bPressureFlag() {
        return this.m_bPressureFlag;
    }

    public void setM_bPressureFlag(boolean z) {
        this.m_bPressureFlag = z;
    }
}
