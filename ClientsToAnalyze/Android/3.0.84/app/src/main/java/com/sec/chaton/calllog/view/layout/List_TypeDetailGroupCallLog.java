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
public class List_TypeDetailGroupCallLog extends RelativeLayout {

    /* renamed from: a */
    private RelativeLayout f3449a;

    /* renamed from: b */
    private ImageView f3450b;

    /* renamed from: c */
    private ImageView f3451c;

    /* renamed from: d */
    private ImageView f3452d;

    /* renamed from: e */
    private TextView f3453e;

    /* renamed from: f */
    private TextView f3454f;

    /* renamed from: g */
    private TextView f3455g;

    /* renamed from: h */
    private CheckBox f3456h;

    public List_TypeDetailGroupCallLog(Context context) {
        super(context);
        m4667a(context);
    }

    public List_TypeDetailGroupCallLog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4667a(context);
    }

    /* renamed from: a */
    private final void m4667a(Context context) {
        View.inflate(context, R.layout.list_detail_group_calllog, this);
        this.f3449a = (RelativeLayout) findViewById(R.id.calllog_list);
        this.f3450b = (ImageView) findViewById(R.id.call_type);
        this.f3451c = (ImageView) findViewById(R.id.call_method);
        this.f3452d = (ImageView) findViewById(R.id.image_calllog_reject_message);
        this.f3453e = (TextView) findViewById(R.id.call_time_at);
        this.f3454f = (TextView) findViewById(R.id.call_time);
        this.f3455g = (TextView) findViewById(R.id.call_duration);
        this.f3456h = (CheckBox) findViewById(R.id.delete);
        this.f3456h.setClickable(false);
        this.f3456h.setFocusable(false);
    }

    public final void setCallType(CallLogData callLogData) {
        this.f3450b.setBackgroundResource(C0841a.m4454c(callLogData));
    }

    public final void setCallMethod(int i) {
        int i2 = R.drawable.buddies_voicecall;
        switch (i) {
            case 6:
            case 10:
                this.f3452d.setVisibility(8);
                break;
            case 7:
            case 11:
                i2 = R.drawable.buddies_videocall;
                this.f3452d.setVisibility(8);
                break;
            case 12:
                i2 = R.drawable.buddies_list_rejected_message;
                this.f3452d.setVisibility(0);
                break;
        }
        this.f3451c.setBackgroundResource(i2);
    }

    public final void setTime(String str) {
        if (this.f3453e != null) {
            if (this.f3456h.getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.alignWithParent = true;
                layoutParams.addRule(11, -1);
                layoutParams.rightMargin = 25;
                this.f3453e.setLayoutParams(layoutParams);
                this.f3453e.setText(str);
                return;
            }
            this.f3453e.setText(str);
        }
    }

    public final void setDuration(String str) {
        if (this.f3455g != null) {
            this.f3455g.setText(str);
            this.f3455g.setSelected(true);
        }
    }

    public void setDeleteMode(boolean z) {
        if (z) {
            this.f3456h.setVisibility(0);
        } else {
            this.f3456h.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        this.f3456h.setChecked(z);
    }

    public final void setName(String str) {
        if (this.f3454f != null) {
            this.f3454f.setText(str);
        }
    }

    public void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f3456h.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
