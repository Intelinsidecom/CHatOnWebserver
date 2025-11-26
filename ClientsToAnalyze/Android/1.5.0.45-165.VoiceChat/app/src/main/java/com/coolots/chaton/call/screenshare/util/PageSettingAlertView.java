package com.coolots.chaton.call.screenshare.util;

import android.app.Service;
import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.core.OverlayView;
import com.samsung.vip.engine.VIRecognitionLib;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class PageSettingAlertView extends OverlayView implements DisposeInterface {
    private static final String CLASSNAME = "[PageSettingAlertView]";
    private Button mAlertCancelBtn;
    private Button mAlertLeftArrowBtn;
    private Button mAlertOKBtn;
    private Button mAlertRightArrowBtn;
    private String mAlertTitle;
    private String mCancelBtnTitle;
    private boolean mCancelable;
    private LinearLayout mDialogViewLayout;
    private EditText mEditTextPage;
    private String mNeutralBtnTitle;
    private String mOKBtnTitle;
    private OnClickListener mOnClickListenerCancel;
    private OnClickListener mOnClickListenerLeftArrow;
    private OnClickListener mOnClickListenerOK;
    private OnClickListener mOnClickListenerRightArrow;
    private boolean mShowing;
    private TextView mTextTitle;

    public interface OnClickListener {
        void onClick(PageSettingAlertView pageSettingAlertView, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public PageSettingAlertView(Service service) {
        super(service, C0000R.layout.screenshare_page_setting_alert_view);
        this.mAlertTitle = null;
        this.mOKBtnTitle = null;
        this.mCancelBtnTitle = null;
        this.mNeutralBtnTitle = null;
        this.mCancelable = true;
        this.mShowing = false;
    }

    public PageSettingAlertView(Context context) {
        super(context, C0000R.layout.screenshare_page_setting_alert_view);
        this.mAlertTitle = null;
        this.mOKBtnTitle = null;
        this.mCancelBtnTitle = null;
        this.mNeutralBtnTitle = null;
        this.mCancelable = true;
        this.mShowing = false;
        this.mContext = context;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void setupLayoutParams() {
        logI("Elcyde setLayoutparams");
        this.layoutParams = new WindowManager.LayoutParams(-1, -1, 2021, VIRecognitionLib.VI_EQ_ENGINE_RAM_SIZE, -3);
        this.layoutParams.gravity = getGravity();
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView, android.widget.RelativeLayout
    public int getGravity() {
        return 51;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onInflateView() {
        this.mDialogViewLayout = (LinearLayout) findViewById(C0000R.id.alret_dialog_view);
        LinearLayout alertBtns = (LinearLayout) findViewById(C0000R.id.alert_btns);
        this.mTextTitle = (TextView) findViewById(C0000R.id.alert_title);
        this.mEditTextPage = (EditText) findViewById(C0000R.id.page_edit_text);
        this.mAlertOKBtn = (Button) findViewById(C0000R.id.alert_btn1);
        this.mAlertCancelBtn = (Button) findViewById(C0000R.id.alert_btn2);
        this.mAlertLeftArrowBtn = (Button) findViewById(C0000R.id.left_page_button);
        this.mAlertRightArrowBtn = (Button) findViewById(C0000R.id.right_page_button);
        if (this.mAlertTitle == null) {
            this.mDialogViewLayout.removeView(this.mTextTitle);
        } else {
            this.mTextTitle.setText(this.mAlertTitle);
        }
        if (this.mEditTextPage == null) {
            this.mDialogViewLayout.removeView(this.mEditTextPage);
        }
        if (this.mOKBtnTitle == null && this.mCancelBtnTitle == null && this.mNeutralBtnTitle == null) {
            this.mDialogViewLayout.removeView(alertBtns);
            return;
        }
        if (this.mOKBtnTitle == null) {
            alertBtns.removeView(this.mAlertOKBtn);
        } else {
            this.mAlertOKBtn.setText(this.mOKBtnTitle);
            this.mAlertOKBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.PageSettingAlertView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws Resources.NotFoundException {
                    PageSettingAlertView.this.logI("mAlertOKBtn.setOnClickListener(new View.OnClickListener()");
                    PageSettingAlertView.this.mOnClickListenerOK.onClick(PageSettingAlertView.this, 1);
                    PageSettingAlertView.this.dismiss();
                    PageSettingAlertView.this.setVisibility(8);
                }
            });
        }
        if (this.mCancelBtnTitle == null) {
            alertBtns.removeView(this.mAlertCancelBtn);
        } else {
            this.mAlertCancelBtn.setText(this.mCancelBtnTitle);
            this.mAlertCancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.PageSettingAlertView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) throws Resources.NotFoundException {
                    PageSettingAlertView.this.mOnClickListenerCancel.onClick(PageSettingAlertView.this, 2);
                    PageSettingAlertView.this.dismiss();
                }
            });
        }
        this.mAlertLeftArrowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.PageSettingAlertView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PageSettingAlertView.this.mOnClickListenerLeftArrow.onClick(PageSettingAlertView.this, 3);
            }
        });
        this.mAlertRightArrowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.PageSettingAlertView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PageSettingAlertView.this.mOnClickListenerRightArrow.onClick(PageSettingAlertView.this, 4);
            }
        });
        setCancelable(this.mCancelable);
    }

    public void setTitle(String title) {
        this.mAlertTitle = title;
    }

    public void setPageText(String pageText) {
        this.mEditTextPage.setText(pageText);
        this.mEditTextPage.setSelection(this.mEditTextPage.getText().length(), this.mEditTextPage.getText().length());
        this.mEditTextPage.setSelectAllOnFocus(true);
    }

    public void setPageTextFilter(IDocsViewTouchImage iDocsViewTouchImage) {
        this.mEditTextPage.addTextChangedListener(new PageTextFilter(this.mEditTextPage, iDocsViewTouchImage));
    }

    private class PageTextFilter implements TextWatcher {
        private String beforeText;
        private EditText editText;
        private IDocsViewTouchImage mIDocsViewTouchImage;

        public PageTextFilter(EditText et, IDocsViewTouchImage iDocsViewTouchImage) {
            this.mIDocsViewTouchImage = iDocsViewTouchImage;
            this.editText = et;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            if (s.toString().length() > 0) {
                if (s.charAt(0) == '0') {
                    this.editText.setText(this.beforeText);
                    this.editText.setSelection(this.beforeText.length() - 1);
                } else if (Integer.parseInt(s.toString()) > this.mIDocsViewTouchImage.getMaxPageNumber()) {
                    this.editText.setText(this.beforeText);
                    this.editText.setSelection(this.beforeText.length() - 1);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
            this.beforeText = s.toString();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
        }
    }

    public String getPageText() {
        return this.mEditTextPage.getText().toString();
    }

    public TextView getTextView() {
        return this.mEditTextPage;
    }

    public void setTitle(int resid) {
        this.mAlertTitle = getResources().getString(resid);
    }

    public void setMessage(int resid) {
        this.mEditTextPage.setText(getResources().getString(resid));
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void show() throws Resources.NotFoundException {
        logI("AlertView show ");
        this.mShowing = true;
        load();
        Animation animation = AnimationUtils.loadAnimation(getContext(), C0000R.anim.screenshare_zoom_in);
        animation.reset();
        this.mDialogViewLayout.clearAnimation();
        this.mDialogViewLayout.startAnimation(animation);
        setEnabled(true);
    }

    public void setPositiveButton(String title, OnClickListener onClickListener) {
        logI("setPositiveButton() ");
        this.mOKBtnTitle = title;
        this.mOnClickListenerOK = onClickListener;
    }

    public void setNegativeButton(String title, OnClickListener onClickListener) {
        this.mCancelBtnTitle = title;
        this.mOnClickListenerCancel = onClickListener;
    }

    public void setLeftArrowButton(String title, OnClickListener onClickListener) {
        this.mOnClickListenerLeftArrow = onClickListener;
    }

    public void setRightArrowButton(String title, OnClickListener onClickListener) {
        this.mOnClickListenerRightArrow = onClickListener;
    }

    public void setPositiveButton(int resid, OnClickListener onClickListener) {
        logI("setPositiveButton AlertView ok!!!");
        this.mOKBtnTitle = getResources().getString(resid);
        this.mOnClickListenerOK = onClickListener;
    }

    public void setNegativeButton(int resid, OnClickListener onClickListener) {
        this.mCancelBtnTitle = getResources().getString(resid);
        this.mOnClickListenerCancel = onClickListener;
    }

    public void setLeftArrowButton(int resid, OnClickListener onClickListener) {
        this.mOnClickListenerLeftArrow = onClickListener;
    }

    public void setRightArrowButton(int resid, OnClickListener onClickListener) {
        this.mOnClickListenerRightArrow = onClickListener;
    }

    public void setCancelable(boolean cancelable) {
        this.mCancelable = cancelable;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) throws Resources.NotFoundException {
        logI("haeri===dispatchKeyEvent");
        if (event.getKeyCode() == 4 && event.getAction() == 0 && this.mCancelable) {
            dismiss();
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void dismiss() throws Resources.NotFoundException {
        if (this.mShowing) {
            setEnabled(false);
            Animation animation = AnimationUtils.loadAnimation(getContext(), C0000R.anim.screenshare_zoom_out);
            animation.reset();
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.coolots.chaton.call.screenshare.util.PageSettingAlertView.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation arg0) {
                    PageSettingAlertView.this.unload();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation arg0) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation arg0) {
                }
            });
            this.mDialogViewLayout.clearAnimation();
            this.mDialogViewLayout.startAnimation(animation);
        }
        this.mShowing = false;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        this.mAlertTitle = null;
        this.mOKBtnTitle = null;
        this.mCancelBtnTitle = null;
        this.mNeutralBtnTitle = null;
        if (this.mTextTitle != null) {
            this.mTextTitle.removeCallbacks(null);
            this.mTextTitle = null;
        }
        if (this.mAlertOKBtn != null) {
            this.mAlertOKBtn.removeCallbacks(null);
            this.mAlertOKBtn = null;
        }
        if (this.mAlertCancelBtn != null) {
            this.mAlertCancelBtn.removeCallbacks(null);
            this.mAlertCancelBtn = null;
        }
        if (this.mAlertLeftArrowBtn != null) {
            this.mAlertLeftArrowBtn.removeCallbacks(null);
            this.mAlertLeftArrowBtn = null;
        }
        if (this.mAlertRightArrowBtn != null) {
            this.mAlertRightArrowBtn.removeCallbacks(null);
            this.mAlertRightArrowBtn = null;
        }
        if (this.mOnClickListenerOK != null) {
            this.mOnClickListenerOK = null;
        }
        if (this.mOnClickListenerCancel != null) {
            this.mOnClickListenerCancel = null;
        }
        if (this.mOnClickListenerLeftArrow != null) {
            this.mOnClickListenerLeftArrow = null;
        }
        if (this.mOnClickListenerRightArrow != null) {
            this.mOnClickListenerRightArrow = null;
        }
        if (this.mDialogViewLayout != null) {
            this.mDialogViewLayout.removeAllViewsInLayout();
            this.mDialogViewLayout = null;
        }
    }
}
