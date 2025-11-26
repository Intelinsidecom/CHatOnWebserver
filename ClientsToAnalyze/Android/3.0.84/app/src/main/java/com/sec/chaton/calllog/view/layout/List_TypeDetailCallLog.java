package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.p022b.C0841a;

/* loaded from: classes.dex */
public class List_TypeDetailCallLog extends RelativeLayout {

    /* renamed from: a */
    private RelativeLayout f3442a;

    /* renamed from: b */
    private ImageView f3443b;

    /* renamed from: c */
    private ImageView f3444c;

    /* renamed from: d */
    private ImageView f3445d;

    /* renamed from: e */
    private TextView f3446e;

    /* renamed from: f */
    private TextView f3447f;

    /* renamed from: g */
    private CheckBox f3448g;

    public List_TypeDetailCallLog(Context context) {
        super(context);
        m4666a(context);
    }

    public List_TypeDetailCallLog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4666a(context);
    }

    /* renamed from: a */
    private final void m4666a(Context context) {
        View.inflate(context, R.layout.list_detail_calllog, this);
        this.f3442a = (RelativeLayout) findViewById(R.id.calllog_list);
        this.f3443b = (ImageView) findViewById(R.id.call_type);
        this.f3444c = (ImageView) findViewById(R.id.call_method);
        this.f3445d = (ImageView) findViewById(R.id.image_calllog_reject_message);
        this.f3446e = (TextView) findViewById(R.id.call_time);
        this.f3447f = (TextView) findViewById(R.id.call_duration);
        this.f3448g = (CheckBox) findViewById(R.id.delete);
        this.f3448g.setClickable(false);
        this.f3448g.setFocusable(false);
    }

    public final void setCallType(CallLogData callLogData) {
        this.f3443b.setBackgroundResource(C0841a.m4454c(callLogData));
    }

    public final void setCallMethod(int i) {
        int i2 = R.drawable.buddies_voicecall;
        switch (i) {
            case 6:
            case 10:
                this.f3445d.setVisibility(8);
                break;
            case 7:
            case 11:
                i2 = R.drawable.buddies_videocall;
                this.f3445d.setVisibility(8);
                break;
            case 12:
                i2 = R.drawable.buddies_list_rejected_message;
                this.f3445d.setVisibility(0);
                break;
        }
        this.f3444c.setBackgroundResource(i2);
    }

    public final void setDuration(String str) {
        if (this.f3447f != null) {
            this.f3447f.setText(str);
            this.f3447f.setSelected(true);
        }
    }

    public void setDeleteMode(boolean z) {
        if (z) {
            this.f3448g.setVisibility(0);
        } else {
            this.f3448g.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        this.f3448g.setChecked(z);
    }

    public final void setTime(String str) {
        if (this.f3446e != null) {
            this.f3446e.setText(str);
        }
    }

    public void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f3448g.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
