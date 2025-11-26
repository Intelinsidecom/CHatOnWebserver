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
    TextView f3393a;

    /* renamed from: b */
    TextView f3394b;

    /* renamed from: c */
    String f3395c;

    /* renamed from: d */
    String f3396d;

    public CallLogTitleBar(Context context) {
        super(context);
        m4642a(context, null);
    }

    public CallLogTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4642a(context, EnumC0871a.Green);
    }

    /* renamed from: a */
    private final void m4642a(Context context, EnumC0871a enumC0871a) {
        View.inflate(context, R.layout.layout_common_header, this);
        this.f3393a = (TextView) findViewById(R.id.text1);
        this.f3395c = context.getResources().getString(R.string.calllog_seperator_1);
        this.f3396d = context.getResources().getString(R.string.calllog_seperator_2);
    }

    public void setTitle(String str) {
        if (this.f3393a != null) {
            this.f3393a.setText(str);
        }
    }

    public void setTag(String str) {
        if (this.f3394b != null) {
            this.f3394b.setText(str);
        }
    }
}
