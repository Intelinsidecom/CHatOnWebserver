package com.sec.chaton.settings;

import android.R;
import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
public class AboutNewNotice extends Preference {

    /* renamed from: a */
    private boolean f3415a;

    public AboutNewNotice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3415a = false;
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.title);
        if (this.f3415a) {
            textView.setCompoundDrawablePadding(6);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.sec.chaton.R.drawable.list_icon_new, 0);
        } else {
            textView.setCompoundDrawablePadding(0);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    /* renamed from: a */
    public void m3779a(boolean z) {
        this.f3415a = z;
        notifyChanged();
    }
}
