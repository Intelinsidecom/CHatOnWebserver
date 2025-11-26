package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class CallLogTitleBar extends RelativeLayout {

    /* renamed from: a */
    TextView f5366a;

    /* renamed from: b */
    TextView f5367b;

    /* renamed from: c */
    String f5368c;

    /* renamed from: d */
    String f5369d;

    public CallLogTitleBar(Context context) {
        super(context);
        m7798a(context, null);
    }

    public CallLogTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7798a(context, EnumC1482a.Green);
    }

    /* renamed from: a */
    private final void m7798a(Context context, EnumC1482a enumC1482a) {
        View.inflate(context, R.layout.layout_common_header, this);
        this.f5366a = (TextView) findViewById(R.id.text1);
        this.f5368c = context.getResources().getString(R.string.calllog_seperator_1);
        this.f5369d = context.getResources().getString(R.string.calllog_seperator_2);
    }

    public void setTitle(String str) {
        if (this.f5366a != null) {
            this.f5366a.setText(str);
        }
    }

    public void setTag(String str) {
        if (this.f5367b != null) {
            this.f5367b.setText(str);
        }
    }
}
