package com.coolots.chaton.call.screenshare.util;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.coolots.chaton.call.screenshare.ScreenShareProc;
import com.samsung.android.sdk.pen.SpenSettingEraserInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.SpenSettingViewInterface;
import com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout;
import com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout;
import com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout;
import com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout;
import com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class SettingView extends FrameLayout {
    private static final String CLASSNAME = "[SettingView]";
    public static final int MODE_CUTTER = 4;
    public static final int MODE_ERASER = 2;
    public static final int MODE_PEN = 1;
    public static final int MODE_SELECTION = 5;
    public static final int MODE_TEXT = 3;
    private SpenSettingRemoverInfo[] mCutterDataList;
    private SpenSettingRemoverLayout mCutterSettingView;
    private SpenSettingEraserInfo[] mEraserDataList;
    private SpenSettingEraserLayout mEraserSettingView;
    private SpenSettingPenLayout mPenSettingView;
    private SpenSettingSelectionLayout mSelectionSettingView;
    private SpenSettingTextLayout mTextSettingView;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public SettingView(Context context, RelativeLayout canvasLayout, String customImagePath, HashMap<String, String> fontName) {
        super(context);
        initSettingView(context, canvasLayout, customImagePath, fontName);
    }

    public SettingView(Context context, RelativeLayout canvasLayout) {
        super(context);
        initSettingView(context, canvasLayout, createImagePath(), createFontName());
    }

    public SettingView(Context context, RelativeLayout canvasLayout, String customImagePath) {
        super(context);
        initSettingView(context, canvasLayout, customImagePath, createFontName());
    }

    public SettingView(Context context, RelativeLayout canvasLayout, HashMap<String, String> fontName) {
        super(context);
        initSettingView(context, canvasLayout, createImagePath(), fontName);
    }

    private static HashMap<String, String> createFontName() {
        HashMap<String, String> custFontName = new HashMap<>();
        return custFontName;
    }

    private static String createImagePath() {
        String custImagePath = new String();
        return custImagePath;
    }

    private void initSettingView(Context context, RelativeLayout canvasLayout, String customImagePath, HashMap<String, String> fontName) {
        try {
            this.mPenSettingView = new SpenSettingPenLayout(context, customImagePath, canvasLayout);
            this.mEraserSettingView = new SpenSettingEraserLayout(context, customImagePath, canvasLayout);
            this.mTextSettingView = new SpenSettingTextLayout(context, customImagePath, fontName, canvasLayout);
            this.mCutterSettingView = new SpenSettingRemoverLayout(context, customImagePath, canvasLayout);
            this.mSelectionSettingView = new SpenSettingSelectionLayout(context, customImagePath, canvasLayout);
            this.mEraserDataList = new SpenSettingEraserInfo[2];
            SpenSettingEraserInfo penEraser = new SpenSettingEraserInfo();
            SpenSettingEraserInfo textEraser = new SpenSettingEraserInfo();
            penEraser.size = 10.0f;
            penEraser.type = 0;
            textEraser.size = 10.0f;
            textEraser.type = 1;
            this.mEraserDataList[0] = penEraser;
            this.mEraserDataList[1] = textEraser;
            this.mEraserSettingView.setEraserInfoList(this.mEraserDataList);
            this.mCutterDataList = new SpenSettingRemoverInfo[2];
            SpenSettingRemoverInfo cutCutter = new SpenSettingRemoverInfo();
            SpenSettingRemoverInfo removeCutter = new SpenSettingRemoverInfo();
            cutCutter.size = 20.0f;
            cutCutter.type = 0;
            removeCutter.size = 20.0f;
            removeCutter.type = 1;
            this.mCutterDataList[0] = cutCutter;
            this.mCutterDataList[1] = removeCutter;
            this.mCutterSettingView.setRemoverInfoList(this.mCutterDataList);
            addView(this.mPenSettingView);
            addView(this.mEraserSettingView);
            addView(this.mTextSettingView);
            addView(this.mCutterSettingView);
            addView(this.mSelectionSettingView);
        } catch (Exception e) {
            MainApplication.mPhoneManager.getShareScreenManager().stopShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination());
            ScreenShareProc.stopScreenShare();
        }
    }

    public boolean isSettingViewVisible(int nWhichSettingView) {
        switch (nWhichSettingView) {
            case 1:
                return this.mPenSettingView.isShown();
            case 2:
                return this.mEraserSettingView.isShown();
            case 3:
                return this.mTextSettingView.isShown();
            case 4:
                return this.mCutterSettingView.isShown();
            case 5:
                return this.mSelectionSettingView.isShown();
            default:
                return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setCanvasView(SpenSettingViewInterface canvasView) {
        this.mPenSettingView.setCanvasView(canvasView);
        this.mTextSettingView.setCanvasView(canvasView);
        this.mEraserSettingView.setCanvasView(canvasView);
        this.mCutterSettingView.setCanvasView(canvasView);
        this.mSelectionSettingView.setCanvasView(canvasView);
    }

    public boolean toggleShowSettingView(int type, int viewMode) {
        if (type < 1 || type > 5) {
            return false;
        }
        if (isSettingViewVisible(type)) {
            closeSettingView();
            return true;
        }
        setViewMode(type, viewMode);
        return true;
    }

    public void showSettingView(int type) {
        switch (type) {
            case 1:
                this.mEraserSettingView.setVisibility(8);
                this.mTextSettingView.setVisibility(8);
                this.mPenSettingView.setVisibility(0);
                this.mCutterSettingView.setVisibility(8);
                this.mSelectionSettingView.setVisibility(8);
                break;
            case 2:
                this.mEraserSettingView.setVisibility(0);
                this.mTextSettingView.setVisibility(8);
                this.mPenSettingView.setVisibility(8);
                this.mCutterSettingView.setVisibility(8);
                this.mSelectionSettingView.setVisibility(8);
                break;
            case 3:
                this.mEraserSettingView.setVisibility(8);
                this.mTextSettingView.setVisibility(0);
                this.mPenSettingView.setVisibility(8);
                this.mCutterSettingView.setVisibility(8);
                this.mSelectionSettingView.setVisibility(8);
                break;
            case 4:
                this.mEraserSettingView.setVisibility(8);
                this.mCutterSettingView.setVisibility(0);
                this.mTextSettingView.setVisibility(8);
                this.mPenSettingView.setVisibility(8);
                this.mSelectionSettingView.setVisibility(8);
                break;
            case 5:
                this.mEraserSettingView.setVisibility(8);
                this.mCutterSettingView.setVisibility(8);
                this.mTextSettingView.setVisibility(8);
                this.mPenSettingView.setVisibility(8);
                this.mSelectionSettingView.setVisibility(0);
                break;
        }
    }

    public void setViewMode(int type, int viewMode) {
        switch (type) {
            case 1:
                this.mEraserSettingView.setVisibility(8);
                this.mTextSettingView.setVisibility(8);
                this.mPenSettingView.setVisibility(0);
                this.mCutterSettingView.setVisibility(8);
                this.mSelectionSettingView.setVisibility(8);
                this.mPenSettingView.setViewMode(viewMode);
                break;
            case 2:
                this.mEraserSettingView.setVisibility(0);
                this.mTextSettingView.setVisibility(8);
                this.mPenSettingView.setVisibility(8);
                this.mCutterSettingView.setVisibility(8);
                this.mSelectionSettingView.setVisibility(8);
                this.mEraserSettingView.setViewMode(viewMode);
                break;
            case 3:
                this.mEraserSettingView.setVisibility(8);
                this.mTextSettingView.setVisibility(0);
                this.mPenSettingView.setVisibility(8);
                this.mCutterSettingView.setVisibility(8);
                this.mSelectionSettingView.setVisibility(8);
                this.mTextSettingView.setViewMode(viewMode);
                break;
            case 4:
                this.mEraserSettingView.setVisibility(8);
                this.mCutterSettingView.setVisibility(0);
                this.mTextSettingView.setVisibility(8);
                this.mPenSettingView.setVisibility(8);
                this.mSelectionSettingView.setVisibility(8);
                this.mCutterSettingView.setViewMode(viewMode);
                break;
            case 5:
                this.mEraserSettingView.setVisibility(8);
                this.mCutterSettingView.setVisibility(8);
                this.mTextSettingView.setVisibility(8);
                this.mPenSettingView.setVisibility(8);
                this.mSelectionSettingView.setVisibility(0);
                this.mSelectionSettingView.setViewMode(viewMode);
                break;
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        if (!this.mPenSettingView.isShown() && !this.mEraserSettingView.isShown() && !this.mTextSettingView.isShown() && !this.mCutterSettingView.isShown() && !this.mSelectionSettingView.isShown()) {
            return false;
        }
        return true;
    }

    public void closeSettingView() {
        this.mEraserSettingView.setVisibility(8);
        this.mTextSettingView.setVisibility(8);
        this.mPenSettingView.setVisibility(8);
        this.mCutterSettingView.setVisibility(8);
        this.mSelectionSettingView.setVisibility(8);
    }

    public int getViewMode(int type) {
        switch (type) {
            case 1:
                int viewMode = this.mPenSettingView.getViewMode();
                return viewMode;
            case 2:
                int viewMode2 = this.mEraserSettingView.getViewMode();
                return viewMode2;
            case 3:
                int viewMode3 = this.mTextSettingView.getViewMode();
                return viewMode3;
            case 4:
                int viewMode4 = this.mCutterSettingView.getViewMode();
                return viewMode4;
            case 5:
                int viewMode5 = this.mSelectionSettingView.getViewMode();
                return viewMode5;
            default:
                return -1;
        }
    }

    public void setSpenPenInfo(SpenSettingPenInfo settingInfo) {
        logI("panda     setSpenPenInfo settingInfo = " + settingInfo);
        this.mPenSettingView.setInfo(settingInfo);
    }

    public SpenSettingPenInfo getSpenPenInfo() {
        logI("panda     getSpenPenInfo mPenSettingView.getInfo() = " + this.mPenSettingView.getInfo());
        return this.mPenSettingView.getInfo();
    }

    public void setEraserInfo(SpenSettingEraserInfo settingInfo) {
        this.mEraserSettingView.setInfo(settingInfo);
    }

    public SpenSettingEraserInfo getEraserInfo() {
        return this.mEraserSettingView.getInfo();
    }

    public void setTextInfo(SpenSettingTextInfo settingInfo) {
        this.mTextSettingView.setInfo(settingInfo);
    }

    public SpenSettingTextInfo getTextInfo() {
        return this.mTextSettingView.getInfo();
    }

    public void setCutterInfo(SpenSettingRemoverInfo settingInfo) {
        this.mCutterDataList[settingInfo.type] = settingInfo;
        this.mCutterSettingView.setInfo(settingInfo);
    }

    public SpenSettingRemoverInfo getCutterInfo() {
        return this.mCutterSettingView.getInfo();
    }

    public void setSelectionInfo(SpenSettingSelectionInfo settingInfo) {
        this.mSelectionSettingView.setInfo(settingInfo);
    }

    public SpenSettingSelectionInfo getSelectionInfo() {
        return this.mSelectionSettingView.getInfo();
    }

    public void setEraserInfoList(SpenSettingEraserInfo[] settingInfoList) {
        this.mEraserDataList = settingInfoList;
        this.mEraserSettingView.setEraserInfoList(this.mEraserDataList);
    }

    public void setCutterInfoList(SpenSettingRemoverInfo[] settingInfoList) {
        this.mCutterDataList = settingInfoList;
        this.mCutterSettingView.setRemoverInfoList(this.mCutterDataList);
    }

    public void setEraserInfoList(SpenSettingEraserInfo settingInfo) {
        this.mEraserDataList[settingInfo.type] = settingInfo;
        this.mEraserSettingView.setEraserInfoList(this.mEraserDataList);
    }

    public void setCutterInfoList(SpenSettingRemoverInfo settingInfo) {
        this.mCutterDataList[settingInfo.type] = settingInfo;
        this.mCutterSettingView.setRemoverInfoList(this.mCutterDataList);
    }

    public void setSpenPenInfoList(ArrayList<SpenSettingPenInfo> mSpenSettingPenInfoList) {
        logI("panda     setSpenPenInfoList");
        this.mPenSettingView.setPenInfoList(mSpenSettingPenInfoList);
    }

    public void setPresetInfoList(ArrayList<SpenSettingPenInfo> list) {
        logI("panda     setPresetInfoList");
    }

    public SpenSettingPenLayout getSpenSettingPenLayout() {
        return this.mPenSettingView;
    }

    public SpenSettingTextLayout getSpenSettingTextLayout() {
        return this.mTextSettingView;
    }

    public SpenSettingEraserLayout getSpenSettingEraserLayout() {
        return this.mEraserSettingView;
    }

    public SpenSettingRemoverLayout getSpenSettingRemoverLayout() {
        return this.mCutterSettingView;
    }

    public SpenSettingSelectionLayout getSpenSettingSelectionLayout() {
        return this.mSelectionSettingView;
    }

    public void setEraserListener(SpenSettingEraserLayout.EventListener listener) {
        this.mEraserSettingView.setEraserListener(listener);
    }

    public void setCutterListener(SpenSettingRemoverLayout.EventListener listener) {
        this.mCutterSettingView.setRemoverListener(listener);
    }

    public void close() {
        if (this.mPenSettingView != null) {
            this.mPenSettingView.close();
        }
        if (this.mEraserSettingView != null) {
            this.mEraserSettingView.close();
        }
        if (this.mTextSettingView != null) {
            this.mTextSettingView.close();
        }
        if (this.mCutterSettingView != null) {
            this.mCutterSettingView.close();
        }
        if (this.mSelectionSettingView != null) {
            this.mSelectionSettingView.close();
        }
    }
}
