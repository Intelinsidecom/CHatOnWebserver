package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p102b.C3782a;

/* loaded from: classes.dex */
public class DeliveryReportListItem extends LinearLayout {

    /* renamed from: a */
    private TextView f14774a;

    /* renamed from: b */
    private TextView f14775b;

    DeliveryReportListItem(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f14774a = (TextView) findViewById(R.id.recipient);
        this.f14775b = (TextView) findViewById(R.id.status);
    }

    public DeliveryReportListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public final void m15768a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f14774a.setText(C3782a.m14204a(str, false).m14264f());
        } else {
            this.f14774a.setText("");
        }
        this.f14775b.setText(str2);
        Context context = getContext();
        context.getString(R.string.status_received);
        context.getString(R.string.status_failed);
        context.getString(R.string.status_pending);
        context.getString(R.string.status_rejected);
    }
}
