package com.coolots.chaton.call.view.layout.video;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.util.TranslatorViewController;
import com.coolots.chaton.call.view.VideoCallActivity;
import com.coolots.chaton.call.view.layout.CallTranslatorScrollViewLayout;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class VideoCallTranslatorLayout extends FrameLayout implements DisposeInterface {
    private static final String CLASSNAME = "[VideoCallTranslatorLayout]";
    private static final int GONE_TRANSLATOR_CHANGE_LANGUAGE_HELP = 0;
    private static final int TRANSLATOR_CHANGE_LANGUAGE_DIALOG = 999;
    private static final int TRANSLATOR_CHANGE_LANGUAGE_HELP_TIMER = 5000;
    private static final int VIEW_TRANSLATOR_CHANGE_LANGUAGE_HELP = 1;
    private View.OnClickListener mButtonClickListener;
    private CallTranslatorScrollViewLayout mCallTranslatorScrollViewLayout;
    private LinearLayout mLanguageButton;
    private ViewGroup mMemberLayout;
    private VideoCallActivity mParentActivity;
    private ViewGroup mRootGroupView;
    private LinearLayout mShowButton;
    private ImageView mShowImageView;
    private boolean mShowOnOff;
    private LinearLayout mTTSButton;
    private ImageView mTTSImageView;
    private boolean mTTSOnOff;
    private TextView mTTSTextView;
    private TranslatorViewController.TranslateModeValue mTranslateModeValue;
    private LinearLayout mTranslatorChangeLanguageHelpToast;
    private Handler mTranslatorHelpHandler;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public VideoCallTranslatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTranslatorHelpHandler = new TranslatorHelpHandler();
        this.mButtonClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallTranslatorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (view.getId()) {
                    case C0000R.id.translator_show /* 2131493543 */:
                        VideoCallTranslatorLayout.this.mShowOnOff = VideoCallTranslatorLayout.this.mShowOnOff ? false : true;
                        break;
                    case C0000R.id.translator_tts /* 2131493546 */:
                        VideoCallTranslatorLayout.this.mTTSOnOff = VideoCallTranslatorLayout.this.mTTSOnOff ? false : true;
                        break;
                }
                VideoCallTranslatorLayout.this.setUI(view);
                VideoCallTranslatorLayout.this.setCommand(view);
            }
        };
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_translator, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mShowButton = (LinearLayout) findViewById(C0000R.id.translator_show);
        this.mTTSButton = (LinearLayout) findViewById(C0000R.id.translator_tts);
        this.mLanguageButton = (LinearLayout) findViewById(C0000R.id.translator_change_language);
        this.mTranslatorChangeLanguageHelpToast = (LinearLayout) findViewById(C0000R.id.translator_change_languae_help);
        this.mCallTranslatorScrollViewLayout = (CallTranslatorScrollViewLayout) findViewById(C0000R.id.video_call_translator_content_id);
        this.mShowImageView = (ImageView) findViewById(C0000R.id.translator_image_show);
        this.mTTSImageView = (ImageView) findViewById(C0000R.id.translator_image_tts);
        this.mTTSTextView = (TextView) findViewById(C0000R.id.translator_hold_textView);
        this.mShowButton.setOnClickListener(this.mButtonClickListener);
        this.mTTSButton.setOnClickListener(this.mButtonClickListener);
        this.mLanguageButton.setOnClickListener(this.mButtonClickListener);
    }

    public void setParent(VideoCallActivity parent) {
        this.mParentActivity = parent;
    }

    public void setTranslateModeValue(TranslatorViewController.TranslateModeValue translateModeValue) {
        this.mTranslateModeValue = translateModeValue;
        this.mShowOnOff = this.mTranslateModeValue.getViewOnOff();
        this.mTTSOnOff = this.mTranslateModeValue.getTTSOnOff();
        setShowOnOffUI(this.mShowOnOff);
        setTTSOnOffUI(this.mTTSOnOff);
        setShowOnOffCommand();
    }

    private void setTTSOnOffCommand() {
        if (this.mTTSOnOff) {
            this.mParentActivity.Start_BubbleTTSPlayer();
        } else {
            this.mParentActivity.End_BubbleTTSPlayer();
        }
        this.mTranslateModeValue.setTTSOnOff(this.mTTSOnOff);
    }

    private void setShowOnOffCommand() {
        if (this.mShowOnOff) {
            this.mCallTranslatorScrollViewLayout.setVisibility(0);
        } else {
            this.mCallTranslatorScrollViewLayout.setVisibility(8);
        }
        this.mTranslateModeValue.setViewOnOff(this.mShowOnOff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommand(View view) {
        switch (view.getId()) {
            case C0000R.id.translator_show /* 2131493543 */:
                setShowOnOffCommand();
                break;
            case C0000R.id.translator_tts /* 2131493546 */:
                setTTSOnOffCommand();
                break;
            case C0000R.id.translator_change_language /* 2131493549 */:
                this.mParentActivity.showDialog(999);
                break;
        }
    }

    private void setShowOnOffUI() {
        setShowOnOffUI(this.mShowOnOff);
    }

    private void setShowOnOffUI(boolean OnOff) {
        if (OnOff) {
            this.mShowImageView.setBackgroundResource(C0000R.drawable.translator_show_off_image_selector);
            this.mTTSTextView.setText(C0000R.string.video_option_menu_hide);
        } else {
            this.mShowImageView.setBackgroundResource(C0000R.drawable.translator_show_on_image_selector);
            this.mTTSTextView.setText(C0000R.string.video_option_menu_show);
        }
    }

    private void setTTSOnOffUI(boolean OnOff) {
        if (OnOff) {
            this.mTTSImageView.setBackgroundResource(C0000R.drawable.translator_tts_on_image_selector);
        } else {
            this.mTTSImageView.setBackgroundResource(C0000R.drawable.translator_tts_off_image_selector);
        }
    }

    private void setTTSOnOffUI() {
        setTTSOnOffUI(this.mTTSOnOff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUI(View view) {
        switch (view.getId()) {
            case C0000R.id.translator_show /* 2131493543 */:
                setShowOnOffUI();
                break;
            case C0000R.id.translator_tts /* 2131493546 */:
                setTTSOnOffUI();
                break;
        }
    }

    public void setStartTranslatorUI() {
        this.mTranslatorHelpHandler.removeMessages(1);
        this.mTranslatorHelpHandler.sendEmptyMessage(1);
        this.mTranslatorHelpHandler.sendEmptyMessageDelayed(0, Config.DISCONNECT_TIMEOUT);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mShowImageView != null) {
            this.mShowImageView = null;
        }
        if (this.mTTSImageView != null) {
            this.mTTSImageView = null;
        }
        if (this.mShowButton != null) {
            this.mShowButton.removeAllViews();
        }
        if (this.mTTSButton != null) {
            this.mTTSButton.removeAllViews();
        }
        if (this.mLanguageButton != null) {
            this.mLanguageButton.removeAllViews();
        }
        if (this.mTranslatorHelpHandler != null) {
            this.mTranslatorHelpHandler.removeMessages(0);
            this.mTranslatorHelpHandler.removeMessages(1);
            this.mTranslatorHelpHandler = null;
        }
        removeAllViewsInLayout();
    }

    protected class TranslatorHelpHandler extends Handler {
        protected TranslatorHelpHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    VideoCallTranslatorLayout.this.mTranslatorChangeLanguageHelpToast.setVisibility(8);
                    break;
                case 1:
                    VideoCallTranslatorLayout.this.mTranslatorChangeLanguageHelpToast.setVisibility(0);
                    break;
            }
        }
    }
}
