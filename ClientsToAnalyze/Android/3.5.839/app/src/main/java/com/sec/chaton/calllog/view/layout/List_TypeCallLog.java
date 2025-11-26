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
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4855bt;

/* loaded from: classes.dex */
public class List_TypeCallLog extends List_TypeCommonCallLog {

    /* renamed from: e */
    private BuddyImageView f5386e;

    /* renamed from: f */
    private TextView f5387f;

    /* renamed from: g */
    private TextView f5388g;

    /* renamed from: h */
    private TextView f5389h;

    /* renamed from: i */
    private TextView f5390i;

    /* renamed from: j */
    private CheckBox f5391j;

    /* renamed from: k */
    private LinearLayout f5392k;

    public List_TypeCallLog(Context context) {
        super(context);
        m7812a(context);
    }

    public List_TypeCallLog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7812a(context);
    }

    /* renamed from: a */
    private final void m7812a(Context context) {
        View.inflate(context, R.layout.list_type_calllog, this);
        this.f5393a = (RelativeLayout) findViewById(R.id.list_bg);
        this.f5394b = (ImageView) findViewById(R.id.image_calllog_type);
        this.f5395c = (ImageView) findViewById(R.id.image_calllog_method);
        this.f5396d = (ImageView) findViewById(R.id.image_calllog_reject_message);
        this.f5386e = (BuddyImageView) findViewById(R.id.image_calllog_profile);
        this.f5387f = (TextView) findViewById(R.id.txt_name);
        this.f5388g = (TextView) findViewById(R.id.txt_user_count);
        this.f5389h = (TextView) findViewById(R.id.txt_calllog_time);
        this.f5390i = (TextView) findViewById(R.id.txt_calllog_msg);
        this.f5391j = (CheckBox) findViewById(R.id.chk_delete);
        this.f5392k = (LinearLayout) findViewById(R.id.callog_hover_layout);
        this.f5391j.setClickable(false);
        this.f5391j.setFocusable(false);
    }

    public final void setName(String str) {
        if (this.f5387f != null) {
            this.f5387f.setText(str);
        }
    }

    public final void setCallCount(int i) {
        if (i > 1) {
            this.f5388g.setText("(" + Integer.toString(i) + ")");
            this.f5388g.setVisibility(0);
        } else {
            this.f5388g.setVisibility(8);
        }
    }

    public void setDeleteMode(boolean z) {
        if (z) {
            this.f5391j.setVisibility(0);
        } else {
            this.f5391j.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        this.f5391j.setChecked(z);
    }

    public final void setTime(String str) {
        if (this.f5389h != null) {
            if (this.f5391j.getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.alignWithParent = true;
                layoutParams.addRule(11, -1);
                layoutParams.rightMargin = 25;
                this.f5389h.setLayoutParams(layoutParams);
                this.f5389h.setText(str);
                return;
            }
            this.f5389h.setText(str);
        }
    }

    public final void setMsg(String str) {
        this.f5390i.setText(str);
    }

    public void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f5391j.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setProfileImage(boolean z, String str) {
        if (z) {
            if (str != null && str.length() > 0) {
                C4855bt.m18351a(GlobalApplication.m18732r()).m18367b(this.f5386e, str);
                return;
            } else {
                this.f5386e.setImageResource(R.drawable.profile_photo_group_default);
                return;
            }
        }
        try {
            this.f5386e.m7532a(str);
        } catch (Exception e) {
            this.f5386e.setImageResource(R.drawable.profile_photo_buddy_default);
        }
    }
}
