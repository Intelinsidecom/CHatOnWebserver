package com.infraware.office.evengine;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.infraware.office.evengine.C0508EV;
import com.infraware.office.evengine.EvListener;
import com.infraware.office.evengine.InterfaceC0507E;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class EvNative implements InterfaceC0507E.EV_GUI_EVENT {
    static final /* synthetic */ boolean $assertionsDisabled;
    private EvCodeConversion mEvCodeConversion;
    private EvImageUtil mEvImageUtil;
    private EvInterface mInterface;
    private String LOG_CAT = "EvNative";
    private String versionTAG = "OFFICESDK5VERSION_VoiceService";
    private String versionCode = "5.0.12.16.01R";
    private EvListener.ViewerListener mDvListener = null;
    private String[] mSystemFontFilePaths = null;

    private native int IBeginNative(EvCodeConversion evCodeConversion, EvImageUtil evImageUtil, String str);

    native void ICancel();

    native void IClose();

    native void IFinalize();

    native void IGetConfig(C0508EV.CONFIG_INFO config_info);

    native void IInitialize(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    native void IOpen(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, String str2, String str3);

    native void IOpenEx(String str, String str2);

    native void ISetHeapSize(int i);

    native void ISetLocale(int i);

    native void ISetPrint(int i, int i2, int i3, String str, int i4);

    native void ISetPrintEx(int i, int i2, int i3, String str, int i4, String str2, String str3, int i5, int i6, int i7, int i8);

    native void ISetThumbnailByPrint(int i, int i2, String str, int i3, String str2, String str3, int i4, int i5);

    native void ITimer();

    static {
        $assertionsDisabled = !EvNative.class.desiredAssertionStatus();
        System.loadLibrary("EX_Engine5ex3");
        System.loadLibrary("polarisexternel3");
        System.loadLibrary("polarisexternel3SDK");
    }

    private void MakeSystemFontFileNames() {
        String[] useString = {"nanum", "droids", "droidnask", "samsung", "lohit", "thai", "gp", "arab"};
        List<String> fontPaths = new ArrayList<>();
        File[] fontFiles = new File("/system/fonts/").listFiles();
        int fontCount = fontFiles.length;
        long mostBigFileSize = 0;
        for (int i = 0; i < fontCount; i++) {
            String fontName = fontFiles[i].getName().toLowerCase();
            if (!fontName.contains("bold") && !fontName.contains("lindseyforsamsung-regular")) {
                long fileSize = fontFiles[i].length();
                for (String str : useString) {
                    if (fontName.matches("(?i).*" + str + ".*") && fontFiles[i].getAbsolutePath() != null) {
                        if (mostBigFileSize < fileSize) {
                            mostBigFileSize = fileSize;
                            fontPaths.add(0, fontFiles[i].getAbsolutePath());
                        } else {
                            fontPaths.add(fontFiles[i].getAbsolutePath());
                        }
                    }
                }
            }
        }
        for (int i2 = 0; i2 < fontCount; i2++) {
            if (fontFiles[i2].getName().toLowerCase().matches("(?i).*droidsansjapanese.*") && fontFiles[i2].getAbsolutePath() != null) {
                fontPaths.add(0, fontFiles[i2].getAbsolutePath());
            }
        }
        for (int i3 = 0; i3 < fontCount; i3++) {
            String fontName2 = fontFiles[i3].getName().toLowerCase();
            if ((fontName2.matches("(?i).*gp_thai.*") || fontName2.matches("(?i).*gs_thai.*")) && fontFiles[i3].getAbsolutePath() != null) {
                int j = 0;
                while (true) {
                    if (j >= fontPaths.size()) {
                        break;
                    }
                    String defaultFontName = fontPaths.get(j).toLowerCase();
                    if (!defaultFontName.matches("(?i).*droidsansthai.*")) {
                        j++;
                    } else {
                        fontPaths.add(j, fontFiles[i3].getAbsolutePath());
                        break;
                    }
                }
            }
        }
        int fontNameSize = fontPaths.size();
        this.mSystemFontFilePaths = new String[fontNameSize];
        for (int i4 = 0; i4 < fontNameSize; i4++) {
            this.mSystemFontFilePaths[i4] = fontPaths.get(i4);
        }
    }

    EvNative(EvInterface a_interface, String appDir) {
        this.mInterface = null;
        this.mEvCodeConversion = null;
        this.mEvImageUtil = null;
        if (!$assertionsDisabled && this.mInterface != null) {
            throw new AssertionError();
        }
        this.mInterface = a_interface;
        this.mEvCodeConversion = EvCodeConversion.getCodeConversion();
        this.mEvImageUtil = EvImageUtil.getEvImageUtil();
        MakeSystemFontFileNames();
        IBeginNative(this.mEvCodeConversion, this.mEvImageUtil, appDir);
        Log.i(this.versionTAG, this.versionCode);
    }

    void SetListener(EvListener.ViewerListener DvL) {
        this.mDvListener = DvL;
    }

    String[] GetFontFileList() {
        return this.mSystemFontFilePaths;
    }

    private void OnInitComplete(int EEV_ERROR_CODE) {
        this.mInterface.OnInitComplete(EEV_ERROR_CODE);
    }

    private void OnFinalizeComplete() {
        this.mInterface.OnFinalizeComplete();
    }

    private void OnLoadComplete(int bBookmarkExsit) {
        if (this.mDvListener != null) {
            this.mDvListener.OnLoadComplete();
        }
    }

    private void OnTotalLoadComplete() {
        if (this.mDvListener != null) {
            this.mDvListener.OnTotalLoadComplete();
        }
    }

    private void OnLoadFail(int EEV_ERROR_CODE) {
        if (this.mDvListener != null) {
            this.mDvListener.OnLoadFail(EEV_ERROR_CODE);
        }
    }

    private void OnCloseDoc() {
        if (this.mDvListener != null) {
            this.mDvListener.OnCloseDoc();
        }
    }

    private void OnPageMove(int nCurrentPage, int nTotalPage, int nErrorCode) {
        IGetConfig(this.mInterface.m11EV().getConfigInfo());
        if (this.mDvListener != null) {
            this.mDvListener.OnPageMove(nCurrentPage, nTotalPage, nErrorCode);
        }
    }

    private void OnProgressStart(int EV_PROGRESS_TYPE) {
        if (this.mDvListener != null) {
            this.mDvListener.OnProgressStart(EV_PROGRESS_TYPE);
        }
    }

    private void OnProgress(int EV_PROGRESS_TYPE, int nProgressValue) {
        if (this.mDvListener != null) {
            this.mDvListener.OnProgress(EV_PROGRESS_TYPE, nProgressValue);
        }
    }

    private void OnTerminate() {
        if (this.mDvListener != null) {
            this.mDvListener.OnTerminate();
        }
    }

    private void OnPrintMode(String strPrintFile) {
        if (this.mDvListener != null) {
            this.mDvListener.OnPrintMode(strPrintFile);
        }
    }

    private void OnPrintedCount(int nTotalCount) {
        if (this.mDvListener != null) {
            this.mDvListener.OnPrintedCount(nTotalCount);
        }
    }

    private Bitmap GetBitmap(int w, int h, boolean a_bTrue) {
        if (this.mDvListener != null) {
            return this.mDvListener.GetBitmap(w, h);
        }
        return null;
    }

    private void OnDrawBitmap(int nCallId, int bShowAutomap, int nCurrentMode) {
        IGetConfig(this.mInterface.m11EV().getConfigInfo());
        if (this.mDvListener != null && nCallId != 65535) {
            this.mDvListener.OnDrawBitmap(nCallId, bShowAutomap);
        }
    }

    private String OnGetResStringID(int nStrID) {
        return "";
    }

    private String OnGetDeviceInfo() {
        return Build.MODEL;
    }

    private void OnTimerStart() {
        if (this.mInterface != null) {
            this.mInterface.OnTimerStart();
        }
    }

    private void OnTimerStop() {
        if (this.mInterface != null) {
            this.mInterface.OnTimerStop();
        }
    }
}
