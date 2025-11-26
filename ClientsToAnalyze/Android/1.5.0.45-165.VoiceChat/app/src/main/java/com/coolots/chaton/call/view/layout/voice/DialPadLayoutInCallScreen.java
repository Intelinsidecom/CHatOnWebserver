package com.coolots.chaton.call.view.layout.voice;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class DialPadLayoutInCallScreen extends LinearLayout implements DisposeInterface, Animation.AnimationListener {
    private static final String CLASSNAME = "[DialPadLayoutInCallScreen]";
    private Button mBtn0;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;
    private Button mBtn6;
    private Button mBtn7;
    private Button mBtn8;
    private Button mBtn9;
    private Button mBtnPound;
    private Button mBtnStar;
    private LinearLayout mDialpad;
    private String mDtmfString;
    private TranslateAnimation mDtmfTextTrans;
    private TextView mDtmfTextView;
    private TranslateAnimation mKeypadTrans;
    private int showType;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public DialPadLayoutInCallScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.showType = 0;
        this.mDtmfString = "";
        View.inflate(context, C0000R.layout.dial_in_call_screen, this);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        initialize();
    }

    private void initialize() {
        this.mDialpad = (LinearLayout) findViewById(C0000R.id.dialpad_layout);
        this.mDtmfTextView = (TextView) findViewById(C0000R.id.dtmf_textview);
        this.mBtn0 = (Button) findViewById(C0000R.id.dtmf_button0);
        this.mBtn0.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.DialPadLayoutInCallScreen.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DialPadLayoutInCallScreen.this.attatchDtmfString("0");
                DialPadLayoutInCallScreen.this.sendDtmfTone(48);
            }
        });
        this.mBtn1 = (Button) findViewById(C0000R.id.dtmf_button1);
        this.mBtn1.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.DialPadLayoutInCallScreen.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DialPadLayoutInCallScreen.this.attatchDtmfString("1");
                DialPadLayoutInCallScreen.this.sendDtmfTone(49);
            }
        });
        this.mBtn2 = (Button) findViewById(C0000R.id.dtmf_button2);
        this.mBtn2.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.DialPadLayoutInCallScreen.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DialPadLayoutInCallScreen.this.attatchDtmfString("2");
                DialPadLayoutInCallScreen.this.sendDtmfTone(50);
            }
        });
        this.mBtn3 = (Button) findViewById(C0000R.id.dtmf_button3);
        this.mBtn3.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.DialPadLayoutInCallScreen.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DialPadLayoutInCallScreen.this.attatchDtmfString("3");
                DialPadLayoutInCallScreen.this.sendDtmfTone(51);
            }
        });
        this.mBtn4 = (Button) findViewById(C0000R.id.dtmf_button4);
        this.mBtn4.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.DialPadLayoutInCallScreen.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DialPadLayoutInCallScreen.this.attatchDtmfString(SimpleUserInfo.STATE_MOVETO_CONFERENCE);
                DialPadLayoutInCallScreen.this.sendDtmfTone(52);
            }
        });
        this.mBtn5 = (Button) findViewById(C0000R.id.dtmf_button5);
        this.mBtn5.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.DialPadLayoutInCallScreen.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DialPadLayoutInCallScreen.this.attatchDtmfString("5");
                DialPadLayoutInCallScreen.this.sendDtmfTone(53);
            }
        });
        this.mBtn6 = (Button) findViewById(C0000R.id.dtmf_button6);
        this.mBtn6.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.DialPadLayoutInCallScreen.7
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DialPadLayoutInCallScreen.this.attatchDtmfString("6");
                DialPadLayoutInCallScreen.this.sendDtmfTone(54);
            }
        });
        this.mBtn7 = (Button) findViewById(C0000R.id.dtmf_button7);
        this.mBtn7.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.DialPadLayoutInCallScreen.8
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DialPadLayoutInCallScreen.this.attatchDtmfString("7");
                DialPadLayoutInCallScreen.this.sendDtmfTone(55);
            }
        });
        this.mBtn8 = (Button) findViewById(C0000R.id.dtmf_button8);
        this.mBtn8.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.DialPadLayoutInCallScreen.9
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DialPadLayoutInCallScreen.this.attatchDtmfString("8");
                DialPadLayoutInCallScreen.this.sendDtmfTone(56);
            }
        });
        this.mBtn9 = (Button) findViewById(C0000R.id.dtmf_button9);
        this.mBtn9.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.DialPadLayoutInCallScreen.10
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DialPadLayoutInCallScreen.this.attatchDtmfString("9");
                DialPadLayoutInCallScreen.this.sendDtmfTone(57);
            }
        });
        this.mBtnStar = (Button) findViewById(C0000R.id.dtmf_buttonstar);
        this.mBtnStar.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.DialPadLayoutInCallScreen.11
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DialPadLayoutInCallScreen.this.attatchDtmfString("*");
                DialPadLayoutInCallScreen.this.sendDtmfTone(42);
            }
        });
        this.mBtnPound = (Button) findViewById(C0000R.id.dtmf_buttonpound);
        this.mBtnPound.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.DialPadLayoutInCallScreen.12
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DialPadLayoutInCallScreen.this.attatchDtmfString("#");
                DialPadLayoutInCallScreen.this.sendDtmfTone(35);
            }
        });
    }

    public void sendDtmfTone(int keyCode) {
        logI("sendDtmfTone() : " + keyCode);
        MainApplication.mPhoneManager.getPhoneStateMachine().sendDtmfTone(keyCode);
    }

    public void clearDtmfString() {
        this.mDtmfString = "";
        if (this.mDtmfTextView != null) {
            this.mDtmfTextView.setText(this.mDtmfString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attatchDtmfString(String key) {
        this.mDtmfString = String.valueOf(this.mDtmfString) + key;
        this.mDtmfTextView.setText(this.mDtmfString);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        clearDtmfString();
        super.setVisibility(visibility);
    }

    private void dialpadKeypadAnimation(boolean isOpen) {
        if (isOpen) {
            this.mKeypadTrans = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, 1.0f, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        } else {
            this.mKeypadTrans = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, 1.0f);
        }
        this.mKeypadTrans.setInterpolator(AnimationUtils.loadInterpolator(MainApplication.mContext, R.anim.decelerate_interpolator));
        this.mKeypadTrans.setDuration(400L);
        this.mKeypadTrans.setFillAfter(true);
        this.mDialpad.startAnimation(this.mKeypadTrans);
        this.mKeypadTrans.setAnimationListener(this);
    }

    private void dialpadDtmfEditTextAnimation(boolean isOpen) {
        if (isOpen) {
            this.mDtmfTextTrans = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, -1.0f, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        } else {
            this.mDtmfTextTrans = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, -1.0f);
        }
        this.mDtmfTextTrans.setInterpolator(AnimationUtils.loadInterpolator(MainApplication.mContext, R.anim.decelerate_interpolator));
        this.mDtmfTextTrans.setDuration(400L);
        this.mDtmfTextTrans.setFillAfter(true);
        this.mDtmfTextView.startAnimation(this.mDtmfTextTrans);
        this.mDtmfTextTrans.setAnimationListener(this);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mDtmfTextView != null) {
            this.mDtmfTextView = null;
        }
        if (this.mBtn0 != null) {
            this.mBtn0.setOnClickListener(null);
            this.mBtn0 = null;
        }
        if (this.mBtn1 != null) {
            this.mBtn1.setOnClickListener(null);
            this.mBtn1 = null;
        }
        if (this.mBtn2 != null) {
            this.mBtn2.setOnClickListener(null);
            this.mBtn2 = null;
        }
        if (this.mBtn3 != null) {
            this.mBtn3.setOnClickListener(null);
            this.mBtn3 = null;
        }
        if (this.mBtn4 != null) {
            this.mBtn4.setOnClickListener(null);
            this.mBtn4 = null;
        }
        if (this.mBtn5 != null) {
            this.mBtn5.setOnClickListener(null);
            this.mBtn5 = null;
        }
        if (this.mBtn6 != null) {
            this.mBtn6.setOnClickListener(null);
            this.mBtn6 = null;
        }
        if (this.mBtn7 != null) {
            this.mBtn7.setOnClickListener(null);
            this.mBtn7 = null;
        }
        if (this.mBtn8 != null) {
            this.mBtn8.setOnClickListener(null);
            this.mBtn8 = null;
        }
        if (this.mBtn9 != null) {
            this.mBtn9.setOnClickListener(null);
            this.mBtn9 = null;
        }
        if (this.mBtnStar != null) {
            this.mBtnStar.setOnClickListener(null);
            this.mBtnStar = null;
        }
        if (this.mBtnPound != null) {
            this.mBtnPound.setOnClickListener(null);
            this.mBtnPound = null;
        }
        if (this.mDtmfString != null) {
            this.mDtmfString = null;
        }
        if (this.mKeypadTrans != null) {
            this.mKeypadTrans = null;
        }
        if (this.mDtmfTextTrans != null) {
            this.mDtmfTextTrans = null;
        }
        if (this.mDialpad != null) {
            this.mDialpad = null;
        }
        removeAllViewsInLayout();
    }

    public void showDialPadAnimation(boolean show) {
        if (show) {
            this.showType = 0;
            setVisibility(0);
            dialpadKeypadAnimation(true);
            dialpadDtmfEditTextAnimation(true);
            return;
        }
        this.showType = 1;
        dialpadKeypadAnimation(false);
        dialpadDtmfEditTextAnimation(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation arg0) {
        if (this.showType == 1) {
            setVisibility(4);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation arg0) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation arg0) {
    }
}
