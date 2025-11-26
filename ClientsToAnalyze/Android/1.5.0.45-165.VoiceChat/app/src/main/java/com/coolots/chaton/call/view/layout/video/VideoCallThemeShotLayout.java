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
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.view.VideoCallActivity;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VideoCallThemeShotLayout extends RelativeLayout implements View.OnClickListener, DisposeInterface {
    private static final int THEMESHOT_SELECT_BUTTON_BG_RID = 2130838393;
    private static final int THEMESHOT_UNSELECT_BUTTON_BG_COLOR = 0;
    private static boolean mIsThemeShotShowMode;
    private static int mThemeShotType;
    private int mChangedSelectedSubNo;
    private int mChangedSelectedThemeNo;
    private boolean mChangedThemeShot;
    private boolean mIsHideMe;
    private VideoCallActivity mParentActivity;
    private int mPreSelectedSubNo;
    private int mPreSelectedThemeNo;
    private int mSelectedSubNo;
    private int mSelectedThemeNo;
    private int mSelectedThemeShotNo;
    private ImageView mThemeShot1;
    private ImageView mThemeShot2;
    private ImageView mThemeShot3;
    private ImageView mThemeShot4;
    private ImageView mThemeShot5;
    private ImageView mThemeShotAnimal1;
    private ImageView mThemeShotAnimal2;
    private ImageView mThemeShotAnimal3;
    private ImageView mThemeShotAnimalBack;
    private ImageView mThemeShotAnimalCanel;
    private LinearLayout mThemeShotAnimalLayout;
    private ImageView mThemeShotCanel;
    private ImageView mThemeShotGlasses1;
    private ImageView mThemeShotGlasses2;
    private ImageView mThemeShotGlasses3;
    private ImageView mThemeShotGlassesBack;
    private ImageView mThemeShotGlassesCanel;
    private LinearLayout mThemeShotGlassesLayout;
    private ImageView mThemeShotHat1;
    private ImageView mThemeShotHat2;
    private ImageView mThemeShotHat3;
    private ImageView mThemeShotHatBack;
    private ImageView mThemeShotHatCanel;
    private LinearLayout mThemeShotHatLayout;
    private LinearLayout mThemeShotLayout;
    private ImageView mThemeShotMustache1;
    private ImageView mThemeShotMustache2;
    private ImageView mThemeShotMustache3;
    private ImageView mThemeShotMustacheBack;
    private ImageView mThemeShotMustacheCanel;
    private LinearLayout mThemeShotMustacheLayout;
    private ImageView mThemeShotParty1;
    private ImageView mThemeShotParty2;
    private ImageView mThemeShotParty3;
    private ImageView mThemeShotPartyBack;
    private ImageView mThemeShotPartyCanel;
    private LinearLayout mThemeShotPartyLayout;
    private FrameLayout mThemeShotSettingLayout;

    public VideoCallThemeShotLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSelectedThemeShotNo = -1;
        this.mSelectedSubNo = -1;
        this.mSelectedThemeNo = -1;
        this.mPreSelectedSubNo = -1;
        this.mPreSelectedThemeNo = -1;
        this.mChangedSelectedSubNo = -1;
        this.mChangedSelectedThemeNo = -1;
        this.mChangedThemeShot = false;
        this.mIsHideMe = false;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_theme_shot, (ViewGroup) this, true);
    }

    public void setParent(VideoCallActivity parent, boolean isLandscapeMode) {
        this.mParentActivity = parent;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initLayout();
    }

    private void initLayout() {
        this.mThemeShotSettingLayout = (FrameLayout) findViewById(C0000R.id.themeshot_setting_layout);
        this.mThemeShotLayout = (LinearLayout) findViewById(C0000R.id.themeshot_layout);
        this.mThemeShot1 = (ImageView) findViewById(C0000R.id.themeshot1);
        this.mThemeShot2 = (ImageView) findViewById(C0000R.id.themeshot2);
        this.mThemeShot3 = (ImageView) findViewById(C0000R.id.themeshot3);
        this.mThemeShot4 = (ImageView) findViewById(C0000R.id.themeshot4);
        this.mThemeShot5 = (ImageView) findViewById(C0000R.id.themeshot5);
        this.mThemeShotCanel = (ImageView) findViewById(C0000R.id.themeshot_cancel);
        this.mThemeShot1.setContentDescription(getResources().getString(C0000R.string.icon, 1));
        this.mThemeShot2.setContentDescription(getResources().getString(C0000R.string.icon, 2));
        this.mThemeShot3.setContentDescription(getResources().getString(C0000R.string.icon, 3));
        this.mThemeShot4.setContentDescription(getResources().getString(C0000R.string.icon, 4));
        this.mThemeShot5.setContentDescription(getResources().getString(C0000R.string.icon, 5));
        this.mThemeShot1.setOnClickListener(this);
        this.mThemeShot2.setOnClickListener(this);
        this.mThemeShot3.setOnClickListener(this);
        this.mThemeShot4.setOnClickListener(this);
        this.mThemeShot5.setOnClickListener(this);
        this.mThemeShotCanel.setOnClickListener(this);
        this.mThemeShotAnimalLayout = (LinearLayout) findViewById(C0000R.id.video_call_theme_animal_layout);
        this.mThemeShotAnimalBack = (ImageView) findViewById(C0000R.id.themeshot_animal_back);
        this.mThemeShotAnimal1 = (ImageView) findViewById(C0000R.id.themeshot_animal_1);
        this.mThemeShotAnimal2 = (ImageView) findViewById(C0000R.id.themeshot_animal_2);
        this.mThemeShotAnimal3 = (ImageView) findViewById(C0000R.id.themeshot_animal_3);
        this.mThemeShotAnimalCanel = (ImageView) findViewById(C0000R.id.themeshot_animal_cancel);
        this.mThemeShotAnimal1.setContentDescription(getResources().getString(C0000R.string.icon, 1));
        this.mThemeShotAnimal2.setContentDescription(getResources().getString(C0000R.string.icon, 2));
        this.mThemeShotAnimal3.setContentDescription(getResources().getString(C0000R.string.icon, 3));
        this.mThemeShotAnimalBack.setOnClickListener(this);
        this.mThemeShotAnimal1.setOnClickListener(this);
        this.mThemeShotAnimal2.setOnClickListener(this);
        this.mThemeShotAnimal3.setOnClickListener(this);
        this.mThemeShotAnimalCanel.setOnClickListener(this);
        this.mThemeShotGlassesLayout = (LinearLayout) findViewById(C0000R.id.video_call_theme_glasses_layout);
        this.mThemeShotGlassesBack = (ImageView) findViewById(C0000R.id.themeshot_glasses_back);
        this.mThemeShotGlasses1 = (ImageView) findViewById(C0000R.id.themeshot_glasses_1);
        this.mThemeShotGlasses2 = (ImageView) findViewById(C0000R.id.themeshot_glasses_2);
        this.mThemeShotGlasses3 = (ImageView) findViewById(C0000R.id.themeshot_glasses_3);
        this.mThemeShotGlassesCanel = (ImageView) findViewById(C0000R.id.themeshot_glasses_cancel);
        this.mThemeShotGlasses1.setContentDescription(getResources().getString(C0000R.string.icon, 1));
        this.mThemeShotGlasses2.setContentDescription(getResources().getString(C0000R.string.icon, 2));
        this.mThemeShotGlasses3.setContentDescription(getResources().getString(C0000R.string.icon, 3));
        this.mThemeShotGlassesBack.setOnClickListener(this);
        this.mThemeShotGlasses1.setOnClickListener(this);
        this.mThemeShotGlasses2.setOnClickListener(this);
        this.mThemeShotGlasses3.setOnClickListener(this);
        this.mThemeShotGlassesCanel.setOnClickListener(this);
        this.mThemeShotHatLayout = (LinearLayout) findViewById(C0000R.id.video_call_theme_hat_layout);
        this.mThemeShotHatBack = (ImageView) findViewById(C0000R.id.themeshot_hat_back);
        this.mThemeShotHat1 = (ImageView) findViewById(C0000R.id.themeshot_hat_1);
        this.mThemeShotHat2 = (ImageView) findViewById(C0000R.id.themeshot_hat_2);
        this.mThemeShotHat3 = (ImageView) findViewById(C0000R.id.themeshot_hat_3);
        this.mThemeShotHatCanel = (ImageView) findViewById(C0000R.id.themeshot_hat_cancel);
        this.mThemeShotHat1.setContentDescription(getResources().getString(C0000R.string.icon, 1));
        this.mThemeShotHat2.setContentDescription(getResources().getString(C0000R.string.icon, 2));
        this.mThemeShotHat3.setContentDescription(getResources().getString(C0000R.string.icon, 3));
        this.mThemeShotHatBack.setOnClickListener(this);
        this.mThemeShotHat1.setOnClickListener(this);
        this.mThemeShotHat2.setOnClickListener(this);
        this.mThemeShotHat3.setOnClickListener(this);
        this.mThemeShotHatCanel.setOnClickListener(this);
        this.mThemeShotMustacheLayout = (LinearLayout) findViewById(C0000R.id.video_call_theme_mustache_layout);
        this.mThemeShotMustacheBack = (ImageView) findViewById(C0000R.id.themeshot_mustache_back);
        this.mThemeShotMustache1 = (ImageView) findViewById(C0000R.id.themeshot_mustache_1);
        this.mThemeShotMustache2 = (ImageView) findViewById(C0000R.id.themeshot_mustache_2);
        this.mThemeShotMustache3 = (ImageView) findViewById(C0000R.id.themeshot_mustache_3);
        this.mThemeShotMustacheCanel = (ImageView) findViewById(C0000R.id.themeshot_mustache_cancel);
        this.mThemeShotMustache1.setContentDescription(getResources().getString(C0000R.string.icon, 1));
        this.mThemeShotMustache2.setContentDescription(getResources().getString(C0000R.string.icon, 2));
        this.mThemeShotMustache3.setContentDescription(getResources().getString(C0000R.string.icon, 3));
        this.mThemeShotMustacheBack.setOnClickListener(this);
        this.mThemeShotMustache1.setOnClickListener(this);
        this.mThemeShotMustache2.setOnClickListener(this);
        this.mThemeShotMustache3.setOnClickListener(this);
        this.mThemeShotMustacheCanel.setOnClickListener(this);
        this.mThemeShotPartyLayout = (LinearLayout) findViewById(C0000R.id.video_call_theme_party_layout);
        this.mThemeShotPartyBack = (ImageView) findViewById(C0000R.id.themeshot_party_back);
        this.mThemeShotParty1 = (ImageView) findViewById(C0000R.id.themeshot_party_1);
        this.mThemeShotParty2 = (ImageView) findViewById(C0000R.id.themeshot_party_2);
        this.mThemeShotParty3 = (ImageView) findViewById(C0000R.id.themeshot_party_3);
        this.mThemeShotPartyCanel = (ImageView) findViewById(C0000R.id.themeshot_party_cancel);
        this.mThemeShotParty1.setContentDescription(getResources().getString(C0000R.string.icon, 1));
        this.mThemeShotParty2.setContentDescription(getResources().getString(C0000R.string.icon, 2));
        this.mThemeShotParty3.setContentDescription(getResources().getString(C0000R.string.icon, 3));
        this.mThemeShotPartyBack.setOnClickListener(this);
        this.mThemeShotParty1.setOnClickListener(this);
        this.mThemeShotParty2.setOnClickListener(this);
        this.mThemeShotParty3.setOnClickListener(this);
        this.mThemeShotPartyCanel.setOnClickListener(this);
    }

    public void setThemeShotLayoutParams() {
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
        if (this.mThemeShotSettingLayout != null) {
            this.mThemeShotSettingLayout.removeAllViews();
            this.mThemeShotSettingLayout = null;
        }
        if (this.mThemeShotLayout != null) {
            this.mThemeShotLayout.removeAllViews();
            this.mThemeShotLayout = null;
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
        if (this.mThemeShotAnimalLayout != null) {
            this.mThemeShotAnimalLayout.removeAllViews();
            this.mThemeShotAnimalLayout = null;
        }
        if (this.mThemeShotAnimalBack != null) {
            this.mThemeShotAnimalBack.removeCallbacks(null);
            this.mThemeShotAnimalBack = null;
        }
        if (this.mThemeShotAnimal1 != null) {
            this.mThemeShotAnimal1.removeCallbacks(null);
            this.mThemeShotAnimal1 = null;
        }
        if (this.mThemeShotAnimal2 != null) {
            this.mThemeShotAnimal2.removeCallbacks(null);
            this.mThemeShotAnimal2 = null;
        }
        if (this.mThemeShotAnimal3 != null) {
            this.mThemeShotAnimal3.removeCallbacks(null);
            this.mThemeShotAnimal3 = null;
        }
        if (this.mThemeShotAnimalCanel != null) {
            this.mThemeShotAnimalCanel.removeCallbacks(null);
            this.mThemeShotAnimalCanel = null;
        }
        if (this.mThemeShotGlassesLayout != null) {
            this.mThemeShotGlassesLayout.removeAllViews();
            this.mThemeShotGlassesLayout = null;
        }
        if (this.mThemeShotGlassesBack != null) {
            this.mThemeShotGlassesBack.removeCallbacks(null);
            this.mThemeShotGlassesBack = null;
        }
        if (this.mThemeShotGlasses1 != null) {
            this.mThemeShotGlasses1.removeCallbacks(null);
            this.mThemeShotGlasses1 = null;
        }
        if (this.mThemeShotGlasses2 != null) {
            this.mThemeShotGlasses2.removeCallbacks(null);
            this.mThemeShotGlasses2 = null;
        }
        if (this.mThemeShotGlasses3 != null) {
            this.mThemeShotGlasses3.removeCallbacks(null);
            this.mThemeShotGlasses3 = null;
        }
        if (this.mThemeShotGlassesCanel != null) {
            this.mThemeShotGlassesCanel.removeCallbacks(null);
            this.mThemeShotGlassesCanel = null;
        }
        if (this.mThemeShotHatLayout != null) {
            this.mThemeShotHatLayout.removeAllViews();
            this.mThemeShotHatLayout = null;
        }
        if (this.mThemeShotHatBack != null) {
            this.mThemeShotHatBack.removeCallbacks(null);
            this.mThemeShotHatBack = null;
        }
        if (this.mThemeShotHat1 != null) {
            this.mThemeShotHat1.removeCallbacks(null);
            this.mThemeShotHat1 = null;
        }
        if (this.mThemeShotHat2 != null) {
            this.mThemeShotHat2.removeCallbacks(null);
            this.mThemeShotHat2 = null;
        }
        if (this.mThemeShotHat3 != null) {
            this.mThemeShotHat3.removeCallbacks(null);
            this.mThemeShotHat3 = null;
        }
        if (this.mThemeShotHatCanel != null) {
            this.mThemeShotHatCanel.removeCallbacks(null);
            this.mThemeShotHatCanel = null;
        }
        if (this.mThemeShotMustacheLayout != null) {
            this.mThemeShotMustacheLayout.removeAllViews();
            this.mThemeShotMustacheLayout = null;
        }
        if (this.mThemeShotMustacheBack != null) {
            this.mThemeShotMustacheBack.removeCallbacks(null);
            this.mThemeShotMustacheBack = null;
        }
        if (this.mThemeShotMustache1 != null) {
            this.mThemeShotMustache1.removeCallbacks(null);
            this.mThemeShotMustache1 = null;
        }
        if (this.mThemeShotMustache2 != null) {
            this.mThemeShotMustache2.removeCallbacks(null);
            this.mThemeShotMustache2 = null;
        }
        if (this.mThemeShotMustache3 != null) {
            this.mThemeShotMustache3.removeCallbacks(null);
            this.mThemeShotMustache3 = null;
        }
        if (this.mThemeShotMustacheCanel != null) {
            this.mThemeShotMustacheCanel.removeCallbacks(null);
            this.mThemeShotMustacheCanel = null;
        }
        if (this.mThemeShotPartyLayout != null) {
            this.mThemeShotPartyLayout.removeAllViews();
            this.mThemeShotPartyLayout = null;
        }
        if (this.mThemeShotPartyBack != null) {
            this.mThemeShotPartyBack.removeCallbacks(null);
            this.mThemeShotPartyBack = null;
        }
        if (this.mThemeShotParty1 != null) {
            this.mThemeShotParty1.removeCallbacks(null);
            this.mThemeShotParty1 = null;
        }
        if (this.mThemeShotParty2 != null) {
            this.mThemeShotParty2.removeCallbacks(null);
            this.mThemeShotParty2 = null;
        }
        if (this.mThemeShotParty3 != null) {
            this.mThemeShotParty3.removeCallbacks(null);
            this.mThemeShotParty3 = null;
        }
        if (this.mThemeShotPartyCanel != null) {
            this.mThemeShotPartyCanel.removeCallbacks(null);
            this.mThemeShotPartyCanel = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        switch (view.getId()) {
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
            default:
                onClickThemeSub(view);
                break;
        }
    }

    private void onClickThemeSub(View view) throws Throwable {
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

    private void setVisibiltyThemeShotLayout() {
        if (mIsThemeShotShowMode) {
            this.mThemeShotSettingLayout.setVisibility(0);
            setVisibilitySubThemeLayout();
            mIsThemeShotShowMode = false;
        } else {
            this.mThemeShotSettingLayout.setVisibility(8);
            mIsThemeShotShowMode = true;
        }
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

    private void hideSubThemeShot() {
        this.mThemeShotAnimalLayout.setVisibility(8);
        this.mThemeShotHatLayout.setVisibility(8);
        this.mThemeShotGlassesLayout.setVisibility(8);
        this.mThemeShotMustacheLayout.setVisibility(8);
        this.mThemeShotPartyLayout.setVisibility(8);
    }

    private void setThemeShotCancel() {
        setSubThemeShotAllNotSelected();
        if (this.mIsHideMe) {
            this.mChangedSelectedSubNo = -1;
            this.mChangedSelectedThemeNo = -1;
        } else if (this.mSelectedThemeShotNo != 0) {
            this.mParentActivity.setThemeShot(-1, -1, true);
        }
        this.mSelectedThemeNo = -1;
        this.mSelectedSubNo = -1;
        mThemeShotType = 0;
    }

    public void selectTheme() {
        selectTheme(this.mSelectedThemeNo, this.mSelectedSubNo);
    }

    private void selectTheme(int selectedNo, int selectedSubNo) throws Throwable {
        if (this.mIsHideMe) {
            if (selectedNo == this.mChangedSelectedThemeNo && selectedSubNo == this.mChangedSelectedSubNo) {
                notSelectedThemeShotButton(selectedNo, selectedSubNo);
                this.mChangedSelectedSubNo = selectedSubNo;
                this.mChangedSelectedThemeNo = selectedNo;
            } else {
                removeHideMeSelectedThemeShotButton(selectedNo, selectedSubNo);
                this.mChangedSelectedSubNo = selectedSubNo;
                this.mChangedSelectedThemeNo = selectedNo;
            }
            this.mChangedThemeShot = true;
            return;
        }
        if (selectedNo != -1 && this.mParentActivity.isThemeShotActive(selectedNo, selectedSubNo)) {
            notSelectedThemeShotButton(selectedNo, selectedSubNo);
            this.mParentActivity.setThemeShot(selectedNo, selectedSubNo, true);
        } else {
            this.mParentActivity.setThemeShot(-1, -1, true);
            removeSelectedThemeShotButton(selectedNo, selectedSubNo);
        }
        this.mSelectedThemeNo = selectedNo;
        this.mSelectedSubNo = selectedSubNo;
        this.mParentActivity.checkCallInstanceNRefresh();
        this.mSelectedThemeShotNo = this.mParentActivity.mCallStatusData.getThemeShotType();
    }

    public void setSubThemeShotAllNotSelected() {
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

    private void notSelectedThemeShotButton(int selectedNo, int selectedSubNo) {
        ImageView image = getSubThemeShotImageView(selectedNo, selectedSubNo);
        if (image != null) {
            image.setBackgroundColor(0);
        }
    }

    private void removeHideMeSelectedThemeShotButton(int selectedNo, int selectedSubNo) {
        setSubThemeShotAllNotSelected();
        selectedThemeShotButton(selectedNo, selectedSubNo);
    }

    public void notSelectedThemeShotButton() {
        ImageView image = getSubThemeShotImageView(this.mSelectedThemeNo, this.mSelectedSubNo);
        if (image != null) {
            image.setBackgroundColor(0);
        }
    }

    public void displayThemeShotForP2P() {
        setDrawSelectedThemeShot(true);
    }

    private void removeSelectedThemeShotButton(int selectedNo, int selectedSubNo) {
        setSubThemeShotAllNotSelected();
        if (selectedNo != -1) {
            for (int i = 0; i < 3; i++) {
                if (i != selectedSubNo && this.mParentActivity.isThemeShotActive(selectedNo, i)) {
                    notSelectedThemeShotButton(selectedNo, i);
                    this.mParentActivity.setThemeShot(selectedNo, i, true);
                }
            }
            selectedThemeShotButton(selectedNo, selectedSubNo);
            this.mParentActivity.setThemeShot(selectedNo, selectedSubNo, true);
        }
    }

    private void selectedThemeShotButton(int selectedNo, int selectedSubNo) {
        ImageView image = getSubThemeShotImageView(selectedNo, selectedSubNo);
        if (image != null) {
            image.setBackgroundResource(C0000R.drawable.videocall_emotionalanimation_bg_press_center);
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

    public void displayThemeShot() {
        hideSubThemeShot();
        setVisibilitySubThemeLayout();
        if (mIsThemeShotShowMode) {
            this.mThemeShotSettingLayout.setVisibility(8);
        } else {
            this.mThemeShotSettingLayout.setVisibility(0);
        }
        setThemeShotLayoutParams();
        setDrawSelectedThemeShot(false);
    }

    private void setDrawSelectedThemeShot(boolean isChangeP2P) throws Throwable {
        int currentType = this.mParentActivity.mCallStatusData.getThemeShotType();
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

    private void requestAgain(int selectedNo, int selectedSubNo) throws Throwable {
        this.mParentActivity.setThemeShot(selectedNo, selectedSubNo, false);
        this.mSelectedThemeNo = selectedNo;
        this.mSelectedSubNo = selectedSubNo;
        this.mParentActivity.checkCallInstanceNRefresh();
        this.mSelectedThemeShotNo = this.mParentActivity.mCallStatusData.getThemeShotType();
    }

    public void reStartAnimation() {
        if (this.mChangedThemeShot) {
            if (this.mChangedSelectedSubNo == this.mPreSelectedSubNo && this.mChangedSelectedThemeNo == this.mPreSelectedThemeNo) {
                this.mParentActivity.setThemeShot(this.mPreSelectedThemeNo, this.mPreSelectedSubNo, true);
                this.mSelectedThemeNo = this.mPreSelectedThemeNo;
                this.mSelectedSubNo = this.mPreSelectedSubNo;
                return;
            } else {
                this.mParentActivity.setThemeShot(this.mChangedSelectedThemeNo, this.mChangedSelectedSubNo, true);
                this.mSelectedThemeNo = this.mChangedSelectedThemeNo;
                this.mSelectedSubNo = this.mChangedSelectedSubNo;
                return;
            }
        }
        this.mParentActivity.setThemeShot(this.mSelectedThemeNo, this.mSelectedSubNo, true);
    }

    public void setThemeShot() {
        if (this.mChangedSelectedSubNo == this.mPreSelectedSubNo && this.mChangedSelectedThemeNo == this.mPreSelectedThemeNo) {
            this.mParentActivity.setThemeShot(this.mSelectedThemeNo, this.mSelectedSubNo, true);
        }
    }

    public boolean getChangedThemeShot() {
        return this.mChangedThemeShot;
    }

    public void initData() {
        this.mIsHideMe = false;
        this.mChangedThemeShot = false;
        this.mPreSelectedSubNo = -1;
        this.mPreSelectedThemeNo = -1;
        this.mChangedSelectedSubNo = -1;
        this.mChangedSelectedThemeNo = -1;
        mThemeShotType = 0;
    }

    public void startHideMe() {
        this.mPreSelectedThemeNo = this.mSelectedThemeNo;
        this.mPreSelectedSubNo = this.mSelectedSubNo;
        this.mChangedSelectedThemeNo = this.mSelectedThemeNo;
        this.mChangedSelectedSubNo = this.mSelectedSubNo;
        this.mIsHideMe = true;
    }

    public void setHideMe(boolean flag) {
        this.mIsHideMe = flag;
    }
}
