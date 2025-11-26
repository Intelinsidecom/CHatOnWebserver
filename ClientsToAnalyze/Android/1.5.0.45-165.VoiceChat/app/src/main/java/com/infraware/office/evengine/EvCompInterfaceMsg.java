package com.infraware.office.evengine;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.infraware.office.evengine.C0508EV;
import com.infraware.office.evengine.EvListener;

/* loaded from: classes.dex */
class EvCompInterfaceMsg extends EvInterface {
    protected final HandlerTask mHandler;
    private String versionCode;
    private String versionTAG;

    protected class HandlerTask extends Handler {
        private static final int PREVIEW_TIMER = 1;
        private static final int RUNTIMER = 0;
        private boolean mbAlive = false;
        private boolean mbPreview = false;

        protected HandlerTask() {
        }

        void setOperationTimer(boolean bStart) {
            this.mbAlive = bStart;
            if (this.mbAlive) {
                sendEmptyMessage(0);
            } else {
                removeMessages(0);
            }
        }

        void setPreviewTimer(boolean bStart) {
            this.mbPreview = bStart;
            if (this.mbPreview) {
                sendEmptyMessage(1);
            } else {
                removeMessages(1);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            removeMessages(0);
            switch (msg.what) {
                case 0:
                    if (this.mbAlive && EvCompInterfaceMsg.this.mbSuspend == 0) {
                        EvCompInterfaceMsg.this.Native.ITimer();
                    }
                    if (this.mbAlive && EvCompInterfaceMsg.this.mbSuspend == 0) {
                        sendEmptyMessageDelayed(0, 1L);
                        break;
                    }
                    break;
                case 1:
                    if (this.mbPreview) {
                    }
                    if (this.mbPreview && EvCompInterfaceMsg.this.mbSuspend == 0) {
                        sendEmptyMessageDelayed(1, 1L);
                        break;
                    }
                    break;
            }
        }
    }

    @Override // com.infraware.office.evengine.EvInterface
    void OnTimerStart() {
        this.mHandler.setOperationTimer(true);
    }

    @Override // com.infraware.office.evengine.EvInterface
    void OnTimerStop() {
        this.mHandler.setOperationTimer(false);
    }

    protected EvCompInterfaceMsg(String AppDir) {
        super(AppDir);
        this.versionTAG = "OFFICESDK5VERSION_VoiceService";
        this.versionCode = "5.0.12.16.01R";
        this.mHandler = new HandlerTask();
    }

    @Override // com.infraware.office.evengine.EvInterface
    public void ISetHeapSize(int a_nHeapSize) {
        super.ISetHeapSize(a_nHeapSize);
        this.Native.ISetHeapSize(a_nHeapSize);
    }

    @Override // com.infraware.office.evengine.EvInterface
    public void ISetListener(EvListener.ViewerListener DvL) {
        this.Native.SetListener(DvL);
    }

    @Override // com.infraware.office.evengine.EvInterface
    protected void OnInitComplete(int EEV_ERROR_CODE) {
        super.OnInitComplete(EEV_ERROR_CODE);
    }

    @Override // com.infraware.office.evengine.EvInterface
    public void IInitialize(int a_nWidth, int a_nHeight, int a_nDpi) {
        super.IInitialize(a_nWidth, a_nHeight, a_nDpi);
        if (!isInit()) {
            this.Native.IInitialize(a_nWidth, a_nHeight, 0, 1, 1, 16, 0, a_nDpi);
        }
    }

    @Override // com.infraware.office.evengine.EvInterface
    public void IFinalize() {
        if (isInit()) {
            this.Native.IFinalize();
        }
    }

    @Override // com.infraware.office.evengine.EvInterface
    public void IOpen(String a_sFilePath, int a_nWidth, int a_nHeight, int EEV_FILE_LOAD_TYPE, int a_nLocale, int bLandScape, String a_sTempPath, String a_sBookMarkPath, String a_sBookClipPath) {
        Log.i(this.versionTAG, this.versionCode);
        this.Native.IOpen(a_sFilePath, a_nWidth, a_nHeight, EEV_FILE_LOAD_TYPE, 0, 0, 0, 0, 0, 0, 0, a_nLocale, bLandScape, a_sTempPath, a_sBookMarkPath);
    }

    @Override // com.infraware.office.evengine.EvInterface
    public void IOpenEx(String a_sFilePath, String a_sPassword, int a_nLocale, int a_bLandScape, String a_sTempPath, String a_sBookMarkPath, String a_sBookClipPath) {
        this.Native.IOpenEx(a_sFilePath, a_sPassword);
    }

    @Override // com.infraware.office.evengine.EvInterface
    public void IClose() {
        this.Native.IClose();
        this.mHandler.setOperationTimer(false);
        super.IClose();
    }

    @Override // com.infraware.office.evengine.EvInterface
    public void ICancel() {
        this.Native.ICancel();
    }

    @Override // com.infraware.office.evengine.EvInterface
    public C0508EV.CONFIG_INFO IGetConfig() {
        return this.f61Ev.getConfigInfo();
    }

    @Override // com.infraware.office.evengine.EvInterface
    public void ISetPrint(int a_PaperSize, int a_StartPage, int a_EndPage, String a_szFilePath, int a_ReturnType) {
        this.Native.ISetPrint(a_PaperSize, a_StartPage, a_EndPage, a_szFilePath, a_ReturnType);
    }

    @Override // com.infraware.office.evengine.EvInterface
    public void ISetPrintEx(int a_PaperSize, int a_StartPage, int a_EndPage, String a_szFilePath, int a_ReturnType, int a_margin, String a_szPageBoundary, String a_szOutputPath) {
        this.Native.ISetPrintEx(a_PaperSize, a_StartPage, a_EndPage, a_szFilePath, a_ReturnType, a_szPageBoundary, a_szOutputPath, a_margin, a_margin, a_margin, a_margin);
    }

    @Override // com.infraware.office.evengine.EvInterface
    public void ISetWHByPrint(int a_StartPage, int a_EndPage, String a_szFilePath, int a_RetrunType, String a_szOutputPath, int a_nWidth, int a_nHeight) {
        this.Native.ISetThumbnailByPrint(a_StartPage, a_EndPage, a_szFilePath, a_RetrunType, null, a_szOutputPath, a_nWidth, a_nHeight);
    }
}
