package com.infraware.office.evengine;

/* compiled from: EvTaskObj.java */
/* loaded from: classes.dex */
class EvInitializeObj extends EvTaskObj {
    private int m_bFrameBufferSwap;
    private int m_bUseAutoBookmark;
    private int m_nBits;
    private int m_nBookmarkType;
    private int m_nDpi;
    private int m_nHeight;
    private int m_nScrollModeType;
    private int m_nWidth;

    EvInitializeObj(EvNative a_Native, int a_nWidth, int a_nHeight, int a_nScrollModeType, int a_nBookmarkType, int a_bUseAutoBookmark, int a_nBits, int a_bFrameBufferSwap, int a_nDpi) {
        super(a_Native);
        this.m_nWidth = a_nWidth;
        this.m_nHeight = a_nHeight;
        this.m_nScrollModeType = a_nScrollModeType;
        this.m_nBookmarkType = a_nBookmarkType;
        this.m_bUseAutoBookmark = a_bUseAutoBookmark;
        this.m_nBits = a_nBits;
        this.m_bFrameBufferSwap = a_bFrameBufferSwap;
        this.m_nDpi = a_nDpi;
    }

    @Override // com.infraware.office.evengine.EvTaskObj
    void doTask() {
        this.Native.IInitialize(this.m_nWidth, this.m_nHeight, this.m_nScrollModeType, this.m_nBookmarkType, this.m_bUseAutoBookmark, this.m_nBits, this.m_bFrameBufferSwap, this.m_nDpi);
    }
}
