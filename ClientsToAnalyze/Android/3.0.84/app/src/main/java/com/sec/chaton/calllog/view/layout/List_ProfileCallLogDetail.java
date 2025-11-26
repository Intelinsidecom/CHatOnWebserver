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
public class List_ProfileCallLogDetail extends RelativeLayout {

    /* renamed from: a */
    private RelativeLayout f3419a;

    /* renamed from: b */
    private ImageView f3420b;

    /* renamed from: c */
    private ImageView f3421c;

    /* renamed from: d */
    private TextView f3422d;

    /* renamed from: e */
    private TextView f3423e;

    /* renamed from: f */
    private TextView f3424f;

    /* renamed from: g */
    private CheckBox f3425g;

    /* renamed from: h */
    private CallLogData f3426h;

    /* renamed from: i */
    private int f3427i;

    /* renamed from: j */
    private String f3428j;

    /* renamed from: k */
    private String f3429k;

    /* renamed from: l */
    private String f3430l;

    public List_ProfileCallLogDetail(Context context) {
        super(context);
        this.f3426h = null;
        this.f3427i = -1;
        this.f3428j = "";
        this.f3429k = "";
        this.f3430l = "";
        m4664a(context);
    }

    public List_ProfileCallLogDetail(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3426h = null;
        this.f3427i = -1;
        this.f3428j = "";
        this.f3429k = "";
        this.f3430l = "";
        m4664a(context);
    }

    /* renamed from: a */
    private final void m4664a(Context context) {
        View.inflate(context, R.layout.list_profile_calllog, this);
        this.f3419a = (RelativeLayout) findViewById(R.id.profile_call_layout);
        this.f3420b = (ImageView) findViewById(R.id.profile_call_type);
        this.f3421c = (ImageView) findViewById(R.id.profile_call_method);
        this.f3422d = (TextView) findViewById(R.id.profile_call_time);
        this.f3424f = (TextView) findViewById(R.id.profile_call_duration);
        this.f3423e = (TextView) findViewById(R.id.profile_call_date);
        this.f3425g = (CheckBox) findViewById(R.id.delete);
        setDuration(this.f3429k);
        setTime(this.f3428j);
        setCallType(this.f3426h);
        setCallMethod(this.f3427i);
        setDate(this.f3430l);
        this.f3425g.setClickable(false);
        this.f3425g.setFocusable(false);
    }

    public final void setCallType(CallLogData callLogData) {
        this.f3426h = callLogData;
        this.f3420b.setBackgroundResource(C0841a.m4454c(callLogData));
    }

    public final void setCallMethod(int i) {
        int i2 = R.drawable.profile_info_call;
        this.f3427i = i;
        switch (i) {
            case 7:
            case 11:
                i2 = R.drawable.buddies_list_video_call_light;
                break;
            case 12:
                i2 = R.drawable.buddies_list_rejected_message;
                break;
        }
        this.f3421c.setBackgroundResource(i2);
    }

    public void setDeleteMode(boolean z) {
        if (z) {
            this.f3425g.setVisibility(0);
        } else {
            this.f3425g.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        this.f3425g.setChecked(z);
    }

    public void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f3425g.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public final void setDuration(String str) {
        this.f3429k = str;
        if (this.f3424f != null) {
            this.f3424f.setText(this.f3429k);
        }
    }

    public final void setDate(String str) {
        this.f3430l = str;
        if (this.f3423e != null) {
            this.f3423e.setText(this.f3430l);
        }
    }

    public final void setTime(String str) {
        this.f3428j = str;
        if (this.f3422d != null) {
            this.f3422d.setText(this.f3428j);
        }
    }
}
