package com.coolots.chaton.call.screenshare.util;

import android.app.Service;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.core.OverlayView;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class PenMenuView3 extends OverlayView implements DisposeInterface {
    private static final String CLASSNAME = "[PenMenuView]";
    private boolean isHidden;
    private View.OnClickListener mBtnClickListener;
    PenWritingCallBack mCallback;
    private ImageView mCaptureBtn;
    private ImageView mClearBtn;
    private Button mEndBtn;
    private ImageView mEraserBtn;
    private ImageView mHideBtn;
    boolean mIsConference;
    public ImageView mPenBtn;
    public RelativeLayout mPenBtnLayout;
    public View mPenColor;
    public PenWritingCapture mPenWritingCapture;
    public ImageView mRedoBtn;
    private ScreenShareScale mScreenScale;
    public RelativeLayout mToolBarLayout;
    private LinearLayout mToolbarBtnLayout;
    private LinearLayout mToolbarCaptureLayout;
    public ImageView mUndoBtn;
    private View.OnClickListener undoNredoBtnClickListener;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public PenMenuView3(Service service) {
        super(service, C0000R.layout.screenshare_pen_menu);
        this.isHidden = false;
        this.mIsConference = false;
        this.undoNredoBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.PenMenuView3.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(PenMenuView3.this.mUndoBtn)) {
                    PenMenuView3.this.mCallback.undoNredoClicked(true);
                } else if (v.equals(PenMenuView3.this.mRedoBtn)) {
                    PenMenuView3.this.mCallback.undoNredoClicked(false);
                }
            }
        };
        this.mBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.PenMenuView3.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PenMenuView3.this.mCallback.btnClicked(v);
            }
        };
        Destination destination = MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination();
        if (destination != null && destination.getDestinationType() == 4) {
            this.mIsConference = true;
        }
        load();
    }

    public void setCallback(PenWritingCallBack cb) {
        this.mCallback = cb;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void setupLayoutParams() {
        logI("setupLayoutParams()");
        this.layoutParams = new WindowManager.LayoutParams(-1, -2, 2021, 262440, -3);
        this.layoutParams.gravity = 51;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onInflateView() {
        logI("onInflateView()");
        this.mContext = getService().getApplicationContext();
        this.mPenBtn = (ImageView) findViewById(C0000R.id.pen_btn);
        this.mEraserBtn = (ImageView) findViewById(C0000R.id.eraser_btn);
        this.mUndoBtn = (ImageView) findViewById(C0000R.id.undo_btn);
        this.mRedoBtn = (ImageView) findViewById(C0000R.id.redo_btn);
        this.mCaptureBtn = (ImageView) findViewById(C0000R.id.camera_btn);
        this.mClearBtn = (ImageView) findViewById(C0000R.id.clear_btn);
        this.mEndBtn = (Button) findViewById(C0000R.id.end_btn);
        this.mHideBtn = (ImageView) findViewById(C0000R.id.showhide_btn);
        this.mToolBarLayout = (RelativeLayout) findViewById(C0000R.id.pen_menu_view);
        this.mPenBtnLayout = (RelativeLayout) findViewById(C0000R.id.pen_btn_layout);
        this.mPenBtn.setOnClickListener(this.mBtnClickListener);
        this.mEraserBtn.setOnClickListener(this.mBtnClickListener);
        this.mCaptureBtn.setOnClickListener(this.mBtnClickListener);
        this.mClearBtn.setOnClickListener(this.mBtnClickListener);
        this.mEndBtn.setOnClickListener(this.mBtnClickListener);
        this.mHideBtn.setOnClickListener(this.mBtnClickListener);
        this.mUndoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mRedoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mToolbarBtnLayout = (LinearLayout) findViewById(C0000R.id.share_view_toolbar_layout);
        this.mToolbarCaptureLayout = (LinearLayout) findViewById(C0000R.id.camera_btn_layout);
        this.mPenColor = findViewById(C0000R.id.pen_color_bar);
        this.mUndoBtn.setEnabled(false);
        this.mRedoBtn.setEnabled(false);
        this.mPenBtn.setSelected(true);
        this.mPenWritingCapture = new PenWritingCapture();
        btnHidden(true);
    }

    public void btnHidden(boolean ishidden) {
        if (!ishidden) {
            this.mToolbarBtnLayout.setVisibility(8);
            this.mToolbarCaptureLayout.setVisibility(8);
            this.mHideBtn.setImageResource(C0000R.drawable.screenshare_penwriting_toolbar_hide_selector);
            this.mHideBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.video_option_menu_show));
            this.isHidden = true;
            return;
        }
        this.mToolbarBtnLayout.setVisibility(0);
        this.mToolbarCaptureLayout.setVisibility(0);
        this.mHideBtn.setImageResource(C0000R.drawable.screenshare_penwriting_toolbar_show_selector);
        this.mHideBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.video_option_menu_hide));
        this.isHidden = false;
    }

    public void btnHidden() {
        btnHidden(this.isHidden);
    }

    public void setUserID(int userid) {
        this.mUserId = userid;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mToolBarLayout != null) {
            this.mToolBarLayout = null;
        }
        if (this.mPenBtnLayout != null) {
            this.mPenBtnLayout = null;
        }
        if (this.mToolbarBtnLayout != null) {
            this.mToolbarBtnLayout = null;
        }
        if (this.mToolbarCaptureLayout != null) {
            this.mToolbarCaptureLayout = null;
        }
        if (this.mPenBtn != null) {
            this.mPenBtn.removeCallbacks(null);
            this.mPenBtn = null;
        }
        if (this.mEraserBtn != null) {
            this.mEraserBtn.removeCallbacks(null);
            this.mEraserBtn = null;
        }
        if (this.mUndoBtn != null) {
            this.mUndoBtn.removeCallbacks(null);
            this.mUndoBtn = null;
        }
        if (this.mRedoBtn != null) {
            this.mRedoBtn.removeCallbacks(null);
            this.mRedoBtn = null;
        }
        if (this.mCaptureBtn != null) {
            this.mCaptureBtn.removeCallbacks(null);
            this.mCaptureBtn = null;
        }
        if (this.mClearBtn != null) {
            this.mClearBtn.removeCallbacks(null);
            this.mClearBtn = null;
        }
        if (this.mEndBtn != null) {
            this.mEndBtn.removeCallbacks(null);
            this.mEndBtn = null;
        }
        if (this.mHideBtn != null) {
            this.mHideBtn.removeCallbacks(null);
            this.mHideBtn = null;
        }
        if (this.mPenColor != null) {
            this.mPenColor.removeCallbacks(null);
            this.mPenColor = null;
        }
        if (this.mScreenScale != null) {
            this.mScreenScale = null;
        }
    }

    public void updateBtnState(View v) {
        this.mPenBtn.setSelected(false);
        this.mEraserBtn.setSelected(false);
        this.mClearBtn.setSelected(false);
        v.setSelected(true);
    }
}
