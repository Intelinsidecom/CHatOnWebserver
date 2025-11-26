package com.sec.amsoma.structure;

/* loaded from: classes.dex */
public class AMS_CODING_FILE_INFO {
    public int m_eExportType;
    public int m_nCurPageIndex;
    public int m_nMessageID;
    public int m_nTotalPageNum;
    public String m_strFileName;

    public int getM_eExportType() {
        return this.m_eExportType;
    }

    public void setM_eExportType(int i) {
        this.m_eExportType = i;
    }

    public String getM_strFileName() {
        return this.m_strFileName;
    }

    public void setM_strFileName(String str) {
        this.m_strFileName = str;
    }

    public int getM_nCurPageIndex() {
        return this.m_nCurPageIndex;
    }

    public void setM_nCurPageIndex(int i) {
        this.m_nCurPageIndex = i;
    }

    public int getM_nTotalPageNum() {
        return this.m_nTotalPageNum;
    }

    public void setM_nTotalPageNum(int i) {
        this.m_nTotalPageNum = i;
    }

    public int getM_nMessageID() {
        return this.m_nMessageID;
    }

    public void setM_nMessageID(int i) {
        this.m_nMessageID = i;
    }
}
