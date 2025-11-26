package com.infraware.office.evengine;

import com.infraware.office.evengine.C0508EV;
import com.infraware.office.evengine.EvListener;
import com.infraware.office.evengine.InterfaceC0507E;

/* loaded from: classes.dex */
public abstract class EvInterface implements InterfaceC0507E, InterfaceC0507E.EV_EDITMODETYPE, InterfaceC0507E.EV_DOCEXTENSION_TYPE {
    protected static EvInterface mInterface;
    protected EvNative Native;
    protected int mHeapSize = 256;
    protected boolean mbInit = false;
    protected int mbSuspend = 0;
    protected int mEditorMode = 0;

    /* renamed from: Ev */
    protected C0508EV f61Ev = new C0508EV();

    public abstract void ICancel();

    public abstract void IFinalize();

    public abstract C0508EV.CONFIG_INFO IGetConfig();

    public abstract void IOpen(String str, int i, int i2, int i3, int i4, int i5, String str2, String str3, String str4);

    public abstract void IOpenEx(String str, String str2, int i, int i2, String str3, String str4, String str5);

    public abstract void ISetListener(EvListener.ViewerListener viewerListener);

    public abstract void ISetPrint(int i, int i2, int i3, String str, int i4);

    public abstract void ISetPrintEx(int i, int i2, int i3, String str, int i4, int i5, String str2, String str3);

    public abstract void ISetWHByPrint(int i, int i2, String str, int i3, String str2, int i4, int i5);

    abstract void OnTimerStart();

    abstract void OnTimerStop();

    protected EvInterface(String AppDir) {
        this.Native = new EvNative(this, AppDir);
    }

    public static EvInterface getInterface(String AppDir) {
        if (mInterface == null) {
            mInterface = new EvCompInterfaceMsg(AppDir);
        }
        return mInterface;
    }

    /* renamed from: EV */
    public C0508EV m11EV() {
        return this.f61Ev;
    }

    public int getDocFileExtentionType(String filePath) {
        int nIndex = filePath.lastIndexOf(46);
        if (nIndex < 0) {
            return 255;
        }
        String strExt = filePath.substring(nIndex).toLowerCase();
        if (strExt.compareTo(".doc") == 0) {
            return 2;
        }
        if (strExt.compareTo(".docx") == 0) {
            return 18;
        }
        if (strExt.compareTo(".ppt") == 0) {
            return 1;
        }
        if (strExt.compareTo(".pptx") == 0) {
            return 19;
        }
        if (strExt.compareTo(".pdf") != 0) {
            return 255;
        }
        return 6;
    }

    public String[] getFontFileList() {
        return this.Native.GetFontFileList();
    }

    public void ISetHeapSize(int a_nHeapSize) {
        this.Native.ISetHeapSize(a_nHeapSize);
    }

    public void ISetLocale(int a_nLocale) {
        this.Native.ISetLocale(a_nLocale);
    }

    public int IGetInitialHeapSize() {
        return this.mHeapSize;
    }

    public void ISetInitialHeapSize(int a_nHeapSize) {
        this.mHeapSize = a_nHeapSize;
    }

    boolean isInit() {
        return this.mbInit;
    }

    void OnInitComplete(int EEV_ERROR_CODE) {
        this.mbInit = true;
    }

    void OnFinalizeComplete() {
        this.mbInit = false;
    }

    public void IInitialize(int a_nWidth, int a_nHeight, int a_nDpi) {
        this.Native.ISetHeapSize(this.mHeapSize);
    }

    public void IClose() {
        this.Native.SetListener(null);
        this.f61Ev.clear();
    }
}
