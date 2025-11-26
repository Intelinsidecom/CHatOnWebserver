package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3228cp;

/* loaded from: classes.dex */
public class AboutNewNotice extends Preference {

    /* renamed from: a */
    private boolean f8907a;

    /* renamed from: b */
    private int f8908b;

    public AboutNewNotice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8907a = false;
        this.f8908b = 1;
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.text2);
        if (this.f8907a) {
            textView.setVisibility(0);
            C3228cp.m11345a(textView, this.f8908b);
        } else {
            textView.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void m8909a(boolean z) {
        this.f8907a = z;
        notifyChanged();
    }

    /* renamed from: a */
    public void m8910a(boolean z, int i) {
        this.f8907a = z;
        this.f8908b = i;
        notifyChanged();
    }
}
