package com.sec.amsoma.structure;

/* loaded from: classes.dex */
public class AMS_OBJECT_TEXT_INFO {
    int m_nFontFaceLength;
    int m_nTextLength;
    String m_strFontFaceName;
    String m_strText;

    public char[] getM_cFontFaceName() {
        char[] cArr = new char[this.m_strFontFaceName.length() + 1];
        return this.m_strFontFaceName.toCharArray();
    }

    public char[] getM_cText() {
        char[] cArr = new char[this.m_strText.length() + 1];
        return this.m_strText.toCharArray();
    }

    public int getM_nFontFaceLength() {
        return this.m_nFontFaceLength;
    }

    public int getM_nTextLength() {
        return this.m_nTextLength;
    }

    public String getM_strFontFaceName() {
        return this.m_strFontFaceName;
    }

    public String getM_strText() {
        return this.m_strText;
    }

    public void setM_nFontFaceLength(int i) {
        this.m_nFontFaceLength = i;
    }

    public void setM_nTextLength(int i) {
        this.m_nTextLength = i;
    }

    public void setM_strFontFaceName(String str) {
        this.m_strFontFaceName = str;
    }

    public void setM_strText(String str) {
        this.m_strText = str;
    }
}
