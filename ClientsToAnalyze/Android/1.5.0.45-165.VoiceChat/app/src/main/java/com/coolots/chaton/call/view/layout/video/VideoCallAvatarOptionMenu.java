package com.coolots.chaton.call.view.layout.video;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VideoCallAvatarOptionMenu extends RelativeLayout implements View.OnClickListener, DisposeInterface {
    private static final int GLASSES = 2;
    private static final int HAIR = 1;
    private static final int MAIN = 0;
    private ImageView mCancelBtn;
    private Button mMenuBtn_1;
    private Button mMenuBtn_2;
    private Button mMenuBtn_3;
    private Button mMenuBtn_4;
    private Button mMenuBtn_5;
    private int mMenuStatus;
    private ChatOnCallActivity mParentActivity;

    public VideoCallAvatarOptionMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_avatar_option_menu, (ViewGroup) this, true);
    }

    private void setMenuStatus(int status) {
        this.mMenuStatus = status;
        setButtonVisibility();
    }

    private void setButtonVisibility() {
        if (this.mMenuStatus == 0) {
            this.mMenuBtn_3.setVisibility(4);
            this.mMenuBtn_4.setVisibility(4);
            this.mMenuBtn_5.setVisibility(4);
        } else {
            this.mMenuBtn_3.setVisibility(0);
            this.mMenuBtn_4.setVisibility(0);
            this.mMenuBtn_5.setVisibility(0);
        }
        setButtonText();
    }

    private void setButtonText() {
        if (this.mMenuStatus == 0) {
            this.mMenuBtn_1.setText("Hair");
            this.mMenuBtn_2.setText("Glasses");
            return;
        }
        String text = null;
        if (this.mMenuStatus == 1) {
            text = "Hair";
        }
        if (this.mMenuStatus == 2) {
            text = "Glasses";
        }
        this.mMenuBtn_1.setText(String.valueOf(text) + 1);
        this.mMenuBtn_2.setText(String.valueOf(text) + 2);
        this.mMenuBtn_3.setText(String.valueOf(text) + 3);
        this.mMenuBtn_4.setText(String.valueOf(text) + 4);
        this.mMenuBtn_5.setText(String.valueOf(text) + 5);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initLayout();
        setMenuStatus(0);
    }

    private void initLayout() {
        this.mCancelBtn = (ImageView) findViewById(C0000R.id.avartar_cancel);
        this.mMenuBtn_1 = (Button) findViewById(C0000R.id.avatar_menu_btn_1);
        this.mMenuBtn_2 = (Button) findViewById(C0000R.id.avatar_menu_btn_2);
        this.mMenuBtn_3 = (Button) findViewById(C0000R.id.avatar_menu_btn_3);
        this.mMenuBtn_4 = (Button) findViewById(C0000R.id.avatar_menu_btn_4);
        this.mMenuBtn_5 = (Button) findViewById(C0000R.id.avatar_menu_btn_5);
        this.mCancelBtn.setOnClickListener(this);
        this.mMenuBtn_1.setOnClickListener(this);
        this.mMenuBtn_2.setOnClickListener(this);
        this.mMenuBtn_3.setOnClickListener(this);
        this.mMenuBtn_4.setOnClickListener(this);
        this.mMenuBtn_5.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Log.e("MMMMM", " v.getId() = " + v.getId());
        switch (v.getId()) {
            case C0000R.id.avartar_cancel /* 2131493383 */:
                if (this.mMenuStatus != 0) {
                    Log.e("MMMMM", " GOMAIN");
                    setMenuStatus(0);
                    break;
                }
                break;
            case C0000R.id.avatar_menu_btn_1 /* 2131493384 */:
                if (this.mMenuStatus == 0) {
                    Log.e("MMMMM", " MAIN1");
                    setMenuStatus(1);
                    break;
                } else if (this.mMenuStatus == 1) {
                    OnClickHair();
                    break;
                } else {
                    OnClickGlasses();
                    break;
                }
            case C0000R.id.avatar_menu_btn_2 /* 2131493385 */:
                if (this.mMenuStatus == 0) {
                    setMenuStatus(2);
                    break;
                } else if (this.mMenuStatus == 1) {
                    OnClickHair();
                    break;
                } else {
                    OnClickGlasses();
                    break;
                }
            case C0000R.id.avatar_menu_btn_3 /* 2131493386 */:
            case C0000R.id.avatar_menu_btn_4 /* 2131493387 */:
            case C0000R.id.avatar_menu_btn_5 /* 2131493388 */:
                if (this.mMenuStatus == 1) {
                    OnClickHair();
                    break;
                } else {
                    OnClickGlasses();
                    break;
                }
        }
    }

    private void OnClickHair() {
    }

    private void OnClickGlasses() {
    }

    public void setParent(ChatOnCallActivity parent, boolean isLandscapeMode) {
        this.mParentActivity = parent;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        reCycleView(this.mCancelBtn);
        reCycleView(this.mMenuBtn_1);
        reCycleView(this.mMenuBtn_2);
        reCycleView(this.mMenuBtn_3);
        reCycleView(this.mMenuBtn_4);
        reCycleView(this.mMenuBtn_5);
    }

    private void reCycleView(View v) {
        if (v != null) {
            v.removeCallbacks(null);
        }
    }
}
