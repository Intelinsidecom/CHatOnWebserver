package com.infraware.office.evengine;

/* compiled from: EvTaskObj.java */
/* loaded from: classes.dex */
class EvOpenObj extends EvTaskObj {
    private int m_bLandScape;
    private int m_eLoadType;
    private int m_nHeight;
    private int m_nLocale;
    private int m_nOpenPageNum;
    private int m_nOpenRotateAngle;
    private int m_nOpenScale;
    private int m_nOpenStartX;
    private int m_nOpenStartY;
    private int m_nPageBgColor;
    private int m_nTextColor;
    private int m_nWidth;
    private String m_sBookClipPath;
    private String m_sBookMarkPath;
    private String m_sFilePath;
    private String m_sTempPath;

    EvOpenObj(EvNative a_Native, String a_sFilePath, int a_nWidth, int a_nHeight, int a_eLoadType, int a_nPageBgColor, int a_nTextColor, int a_nOpenPageNum, int a_nOpenScale, int a_nOpenRotateAngle, int a_nOpenStartX, int a_nOpenStartY, int a_nLocale, int a_bLandScape, String a_sTempPath, String a_sBookMarkPath, String a_sBookClipPath) {
        super(a_Native);
        this.m_sFilePath = a_sFilePath;
        this.m_nWidth = a_nWidth;
        this.m_nHeight = a_nHeight;
        this.m_eLoadType = a_eLoadType;
        this.m_nPageBgColor = a_nPageBgColor;
        this.m_nTextColor = a_nTextColor;
        this.m_nOpenPageNum = a_nOpenPageNum;
        this.m_nOpenScale = a_nOpenRotateAngle;
        this.m_nOpenStartX = a_nOpenStartX;
        this.m_nOpenStartY = a_nOpenStartY;
        this.m_nLocale = a_nLocale;
        this.m_bLandScape = a_bLandScape;
        this.m_sTempPath = a_sTempPath;
        this.m_sBookMarkPath = a_sBookMarkPath;
        this.m_sBookClipPath = a_sBookClipPath;
    }

    @Override // com.infraware.office.evengine.EvTaskObj
    void doTask() {
        this.Native.IOpen(this.m_sFilePath, this.m_nWidth, this.m_nHeight, this.m_eLoadType, this.m_nPageBgColor, this.m_nTextColor, this.m_nOpenPageNum, this.m_nOpenScale, this.m_nOpenRotateAngle, this.m_nOpenStartX, this.m_nOpenStartY, this.m_nLocale, this.m_bLandScape, this.m_sTempPath, this.m_sBookMarkPath);
    }
}
