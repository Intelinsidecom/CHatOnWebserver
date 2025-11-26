package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.calllog.buddy.view.BuddyImageView;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.p022b.C0841a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3205bt;

/* loaded from: classes.dex */
public class List_TypeCallLog extends RelativeLayout {

    /* renamed from: a */
    private RelativeLayout f3431a;

    /* renamed from: b */
    private ImageView f3432b;

    /* renamed from: c */
    private ImageView f3433c;

    /* renamed from: d */
    private ImageView f3434d;

    /* renamed from: e */
    private BuddyImageView f3435e;

    /* renamed from: f */
    private TextView f3436f;

    /* renamed from: g */
    private TextView f3437g;

    /* renamed from: h */
    private TextView f3438h;

    /* renamed from: i */
    private TextView f3439i;

    /* renamed from: j */
    private CheckBox f3440j;

    /* renamed from: k */
    private LinearLayout f3441k;

    public List_TypeCallLog(Context context) {
        super(context);
        m4665a(context);
    }

    public List_TypeCallLog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4665a(context);
    }

    /* renamed from: a */
    private final void m4665a(Context context) {
        View.inflate(context, R.layout.list_type_calllog, this);
        this.f3431a = (RelativeLayout) findViewById(R.id.list_bg);
        this.f3432b = (ImageView) findViewById(R.id.image_calllog_type);
        this.f3433c = (ImageView) findViewById(R.id.image_calllog_method);
        this.f3434d = (ImageView) findViewById(R.id.image_calllog_reject_message);
        this.f3435e = (BuddyImageView) findViewById(R.id.image_calllog_profile);
        this.f3436f = (TextView) findViewById(R.id.txt_name);
        this.f3437g = (TextView) findViewById(R.id.txt_user_count);
        this.f3438h = (TextView) findViewById(R.id.txt_calllog_time);
        this.f3439i = (TextView) findViewById(R.id.txt_calllog_msg);
        this.f3440j = (CheckBox) findViewById(R.id.chk_delete);
        this.f3441k = (LinearLayout) findViewById(R.id.callog_hover_layout);
        this.f3440j.setClickable(false);
        this.f3440j.setFocusable(false);
    }

    public final void setCallType(CallLogData callLogData) {
        this.f3432b.setBackgroundResource(C0841a.m4454c(callLogData));
    }

    public final void setCallMethod(int i) {
        int i2 = R.drawable.buddies_voicecall;
        switch (i) {
            case 6:
            case 10:
                this.f3434d.setVisibility(8);
                break;
            case 7:
            case 11:
                i2 = R.drawable.buddies_videocall;
                this.f3434d.setVisibility(8);
                break;
            case 12:
                i2 = R.drawable.buddies_list_rejected_message;
                this.f3434d.setVisibility(0);
                break;
        }
        this.f3433c.setBackgroundResource(i2);
    }

    public final void setName(String str) {
        if (this.f3436f != null) {
            this.f3436f.setText(str);
        }
    }

    public final void setCallCount(int i) {
        if (i > 1) {
            this.f3437g.setText("(" + Integer.toString(i) + ")");
            this.f3437g.setVisibility(0);
        } else {
            this.f3437g.setVisibility(8);
        }
    }

    public void setDeleteMode(boolean z) {
        if (z) {
            this.f3440j.setVisibility(0);
        } else {
            this.f3440j.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        this.f3440j.setChecked(z);
    }

    public final void setTime(String str) {
        if (this.f3438h != null) {
            if (this.f3440j.getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.alignWithParent = true;
                layoutParams.addRule(11, -1);
                layoutParams.rightMargin = 25;
                this.f3438h.setLayoutParams(layoutParams);
                this.f3438h.setText(str);
                return;
            }
            this.f3438h.setText(str);
        }
    }

    public final void setMsg(String str) {
        this.f3439i.setText(str);
    }

    public void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f3440j.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setProfileImage(boolean z, String str) {
        if (z) {
            if (str != null && str.length() > 0) {
                C3205bt.m11182a(GlobalApplication.m11493l()).m11226b(this.f3435e, str);
                return;
            } else {
                this.f3435e.setImageResource(R.drawable.contacts_default_group);
                return;
            }
        }
        try {
            this.f3435e.m4379a(str);
        } catch (Exception e) {
            this.f3435e.setImageResource(R.drawable.profile_photo_buddy_default);
        }
    }
}
