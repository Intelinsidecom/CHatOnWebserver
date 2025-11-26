package com.sec.amsoma.structure;

/* loaded from: classes.dex */
public class AMS_OBJECT_DATA {
    int m_bObjectInputFlag;
    int m_cAdditionalID;
    byte m_cSize;
    int m_cStyle;
    int m_eType;
    int m_nColor565;
    int m_nColorB;
    int m_nColorG;
    int m_nColorR;
    int m_nDrawingMapID;
    byte m_nIsThisSimplified;
    int m_nSpecialCodingBitSize;
    AMS_RECT m_TRect = new AMS_RECT();
    AMS_OBJECT_TEXT_INFO m_TText = new AMS_OBJECT_TEXT_INFO();
    AMS_OBJECT_POINT_INFO m_TPoint = new AMS_OBJECT_POINT_INFO();

    public byte getM_nIsThisSimplified() {
        return this.m_nIsThisSimplified;
    }

    public void setM_nIsThisSimplified(byte b) {
        this.m_nIsThisSimplified = b;
    }

    public int getM_eType() {
        return this.m_eType;
    }

    public void setM_eType(int i) {
        this.m_eType = i;
    }

    public int getM_cStyle() {
        return this.m_cStyle;
    }

    public void setM_cStyle(int i) {
        this.m_cStyle = i;
    }

    public byte getM_cSize() {
        return this.m_cSize;
    }

    public void setM_cSize(byte b) {
        this.m_cSize = b;
    }

    public int getM_nColorR() {
        return this.m_nColorR;
    }

    public void setM_nColorR(int i) {
        this.m_nColorR = i;
    }

    public int getM_nColorG() {
        return this.m_nColorG;
    }

    public void setM_nColorG(int i) {
        this.m_nColorG = i;
    }

    public int getM_nColorB() {
        return this.m_nColorB;
    }

    public void setM_nColorB(int i) {
        this.m_nColorB = i;
    }

    public int getM_cAdditionalID() {
        return this.m_cAdditionalID;
    }

    public void setM_cAdditionalID(int i) {
        this.m_cAdditionalID = i;
    }

    public int getM_bObjectInputFlag() {
        return this.m_bObjectInputFlag;
    }

    public void setM_bObjectInputFlag(int i) {
        this.m_bObjectInputFlag = i;
    }

    public AMS_RECT getM_TRect() {
        return this.m_TRect;
    }

    public void setM_TRect(AMS_RECT ams_rect) {
        this.m_TRect = ams_rect;
    }

    public AMS_OBJECT_TEXT_INFO getM_TText() {
        return this.m_TText;
    }

    public void setM_TText(AMS_OBJECT_TEXT_INFO ams_object_text_info) {
        this.m_TText = ams_object_text_info;
    }

    public AMS_OBJECT_POINT_INFO getM_TPoint() {
        return this.m_TPoint;
    }

    public void setM_TPoint(AMS_OBJECT_POINT_INFO ams_object_point_info) {
        this.m_TPoint = ams_object_point_info;
    }

    public int getM_nColor565() {
        return this.m_nColor565;
    }

    public void setM_nColor565(int i) {
        this.m_nColor565 = i;
    }

    public int getM_nSpecialCodingBitSize() {
        return this.m_nSpecialCodingBitSize;
    }

    public void setM_nSpecialCodingBitSize(int i) {
        this.m_nSpecialCodingBitSize = i;
    }

    public int getM_nDrawingMapID() {
        return this.m_nDrawingMapID;
    }

    public void setM_nDrawingMapID(int i) {
        this.m_nDrawingMapID = i;
    }

    public boolean equals(AMS_OBJECT_DATA ams_object_data) {
        if (this.m_eType != ams_object_data.getM_eType()) {
            return false;
        }
        switch (this.m_eType) {
            case 2:
                if (this.m_cSize == ams_object_data.getM_cSize() && this.m_nColorR == ams_object_data.getM_nColorR() && this.m_nColorG == ams_object_data.getM_nColorB() && this.m_nColorB == ams_object_data.getM_nColorB() && this.m_TRect.nLeft == ams_object_data.m_TRect.nLeft && this.m_TRect.nRight == ams_object_data.m_TRect.nRight && this.m_TRect.nTop == ams_object_data.m_TRect.nTop && this.m_TRect.nBottom == ams_object_data.m_TRect.nBottom && this.m_TText.m_strText == ams_object_data.m_TText.m_strText) {
                    break;
                }
                break;
            case 3:
                if (this.m_cStyle == ams_object_data.getM_cStyle() && this.m_cAdditionalID == ams_object_data.getM_cAdditionalID() && this.m_TRect.nLeft == ams_object_data.m_TRect.nLeft && this.m_TRect.nRight == ams_object_data.m_TRect.nRight && this.m_TRect.nTop == ams_object_data.m_TRect.nTop && this.m_TRect.nBottom == ams_object_data.m_TRect.nBottom) {
                    break;
                }
                break;
            case 4:
                if (this.m_cStyle == ams_object_data.getM_cStyle() && this.m_cSize == ams_object_data.getM_cSize() && this.m_nColorR == ams_object_data.getM_nColorR() && this.m_nColorG == ams_object_data.getM_nColorG() && this.m_nColorB == ams_object_data.getM_nColorB() && this.m_TRect.nLeft == ams_object_data.m_TRect.nLeft && this.m_TRect.nRight == ams_object_data.m_TRect.nRight && this.m_TRect.nTop == ams_object_data.m_TRect.nTop && this.m_TRect.nBottom == ams_object_data.m_TRect.nBottom) {
                    break;
                }
                break;
        }
        return false;
    }
}
