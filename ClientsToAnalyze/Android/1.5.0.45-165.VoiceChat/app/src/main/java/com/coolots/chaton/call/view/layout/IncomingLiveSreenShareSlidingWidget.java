package com.coolots.chaton.call.view.layout;

import android.R;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.view.layout.IncomingLiveScreenShareCallWidget;
import com.coolots.common.CoolotsCode;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.PhoneNumberUtil;
import com.sds.coolots.common.view.DisposeInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class IncomingLiveSreenShareSlidingWidget extends RelativeLayout implements IncomingLiveScreenShareCallWidget.OnTriggerListener, View.OnClickListener, DisposeInterface {
    public static final String CLASSNAME = "[IncomingSlidingWidget]";
    private static final int IN_CALL_WIDGET_TRANSITION_TIME = 250;
    private CallDisplayUserInfo mCalluserInfo;
    private Context mContext;
    private Destination mDestination;
    public IncomingLiveScreenShareCallWidget mIncomingSlidingTab;
    private boolean mIsUsim;
    private long mLastIncomingCallActionTime;
    private boolean mOpenRejectMsg;
    private CallActivity mParentActivity;
    private String mPhoneNumber;
    private Button mReceiveBtn;
    public SlidingDrawer mRejectCallWithMsgDrawer;
    private Button mRejectCallWithMsgHandle;
    private RejectCallWithMsgLayout mRejectCallWithMsgLayout;
    private AlphaAnimation mSlidingTabAnim;

    private void logI(String message) {
        Log.m2963i("[IncomingSlidingWidget]" + message);
    }

    public IncomingLiveSreenShareSlidingWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = null;
        this.mIsUsim = true;
        this.mOpenRejectMsg = false;
        this.mContext = context;
    }

    private void linkControls() {
        this.mIncomingSlidingTab = (IncomingLiveScreenShareCallWidget) findViewById(C0000R.id.incomingCallWidget);
        this.mIncomingSlidingTab.setLeftHintText(C0000R.string.calling_button_receive);
        this.mIncomingSlidingTab.setRightHintText(C0000R.string.calling_button_hang_up);
        this.mIncomingSlidingTab.setOnTriggerListener(this);
        if (this.mIsUsim) {
            this.mRejectCallWithMsgDrawer = (SlidingDrawer) findViewById(C0000R.id.reject_call_with_msg_container);
            this.mRejectCallWithMsgHandle = (Button) findViewById(C0000R.id.reject_call_with_msg_handle);
            this.mRejectCallWithMsgDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() { // from class: com.coolots.chaton.call.view.layout.IncomingLiveSreenShareSlidingWidget.1
                @Override // android.widget.SlidingDrawer.OnDrawerOpenListener
                public void onDrawerOpened() {
                    if (IncomingLiveSreenShareSlidingWidget.this.mRejectCallWithMsgHandle != null) {
                        boolean isPortrate = MainApplication.mContext.getResources().getConfiguration().orientation == 1;
                        IncomingLiveSreenShareSlidingWidget.this.mOpenRejectMsg = true;
                        if (isPortrate) {
                            IncomingLiveSreenShareSlidingWidget.this.mRejectCallWithMsgHandle.setBackgroundResource(C0000R.drawable.reject_call_selector_down);
                        } else {
                            IncomingLiveSreenShareSlidingWidget.this.mRejectCallWithMsgHandle.setBackgroundResource(C0000R.drawable.reject_call_selector_down_h);
                        }
                    }
                }
            });
            this.mRejectCallWithMsgDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() { // from class: com.coolots.chaton.call.view.layout.IncomingLiveSreenShareSlidingWidget.2
                @Override // android.widget.SlidingDrawer.OnDrawerCloseListener
                public void onDrawerClosed() {
                    if (IncomingLiveSreenShareSlidingWidget.this.mRejectCallWithMsgHandle != null) {
                        boolean isPortrate = MainApplication.mContext.getResources().getConfiguration().orientation == 1;
                        IncomingLiveSreenShareSlidingWidget.this.mOpenRejectMsg = false;
                        if (isPortrate) {
                            IncomingLiveSreenShareSlidingWidget.this.mRejectCallWithMsgHandle.setBackgroundResource(C0000R.drawable.reject_call_selector);
                        } else {
                            IncomingLiveSreenShareSlidingWidget.this.mRejectCallWithMsgHandle.setBackgroundResource(C0000R.drawable.reject_call_selector_h);
                        }
                    }
                }
            });
            this.mRejectCallWithMsgLayout = (RejectCallWithMsgLayout) findViewById(C0000R.id.reject_call_with_msg_content);
            this.mRejectCallWithMsgLayout.setCallInfo(this.mParentActivity, this.mPhoneNumber, this.mDestination, this.mCalluserInfo);
        }
        this.mReceiveBtn = (Button) findViewById(C0000R.id.btn_receive);
        this.mReceiveBtn.setOnClickListener(this);
    }

    public void initialize(CallActivity parent, Destination destination, CallDisplayUserInfo info) {
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        inflater.inflate(C0000R.layout.incoming_live_screen_share_sliding_widget, (ViewGroup) this, true);
        getPhoneNumber(destination);
        this.mDestination = destination;
        this.mParentActivity = parent;
        this.mCalluserInfo = info;
        linkControls();
    }

    public void setDestination(Destination destination) {
        this.mDestination = destination;
        getPhoneNumber(destination);
        if (this.mIsUsim) {
            this.mRejectCallWithMsgLayout.setCallInfo(this.mParentActivity, this.mPhoneNumber, this.mDestination, this.mCalluserInfo);
        }
    }

    private void getPhoneNumber(Destination destination) {
        String phoneNum = null;
        try {
            if (destination != null) {
                try {
                    String pNum = destination.getPhoneNo();
                    PhoneNumberUtil phoneUtil = new PhoneNumberUtil(pNum.replace("@chaton", "").replace(CoolotsCode.ID_DOMAIN_COOLOTS, ""));
                    phoneNum = PhoneNumberUtil.formatNumber(phoneUtil.getPhoneNumber());
                } catch (Exception e) {
                    e.printStackTrace();
                    if (0 != 0) {
                        this.mPhoneNumber = null;
                        return;
                    }
                    return;
                }
            }
            if (phoneNum != null) {
                this.mPhoneNumber = phoneNum;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                this.mPhoneNumber = null;
            }
            throw th;
        }
    }

    private void hideIncomingCallWidget() {
        if (this.mIncomingSlidingTab.getVisibility() == 0 && this.mIncomingSlidingTab.getAnimation() == null) {
            if (this.mSlidingTabAnim == null) {
                this.mSlidingTabAnim = new AlphaAnimation(1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                this.mSlidingTabAnim.setDuration(250L);
                this.mSlidingTabAnim.setAnimationListener(new Animation.AnimationListener() { // from class: com.coolots.chaton.call.view.layout.IncomingLiveSreenShareSlidingWidget.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        IncomingLiveSreenShareSlidingWidget.this.mIncomingSlidingTab.clearAnimation();
                        IncomingLiveSreenShareSlidingWidget.this.mIncomingSlidingTab.setVisibility(8);
                    }
                });
            }
            this.mIncomingSlidingTab.startAnimation(this.mSlidingTabAnim);
        }
    }

    private void showIncomingCallWidget() {
        Animation anim = this.mIncomingSlidingTab.getAnimation();
        if (anim != null) {
            anim.reset();
            this.mIncomingSlidingTab.clearAnimation();
        }
        this.mIncomingSlidingTab.setVisibility(0);
        this.mReceiveBtn.requestFocus();
    }

    @Override // com.coolots.chaton.call.view.layout.IncomingLiveScreenShareCallWidget.OnTriggerListener
    public void onTrigger(View view, int whichHandle) {
        switch (whichHandle) {
            case 1:
                hideIncomingCallWidget();
                this.mLastIncomingCallActionTime = SystemClock.uptimeMillis();
                if (this.mParentActivity != null) {
                    this.mParentActivity.receiveCall();
                    break;
                }
                break;
            case 2:
                hideIncomingCallWidget();
                this.mLastIncomingCallActionTime = SystemClock.uptimeMillis();
                if (this.mParentActivity != null) {
                    this.mParentActivity.denyCall();
                    break;
                }
                break;
            default:
                logI("onDialTrigger: unexpected whichHandle value: " + whichHandle);
                break;
        }
    }

    @Override // com.coolots.chaton.call.view.layout.IncomingLiveScreenShareCallWidget.OnTriggerListener
    public void onGrabbedStateChange(View view, int grabbedState) {
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        if (visibility == 0) {
            showIncomingCallWidget();
            if (this.mIsUsim) {
                this.mRejectCallWithMsgDrawer.setVisibility(0);
            }
        } else {
            hideIncomingCallWidget();
            if (this.mIsUsim) {
                if (this.mRejectCallWithMsgDrawer.isOpened()) {
                    this.mRejectCallWithMsgDrawer.toggle();
                }
                this.mRejectCallWithMsgDrawer.setVisibility(8);
            }
        }
        super.setVisibility(visibility);
    }

    long getLastIncomingCallActionTime() {
        return this.mLastIncomingCallActionTime;
    }

    public void closeRejectMsg() {
        if (this.mOpenRejectMsg) {
            this.mRejectCallWithMsgDrawer.close();
        }
    }

    public void showReceveBtnAnimation() {
        TranslateAnimation mRejectMsgTrans = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, 1.0f, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        mRejectMsgTrans.setInterpolator(AnimationUtils.loadInterpolator(MainApplication.mContext, R.anim.decelerate_interpolator));
        mRejectMsgTrans.setDuration(400L);
        this.mRejectCallWithMsgDrawer.startAnimation(mRejectMsgTrans);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mParentActivity != null) {
            this.mParentActivity = null;
        }
        if (this.mContext != null) {
            this.mContext = null;
        }
        if (this.mIncomingSlidingTab != null) {
            this.mIncomingSlidingTab.dispose();
            this.mIncomingSlidingTab = null;
        }
        if (this.mRejectCallWithMsgDrawer != null) {
            this.mRejectCallWithMsgDrawer = null;
        }
        if (this.mRejectCallWithMsgLayout != null) {
            this.mRejectCallWithMsgLayout.dispose();
            this.mRejectCallWithMsgLayout = null;
        }
        if (this.mRejectCallWithMsgHandle != null) {
            this.mRejectCallWithMsgHandle = null;
        }
        if (this.mSlidingTabAnim != null) {
            this.mSlidingTabAnim = null;
        }
        removeAllViewsInLayout();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 4:
                this.mParentActivity.denyCall();
                return true;
            case 19:
            case 20:
            case 21:
            case 22:
                this.mReceiveBtn.requestFocus();
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.mReceiveBtn.getId()) {
            this.mParentActivity.receiveCall();
        }
    }
}
