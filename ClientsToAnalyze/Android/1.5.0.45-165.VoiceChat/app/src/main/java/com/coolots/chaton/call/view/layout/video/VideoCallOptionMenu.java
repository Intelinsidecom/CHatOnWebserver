package com.coolots.chaton.call.view.layout.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VideoCallOptionMenu extends FrameLayout implements View.OnClickListener, DisposeInterface {
    private static final String CLASSNAME = "[VideoCallOptionMenu]";
    private static final int EMOTIONAL_ANIMATION_BTN_BG_UNSELECT_RID = 2130837750;
    private static final int THEMESHOT_SELECT_BUTTON_BG_RID = 2130838403;
    private static final int THEMESHOT_UNSELECT_BUTTON_BG_COLOR = 0;
    private static boolean mIsAnimationShowMode = false;
    private static boolean mIsThemeShotShowMode = false;
    private static int mThemeShotType = 0;
    private ImageView mAnimation1;
    private ImageView mAnimation2;
    private ImageView mAnimation3;
    private ImageView mAnimation4;
    private ImageView mAnimation5;
    private TextView mAnimationAlways;
    private ImageView mAnimationCanel;
    private LinearLayout mAnimationLayout;
    private LinearLayout mAnimationSettingLayout;
    private TextView mAnimationShowButton;
    private ImageView mAnimationSwitchButton;
    private int mAnimationType;
    private boolean mAutoEmotion;
    private int mChangedSelectedSubNo;
    private int mChangedSelectedThemeNo;
    private boolean mChangedThemeShot;
    private boolean mIsAutoMode;
    private boolean mIsHideMe;
    private ChatOnCallActivity mParentActivity;
    private int mPreSelectedSubNo;
    private int mPreSelectedThemeNo;
    private int mSelectedAnimationNo;
    private int mSelectedSubNo;
    private int mSelectedThemeNo;
    private int mSelectedThemeShotNo;
    private ImageView mThemeShot1;
    private ImageView mThemeShot2;
    private ImageView mThemeShot3;
    private ImageView mThemeShot4;
    private ImageView mThemeShot5;
    private RelativeLayout mThemeShotAllLayout;
    private ImageView mThemeShotAnimal1;
    private ImageView mThemeShotAnimal2;
    private ImageView mThemeShotAnimal3;
    private LinearLayout mThemeShotAnimalLayout;
    private ImageView mThemeShotCanel;
    private ImageView mThemeShotGlasses1;
    private ImageView mThemeShotGlasses2;
    private ImageView mThemeShotGlasses3;
    private LinearLayout mThemeShotGlassesLayout;
    private ImageView mThemeShotHat1;
    private ImageView mThemeShotHat2;
    private ImageView mThemeShotHat3;
    private LinearLayout mThemeShotHatLayout;
    private LinearLayout mThemeShotLayout;
    private ImageView mThemeShotMustache1;
    private ImageView mThemeShotMustache2;
    private ImageView mThemeShotMustache3;
    private LinearLayout mThemeShotMustacheLayout;
    private ImageView mThemeShotParty1;
    private ImageView mThemeShotParty2;
    private ImageView mThemeShotParty3;
    private LinearLayout mThemeShotPartyLayout;
    private FrameLayout mThemeShotSettingLayout;
    private TextView mThemeShotShowButton;

    private void logI(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public VideoCallOptionMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mIsAutoMode = false;
        this.mSelectedAnimationNo = -1;
        this.mSelectedThemeShotNo = -1;
        this.mSelectedSubNo = -1;
        this.mSelectedThemeNo = -1;
        this.mPreSelectedSubNo = -1;
        this.mPreSelectedThemeNo = -1;
        this.mChangedSelectedSubNo = -1;
        this.mChangedSelectedThemeNo = -1;
        this.mChangedThemeShot = false;
        this.mIsHideMe = false;
        this.mAutoEmotion = false;
        this.mAnimationType = 0;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_option_menu, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initLayout();
    }

    private void initLayout() {
        this.mAnimationLayout = (LinearLayout) findViewById(C0000R.id.animation_layout);
        this.mAnimationShowButton = (TextView) findViewById(C0000R.id.animation_show_btn);
        this.mAnimationSettingLayout = (LinearLayout) findViewById(C0000R.id.animation_setting_layout);
        this.mAnimationAlways = (TextView) findViewById(C0000R.id.animation_always);
        this.mAnimationSwitchButton = (ImageView) findViewById(C0000R.id.animation_always_button);
        this.mAnimation1 = (ImageView) findViewById(C0000R.id.animation1);
        this.mAnimation2 = (ImageView) findViewById(C0000R.id.animation2);
        this.mAnimation3 = (ImageView) findViewById(C0000R.id.animation3);
        this.mAnimation4 = (ImageView) findViewById(C0000R.id.animation4);
        this.mAnimation5 = (ImageView) findViewById(C0000R.id.animation5);
        this.mAnimationCanel = (ImageView) findViewById(C0000R.id.animation_cancel);
        this.mThemeShotAllLayout = (RelativeLayout) findViewById(C0000R.id.themeshot_all_layout);
        this.mThemeShotShowButton = (TextView) findViewById(C0000R.id.themeshot_show_btn);
        this.mThemeShotSettingLayout = (FrameLayout) findViewById(C0000R.id.themeshot_setting_layout);
        this.mThemeShotLayout = (LinearLayout) findViewById(C0000R.id.themeshot_layout);
        this.mThemeShot1 = (ImageView) findViewById(C0000R.id.themeshot1);
        this.mThemeShot2 = (ImageView) findViewById(C0000R.id.themeshot2);
        this.mThemeShot3 = (ImageView) findViewById(C0000R.id.themeshot3);
        this.mThemeShot4 = (ImageView) findViewById(C0000R.id.themeshot4);
        this.mThemeShot5 = (ImageView) findViewById(C0000R.id.themeshot5);
        this.mThemeShotCanel = (ImageView) findViewById(C0000R.id.themeshot_cancel);
        this.mThemeShotAnimalLayout = (LinearLayout) findViewById(C0000R.id.video_call_theme_animal_layout);
        ImageView mThemeShotAnimalBack = (ImageView) findViewById(C0000R.id.themeshot_animal_back);
        this.mThemeShotAnimal1 = (ImageView) findViewById(C0000R.id.themeshot_animal_1);
        this.mThemeShotAnimal2 = (ImageView) findViewById(C0000R.id.themeshot_animal_2);
        this.mThemeShotAnimal3 = (ImageView) findViewById(C0000R.id.themeshot_animal_3);
        ImageView mThemeShotAnimalCanel = (ImageView) findViewById(C0000R.id.themeshot_animal_cancel);
        this.mThemeShotGlassesLayout = (LinearLayout) findViewById(C0000R.id.video_call_theme_glasses_layout);
        ImageView mThemeShotGlassesBack = (ImageView) findViewById(C0000R.id.themeshot_glasses_back);
        this.mThemeShotGlasses1 = (ImageView) findViewById(C0000R.id.themeshot_glasses_1);
        this.mThemeShotGlasses2 = (ImageView) findViewById(C0000R.id.themeshot_glasses_2);
        this.mThemeShotGlasses3 = (ImageView) findViewById(C0000R.id.themeshot_glasses_3);
        ImageView mThemeShotGlassesCanel = (ImageView) findViewById(C0000R.id.themeshot_glasses_cancel);
        this.mThemeShotHatLayout = (LinearLayout) findViewById(C0000R.id.video_call_theme_hat_layout);
        ImageView mThemeShotHatBack = (ImageView) findViewById(C0000R.id.themeshot_hat_back);
        this.mThemeShotHat1 = (ImageView) findViewById(C0000R.id.themeshot_hat_1);
        this.mThemeShotHat2 = (ImageView) findViewById(C0000R.id.themeshot_hat_2);
        this.mThemeShotHat3 = (ImageView) findViewById(C0000R.id.themeshot_hat_3);
        ImageView mThemeShotHatCanel = (ImageView) findViewById(C0000R.id.themeshot_hat_cancel);
        this.mThemeShotMustacheLayout = (LinearLayout) findViewById(C0000R.id.video_call_theme_mustache_layout);
        ImageView mThemeShotMustacheBack = (ImageView) findViewById(C0000R.id.themeshot_mustache_back);
        this.mThemeShotMustache1 = (ImageView) findViewById(C0000R.id.themeshot_mustache_1);
        this.mThemeShotMustache2 = (ImageView) findViewById(C0000R.id.themeshot_mustache_2);
        this.mThemeShotMustache3 = (ImageView) findViewById(C0000R.id.themeshot_mustache_3);
        ImageView mThemeShotMustacheCanel = (ImageView) findViewById(C0000R.id.themeshot_mustache_cancel);
        this.mThemeShotPartyLayout = (LinearLayout) findViewById(C0000R.id.video_call_theme_party_layout);
        ImageView mThemeShotPartyBack = (ImageView) findViewById(C0000R.id.themeshot_party_back);
        this.mThemeShotParty1 = (ImageView) findViewById(C0000R.id.themeshot_party_1);
        this.mThemeShotParty2 = (ImageView) findViewById(C0000R.id.themeshot_party_2);
        this.mThemeShotParty3 = (ImageView) findViewById(C0000R.id.themeshot_party_3);
        ImageView mThemeShotPartyCanel = (ImageView) findViewById(C0000R.id.themeshot_party_cancel);
        this.mAnimationSwitchButton.setOnClickListener(this);
        this.mAnimation1.setOnClickListener(this);
        this.mAnimation2.setOnClickListener(this);
        this.mAnimation3.setOnClickListener(this);
        this.mAnimation4.setOnClickListener(this);
        this.mAnimation5.setOnClickListener(this);
        this.mAnimationCanel.setOnClickListener(this);
        this.mThemeShot1.setOnClickListener(this);
        this.mThemeShot2.setOnClickListener(this);
        this.mThemeShot3.setOnClickListener(this);
        this.mThemeShot4.setOnClickListener(this);
        this.mThemeShot5.setOnClickListener(this);
        this.mThemeShotCanel.setOnClickListener(this);
        mThemeShotAnimalBack.setOnClickListener(this);
        this.mThemeShotAnimal1.setOnClickListener(this);
        this.mThemeShotAnimal2.setOnClickListener(this);
        this.mThemeShotAnimal3.setOnClickListener(this);
        mThemeShotAnimalCanel.setOnClickListener(this);
        mThemeShotHatBack.setOnClickListener(this);
        this.mThemeShotHat1.setOnClickListener(this);
        this.mThemeShotHat2.setOnClickListener(this);
        this.mThemeShotHat3.setOnClickListener(this);
        mThemeShotHatCanel.setOnClickListener(this);
        mThemeShotPartyBack.setOnClickListener(this);
        this.mThemeShotParty1.setOnClickListener(this);
        this.mThemeShotParty2.setOnClickListener(this);
        this.mThemeShotParty3.setOnClickListener(this);
        mThemeShotPartyCanel.setOnClickListener(this);
        mThemeShotMustacheBack.setOnClickListener(this);
        this.mThemeShotMustache1.setOnClickListener(this);
        this.mThemeShotMustache2.setOnClickListener(this);
        this.mThemeShotMustache3.setOnClickListener(this);
        mThemeShotMustacheCanel.setOnClickListener(this);
        mThemeShotGlassesBack.setOnClickListener(this);
        this.mThemeShotGlasses1.setOnClickListener(this);
        this.mThemeShotGlasses2.setOnClickListener(this);
        this.mThemeShotGlasses3.setOnClickListener(this);
        mThemeShotGlassesCanel.setOnClickListener(this);
        this.mAnimationShowButton.setOnClickListener(this);
        this.mThemeShotShowButton.setOnClickListener(this);
        this.mAnimationLayout.setVisibility(8);
        this.mThemeShotAllLayout.setVisibility(8);
    }

    public void setParent(ChatOnCallActivity parent, boolean isLandscapeMode) {
        this.mParentActivity = parent;
    }

    public void closeView() {
        closeEmotionalAnimation();
        closeThemeShot();
        closeSubThemeShot();
        this.mParentActivity.closeThemeShotEmotionalAnimation();
    }

    public void stopFunction() {
        logI("stopFunction()");
        offAutoAnimation();
        this.mAutoEmotion = false;
        this.mAnimationLayout.setVisibility(8);
        setThemeShotCancel();
        this.mThemeShotAllLayout.setVisibility(8);
        hideSubThemeShot();
        this.mParentActivity.closeThemeShotEmotionalAnimation();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        onClickAnimation(view);
    }

    private void onClickAnimation(View view) {
        switch (view.getId()) {
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
                this.mAutoEmotion = false;
                this.mParentActivity.closeThemeShotEmotionalAnimation();
                this.mAnimationLayout.setVisibility(8);
                break;
            case C0000R.id.animation_show_btn /* 2131493441 */:
                setVisibiltyAnimaiontLayout();
                break;
            default:
                onClickTheme(view);
                break;
        }
    }

    public void closeEmotionalAnimation() {
        if (this.mAnimationLayout != null) {
            this.mAnimationLayout.setVisibility(8);
        }
    }

    private void onClickTheme(View view) {
        switch (view.getId()) {
            case C0000R.id.themeshot_show_btn /* 2131493444 */:
                setVisibiltyThemeShotLayout();
                break;
            case C0000R.id.themeshot_setting_layout /* 2131493445 */:
            case C0000R.id.themeshot_layout /* 2131493446 */:
            default:
                onClickThemeSub(view);
                break;
            case C0000R.id.themeshot1 /* 2131493447 */:
                this.mThemeShotLayout.setVisibility(8);
                this.mThemeShotPartyLayout.setVisibility(0);
                mThemeShotType = 1;
                break;
            case C0000R.id.themeshot2 /* 2131493448 */:
                this.mThemeShotLayout.setVisibility(8);
                this.mThemeShotAnimalLayout.setVisibility(0);
                mThemeShotType = 2;
                break;
            case C0000R.id.themeshot3 /* 2131493449 */:
                this.mThemeShotLayout.setVisibility(8);
                this.mThemeShotGlassesLayout.setVisibility(0);
                mThemeShotType = 3;
                break;
            case C0000R.id.themeshot4 /* 2131493450 */:
                this.mThemeShotLayout.setVisibility(8);
                this.mThemeShotHatLayout.setVisibility(0);
                mThemeShotType = 4;
                break;
            case C0000R.id.themeshot5 /* 2131493451 */:
                this.mThemeShotLayout.setVisibility(8);
                this.mThemeShotMustacheLayout.setVisibility(0);
                mThemeShotType = 5;
                break;
            case C0000R.id.themeshot_cancel /* 2131493452 */:
                setThemeShotCancel();
                this.mParentActivity.closeThemeShotEmotionalAnimation();
                this.mThemeShotLayout.setVisibility(8);
                mThemeShotType = 0;
                break;
        }
    }

    private void setThemeShotCancel() {
        logI("setThemeShotCancel: " + this.mSelectedThemeNo + " mSelectedSubNo: " + this.mSelectedSubNo);
        setSubThemeShotAllNotSelected();
        if (this.mIsHideMe) {
            this.mChangedSelectedSubNo = -1;
            this.mChangedSelectedThemeNo = -1;
        } else if (this.mSelectedThemeShotNo != 0) {
            this.mParentActivity.setThemeShot(-1, -1, true);
        }
        this.mAnimationType = 0;
        this.mSelectedThemeNo = -1;
        this.mSelectedSubNo = -1;
        mThemeShotType = 0;
    }

    public void closeThemeShot() {
        if (this.mThemeShotAllLayout != null) {
            this.mThemeShotAllLayout.setVisibility(8);
        }
    }

    private void onClickThemeSub(View view) {
        switch (view.getId()) {
            case C0000R.id.themeshot_animal_back /* 2131493505 */:
                this.mThemeShotAnimalLayout.setVisibility(8);
                this.mThemeShotLayout.setVisibility(0);
                mThemeShotType = 0;
                break;
            case C0000R.id.themeshot_animal_1 /* 2131493506 */:
                selectTheme(1, 0);
                break;
            case C0000R.id.themeshot_animal_2 /* 2131493507 */:
                selectTheme(1, 1);
                break;
            case C0000R.id.themeshot_animal_3 /* 2131493508 */:
                selectTheme(1, 2);
                break;
            case C0000R.id.themeshot_animal_cancel /* 2131493509 */:
                setThemeShotCancel();
                this.mThemeShotAnimalLayout.setVisibility(8);
                this.mParentActivity.closeThemeShotEmotionalAnimation();
                break;
            case C0000R.id.themeshot_glasses_back /* 2131493511 */:
                this.mThemeShotGlassesLayout.setVisibility(8);
                this.mThemeShotLayout.setVisibility(0);
                mThemeShotType = 0;
                break;
            case C0000R.id.themeshot_glasses_1 /* 2131493512 */:
                selectTheme(2, 0);
                break;
            case C0000R.id.themeshot_glasses_2 /* 2131493513 */:
                selectTheme(2, 1);
                break;
            case C0000R.id.themeshot_glasses_3 /* 2131493514 */:
                selectTheme(2, 2);
                break;
            case C0000R.id.themeshot_glasses_cancel /* 2131493515 */:
                setThemeShotCancel();
                this.mThemeShotGlassesLayout.setVisibility(8);
                this.mParentActivity.closeThemeShotEmotionalAnimation();
                break;
            case C0000R.id.themeshot_hat_back /* 2131493517 */:
                this.mThemeShotHatLayout.setVisibility(8);
                this.mThemeShotLayout.setVisibility(0);
                mThemeShotType = 0;
                break;
            case C0000R.id.themeshot_hat_1 /* 2131493518 */:
                selectTheme(3, 0);
                break;
            case C0000R.id.themeshot_hat_2 /* 2131493519 */:
                selectTheme(3, 1);
                break;
            case C0000R.id.themeshot_hat_3 /* 2131493520 */:
                selectTheme(3, 2);
                break;
            case C0000R.id.themeshot_hat_cancel /* 2131493521 */:
                setThemeShotCancel();
                this.mThemeShotHatLayout.setVisibility(8);
                this.mParentActivity.closeThemeShotEmotionalAnimation();
                break;
            case C0000R.id.themeshot_mustache_back /* 2131493523 */:
                this.mThemeShotMustacheLayout.setVisibility(8);
                this.mThemeShotLayout.setVisibility(0);
                mThemeShotType = 0;
                break;
            case C0000R.id.themeshot_mustache_1 /* 2131493524 */:
                selectTheme(4, 0);
                break;
            case C0000R.id.themeshot_mustache_2 /* 2131493525 */:
                selectTheme(4, 1);
                break;
            case C0000R.id.themeshot_mustache_3 /* 2131493526 */:
                selectTheme(4, 2);
                break;
            case C0000R.id.themeshot_mustache_cancel /* 2131493527 */:
                setThemeShotCancel();
                this.mThemeShotMustacheLayout.setVisibility(8);
                this.mParentActivity.closeThemeShotEmotionalAnimation();
                break;
            case C0000R.id.themeshot_party_back /* 2131493529 */:
                this.mThemeShotPartyLayout.setVisibility(8);
                this.mThemeShotLayout.setVisibility(0);
                mThemeShotType = 0;
                break;
            case C0000R.id.themeshot_party_1 /* 2131493530 */:
                selectTheme(0, 0);
                break;
            case C0000R.id.themeshot_party_2 /* 2131493531 */:
                selectTheme(0, 1);
                break;
            case C0000R.id.themeshot_party_3 /* 2131493532 */:
                selectTheme(0, 2);
                break;
            case C0000R.id.themeshot_party_cancel /* 2131493533 */:
                setThemeShotCancel();
                this.mThemeShotPartyLayout.setVisibility(8);
                this.mParentActivity.closeThemeShotEmotionalAnimation();
                break;
        }
    }

    public void closeSubThemeShot() {
        if (this.mThemeShotPartyLayout != null) {
            this.mThemeShotPartyLayout.setVisibility(8);
        }
        if (this.mThemeShotAnimalLayout != null) {
            this.mThemeShotAnimalLayout.setVisibility(8);
        }
        if (this.mThemeShotGlassesLayout != null) {
            this.mThemeShotGlassesLayout.setVisibility(8);
        }
        if (this.mThemeShotHatLayout != null) {
            this.mThemeShotHatLayout.setVisibility(8);
        }
        if (this.mThemeShotMustacheLayout != null) {
            this.mThemeShotMustacheLayout.setVisibility(8);
        }
    }

    private void offThemeShot() {
        logI("offTheme");
        int currentType = this.mParentActivity.mCallStatusData.getThemeShotType();
        if (currentType != 0) {
            for (int selectedNo = 0; selectedNo < 5; selectedNo++) {
                for (int selectedSubNo = 0; selectedSubNo < 3; selectedSubNo++) {
                    if (this.mParentActivity.isThemeShotActive(selectedNo, selectedSubNo)) {
                        this.mParentActivity.setThemeShot(selectedNo, selectedSubNo, true);
                        this.mSelectedThemeNo = -1;
                        this.mSelectedSubNo = -1;
                        this.mAnimationType = 0;
                    }
                }
            }
        }
    }

    private void hideSubThemeShot() {
        this.mThemeShotAnimalLayout.setVisibility(8);
        this.mThemeShotHatLayout.setVisibility(8);
        this.mThemeShotGlassesLayout.setVisibility(8);
        this.mThemeShotMustacheLayout.setVisibility(8);
        this.mThemeShotPartyLayout.setVisibility(8);
    }

    public void displayEmotionalAnimation() {
        this.mParentActivity.checkCallInstanceNRefresh();
        offThemeShot();
        this.mThemeShotAllLayout.setVisibility(8);
        hideSubThemeShot();
        this.mAnimationLayout.setVisibility(0);
        if (mIsAnimationShowMode) {
            this.mAnimationSettingLayout.setVisibility(8);
            this.mAnimationShowButton.setText(this.mContext.getResources().getString(C0000R.string.video_option_menu_show));
        } else {
            this.mAnimationSettingLayout.setVisibility(0);
            this.mAnimationShowButton.setText(this.mContext.getResources().getString(C0000R.string.video_option_menu_hide));
        }
        this.mParentActivity.checkCallInstanceNRefresh();
        this.mAutoEmotion = true;
        this.mIsAutoMode = this.mParentActivity.mCallStatusData.isAlwaysEmotional();
        if (this.mIsAutoMode) {
            this.mAnimationSwitchButton.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_on);
            this.mAnimationType = 1;
        } else {
            this.mAnimationSwitchButton.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_off);
            notSelectedAniButton();
        }
    }

    public void resetAnimationData() {
        mIsAnimationShowMode = false;
        mIsThemeShotShowMode = false;
    }

    private void setVisibiltyAnimaiontLayout() {
        if (mIsAnimationShowMode) {
            this.mAnimationSettingLayout.setVisibility(0);
            mIsAnimationShowMode = false;
            this.mAnimationShowButton.setText(this.mContext.getResources().getString(C0000R.string.video_option_menu_hide));
        } else {
            this.mAnimationSettingLayout.setVisibility(8);
            mIsAnimationShowMode = true;
            this.mAnimationShowButton.setText(this.mContext.getResources().getString(C0000R.string.video_option_menu_show));
        }
    }

    private void setEmotionalAnimation(int selectedNo) {
        if (this.mParentActivity != null) {
            if (selectedNo == -1) {
                this.mSelectedAnimationNo = -1;
                notSelectedAniButton();
                this.mParentActivity.setEmotionalAnimation(this.mSelectedAnimationNo, this.mIsAutoMode);
                return;
            }
            if (this.mIsAutoMode) {
                setAutoFaceEmotion(false);
                this.mAnimationSwitchButton.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_off);
                this.mIsAutoMode = false;
                this.mParentActivity.setEmotionalAnimation(selectedNo, this.mIsAutoMode);
            } else {
                this.mParentActivity.setEmotionalAnimation(selectedNo, this.mIsAutoMode);
            }
            this.mParentActivity.checkCallInstanceNRefresh();
        }
    }

    private void notSelectedAniButton() {
        this.mAnimation1.setBackgroundResource(C0000R.drawable.call_video_btn_ani_selector);
        this.mAnimation2.setBackgroundResource(C0000R.drawable.call_video_btn_ani_selector);
        this.mAnimation3.setBackgroundResource(C0000R.drawable.call_video_btn_ani_selector);
        this.mAnimation4.setBackgroundResource(C0000R.drawable.call_video_btn_ani_selector);
        this.mAnimation5.setBackgroundResource(C0000R.drawable.call_video_btn_ani_selector);
    }

    private void changeEmotionalAnimationAlwaysMode() {
        if (this.mIsAutoMode) {
            this.mIsAutoMode = false;
            this.mAnimationSwitchButton.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_off);
            notSelectedAniButton();
            setAutoFaceEmotion(false);
            this.mParentActivity.setEmotionalAnimation(-1, this.mIsAutoMode);
            return;
        }
        this.mIsAutoMode = true;
        setEmotionalAnimation(-1);
        this.mAnimationSwitchButton.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_on);
        if (this.mAutoEmotion) {
            this.mAutoEmotion = false;
            Toast.makeText(this.mContext, this.mContext.getResources().getString(C0000R.string.video_animated_emotioins_auto), 0).show();
        }
        setAutoFaceEmotion(true);
    }

    public void displayEmotionalAutoOn() {
        this.mIsAutoMode = true;
        setEmotionalAnimation(-1);
        this.mAnimationSwitchButton.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_on);
        if (this.mAutoEmotion) {
            this.mAutoEmotion = false;
            Toast.makeText(this.mContext, this.mContext.getResources().getString(C0000R.string.video_animated_emotioins_auto), 0).show();
        }
        setAutoFaceEmotion(true);
    }

    private void setAutoFaceEmotion(boolean goAuto) {
        int faceEmotion = -1;
        this.mAnimationType = 0;
        if (goAuto) {
            faceEmotion = 0;
            this.mAnimationType = 1;
        }
        logI("setAutoFaceEmotion goAuto: " + goAuto);
        this.mParentActivity.setFaceEmotion(faceEmotion);
    }

    private void offAutoAnimation() {
        if (this.mIsAutoMode) {
            this.mIsAutoMode = false;
            setAutoFaceEmotion(false);
            this.mParentActivity.setEmotionalAnimation(-1, this.mIsAutoMode);
        }
    }

    public boolean isAlwaysMode() {
        return this.mIsAutoMode;
    }

    public void setAlwaysMode(boolean mode) {
        this.mIsAutoMode = mode;
    }

    private void setVisibilitySubThemeLayout() {
        switch (mThemeShotType) {
            case 1:
                this.mThemeShotLayout.setVisibility(8);
                this.mThemeShotPartyLayout.setVisibility(0);
                break;
            case 2:
                this.mThemeShotLayout.setVisibility(8);
                this.mThemeShotAnimalLayout.setVisibility(0);
                break;
            case 3:
                this.mThemeShotLayout.setVisibility(8);
                this.mThemeShotGlassesLayout.setVisibility(0);
                break;
            case 4:
                this.mThemeShotLayout.setVisibility(8);
                this.mThemeShotHatLayout.setVisibility(0);
                break;
            case 5:
                this.mThemeShotLayout.setVisibility(8);
                this.mThemeShotMustacheLayout.setVisibility(0);
                break;
            default:
                hideSubThemeShot();
                this.mThemeShotLayout.setVisibility(0);
                break;
        }
    }

    public void displayThemeShot() {
        offAutoAnimation();
        this.mAnimationLayout.setVisibility(8);
        this.mThemeShotAllLayout.setVisibility(0);
        hideSubThemeShot();
        setVisibilitySubThemeLayout();
        logI("mIsThemeShotShowMode: " + mIsThemeShotShowMode + " mThemeShotType: " + mThemeShotType);
        if (mIsThemeShotShowMode) {
            this.mThemeShotSettingLayout.setVisibility(8);
            this.mThemeShotShowButton.setText(this.mContext.getResources().getString(C0000R.string.video_option_menu_show));
        } else {
            this.mThemeShotSettingLayout.setVisibility(0);
            this.mThemeShotShowButton.setText(this.mContext.getResources().getString(C0000R.string.video_option_menu_hide));
        }
        setDrawSelectedThemeShot(false);
    }

    public void displayThemeShotForP2P() {
        setDrawSelectedThemeShot(true);
    }

    private void setDrawSelectedThemeShot(boolean isChangeP2P) {
        int currentType = this.mParentActivity.mCallStatusData.getThemeShotType();
        logI("setDrawSelectedThemeShot() currentType: " + Integer.toBinaryString(currentType));
        if (currentType == 0) {
            setSubThemeShotAllNotSelected();
            return;
        }
        for (int selectedNo = 0; selectedNo < 5; selectedNo++) {
            for (int selectedSubNo = 0; selectedSubNo < 3; selectedSubNo++) {
                if (this.mParentActivity.isThemeShotActive(selectedNo, selectedSubNo)) {
                    if (isChangeP2P) {
                        requestAgain(selectedNo, selectedSubNo);
                    }
                    selectedThemeShotButton(selectedNo, selectedSubNo);
                }
            }
        }
    }

    private void setSubThemeShotAllNotSelected() {
        logI("setSubThemeShotAllNotSelected()");
        this.mThemeShotParty1.setBackgroundColor(0);
        this.mThemeShotParty2.setBackgroundColor(0);
        this.mThemeShotParty3.setBackgroundColor(0);
        this.mThemeShotAnimal1.setBackgroundColor(0);
        this.mThemeShotAnimal2.setBackgroundColor(0);
        this.mThemeShotAnimal3.setBackgroundColor(0);
        this.mThemeShotGlasses1.setBackgroundColor(0);
        this.mThemeShotGlasses2.setBackgroundColor(0);
        this.mThemeShotGlasses3.setBackgroundColor(0);
        this.mThemeShotHat1.setBackgroundColor(0);
        this.mThemeShotHat2.setBackgroundColor(0);
        this.mThemeShotHat3.setBackgroundColor(0);
        this.mThemeShotMustache1.setBackgroundColor(0);
        this.mThemeShotMustache2.setBackgroundColor(0);
        this.mThemeShotMustache3.setBackgroundColor(0);
    }

    private void selectedThemeShotButton(int selectedNo, int selectedSubNo) {
        logI("selectedThemeShot(" + selectedNo + ", " + selectedSubNo + ")");
        ImageView image = getSubThemeShotImageView(selectedNo, selectedSubNo);
        if (image != null) {
            logI("selectedThemeShot(): set selection");
            image.setBackgroundResource(C0000R.drawable.videocall_emotionalanimation_press);
        }
    }

    private void notSelectedThemeShotButton(int selectedNo, int selectedSubNo) {
        logI("notSelectedThemeShotButton(" + selectedNo + ", " + selectedSubNo + ")");
        ImageView image = getSubThemeShotImageView(selectedNo, selectedSubNo);
        if (image != null) {
            logI("notSelectedThemeShotButton(): set unselection");
            image.setBackgroundColor(0);
        }
    }

    public void startHideMe() {
        logI("startHideMe(): mSelectedThemeNo: " + this.mSelectedThemeNo + " mSelectedSubNo: " + this.mSelectedSubNo);
        this.mPreSelectedThemeNo = this.mSelectedThemeNo;
        this.mPreSelectedSubNo = this.mSelectedSubNo;
        this.mChangedSelectedThemeNo = this.mSelectedThemeNo;
        this.mChangedSelectedSubNo = this.mSelectedSubNo;
        this.mIsHideMe = true;
    }

    private void setVisibiltyThemeShotLayout() {
        if (mIsThemeShotShowMode) {
            this.mThemeShotSettingLayout.setVisibility(0);
            setVisibilitySubThemeLayout();
            mIsThemeShotShowMode = false;
            this.mThemeShotShowButton.setText(this.mContext.getResources().getString(C0000R.string.video_option_menu_hide));
            return;
        }
        this.mThemeShotSettingLayout.setVisibility(8);
        mIsThemeShotShowMode = true;
        this.mThemeShotShowButton.setText(this.mContext.getResources().getString(C0000R.string.video_option_menu_show));
    }

    private void selectTheme(int selectedNo, int selectedSubNo) {
        logI("new selectTheme(" + selectedNo + ", " + selectedSubNo + ") old selectTheme(" + this.mSelectedThemeNo + ", " + this.mSelectedSubNo + ")");
        if (this.mIsHideMe) {
            if (selectedNo == this.mChangedSelectedThemeNo && selectedSubNo == this.mChangedSelectedSubNo) {
                notSelectedThemeShotButton(selectedNo, selectedSubNo);
                this.mAnimationType = 0;
                this.mChangedSelectedSubNo = selectedSubNo;
                this.mChangedSelectedThemeNo = selectedNo;
            } else {
                removeHideMeSelectedThemeShotButton(selectedNo, selectedSubNo);
                this.mAnimationType = 2;
                this.mChangedSelectedSubNo = selectedSubNo;
                this.mChangedSelectedThemeNo = selectedNo;
            }
            this.mChangedThemeShot = true;
            logI("HIDEME : after selectTheme(): mChangedSelectedThemeNo: " + this.mChangedSelectedThemeNo + " mChangedSelectedSubNo: " + this.mChangedSelectedSubNo);
            return;
        }
        if (this.mParentActivity.isThemeShotActive(selectedNo, selectedSubNo)) {
            notSelectedThemeShotButton(selectedNo, selectedSubNo);
            this.mParentActivity.setThemeShot(selectedNo, selectedSubNo, true);
            this.mAnimationType = 0;
        } else {
            this.mParentActivity.setThemeShot(-1, -1, true);
            this.mAnimationType = 0;
            removeSelectedThemeShotButton(selectedNo, selectedSubNo);
        }
        this.mSelectedThemeNo = selectedNo;
        this.mSelectedSubNo = selectedSubNo;
        this.mParentActivity.checkCallInstanceNRefresh();
        this.mSelectedThemeShotNo = this.mParentActivity.mCallStatusData.getThemeShotType();
        logI("setThemeShot() selectedThemeShotNo: " + Integer.toBinaryString(this.mSelectedThemeShotNo));
        if (this.mSelectedThemeShotNo == 0) {
            this.mAnimationType = 0;
        } else {
            this.mAnimationType = 2;
        }
    }

    private void requestAgain(int selectedNo, int selectedSubNo) {
        this.mParentActivity.setThemeShot(selectedNo, selectedSubNo, false);
        this.mSelectedThemeNo = selectedNo;
        this.mSelectedSubNo = selectedSubNo;
        this.mParentActivity.checkCallInstanceNRefresh();
        this.mSelectedThemeShotNo = this.mParentActivity.mCallStatusData.getThemeShotType();
        logI("setThemeShot() selectedThemeShotNo: " + Integer.toBinaryString(this.mSelectedThemeShotNo));
        if (this.mSelectedThemeShotNo == 0) {
            this.mAnimationType = 0;
        } else {
            this.mAnimationType = 2;
        }
    }

    private void removeSelectedThemeShotButton(int selectedNo, int selectedSubNo) {
        setSubThemeShotAllNotSelected();
        for (int i = 0; i < 3; i++) {
            if (i != selectedSubNo && this.mParentActivity.isThemeShotActive(selectedNo, i)) {
                notSelectedThemeShotButton(selectedNo, i);
                this.mParentActivity.setThemeShot(selectedNo, i, true);
            }
        }
        selectedThemeShotButton(selectedNo, selectedSubNo);
        this.mParentActivity.setThemeShot(selectedNo, selectedSubNo, true);
        this.mAnimationType = 2;
    }

    private void removeHideMeSelectedThemeShotButton(int selectedNo, int selectedSubNo) {
        setSubThemeShotAllNotSelected();
        selectedThemeShotButton(selectedNo, selectedSubNo);
        this.mAnimationType = 2;
    }

    public void refreshOptionMenu(boolean isAnimation, boolean isThemeShot) {
        this.mParentActivity.checkCallInstanceNRefresh();
        if (isAnimation) {
            this.mAnimationSwitchButton.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_off);
        }
        if (isThemeShot) {
            notSelectedThemeShotButton(this.mSelectedThemeNo, this.mSelectedSubNo);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private ImageView getSubThemeShotImageView(int selectedNo, int selectedSubNo) {
        switch (selectedNo) {
            case 0:
                if (selectedSubNo == 0) {
                    return this.mThemeShotParty1;
                }
                if (selectedSubNo == 1) {
                    return this.mThemeShotParty2;
                }
                if (selectedSubNo == 2) {
                    return this.mThemeShotParty3;
                }
                return null;
            case 1:
                if (selectedSubNo == 0) {
                    return this.mThemeShotAnimal1;
                }
                if (selectedSubNo == 1) {
                    return this.mThemeShotAnimal2;
                }
                if (selectedSubNo == 2) {
                    return this.mThemeShotAnimal3;
                }
                return null;
            case 2:
                if (selectedSubNo == 0) {
                    return this.mThemeShotGlasses1;
                }
                if (selectedSubNo == 1) {
                    return this.mThemeShotGlasses2;
                }
                if (selectedSubNo == 2) {
                    return this.mThemeShotGlasses3;
                }
                return null;
            case 3:
                if (selectedSubNo == 0) {
                    return this.mThemeShotHat1;
                }
                if (selectedSubNo == 1) {
                    return this.mThemeShotHat2;
                }
                if (selectedSubNo == 2) {
                    return this.mThemeShotHat3;
                }
                return null;
            case 4:
                if (selectedSubNo == 0) {
                    return this.mThemeShotMustache1;
                }
                if (selectedSubNo == 1) {
                    return this.mThemeShotMustache2;
                }
                if (selectedSubNo == 2) {
                    return this.mThemeShotMustache3;
                }
                return null;
            default:
                return null;
        }
    }

    public int reStartAnimation() {
        logI("reStartAnimation mAnimationType: " + this.mAnimationType);
        if (this.mAnimationType == 1) {
            this.mIsAutoMode = this.mParentActivity.mCallStatusData.isAlwaysEmotional();
            logI("reStartAnimation mIsAutoMode: " + this.mIsAutoMode);
            if (this.mIsAutoMode) {
                this.mAnimationSwitchButton.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_on);
                this.mAnimationType = 1;
                setAutoFaceEmotion(true);
            } else {
                this.mAnimationSwitchButton.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_off);
                notSelectedAniButton();
                setAutoFaceEmotion(false);
            }
        } else if (this.mAnimationType == 2) {
            if (this.mChangedThemeShot) {
                logI("HIDEME : reStartAnimation() : mChangedSelectedThemeNo: " + this.mChangedSelectedThemeNo + " mChangedSelectedSubNo: " + this.mChangedSelectedSubNo + " mPreSelectedThemeNo: " + this.mPreSelectedThemeNo + " mPreSelectedSubNo: " + this.mPreSelectedSubNo);
                if (this.mChangedSelectedSubNo == this.mPreSelectedSubNo && this.mChangedSelectedThemeNo == this.mPreSelectedThemeNo) {
                    this.mParentActivity.setThemeShot(this.mPreSelectedThemeNo, this.mPreSelectedSubNo, true);
                    this.mSelectedThemeNo = this.mPreSelectedThemeNo;
                    this.mSelectedSubNo = this.mPreSelectedSubNo;
                } else {
                    this.mParentActivity.setThemeShot(this.mChangedSelectedThemeNo, this.mChangedSelectedSubNo, true);
                    this.mSelectedThemeNo = this.mChangedSelectedThemeNo;
                    this.mSelectedSubNo = this.mChangedSelectedSubNo;
                }
            } else {
                logI("reStartAnimation mSelectedThemeShotNo: " + this.mSelectedThemeShotNo + " mSelectedThemeNo: " + this.mSelectedThemeNo + " mSelectedSubNo:" + this.mSelectedSubNo);
                this.mParentActivity.setThemeShot(this.mSelectedThemeNo, this.mSelectedSubNo, true);
            }
        } else if (this.mChangedThemeShot && this.mAnimationType == 0 && this.mChangedSelectedSubNo == this.mPreSelectedSubNo && this.mChangedSelectedThemeNo == this.mPreSelectedThemeNo) {
            this.mParentActivity.setThemeShot(this.mSelectedThemeNo, this.mSelectedSubNo, true);
        }
        initData();
        return this.mAnimationType;
    }

    private void initData() {
        this.mIsHideMe = false;
        this.mChangedThemeShot = false;
        this.mPreSelectedSubNo = -1;
        this.mPreSelectedThemeNo = -1;
        this.mChangedSelectedSubNo = -1;
        this.mChangedSelectedThemeNo = -1;
        mThemeShotType = 0;
    }

    public void resetAllData() {
        if (this.mParentActivity != null) {
            logI("resetEmtionalThemeData() ");
            setSubThemeShotAllNotSelected();
            this.mParentActivity.setThemeShot(-1, -1, true);
            notSelectedAniButton();
            setEmotionalAnimation(-1);
            if (this.mIsAutoMode) {
                this.mAnimationSwitchButton.setImageResource(C0000R.drawable.videocall_emotionalanimation_auto_off);
                setAutoFaceEmotion(false);
                this.mParentActivity.setEmotionalAnimation(-1, false);
            }
            this.mIsAutoMode = false;
            this.mSelectedAnimationNo = -1;
            this.mSelectedThemeShotNo = -1;
            mIsAnimationShowMode = false;
            mIsThemeShotShowMode = false;
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mAnimationLayout != null) {
            this.mAnimationLayout.removeAllViews();
            this.mAnimationLayout = null;
        }
        if (this.mAnimationShowButton != null) {
            this.mAnimationShowButton.removeCallbacks(null);
            this.mAnimationShowButton = null;
        }
        if (this.mAnimationSettingLayout != null) {
            this.mAnimationSettingLayout.removeAllViews();
            this.mAnimationSettingLayout = null;
        }
        if (this.mAnimation1 != null) {
            this.mAnimation1.removeCallbacks(null);
            this.mAnimation1 = null;
        }
        if (this.mAnimation2 != null) {
            this.mAnimation2.removeCallbacks(null);
            this.mAnimation2 = null;
        }
        if (this.mAnimation3 != null) {
            this.mAnimation3.removeCallbacks(null);
            this.mAnimation3 = null;
        }
        if (this.mAnimation4 != null) {
            this.mAnimation4.removeCallbacks(null);
            this.mAnimation4 = null;
        }
        if (this.mAnimation5 != null) {
            this.mAnimation5.removeCallbacks(null);
            this.mAnimation5 = null;
        }
        if (this.mAnimationCanel != null) {
            this.mAnimationCanel.removeCallbacks(null);
            this.mAnimationCanel = null;
        }
        if (this.mAnimationAlways != null) {
            this.mAnimationAlways.removeCallbacks(null);
            this.mAnimationAlways = null;
        }
        if (this.mAnimationSwitchButton != null) {
            this.mAnimationSwitchButton.removeCallbacks(null);
            this.mAnimationSwitchButton = null;
        }
        if (this.mThemeShot1 != null) {
            this.mThemeShot1.removeCallbacks(null);
            this.mThemeShot1 = null;
        }
        if (this.mThemeShot2 != null) {
            this.mThemeShot2.removeCallbacks(null);
            this.mThemeShot2 = null;
        }
        if (this.mThemeShot3 != null) {
            this.mThemeShot3.removeCallbacks(null);
            this.mThemeShot3 = null;
        }
        if (this.mThemeShot4 != null) {
            this.mThemeShot4.removeCallbacks(null);
            this.mThemeShot4 = null;
        }
        if (this.mThemeShot5 != null) {
            this.mThemeShot5.removeCallbacks(null);
            this.mThemeShot5 = null;
        }
        if (this.mThemeShotCanel != null) {
            this.mThemeShotCanel.removeCallbacks(null);
            this.mThemeShotCanel = null;
        }
        if (this.mThemeShotShowButton != null) {
            this.mThemeShotShowButton.removeCallbacks(null);
            this.mThemeShotShowButton = null;
        }
        if (this.mThemeShotSettingLayout != null) {
            this.mThemeShotSettingLayout.removeAllViews();
            this.mThemeShotSettingLayout = null;
        }
        if (this.mThemeShotLayout != null) {
            this.mThemeShotLayout.removeAllViews();
            this.mThemeShotLayout = null;
        }
    }
}
