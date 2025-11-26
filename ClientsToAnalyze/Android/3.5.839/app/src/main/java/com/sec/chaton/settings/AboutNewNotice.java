package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4880cr;

/* loaded from: classes.dex */
public class AboutNewNotice extends Preference {

    /* renamed from: a */
    private boolean f12437a;

    /* renamed from: b */
    private int f12438b;

    public AboutNewNotice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12437a = false;
        this.f12438b = 1;
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.text2);
        if (this.f12437a) {
            textView.setVisibility(0);
            C4880cr.m18525a(textView, this.f12438b);
        } else {
            textView.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void m13295a(boolean z) {
        this.f12437a = z;
        notifyChanged();
    }

    /* renamed from: a */
    public void m13296a(boolean z, int i) {
        this.f12437a = z;
        this.f12438b = i;
        notifyChanged();
    }
}
