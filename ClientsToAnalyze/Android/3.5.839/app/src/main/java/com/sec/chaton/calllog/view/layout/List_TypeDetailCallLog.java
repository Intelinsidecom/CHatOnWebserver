package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class List_TypeDetailCallLog extends List_TypeDetailCommonCallLog {

    /* renamed from: g */
    private TextView f5397g;

    public List_TypeDetailCallLog(Context context) {
        super(context);
        m7813a(context);
    }

    public List_TypeDetailCallLog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7813a(context);
    }

    /* renamed from: a */
    private final void m7813a(Context context) {
        View.inflate(context, R.layout.list_detail_calllog, this);
        this.f5393a = (RelativeLayout) findViewById(R.id.calllog_list);
        this.f5394b = (ImageView) findViewById(R.id.call_type);
        this.f5395c = (ImageView) findViewById(R.id.call_method);
        this.f5396d = (ImageView) findViewById(R.id.image_calllog_reject_message);
        this.f5397g = (TextView) findViewById(R.id.call_time);
        this.f5398e = (TextView) findViewById(R.id.call_duration);
        this.f5399f = (CheckBox) findViewById(R.id.delete);
        this.f5399f.setClickable(false);
        this.f5399f.setFocusable(false);
    }

    public final void setTime(String str) {
        if (this.f5397g != null) {
            this.f5397g.setText(str);
        }
    }
}
