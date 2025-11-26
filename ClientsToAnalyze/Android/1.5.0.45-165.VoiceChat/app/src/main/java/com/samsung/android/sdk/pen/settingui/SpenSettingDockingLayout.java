package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.SpenSettingViewInterface;
import com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2;
import com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2;
import com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout2;
import com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class SpenSettingDockingLayout extends LinearLayout {
    protected static int mSdkVersion = Build.VERSION.SDK_INT;
    protected SPenImageUtil mDrawableImg;
    private boolean mEnable;
    private Listener mListener;
    private SpenSettingPenLayout2 mPenSettingView;
    private SpenSettingRemoverLayout2 mRemoverSettingView;
    private SpenSettingSelectionLayout2 mSelectionSettingView;
    private SpenSettingTextLayout2 mTextSettingView;

    public interface Listener {
        public static final int MODE_ERASER = 2;
        public static final int MODE_PEN = 1;
        public static final int MODE_SELECTION = 4;
        public static final int MODE_TEXT = 3;

        void onClearAll();

        void onPopup(int i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.mEnable) {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        if (this.mEnable) {
            setTopBottomToZeroMarginItem();
            super.onConfigurationChanged(newConfig);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        if (this.mEnable) {
            setTopBottomToZeroMarginItem();
            super.onVisibilityChanged(changedView, visibility);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopBottomToZeroMarginItem() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingDockingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LinearLayout.LayoutParams textParam = (LinearLayout.LayoutParams) SpenSettingDockingLayout.this.mTextSettingView.getLayoutParams();
                    textParam.topMargin = 0;
                    textParam.bottomMargin = 0;
                    SpenSettingDockingLayout.this.mTextSettingView.setLayoutParams(textParam);
                    LinearLayout.LayoutParams eraserParam = (LinearLayout.LayoutParams) SpenSettingDockingLayout.this.mRemoverSettingView.getLayoutParams();
                    eraserParam.topMargin = 0;
                    eraserParam.bottomMargin = 0;
                    SpenSettingDockingLayout.this.mRemoverSettingView.setLayoutParams(eraserParam);
                    LinearLayout.LayoutParams selectionParam = (LinearLayout.LayoutParams) SpenSettingDockingLayout.this.mSelectionSettingView.getLayoutParams();
                    selectionParam.topMargin = 0;
                    selectionParam.bottomMargin = 0;
                    SpenSettingDockingLayout.this.mSelectionSettingView.setLayoutParams(selectionParam);
                } catch (NullPointerException e) {
                }
            }
        }, 100L);
    }

    public SpenSettingDockingLayout(Context context, HashMap<String, Integer> resourceIds, HashMap<String, String> fontName, String imagePath, RelativeLayout canvasLayout) {
        super(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int deviceWidth = displayMetrics.widthPixels;
        int deviceHeight = displayMetrics.heightPixels;
        if (deviceWidth < 1600 || deviceHeight < 1600) {
            Toast.makeText(context, "It does not support the current resolution.", 0).show();
            this.mEnable = false;
            return;
        }
        this.mEnable = true;
        this.mDrawableImg = new SPenImageUtil(context, imagePath, 1.0f);
        this.mPenSettingView = new SpenSettingPenLayout2(context, imagePath, canvasLayout, 1.0f);
        this.mTextSettingView = new SpenSettingTextLayout2(context, imagePath, fontName, canvasLayout, 1.0f);
        this.mRemoverSettingView = new SpenSettingRemoverLayout2(context, imagePath, canvasLayout, 1.0f);
        this.mSelectionSettingView = new SpenSettingSelectionLayout2(context, imagePath, canvasLayout, 1.0f);
        if (mSdkVersion < 16) {
            setBackgroundDrawable(this.mDrawableImg.setDrawableImg("vienna_popup_bg"));
        } else {
            setBackground(this.mDrawableImg.setDrawableImg("vienna_popup_bg"));
        }
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        setOrientation(1);
        addView(this.mPenSettingView);
        addView(this.mTextSettingView);
        addView(this.mRemoverSettingView);
        addView(this.mSelectionSettingView);
        this.mPenSettingView.setVisibility(0);
        this.mTextSettingView.setVisibility(0);
        this.mRemoverSettingView.setVisibility(0);
        this.mSelectionSettingView.setVisibility(0);
        this.mPenSettingView.setPopup(true);
        this.mTextSettingView.setPopup(false);
        this.mRemoverSettingView.setPopup(false);
        this.mSelectionSettingView.setPopup(false);
        this.mPenSettingView.setPopupListenr(new onPenPopupListener(this, null));
        this.mTextSettingView.setPopupListenr(new onTextPopupListener(this, null));
        this.mRemoverSettingView.setPopupListenr(new onRemoverPopupListener(this, null));
        this.mSelectionSettingView.setPopupListenr(new onSelectPopupListener(this, null));
        this.mRemoverSettingView.setEraserListener(new onEraserClearListener());
        this.mListener = null;
    }

    public void close() throws IOException {
        if (this.mEnable) {
            if (this.mPenSettingView != null) {
                this.mPenSettingView.close();
                this.mPenSettingView = null;
            }
            if (this.mTextSettingView != null) {
                this.mTextSettingView.close();
                this.mTextSettingView = null;
            }
            if (this.mSelectionSettingView != null) {
                this.mSelectionSettingView.close();
                this.mSelectionSettingView = null;
            }
            if (this.mRemoverSettingView != null) {
                this.mRemoverSettingView.close();
                this.mRemoverSettingView = null;
            }
        }
    }

    public void setSpenView(SpenSettingViewInterface spenView) {
        if (this.mEnable) {
            this.mPenSettingView.setCanvasView(spenView);
            this.mTextSettingView.setCanvasView(spenView);
            this.mRemoverSettingView.setCanvasView(spenView);
            this.mSelectionSettingView.setCanvasView(spenView);
        }
    }

    public void setPopupMode(int mode) {
        if (this.mEnable) {
            switch (mode) {
                case 1:
                    this.mPenSettingView.setPopup(true);
                    this.mTextSettingView.setPopup(false);
                    this.mRemoverSettingView.setPopup(false);
                    this.mSelectionSettingView.setPopup(false);
                    if (this.mListener != null) {
                        this.mListener.onPopup(1);
                        break;
                    }
                    break;
                case 2:
                    this.mPenSettingView.setPopup(false);
                    this.mTextSettingView.setPopup(false);
                    this.mRemoverSettingView.setPopup(true);
                    this.mSelectionSettingView.setPopup(false);
                    if (this.mListener != null) {
                        this.mListener.onPopup(2);
                        break;
                    }
                    break;
                case 3:
                    this.mPenSettingView.setPopup(false);
                    this.mTextSettingView.setPopup(true);
                    this.mRemoverSettingView.setPopup(false);
                    this.mSelectionSettingView.setPopup(false);
                    if (this.mListener != null) {
                        this.mListener.onPopup(3);
                        break;
                    }
                    break;
                case 4:
                    this.mPenSettingView.setPopup(false);
                    this.mTextSettingView.setPopup(false);
                    this.mRemoverSettingView.setPopup(false);
                    this.mSelectionSettingView.setPopup(true);
                    if (this.mListener != null) {
                        this.mListener.onPopup(4);
                        break;
                    }
                    break;
                default:
                    this.mPenSettingView.setPopup(true);
                    this.mTextSettingView.setPopup(false);
                    this.mRemoverSettingView.setPopup(false);
                    this.mSelectionSettingView.setPopup(false);
                    if (this.mListener != null) {
                        this.mListener.onPopup(1);
                        break;
                    }
                    break;
            }
        }
    }

    public void setPosition(int x, int y) {
        if (this.mEnable) {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();
            params.leftMargin = x;
            params.topMargin = y;
            setLayoutParams(params);
        }
    }

    public void setListener(Listener listener) {
        if (this.mEnable && listener != null) {
            this.mListener = listener;
        }
    }

    public void setPenInfo(SpenSettingPenInfo settingInfo) throws NumberFormatException {
        if (this.mEnable) {
            this.mPenSettingView.setInfo(settingInfo);
        }
    }

    public void setPenInfoList(List<SpenSettingPenInfo> list) {
        if (this.mEnable) {
            this.mPenSettingView.setPenInfoList(list);
        }
    }

    public void setTextInfo(SpenSettingTextInfo settingInfo) {
        if (this.mEnable) {
            this.mTextSettingView.setInfo(settingInfo);
        }
    }

    public void setEraserInfo(SpenSettingRemoverInfo settingInfo) {
        if (this.mEnable) {
            this.mRemoverSettingView.setInfo(settingInfo);
        }
    }

    public void setSelectionInfo(SpenSettingSelectionInfo settingInfo) {
        if (this.mEnable) {
            this.mSelectionSettingView.setInfo(settingInfo);
        }
    }

    private class onPenPopupListener implements SpenSettingPenLayout2.PopupListener {
        private onPenPopupListener() {
        }

        /* synthetic */ onPenPopupListener(SpenSettingDockingLayout spenSettingDockingLayout, onPenPopupListener onpenpopuplistener) {
            this();
        }

        @Override // com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout2.PopupListener
        public void onPopup(boolean open) {
            if (!open) {
                SpenSettingDockingLayout.this.mPenSettingView.setPopup(false);
            } else {
                SpenSettingDockingLayout.this.mTextSettingView.setPopup(false);
                SpenSettingDockingLayout.this.mRemoverSettingView.setPopup(false);
                SpenSettingDockingLayout.this.mSelectionSettingView.setPopup(false);
                SpenSettingDockingLayout.this.mPenSettingView.setPopup(true);
                if (SpenSettingDockingLayout.this.mListener != null) {
                    SpenSettingDockingLayout.this.mListener.onPopup(1);
                }
            }
            SpenSettingDockingLayout.this.setTopBottomToZeroMarginItem();
        }
    }

    private class onTextPopupListener implements SpenSettingTextLayout2.PopupListener {
        private onTextPopupListener() {
        }

        /* synthetic */ onTextPopupListener(SpenSettingDockingLayout spenSettingDockingLayout, onTextPopupListener ontextpopuplistener) {
            this();
        }

        @Override // com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.PopupListener
        public void onPopup(boolean open) {
            if (open) {
                SpenSettingDockingLayout.this.mPenSettingView.setPopup(false);
                SpenSettingDockingLayout.this.mRemoverSettingView.setPopup(false);
                SpenSettingDockingLayout.this.mSelectionSettingView.setPopup(false);
                SpenSettingDockingLayout.this.mTextSettingView.setPopup(true);
                if (SpenSettingDockingLayout.this.mListener != null) {
                    SpenSettingDockingLayout.this.mListener.onPopup(3);
                }
            } else {
                SpenSettingDockingLayout.this.mTextSettingView.setPopup(false);
            }
            SpenSettingDockingLayout.this.setTopBottomToZeroMarginItem();
        }
    }

    private class onRemoverPopupListener implements SpenSettingRemoverLayout2.PopupListener {
        private onRemoverPopupListener() {
        }

        /* synthetic */ onRemoverPopupListener(SpenSettingDockingLayout spenSettingDockingLayout, onRemoverPopupListener onremoverpopuplistener) {
            this();
        }

        @Override // com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.PopupListener
        public void onPopup(boolean open) {
            if (open) {
                SpenSettingDockingLayout.this.mPenSettingView.setPopup(false);
                SpenSettingDockingLayout.this.mTextSettingView.setPopup(false);
                SpenSettingDockingLayout.this.mSelectionSettingView.setPopup(false);
                SpenSettingDockingLayout.this.mRemoverSettingView.setPopup(true);
                if (SpenSettingDockingLayout.this.mListener != null) {
                    SpenSettingDockingLayout.this.mListener.onPopup(2);
                }
            } else {
                SpenSettingDockingLayout.this.mRemoverSettingView.setPopup(false);
            }
            SpenSettingDockingLayout.this.setTopBottomToZeroMarginItem();
        }
    }

    private class onSelectPopupListener implements SpenSettingSelectionLayout2.PopupListener {
        private onSelectPopupListener() {
        }

        /* synthetic */ onSelectPopupListener(SpenSettingDockingLayout spenSettingDockingLayout, onSelectPopupListener onselectpopuplistener) {
            this();
        }

        @Override // com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout2.PopupListener
        public void onPopup(boolean open) {
            if (open) {
                SpenSettingDockingLayout.this.mPenSettingView.setPopup(false);
                SpenSettingDockingLayout.this.mTextSettingView.setPopup(false);
                SpenSettingDockingLayout.this.mRemoverSettingView.setPopup(false);
                SpenSettingDockingLayout.this.mSelectionSettingView.setPopup(true);
                if (SpenSettingDockingLayout.this.mListener != null) {
                    SpenSettingDockingLayout.this.mListener.onPopup(4);
                }
            } else {
                SpenSettingDockingLayout.this.mSelectionSettingView.setPopup(false);
            }
            SpenSettingDockingLayout.this.setTopBottomToZeroMarginItem();
        }
    }

    class onEraserClearListener implements SpenSettingRemoverLayout2.EventListener {
        onEraserClearListener() {
        }

        @Override // com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout2.EventListener
        public void onClearAll() {
            if (SpenSettingDockingLayout.this.mListener != null) {
                SpenSettingDockingLayout.this.mListener.onClearAll();
            }
        }
    }
}
