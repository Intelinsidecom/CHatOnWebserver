package com.coolots.chaton.call.view.layout.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.view.VideoCallActivity;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VideoCallEmotiAnimationLayout extends LinearLayout implements View.OnClickListener, DisposeInterface {
    private static final String CLASSNAME = "[VideoCallEmotiAnimationLayout]";
    private static final int NOT_SELECTED = -1;
    public ImageView[] mAnimationArray;
    private ImageView mAnimationAutoMode;
    private ImageView mAnimationCanel;
    private LinearLayout mAnimationSettingLayout;
    private boolean mIsAutoEmotionFirst;
    private boolean mIsAutoMode;
    private VideoCallActivity mParentActivity;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public VideoCallEmotiAnimationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mAnimationArray = new ImageView[5];
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_emotional, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initLayout();
    }

    public void setParent(VideoCallActivity parent, boolean isLandscapeMode) {
        this.mParentActivity = parent;
    }

    private void initLayout() {
        this.mAnimationSettingLayout = (LinearLayout) findViewById(C0000R.id.animation_setting_layout);
        this.mAnimationAutoMode = (ImageView) findViewById(C0000R.id.animation_always_button);
        this.mAnimationAutoMode.setOnClickListener(this);
        this.mAnimationArray[0] = (ImageView) findViewById(C0000R.id.animation1);
        this.mAnimationArray[1] = (ImageView) findViewById(C0000R.id.animation2);
        this.mAnimationArray[2] = (ImageView) findViewById(C0000R.id.animation3);
        this.mAnimationArray[3] = (ImageView) findViewById(C0000R.id.animation4);
        this.mAnimationArray[4] = (ImageView) findViewById(C0000R.id.animation5);
        this.mAnimationArray[0].setContentDescription(getResources().getString(C0000R.string.icon, 2));
        this.mAnimationArray[1].setContentDescription(getResources().getString(C0000R.string.icon, 3));
        this.mAnimationArray[2].setContentDescription(getResources().getString(C0000R.string.icon, 5));
        this.mAnimationArray[3].setContentDescription(getResources().getString(C0000R.string.icon, 4));
        this.mAnimationArray[4].setContentDescription(getResources().getString(C0000R.string.icon, 1));
        for (int i = 0; i < this.mAnimationArray.length; i++) {
            this.mAnimationArray[i].setOnClickListener(this);
        }
        this.mAnimationCanel = (ImageView) findViewById(C0000R.id.animation_cancel);
        this.mAnimationCanel.setOnClickListener(this);
    }

    public void setEmotionAnimationLayoutParams() {
        if (getResources().getConfiguration().orientation == 2) {
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
            if (this.mParentActivity.getShareViewFullScreen()) {
                params.width = -1;
            } else {
                params.width = 1338;
            }
            setLayoutParams(params);
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mAnimationSettingLayout != null) {
            this.mAnimationSettingLayout.removeAllViews();
            this.mAnimationSettingLayout = null;
        }
        if (this.mAnimationAutoMode != null) {
            this.mAnimationAutoMode.removeCallbacks(null);
            this.mAnimationAutoMode = null;
        }
        if (this.mAnimationArray != null) {
            for (int i = 0; i < this.mAnimationArray.length; i++) {
                if (this.mAnimationArray[i] != null) {
                    this.mAnimationArray[i].removeCallbacks(null);
                    this.mAnimationArray[i] = null;
                }
            }
            this.mAnimationArray = null;
        }
        if (this.mAnimationCanel != null) {
            this.mAnimationCanel.removeCallbacks(null);
            this.mAnimationCanel = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) throws Throwable {
        switch (v.getId()) {
            case C0000R.id.animation_always_button /* 2131493412 */:
                changeEmotionalAnimationAlwaysMode();
                break;
            case C0000R.id.animation5 /* 2131493414 */:
                setEmotionalAnimation(4);
                break;
            case C0000R.id.animation1 /* 2131493415 */:
                setEmotionalAnimation(0);
                break;
            case C0000R.id.animation2 /* 2131493416 */:
                setEmotionalAnimation(1);
                break;
            case C0000R.id.animation4 /* 2131493417 */:
                setEmotionalAnimation(3);
                break;
            case C0000R.id.animation3 /* 2131493418 */:
                setEmotionalAnimation(2);
                break;
            case C0000R.id.animation_cancel /* 2131493419 */:
                offAutoAnimation();
                this.mIsAutoEmotionFirst = false;
                this.mParentActivity.closeThemeShotEmotionalAnimation();
                break;
        }
    }

    private void changeEmotionalAnimationAlwaysMode() throws Throwable {
        if (this.mIsAutoMode) {
            setAutoMode(false);
            notSelectedAniButton();
            setAutoFaceEmotion(false);
            this.mParentActivity.setEmotionalAnimation(-1, this.mIsAutoMode);
            return;
        }
        setAutoMode(true);
        setEmotionalAnimation(-1);
        if (this.mIsAutoEmotionFirst) {
            this.mIsAutoEmotionFirst = false;
            Toast.makeText(this.mContext, getResources().getString(C0000R.string.video_animated_emotioins_auto), 0).show();
        }
        setAutoFaceEmotion(true);
    }

    private void setEmotionalAnimation(int selectedNo) throws Throwable {
        if (this.mParentActivity != null) {
            if (selectedNo == -1) {
                notSelectedAniButton();
                this.mParentActivity.setEmotionalAnimation(-1, this.mIsAutoMode);
                return;
            }
            if (this.mIsAutoMode) {
                setAutoFaceEmotion(false);
                setAutoMode(false);
            }
            this.mParentActivity.setEmotionalAnimation(selectedNo, this.mIsAutoMode);
            this.mParentActivity.checkCallInstanceNRefresh();
        }
    }

    private void setPressImage(int imageNo) {
        notSelectedAniButton();
        this.mAnimationArray[imageNo].setSelected(true);
    }

    public void setAutoMode(boolean flag) {
        this.mIsAutoMode = flag;
        if (flag) {
            this.mAnimationAutoMode.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_on);
            this.mAnimationAutoMode.setContentDescription(getResources().getString(C0000R.string.auto_on));
        } else {
            this.mAnimationAutoMode.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_off);
            this.mAnimationAutoMode.setContentDescription(getResources().getString(C0000R.string.auto_off));
        }
    }

    public void setAutoFaceEmotion(boolean goAuto) {
        int faceEmotion = -1;
        if (goAuto) {
            faceEmotion = 0;
        }
        this.mParentActivity.setFaceEmotion(faceEmotion);
    }

    private void notSelectedAniButton() {
        for (int animationArrayIdx = 0; animationArrayIdx < this.mAnimationArray.length; animationArrayIdx++) {
            this.mAnimationArray[animationArrayIdx].setSelected(false);
        }
    }

    private void offAutoAnimation() {
        if (this.mIsAutoMode) {
            this.mIsAutoMode = false;
            setAutoFaceEmotion(false);
            this.mParentActivity.setEmotionalAnimation(-1, this.mIsAutoMode);
        }
    }

    public void displayEmotionalAnimation() {
        this.mAnimationSettingLayout.setVisibility(0);
        this.mParentActivity.checkCallInstanceNRefresh();
        setEmotionAnimationLayoutParams();
        this.mIsAutoEmotionFirst = true;
        this.mIsAutoMode = this.mParentActivity.mCallStatusData.isAlwaysEmotional();
        if (this.mIsAutoMode) {
            this.mAnimationAutoMode.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_on);
            this.mAnimationAutoMode.setContentDescription(getResources().getString(C0000R.string.auto_on));
        } else {
            this.mAnimationAutoMode.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_off);
            this.mAnimationAutoMode.setContentDescription(getResources().getString(C0000R.string.auto_off));
        }
    }

    public void reStartAnimation() {
        boolean isAutoMode = this.mParentActivity.mCallStatusData.isAlwaysEmotional();
        if (isAutoMode) {
            this.mAnimationAutoMode.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_on);
            this.mAnimationAutoMode.setContentDescription(getResources().getString(C0000R.string.auto_on));
            setAutoFaceEmotion(true);
        } else {
            this.mAnimationAutoMode.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_off);
            this.mAnimationAutoMode.setContentDescription(getResources().getString(C0000R.string.auto_off));
            notSelectedAniButton();
            setAutoFaceEmotion(false);
        }
    }

    public boolean isAutoMode() {
        return this.mIsAutoMode;
    }

    public void setAlwaysMode(boolean flag) {
        this.mIsAutoMode = flag;
    }

    public void displayEmotionalAutoOn() {
        this.mIsAutoMode = true;
        setEmotionalAnimation(-1);
        this.mAnimationAutoMode.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_on);
        this.mAnimationAutoMode.setContentDescription(getResources().getString(C0000R.string.auto_on));
        if (this.mIsAutoEmotionFirst) {
            this.mIsAutoEmotionFirst = false;
            Toast.makeText(this.mContext, this.mContext.getResources().getString(C0000R.string.video_animated_emotioins_auto), 0).show();
        }
        setAutoFaceEmotion(true);
    }
}
